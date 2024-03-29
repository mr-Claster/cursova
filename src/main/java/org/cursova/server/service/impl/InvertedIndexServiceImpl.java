package org.cursova.server.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.cursova.server.service.InvertedIndexService;

public class InvertedIndexServiceImpl implements InvertedIndexService {

    private final int numberOfThreads;
    private static Map<String, Set<String>> index;

    public InvertedIndexServiceImpl(int numberOfThreads) {
        index = new ConcurrentHashMap<>();
        this.numberOfThreads = numberOfThreads;
    }

    public InvertedIndexServiceImpl() {
        index = new ConcurrentHashMap<>();
        this.numberOfThreads = Runtime.getRuntime().availableProcessors();
    }

    @Override
    public void addFile(String fileName, String content) {
        String[] words = content.toLowerCase().split("\\W+");
        Arrays.stream(words)
                .forEach(w -> index
                        .computeIfAbsent(w, k -> new HashSet<>())
                        .add(fileName));
    }

    @Override
    public void addFiles(Map<String, String> fileTextMap, String[] fileNames) {
        Thread[] thread = new Thread[numberOfThreads];
        for(int i = 1; i <= numberOfThreads; i++) {
            int start = fileNames.length / numberOfThreads * (i - 1);
            int end = i == numberOfThreads ? fileNames.length : fileNames.length / numberOfThreads * i;

            thread[i - 1] = new Thread(new FileAdder(fileTextMap, Arrays.copyOfRange(fileNames, start, end)));
            thread[i - 1].start();
        }
        for(int i = 0; i < numberOfThreads; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<String> search(String word) {
        Set<String> resultSet = new HashSet<>(index.getOrDefault(word, new HashSet<>()));
        return resultSet.stream().toList();
    }

    private static class FileAdder implements Runnable {
        private final Map<String, String> fileTextMap;
        private final String[] fileNames;

        public FileAdder(Map<String, String> fileTextMap, String[] fileNames) {
            this.fileTextMap = fileTextMap;
            this.fileNames = fileNames;
        }

        @Override
        public void run() {
            for(String fileName : fileNames) {
                String[] words = fileTextMap.get(fileName).toLowerCase().split("\\W+");
                Arrays.stream(words)
                        .forEach(w -> index
                                .computeIfAbsent(w, k -> new HashSet<>())
                                .add(fileName));
            }
        }
    }
}

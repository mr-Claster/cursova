package org.cursova;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InvertedIndex {
    private static final int NUMBER_OF_THREADS = 10;
    private static Map<String, Set<String>> index;

    public InvertedIndex() {
        index = new ConcurrentHashMap<>();
    }

    public void addDocument(String fileName, String content) {
        String[] words = content.toLowerCase().split("\\W+");
        Arrays.stream(words)
                .forEach(w -> index
                        .computeIfAbsent(w, k -> new HashSet<>())
                        .add(fileName));
    }

    public void addDocuments(Map<String, String> fileTextMap, String[] fileNames) {
        DocumentAdder[] documentAdder = new DocumentAdder[NUMBER_OF_THREADS];
        Thread[] thread = new Thread[NUMBER_OF_THREADS];
        for(int i = 1; i <= NUMBER_OF_THREADS; i++) {
            thread[i - 1] = new Thread(documentAdder[i - 1]
                    = new DocumentAdder(fileTextMap, Arrays.copyOfRange(fileNames,
                    fileNames.length / NUMBER_OF_THREADS * (i - 1),
                    fileNames.length / NUMBER_OF_THREADS * i)));
            thread[i - 1].start();
        }
        for(int i = 0; i < NUMBER_OF_THREADS; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> search(String word) {
        Set<String> resultSet = new HashSet<>(index.getOrDefault(word, new HashSet<>()));
        return resultSet.stream().toList();
    }

    private static class DocumentAdder implements Runnable {
        private final Map<String, String> fileTextMap;
        private final String[] fileNames;

        public DocumentAdder(Map<String, String> fileTextMap, String[] fileNames) {
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

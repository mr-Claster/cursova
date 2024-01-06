package org.cursova.server.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileService {
    private final int numberOfThreads;
    private static Map<String, String> fileTextMap;

    public FileService(int numberOfThreads) {
        fileTextMap = new ConcurrentHashMap<>();
        this.numberOfThreads = numberOfThreads;
    }

    public FileService() {
        fileTextMap = new ConcurrentHashMap<>();
        this.numberOfThreads = Runtime.getRuntime().availableProcessors();
    }

    public String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public Map<String, String> readFiles(String[] fileNames) {
        Thread[] threads = new Thread[numberOfThreads];

        for(int i = 1; i <= numberOfThreads; i++) {
            int start = fileNames.length / numberOfThreads * (i - 1);
            int end = i == numberOfThreads ? fileNames.length : fileNames.length / numberOfThreads * i;

            threads[i - 1] = new Thread(new FileReader(Arrays.copyOfRange(fileNames, start, end)));
            threads[i - 1].start();
        }
        try {
            for(int i = 0; i < numberOfThreads; i++) {
                threads[i].join();
            }
            return new ConcurrentHashMap<>(fileTextMap);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            fileTextMap.clear();
        }
    }

    public String[] getFilesAbsolutePathInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if(files == null) {
            throw new RuntimeException("The directory is empty or does not exist.");
        }
        return Arrays.stream(files)
                .map(File::getAbsolutePath)
                .toArray(String[]::new);
    }

    private static class FileReader implements Runnable {
        private final String[] fileNames;

        public FileReader(String[] fileNames) {
            this.fileNames = fileNames;
        }

        @Override
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                for(String fileName : fileNames) {
                    BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    fileTextMap.put(fileName, stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

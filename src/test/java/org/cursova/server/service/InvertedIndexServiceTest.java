package org.cursova.server.service;

import java.util.Map;
import org.cursova.server.service.impl.FileServiceImpl;
import org.cursova.server.service.impl.InvertedIndexServiceImpl;
import org.junit.jupiter.api.Test;

class InvertedIndexServiceTest {
    Map<String, String> fileTextMap;
    String[] filesPath;


     InvertedIndexServiceTest() {
        FileServiceImpl fileService = new FileServiceImpl();
        this.filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        this.fileTextMap = fileService.readFiles(filesPath);
    }

    @Test
    void testAddFiles() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(1);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1 thread");
    }

    @Test
    void testAddFiles1() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(2);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2 thread");
    }

    @Test
    void testAddFiles2() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(5);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 5 thread");
    }

    @Test
    void testAddFiles3() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(10);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 10 thread");
    }

    @Test
    void testAddFiles4() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(20);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 20 thread");
    }

    @Test
    void testAddFiles5() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(50);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 50 thread");
    }

    @Test
    void testAddFiles6() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(100);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 100 thread");
    }

    @Test
    void testAddFiles7() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(200);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 200 thread");
    }

    @Test
    void testAddFiles8() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(500);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 500 thread");
    }

    @Test
    void testAddFiles9() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(1000);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1000 thread");
    }

    @Test
    void testAddFiles10() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl(2000);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2000 thread");
    }

    @Test
    void testAddFiles11() {
        InvertedIndexServiceImpl invertedIndexService = new InvertedIndexServiceImpl();
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("\n\nExecution Time: " + (endTime - startTime));
    }
}

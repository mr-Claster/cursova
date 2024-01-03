package org.cursova;

import java.util.Map;
import org.junit.jupiter.api.Test;

class InvertedIndexServiceTest {
    Map<String, String> fileTextMap;
    String[] filesPath;


     InvertedIndexServiceTest() {
        FileService fileService = new FileService();
        this.filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        this.fileTextMap = fileService.readFiles(filesPath);
    }

    @Test
    void testAddFiles() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(1);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1 thread");
    }

    @Test
    void testAddFiles1() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(2);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2 thread");
    }

    @Test
    void testAddFiles2() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(5);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 5 thread");
    }

    @Test
    void testAddFiles3() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(10);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 10 thread");
    }

    @Test
    void testAddFiles4() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(20);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 20 thread");
    }

    @Test
    void testAddFiles5() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(50);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 50 thread");
    }

    @Test
    void testAddFiles6() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(100);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 100 thread");
    }

    @Test
    void testAddFiles7() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(200);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 200 thread");
    }

    @Test
    void testAddFiles8() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(500);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 500 thread");
    }

    @Test
    void testAddFiles9() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(1000);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1000 thread");
    }

    @Test
    void testAddFiles10() {
        InvertedIndexService invertedIndexService = new InvertedIndexService(2000);
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2000 thread");
    }

    @Test
    void testAddFiles11() {
        InvertedIndexService invertedIndexService = new InvertedIndexService();
        long startTime = System.currentTimeMillis();
        invertedIndexService.addFiles(fileTextMap, filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("\n\nExecution Time: " + (endTime - startTime));
    }
}

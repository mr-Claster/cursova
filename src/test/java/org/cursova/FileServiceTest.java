package org.cursova;

import org.junit.jupiter.api.Test;

class FileServiceTest {

    @Test
    void testReadFiles() {
        FileService fileService = new FileService(1);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1 thread");
    }

    @Test
    void testReadFiles2() {
        FileService fileService = new FileService(2);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2 threads");
    }

    @Test
    void testReadFiles3() {
        FileService fileService = new FileService(5);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 5 threads");
    }

    @Test
    void testReadFiles4() {
        FileService fileService = new FileService(10);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 10 threads");
    }

    @Test
    void testReadFiles5() {
        FileService fileService = new FileService(20);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 20 threads");
    }

    @Test
    void testReadFiles6() {
        FileService fileService = new FileService(50);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 50 threads");
    }

    @Test
    void testReadFiles7() {
        FileService fileService = new FileService(100);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 100 threads");
    }

    @Test
    void testReadFiles8() {
        FileService fileService = new FileService(200);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 200 threads");
    }

    @Test
    void testReadFiles9() {
        FileService fileService = new FileService(400);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 400 threads");
    }

    @Test
    void testReadFiles10() {
        FileService fileService = new FileService(1000);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1000 threads");
    }

    @Test
    void testReadFiles11() {
        FileService fileService = new FileService(2000);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2000 threads");
    }

    @Test
    void testReadFiles12() {
        FileService fileService = new FileService();
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("\n\nExecution Time: " + (endTime - startTime) + " milliseconds");
    }
}

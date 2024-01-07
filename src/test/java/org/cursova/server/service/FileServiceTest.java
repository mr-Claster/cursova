package org.cursova.server.service;

import org.cursova.server.service.impl.FileServiceImpl;
import org.junit.jupiter.api.Test;

class FileServiceTest {

    @Test
    void testReadFiles() {
        FileServiceImpl fileService = new FileServiceImpl(1);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1 thread");
    }

    @Test
    void testReadFiles2() {
        FileServiceImpl fileService = new FileServiceImpl(2);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2 threads");
    }

    @Test
    void testReadFiles3() {
        FileServiceImpl fileService = new FileServiceImpl(5);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 5 threads");
    }

    @Test
    void testReadFiles4() {
        FileServiceImpl fileService = new FileServiceImpl(10);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 10 threads");
    }

    @Test
    void testReadFiles5() {
        FileServiceImpl fileService = new FileServiceImpl(20);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 20 threads");
    }

    @Test
    void testReadFiles6() {
        FileServiceImpl fileService = new FileServiceImpl(50);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 50 threads");
    }

    @Test
    void testReadFiles7() {
        FileServiceImpl fileService = new FileServiceImpl(100);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 100 threads");
    }

    @Test
    void testReadFiles8() {
        FileServiceImpl fileService = new FileServiceImpl(200);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 200 threads");
    }

    @Test
    void testReadFiles9() {
        FileServiceImpl fileService = new FileServiceImpl(400);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 400 threads");
    }

    @Test
    void testReadFiles10() {
        FileServiceImpl fileService = new FileServiceImpl(1000);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 1000 threads");
    }

    @Test
    void testReadFiles11() {
        FileServiceImpl fileService = new FileServiceImpl(2000);
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds for 2000 threads");
    }

    @Test
    void testReadFiles12() {
        FileServiceImpl fileService = new FileServiceImpl();
        String[] filesPath = fileService.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\test\\neg");
        long startTime = System.currentTimeMillis();
        fileService.readFiles(filesPath);
        long endTime = System.currentTimeMillis();
        System.out.println("\n\nExecution Time: " + (endTime - startTime) + " milliseconds");
    }
}

package org.cursova.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import org.cursova.server.service.FileService;
import org.cursova.server.service.InvertedIndexService;
import org.cursova.server.service.impl.FileServiceImpl;
import org.cursova.server.service.impl.InvertedIndexServiceImpl;

public class Main {

    private static final String PATH = "train\\unsup";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Server started");

        InvertedIndexService invertedIndex = new InvertedIndexServiceImpl();
        FileService fileReader = new FileServiceImpl();

        String[] filesInDirectory = fileReader.getFilesAbsolutePathInDirectory(PATH);
        Map<String, String> fileTextMap = fileReader.readFiles(filesInDirectory);
        invertedIndex.addFiles(fileTextMap, filesInDirectory);
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new ClientThread(clientSocket, invertedIndex);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

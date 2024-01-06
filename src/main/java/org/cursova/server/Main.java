package org.cursova.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import org.cursova.server.service.FileService;
import org.cursova.server.service.InvertedIndexService;

public class Main {
    public static void main(String[] args) {
        InvertedIndexService invertedIndex = new InvertedIndexService();
        FileService fileReader = new FileService();
        String[] filesInDirectory = fileReader.getFilesAbsolutePathInDirectory("C:\\kpi\\cursova\\train\\unsup");
        Map<String, String> fileTextMap = fileReader.readFiles(filesInDirectory);
        invertedIndex.addFiles(fileTextMap, filesInDirectory);
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
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

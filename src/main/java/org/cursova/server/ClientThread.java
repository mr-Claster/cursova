package org.cursova.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.cursova.server.service.InvertedIndexService;

class ClientThread extends Thread {
    private final Socket clientSocket;
    private final InvertedIndexService invertedIndexService;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    ClientThread(Socket clientSocket, InvertedIndexService invertedIndexService) {
        this.clientSocket = clientSocket;
        this.invertedIndexService = invertedIndexService;
    }

    @Override
    public void run() {
        try (BufferedReader inputReader
                     = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter outputWriter
                     = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String clientMessage = inputReader.readLine();

            List<String> files = executorService
                    .submit(() -> invertedIndexService.search(clientMessage.toLowerCase()))
                    .get();
            outputWriter.println(files.toString());
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

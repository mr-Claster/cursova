package org.cursova.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection implements Runnable {
    private final String serverAddress;
    private final int serverPort;
    private final String word;

    public ClientConnection(String serverAddress, int serverPort, String word) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.word = word;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(word);
            String response = in.readLine();
            System.out.println("\n\nServer response for the '" + word + "': " + response
                    + "\n Tread: " + Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

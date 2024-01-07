package org.cursova.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;

        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server.");
            System.out.println("Enter a message for searching files with this words:");
            String userInput = stdIn.readLine();

            out.println(userInput);

            String response = in.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

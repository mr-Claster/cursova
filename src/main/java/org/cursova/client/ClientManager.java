package org.cursova.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientManager {
    public static void main(String[] args) {
        String[] words = {"time", "the", "for", "lol", "maybe"};
        ExecutorService executor = Executors.newFixedThreadPool(words.length);
        for (String word : words) {
            ClientConnection client = new ClientConnection("localhost", 8080, word);
            executor.execute(client);
        }
    }
}


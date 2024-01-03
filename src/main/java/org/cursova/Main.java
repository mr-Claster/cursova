package org.cursova;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        InvertedIndex invertedIndex = new InvertedIndex();
        FileService fileReader = new FileService();
        String[] filesInDirectory = fileReader.showFilesInDirectory("C:\\kpi\\cursova\\train\\neg\\");

        Map<String, String> fileTextMap = fileReader.readFiles(filesInDirectory);


        System.out.println(filesInDirectory[0]);
        System.out.println(filesInDirectory[1]);

        String s = fileReader.readFile(filesInDirectory[0]);
        invertedIndex.addDocument(filesInDirectory[0], s);

        s = fileReader.readFile(filesInDirectory[1]);
        invertedIndex.addDocument(filesInDirectory[1], s);

        System.out.println("Search results for the 'say':"
                + invertedIndex.search("say"));
        System.out.println("Search results for the 'it':"
                + invertedIndex.search("it"));
    }
}

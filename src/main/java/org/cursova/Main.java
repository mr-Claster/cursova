package org.cursova;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InvertedIndex invertedIndex = new InvertedIndex();
        FileService fileReader = new FileService();
        List<String> filesInDirectory = fileReader.showFilesInDirectory("C:\\kpi\\cursova\\train\\neg\\");

        System.out.println(filesInDirectory.get(0));
        System.out.println(filesInDirectory.get(1));

        String s = fileReader.readFile(filesInDirectory.get(0));
        invertedIndex.addDocument(filesInDirectory.get(0), s);

        s = fileReader.readFile(filesInDirectory.get(1));
        invertedIndex.addDocument(filesInDirectory.get(1), s);

        System.out.println("Search results for the 'say':"
                + invertedIndex.search("say"));
        System.out.println("Search results for the 'it':"
                + invertedIndex.search("it"));
    }
}

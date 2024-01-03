package org.cursova;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        InvertedIndex invertedIndex = new InvertedIndex();
        FileService fileReader = new FileService();
        String[] filesInDirectory = fileReader.showFilesInDirectory("C:\\kpi\\cursova\\train\\neg\\");


        Map<String, String> fileTextMap = fileReader.readFiles(filesInDirectory);
        invertedIndex.addDocuments(fileTextMap, filesInDirectory);

        System.out.println("Search results for the 'say':"
                + invertedIndex.search("say"));
        System.out.println();
        System.out.println();
        System.out.println("Search results for the 'it':"
                + invertedIndex.search("it"));
        System.out.println();
        System.out.println();
        System.out.println("Search results for the 'was':"
                + invertedIndex.search("was"));
        System.out.println();
        System.out.println();
        System.out.println("Search results for the 'task':"
                + invertedIndex.search("task"));
    }
}

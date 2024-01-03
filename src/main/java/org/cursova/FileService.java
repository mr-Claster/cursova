package org.cursova;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    public FileService() {
    }

    public String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public List<String> showFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if(files == null) {
            throw new RuntimeException("The directory is empty or does not exist.");
        }
        return Arrays.stream(files)
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());
    }
}

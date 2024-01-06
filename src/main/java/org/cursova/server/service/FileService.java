package org.cursova.server.service;

import java.util.Map;

public interface FileService {

    String readFile(String fileName);

    Map<String, String> readFiles(String[] fileNames);

    public String[] getFilesAbsolutePathInDirectory(String directoryPath);
}

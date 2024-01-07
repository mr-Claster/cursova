package org.cursova.server.service;

import java.util.List;
import java.util.Map;

public interface InvertedIndexService {

    void addFile(String fileName, String content);

    void addFiles(Map<String, String> fileTextMap, String[] fileNames);

    List<String> search(String word);
}

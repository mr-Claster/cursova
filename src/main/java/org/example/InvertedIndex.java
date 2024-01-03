package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {
    private Map<String, Set<String>> index;

    public InvertedIndex() {
        this.index = new HashMap<>();
    }

    public void addDocument(String fileName, String content) {
        String[] words = content.toLowerCase().split("\\W+");
        Arrays.stream(words)
                .forEach(w -> index
                        .computeIfAbsent(w, k -> new HashSet<>())
                        .add(fileName));
    }

    public List<String> search(String word) {
        return index.getOrDefault(word, new HashSet<>())
                .stream()
                .toList();
    }
}

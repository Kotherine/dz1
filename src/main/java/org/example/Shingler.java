package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shingler {
    public static List<String> buildShingles(String text, int n) {
        List<String> shingles = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder shingle = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j > 0) shingle.append(" ");
                shingle.append(words[i + j]);
            }
            shingles.add(shingle.toString());
        }
        return shingles;
    }
}
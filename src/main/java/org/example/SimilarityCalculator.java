package org.example;

import java.util.HashSet;
import java.util.Set;

public class SimilarityCalculator {
    public static double calculateJaccardSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    public static double calculateMinHashSimilarity(int[] hash1, int[] hash2) {
        int equal = 0;
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] == hash2[i]) {
                equal++;
            }
        }
        return (double) equal / hash1.length;
    }
}

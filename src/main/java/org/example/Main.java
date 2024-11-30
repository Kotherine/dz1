package org.example;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String text1 = "Привет мир, это тест";
        String text2 = "Это тест, привет мир";

        // Канонизация текстов
        text1 = TextCanonicalizer.canonicalize(text1);
        text2 = TextCanonicalizer.canonicalize(text2);

        // Построение шинглов
        List<String> shingles1 = Shingler.buildShingles(text1, 2);
        List<String> shingles2 = Shingler.buildShingles(text2, 2);

        // Преобразуем списки в множества
        Set<String> shingleSet1 = new HashSet<>(shingles1);
        Set<String> shingleSet2 = new HashSet<>(shingles2);
        System.out.println(shingleSet1);
        System.out.println(shingleSet2);

        // MinHash
        int numHashes = 100;
        int prime = 104729; // Простое число для MinHash
        MinHasher minHasher = new MinHasher(numHashes, prime);

        int[] hash1 = minHasher.minHash(shingleSet1);
        int[] hash2 = minHasher.minHash(shingleSet2);
        System.out.println(hash1);
        System.out.println(hash2);

        // Сравнение
        double jaccardSimilarity = SimilarityCalculator.calculateJaccardSimilarity(shingleSet1, shingleSet2);
        double minHashSimilarity = SimilarityCalculator.calculateMinHashSimilarity(hash1, hash2);

        System.out.println("Jaccard Similarity: " + jaccardSimilarity);
        System.out.println("MinHash Similarity: " + minHashSimilarity);
    }
}

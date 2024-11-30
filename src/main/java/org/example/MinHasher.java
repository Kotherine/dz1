package org.example;

import java.util.Set;
import java.util.Random;

public class MinHasher {
    private final int numHashes;
    private final int[] a;
    private final int[] b;
    private final int prime;

    public MinHasher(int numHashes, int prime) {
        this.numHashes = numHashes;
        this.prime = prime;
        this.a = new int[numHashes];
        this.b = new int[numHashes];
        Random rand = new Random();
        for (int i = 0; i < numHashes; i++) {
            this.a[i] = rand.nextInt(prime - 1) + 1;
            this.b[i] = rand.nextInt(prime);
        }
    }

    public int[] minHash(Set<String> shingles) {
        int[] signature = new int[numHashes];
        for (int i = 0; i < numHashes; i++) {
            signature[i] = Integer.MAX_VALUE;
        }

        for (String shingle : shingles) {
            int hash = shingle.hashCode();
            for (int i = 0; i < numHashes; i++) {
                int combinedHash = (a[i] * hash + b[i]) % prime;
                signature[i] = Math.min(signature[i], combinedHash);
            }
        }
        return signature;
    }
}

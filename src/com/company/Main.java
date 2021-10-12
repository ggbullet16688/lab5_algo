package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * This program creates an array in size (N) with random values within an upper bound(RANGE).
 * And then find if there has duplicates in the array. A global counter to keep track with it.
 * For each TRAIL, repeat the process as described above.
 *
 * Track CPU time used before and after running BF and T&C method while running the program.
 */
public class Main {

    final static int N = 10; // Size of array.
    final static int RANGE = 10; //Upper bound of random int in array.
    final static int TRIALS = 1; // Each trail fill array with random values, call BF and T&C to find duplicates in ary.
    static int bfCounter = 0;  // Keep track with the total of duplicates.
    static int tcCounter = 0;// Keep track with the total of duplicates.
    final static double Hundred = 100.00;

    public static void main(String[] args) {

        for (int i = 0; i < TRIALS; i++) {
            int[] ary = aryGenerator();
            System.out.println(Arrays.toString(ary));

            if (bfVSP(ary)) {
                bfCounter++;
            }
            if (tcVSP(ary)) {
                tcCounter++;
            }
        }
        print();

    }

    // Brute force method to find duplicates.
    public static boolean bfVSP(int[] ary) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (ary[i] == ary[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // T&C method to find duplicates.
    public static boolean tcVSP(int[] ary) {
        Arrays.sort(ary);
        for (int i = 0; i < ary.length - 1; i++) {
            if (ary[i] == ary[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Generate array with random integers.
    public static int[] aryGenerator() {
        int[] ary = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            ary[i] = rand.nextInt(RANGE);
        }
        return ary;
    }

    // Print info:
    // Size of array, N;
    // Range, (0 to R - 1);
    // Trails; Time find duplicates; Probability;
    // CPU time used BF, sum in ms, avg time in ms.
    // CPU time used T&C, sum in ms, avg time in ms.
    public static void print() {
        System.out.println("Size of array: " + N + '\n' +
                "Range: 0 to " + (RANGE - 1) + '\n' +
                "NUM_TRIALS: " + TRIALS + '\n' +
                "Duplicate array appearance: " + bfCounter + '\t' + tcCounter + '\n' +
                "Probability of array containing duplicates: " + (bfCounter / TRIALS * Hundred) + "%\n" +
                "Total amount of CPU time used for BF testing: " + '\n' +
                "Average amount of CPU time used for BF testing: " + '\n' +
                "Total amount of CPU time used for T&C testing: " + '\n' +
                "Average amount of CPU time used for T&C testing : " + '\n'
        );

    }
}


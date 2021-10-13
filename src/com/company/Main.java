package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 * Lab5
 * This program creates an array in size (N) with random values within an upper bound(RANGE).
 * And then find if there has duplicates in the array. A global counter to keep track with it.
 * For each TRAIL, repeat the process as described above.
 *
 * Track CPU time used before and after running BF and T&C method while running the program.
 *
 * StudentName: JunxianLiu (Stan)
 * StudentID: A01175175
 */
public class Main {

    final static int N = 10000; // Size of array.
    final static int RANGE = Integer.MAX_VALUE; //Upper bound of random int in array. Integer.MAX_VALUE
    final static int TRIALS = 1000; // Each trail fill array with random values, call BF and T&C to find duplicates in ary.
    static int bfCounter = 0;  // Keep track with the total of duplicates.
    static int tcCounter = 0;// Keep track with the total of duplicates.
    static double bfCPU = 0;
    static double tcCPU = 0;
    static double bfCPUTotal = 0;
    static double tcCPUTotal = 0;
    final static double Hundred = 100.00;

    public static void main(String[] args) {

        for (int i = 0; i < TRIALS; i++) {
            int[] ary = aryGenerator();

            if (bfVSP(ary)) {
                bfCounter++;
            }
            if (tcVSP(ary)) {
                tcCounter++;
            }
            bfCPUTotal += bfCPU;
            tcCPUTotal = tcCPUTotal + tcCPU;
        }
        print();

    }

    // Brute force method to find duplicates.
    public static boolean bfVSP(int[] ary) {
        long start = System.nanoTime();//System.currentTimeMillis();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (ary[i] == ary[j]) {
                    long end = System.nanoTime();//System.currentTimeMillis();
                    bfCPU = end - start;
                    return true;
                }
            }
        }
        long end = System.nanoTime();//System.currentTimeMillis();
        bfCPU = end - start;
        return false;
    }

    // T&C method to find duplicates.
    public static boolean tcVSP(int[] ary) {

        long start = System.nanoTime();//System.currentTimeMillis();

        Arrays.sort(ary);
        for (int i = 0; i < ary.length - 1; i++) {
            if (ary[i] == ary[i + 1]) {
                long end = System.nanoTime();//System.currentTimeMillis();
                tcCPU = end - start;
                return true;
            }
        }
        long end = System.nanoTime();//System.currentTimeMillis();
        tcCPU = end - start;
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
                "Total amount of CPU time used for BF testing: " + bfCPUTotal + '\n' +
                "Average amount of CPU time used for BF testing: " + (bfCPUTotal / TRIALS) + '\n' +
                "Total amount of CPU time used for T&C testing: " + tcCPUTotal + '\n' +
                "Average amount of CPU time used for T&C testing : " + (tcCPUTotal / TRIALS) + '\n'
        );

    }
}


package ru.botsner.algorithms;

import java.util.Arrays;

public class Fibonacci {

    // naive, recursion
    public static long fibNaive(int n) {
        if (n <= 1) return n;

        return fibNaive(n - 1) + fibNaive(n - 2);
    }

    // naive, recursion + memoization
    public static long fibNaiveMem(int n) {
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        return fibNaiveMemRec(n, mem);
    }

    private static long fibNaiveMemRec(int n, long[] mem) {
        if (n <= 1) return n;

        if (mem[n] != -1) {
            return mem[n];
        }

        long result = fibNaiveMemRec(n - 1, mem) + fibNaiveMemRec(n - 2, mem);
        mem[n] = result;

        return result;
    }

    // effective
    public static long fibEffective(int n) {
        if (n == 0) return 0;

        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}

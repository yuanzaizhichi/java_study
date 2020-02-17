package com.cxf.algorithm;

import java.util.Random;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }
        if (alg.equals("Selection")) {
            Selection.sort(a);
        }
//        if (alg.equals("Shell")) Shell.sort(a);
//        if (alg.equals("Merge")) Merge.sort(a);
//        if (alg.equals("Quick")) Quick.sort(a);
//        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        double t1 = timeRandomInput("Insertion", 1000, 100); // 算法1的总时间
        double t2 = timeRandomInput("Selection", 1000, 100); // 算法1的总时间
        System.out.println(t1);
        System.out.println(t2);
        StdOut.printf("For %d random Doubles\n %s is", 1000, "Insertion");
        StdOut.printf("%.1f times faster than %s\n", t2/t1, "Selection");
    }
}

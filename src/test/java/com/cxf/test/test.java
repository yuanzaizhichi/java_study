package com.cxf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    public static void main(String[] args) {
        int[] arr = new int[11];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        for (int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
        System.arraycopy(arr, 4, arr, 5, 6);
        for (int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();

        int[] arr2 = Arrays.copyOf(arr, 5);
        for (int el : arr2) {
            System.out.print(el + " ");
        }
    }
}

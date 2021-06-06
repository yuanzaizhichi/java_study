package com.cxf.leetcode;

public class Question_4 {
    public static void main(String[] args) throws Exception {
        System.out.println(Q4Solution2.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4, 6, 8, 9, 10}));
    }
}

class Q4Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, count = 0;
        int[] sumArr = new int[len1 + len2];

        while (count != (len1 + len2)) {
            if (i == len1) {
                while (j != len2) {
                    sumArr[count++] = nums2[j++];
                }
                break;
            }

            if (j == len2) {
                while (i != len1) {
                    sumArr[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                sumArr[count++] = nums1[i++];
            } else {
                sumArr[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (sumArr[count / 2 - 1] + sumArr[count / 2]) / 2.0;
        } else {
            return sumArr[count / 2];
        }
    }
}

class Q4Solution2 {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }
}
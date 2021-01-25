package com.my.algorithm.search;

public class BinarySearch {
    public static int binarySearch(int[] A, int l, int r, int x) {
        if (r > l) {
            int mid = (r + l) / 2;
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] > x) {
                return binarySearch(A, l, mid - 1, x);
            } else {
                return binarySearch(A, mid + 1, r, x);
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] arr = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

}

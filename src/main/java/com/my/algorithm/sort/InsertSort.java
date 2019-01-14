package com.my.algorithm.sort;

public class InsertSort {
    public void insertSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int s = i - 1;
            int x = A[i];
            while (s >= 0 && x < A[s]) {
                A[s + 1] = A[s];
                s--;
            }
            A[++s] = x;
        }
    }


    public static void main(String[] args) {
        int[] A = new int[]{
                1, 9, 5, 45, 0, -1, 58, 96
        };//1, 9, 5, 45, 0, -1, 58, 96

        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(A);
    }
}

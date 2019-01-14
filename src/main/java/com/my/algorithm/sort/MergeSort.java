package com.my.algorithm.sort;

public class MergeSort {

    void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (r + p) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    void merge(int[] A, int p, int q, int r) {
        System.out.println(" p =" + p + "  q ====" + q + "      r ==" + r);
        int m = q - p + 1;
        int n = r - q;

        //临时数组
        int[] min = new int[m];
        int[] max = new int[n];

        //存储下标p至下标q - p + 1
        for (int i = 0; i < m; i++) {
            min[i] = A[p + i];
            System.out.println("min[i] =" + min[i]);
        }
//        min[m] = Integer.MAX_VALUE;

        //存储下标q+1至下标r
        for (int i = 0; i < n; i++) {
            max[i] = A[q + 1 + i];
            System.out.println("max[i] =" + max[i]);
        }
//        max[n] = Integer.MAX_VALUE;
        //依次根据数组min和max元素排序
        int x = 0;
        int y = 0;
        for (int i = p; i <= r; i++) {
            if (x < min.length && y < max.length) {
                if (min[x] <= max[y]) {
                    A[i] = min[x];
                    System.out.println("A[i] bbbb===" + A[i] + "    i ==" + i);
                    x++;
                    continue;
                } else {
                    A[i] = max[y];
                    System.out.println("A[i] aaaaa===" + A[i] + "    i ==" + i);
                    y++;
                    continue;
                }
            }
            if (x >= min.length && y < max.length) {
                A[i] = max[y];
                System.out.println("A[i]2222222===" + A[i] + "    i ==" + i);
                y++;
                continue;
            }
            if (y >= max.length && x < min.length) {
                A[i] = min[x];
                System.out.println("A[i] 33333===" + A[i] + "    i ==" + i);
                x++;
                continue;
            }

        }

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] A = new int[]{
                1, 9, 5, 45, 0, -1, 58, 96
        };//1, 9, 5, 45, 0, -1, 58, 96

        mergeSort.mergeSort(A, 0, A.length - 1);
    }
}

package com.my;


public class TestAccount {

    public static void method(int[] A) {
        //将一个数组所有正数放在左边，负数放在右边
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            if (A[i] > 0 && A[j] < 0) {
                //不用移动
                continue;
            } else if (A[i] > 0 && A[j] > 0) {
                //j不更新
                j += 1;
                continue;
            } else if (A[i] < 0 && A[j] < 0) {
                //i不更新
                i -= 1;
                continue;
            } else if (A[i] < 0 && A[j] > 0) {
                //交换A[i]和A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{
                1, 9, 5, 45, -9, -1
        };

        method(A);
        System.out.println();
    }
}

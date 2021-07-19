package com.leetcode.medium;

public class CoinChange322 {

    public static int coinChange(int[] coins, int amount) {
        int[] cacValue = new int[amount + 1];
        cacValue[0] = 0;
        for (int i = 1; i <= amount; i++) {
            cacValue[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && cacValue[i - coin] != Integer.MAX_VALUE) {
                    cacValue[i] = Math.min(cacValue[i - coin] + 1, cacValue[i]);
                }
            }
        }

        if (cacValue[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return cacValue[amount];
        }
    }

    public static void main(String args[]) {
        int arr[] = {2};
        int amount = 3;
        System.out.println("Sorted array is" + CoinChange322.coinChange(arr, amount));
    }
}

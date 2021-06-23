package com.leetcode;

public class MaxSubArray53 {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
            System.out.println(".......pre="+pre+".......maxAns="+maxAns);
        }
        return maxAns;
    }

    public static void main(String args[]) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Sorted array is=" + MaxSubArray53.maxSubArray(arr));
    }
}

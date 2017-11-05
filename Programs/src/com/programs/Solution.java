package com.programs;

import java.util.Arrays;

public class Solution {
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] T = new int[nums.length];
		Arrays.fill(T, 1);

		int max = 1;
		for (int i = 1; i < T.length; i++) {
			int loopMax = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					loopMax = T[i] = Math.max(T[j] + 1, T[i]);
				}
			}
			max = Math.max(loopMax, max);
		}

		return max;
	}

	public static int lengthOfLISBinary(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) {
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLISBinary(new int[] { 10, 22, 9, 33, 21, 50, 41, 60 }));
		// System.out.println(lengthOfLIS(new int[] { 23, 10, 22, 5, 33, 8, 9,
		// 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27 }));

	}
}
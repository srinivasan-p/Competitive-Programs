package com.programs;

public class SumOfAllSubArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3,4 };
		findSumAllSubArray(arr);
	}

	private static void findSumAllSubArray(int[] arr) {
		int sum = 0;
		for (int period = 1; period <= arr.length; period++) {
			for (int i = 0; i < arr.length - period; i += period) {
				sum += getArraySum(arr, i, i + period);
			}
		}
		System.out.println(sum);
	}

	private static int getArraySum(int[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}
		return sum;
	}
}

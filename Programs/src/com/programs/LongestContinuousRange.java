package com.programs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.programs.util.Utils;

public class LongestContinuousRange {

	public static void main(String[] args) throws IOException {
		Scanner sc = Utils.getScanner();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int[] lcr = getLCR(arr);
		System.out.println(Arrays.toString(lcr));
	}

	private static int[] getLCR(int[] arr) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int maxLen = -1;
		int maxStartIdx = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int count = 1;
			int curStartIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] - arr[j - 1] == 1) {
					i++;
					count++;
				} else {
					break;
				}
			}
			if (count > maxLen) {
				maxLen = count;
				maxStartIdx = curStartIdx;
			}
		}
		int[] a = new int[maxLen];
		for (int i = 0; i < a.length; i++) {
			a[i] = arr[maxStartIdx + i];

		}
		return a;
	}
}

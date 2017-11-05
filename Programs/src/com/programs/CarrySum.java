package com.programs;

import java.util.Arrays;

public class CarrySum {
	public static void main(String[] args) {
		System.out.println(printCarrySum(new int[] { 5, 6, 3 }, new int[] { 8, 4, 2 }));
		System.out.println(
				printCarrySum(new int[] { 2, 2, 7, 5, 3, 3, 7, 3, 3, 6, 8, 3, 0, 5, 0, 6 }, new int[] { 4, 3, 3, 8 }));
	}

	private static int printCarrySum(int[] n, int[] m) {
		int[] sum = new int[Math.max(n.length, m.length) + 1];
		int carry = 0;
		int nEnd = n.length - 1;
		int mEnd = m.length - 1;
		while (nEnd >= 0 || mEnd >= 0) {
			int temp = (nEnd >= 0 ? n[nEnd] : 0) + (mEnd >= 0 ? m[mEnd] : 0) + carry;
			sum[Math.max(nEnd, mEnd) + 1] = temp % 10;
			carry = temp / 10;
			nEnd--;
			mEnd--;
		}
		sum[0] = carry;
		System.out.println(Arrays.toString(sum));
		return carry;
	}
}

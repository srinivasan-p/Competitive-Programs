package com.programs;

public class Coin135 {
	static int N = 7;
	static int[] cache = new int[N + 1];

	public static void main(String[] args) {
		for (int i = 0; i < cache.length; i++) {
			cache[i] = -1;

		}
		System.out.println(calculateWays(N));
	}

	private static int calculateWays(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		} else {
			if (cache[n] != -1)
				return cache[n];
			cache[n] = calculateWays(n - 1) + calculateWays(n - 3) + calculateWays(n - 5);
			return cache[n];
		}
	}
}

package com.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountChar {
	public static int output = 0;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			final int T = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < T; i++) {
				String[] input = br.readLine().split(" ");
				String str = input[0];
				int N = Integer.parseInt(input[1]);
				CountChar solver = new CountChar();
				output = solver.solveCountChar(str, N);
				System.out.println(output);
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Input read Error" + e);
		}
	}

	private int solveCountChar(String str, int n) {
		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put(str.charAt(0), 1);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) != str.charAt(i)) {
				charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
			}
		}
		return (int) charMap.entrySet().stream().filter(entry -> entry.getValue() == n).count();

	}
}

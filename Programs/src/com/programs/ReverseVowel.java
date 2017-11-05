package com.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseVowel {
	public static String output = "";

	public static void main(String[] args) {
		
		char a ='a';
		a = (char) (a^256);
		System.out.println(a);
		a = (char) (a^256);
		System.out.println(a);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			final int T = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < T; i++) {
				System.out.println(Integer.toBinaryString(T));

				String[] input = br.readLine().split(" ");
				String str = input[0].trim();
				ReverseVowel solver = new ReverseVowel();
				output = solver.solveReverseVowel(str.toCharArray());
				System.out.println(output);
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Input read Error" + e);
		}
	}

	private String solveReverseVowel(char[] cs) {
		int i = 0, j = cs.length - 1;
		while (i <= j) {
			while (i <= j && !isVowel(cs[i])) {
				i++;
			}
			while (i <= j && !isVowel(cs[j])) {
				j--;
			}
			swap(cs, i, j);
			i++;
			j--;

		}
		return String.valueOf(cs);
	}

	private void swap(char[] cs, int i, int j) {
		if (i == j)
			return;
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;

	}

	private boolean isVowel(char c) {
		switch (c) {
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			return true;
		default:
			return false;
		}
	}
}

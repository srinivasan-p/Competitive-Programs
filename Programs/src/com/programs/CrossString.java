package com.programs;

public class CrossString {
	public static void main(String[] args) {
		printCrossString("geeks".toCharArray());
	}

	private static void printCrossString(char[] cs) {
		int start = 0;
		int end = cs.length-1;
		while (start < cs.length && end >= 0) {
			System.out.println(cs[start++] + "    " + cs[end--]);
		}
		for (int i = 0; i < cs.length; i++) {
			System.out.println();
		}

	}
}

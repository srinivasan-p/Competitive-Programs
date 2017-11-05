package com.programs;

import java.util.Arrays;

public class WordSearch {
	private static char[] wrd;
	private static char[][] brd;
	private static char[][] brdMap;
	private static boolean[][] visited;
	private static int count = 0;

	public static boolean exist(char[][] board, String word) {
		wrd = word.toCharArray();
		brd = board;
		brdMap = new char[brd.length][brd[0].length];
		visited = new boolean[brd.length][brd[0].length];
		for (int i = 0; i < brdMap.length; i++) {
			Arrays.fill(brdMap[i], '~');
		}

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (exist(row, col, 0)) {
					System.out.println("Found at " + row + " - " + col);
					return true;
				}
			}
		}
		return false;

	}

	private static boolean exist(int row, int col, int pos) {
		if (pos == wrd.length)
			return true;
		if (row < 0 || col < 0 || row >= brd.length || col >= brd[0].length)
			return false;
		if (brd[row][col] != wrd[pos])
			return false;
		// brd[row][col] ^= 256;
		visited[row][col] = true;
		brdMap[row][col] = Character.forDigit(++count, 10);
		boolean exists = exist(row, col + 1, pos + 1) || exist(row + 1, col, pos + 1) || exist(row, col - 1, pos + 1)
				|| exist(row - 1, col, pos + 1) || exist(row - 1, col + 1, pos + 1) || exist(row - 1, col - 1, pos + 1)
				|| exist(row + 1, col + 1, pos + 1) || exist(row + 1, col - 1, pos + 1);
//		brd[row][col] ^= 256;
		visited[row][col] = false;
		if (!exists) {
			 brdMap[row][col] = '~';
			count--;
		}
		return exists;
	}

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } }, "QUIZ"));
		printArray(brd);
		printArray(brdMap);
		printArray(visited);
	}

	private static void printArray(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printArray(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

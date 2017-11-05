package com.programs;

public class ValidateSudoku {
	static boolean[] flag= new boolean [10];
	public static void main(String[] args) {
		
		System.out.println(isValidSudoku(new char[][] { 
				{ '3', '.', '6', '5', '.', '8', '4', '.', '.' },
				{ '5', '2', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '.', '8', '7', '.', '.', '.', '.', '3', '1' },
				{ '.', '.', '3', '.', '1', '.', '.', '8', '.' }, 
				{ '9', '.', '.', '8', '6', '3', '.', '.', '5' },
				{ '.', '5', '.', '.', '9', '.', '6', '.', '.' }, 
				{ '1', '3', '.', '.', '.', '.', '2', '5', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '7', '4' }, 
				{ '.', '.', '5', '2', '.', '6', '3', '.', '.' } }));
	}

	public static boolean isValidSudoku(char[][] board) {
		// rows
		for (int rows = 0; rows < board.length; rows++) {
			// System.out.print(board[][]);
		}
		for (int col = 0; col < board.length; col++) {

		}
		return false;

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
}

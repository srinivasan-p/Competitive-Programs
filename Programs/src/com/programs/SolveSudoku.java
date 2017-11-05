package com.programs;

public class SolveSudoku {
	public static void main(String[] args) {
		solveSudoku(new char[][] { 
			{ '3', '.', '6', '5', '.', '8', '4', '.', '.' },
			{ '5', '2', '.', '.', '.', '.', '.', '.', '.' }, 
			{ '.', '8', '7', '.', '.', '.', '.', '3', '1' },
			{ '.', '.', '3', '.', '1', '.', '.', '8', '.' }, 
			{ '9', '.', '.', '8', '6', '3', '.', '.', '5' },
			{ '.', '5', '.', '.', '9', '.', '6', '.', '.' }, 
			{ '1', '3', '.', '.', '.', '.', '2', '5', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '7', '4' }, 
			{ '.', '.', '5', '2', '.', '6', '3', '.', '.' } });
	}
	public static void solveSudoku(char[][] board) {
		printArray(board);
		solve(board);
		printArray(board);
	}
	private static boolean solve(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if(board[row][col]=='.'){
					
					for (char c = '1'; c <= '9'; c++) {
						if(isValid(row, col, c, board)){
							board[row][col] = c;
							
							if(solve(board)){
								return true;
							}else{
								board[row][col] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		printArray(board);
		return true;
	}

	private static boolean isValid(int row, int col, char c, char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.' && board[row][i] == c)
				return false;
			if (board[i][col] != '.' && board[i][col] == c)
				return false;
			if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] != '.'
					&& board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c)
				return false;
		}
		return true;
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

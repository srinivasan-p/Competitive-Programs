package com.programs;

import java.util.HashSet;
import java.util.Set;

public class validSudoku2 {
	public static boolean isValidSudoku(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			Set<Character> rowSet = new HashSet<>();
			Set<Character> colSet = new HashSet<>();
			Set<Character> cubeSet = new HashSet<>();
			for (int col = 0; col < board[row].length; col++) {
				if(board[row][col]!='.' && !rowSet.add(board[row][col]))
					return false;
				if(board[col][row]!='.' && !colSet.add(board[col][row]))
					return false;
				int rowCubeIndex = 3*(row/3);
				int colCubeIndex = 3*(row%3);
				int rowCubePos = 3*(row/3) + col/3;
				int colCudePos = 3*(row%3) + col%3;
				
				if(board[rowCubePos][colCudePos]!='.' && !cubeSet.add(board[rowCubePos][colCudePos]))
					return false;
			}
		}
		return true;
	}
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
}

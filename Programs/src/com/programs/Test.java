package com.programs;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		isValid(1, 8);
	}

	private static void isValid(int row, int col) {
		System.out.println(row + "     " + col);
		
		for (int i = 0; i < 9; i++) {
			System.out.println((3 * (row / 3) + (i / 3)) + "     " + (3 * (col / 3) + (i % 3)));
		}
		System.out.println();
//		for (int i = 0; i < 9; i++) {
//			System.out.println((3 * (row / 3) + (i / 3)) + "     " + (3 * (row % 3) + (i % 3)));
//		}
		
		
		for (row = 0; row < 9; row++) {
			System.out.println("ROW ->" +row);
			for (col = 0; col < 9; col++) {
				int rowCubePos = 3*(row/3) + col/3;
				int colCudePos = 3*(row%3) + col%3;
				System.out.println(rowCubePos + "     " + colCudePos);
			}
		}
		
		
	}
}

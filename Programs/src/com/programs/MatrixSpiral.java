package com.programs;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiral {
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
		printArray(generateMatrix(5));

	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0)
			return matrix;

		int num = n*n;

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {

			// Traverse left
			for (int i = colBegin; i <= colEnd; i++) {
				matrix[rowBegin][i] = num--;
			}
			rowBegin++;

			// Traverse down
			for (int i = rowBegin; i <= rowEnd; i++) {
				matrix[i][colEnd] = num--;
			}
			colEnd--;

			if (rowBegin > rowEnd || colBegin > colEnd)
				break;

			// Traverse right
			for (int i = colEnd; i >= colBegin; i--) {
				matrix[rowEnd][i] = num--;
			}
			rowEnd--;

			// Traverse top
			for (int i = rowEnd; i >= rowBegin; i--) {
				matrix[i][colBegin] = num--;
			}
			colBegin++;
		}

		return matrix;

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return list;

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse left
			for (int i = colBegin; i <= colEnd; i++) {
				list.add(matrix[rowBegin][i]);
			}
			rowBegin++;

			// Traverse down
			for (int i = rowBegin; i <= rowEnd; i++) {
				list.add(matrix[i][colEnd]);
			}
			colEnd--;

			if (rowBegin > rowEnd || colBegin > colEnd)
				break;

			// Traverse right
			for (int i = colEnd; i >= colBegin; i--) {
				list.add(matrix[rowEnd][i]);
			}
			rowEnd--;

			// Traverse top
			for (int i = rowEnd; i >= rowBegin; i--) {
				list.add(matrix[i][colBegin]);
			}
			colBegin++;
		}

		return list;

	}

	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

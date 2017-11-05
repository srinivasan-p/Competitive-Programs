
package com.programs;

public class AllOccuranceOfWord2D {
	static char[][] mat;
	static boolean[][] visited;
	static char[] word;
	static int[] rowDir = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] colDir = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		mat = new char[][] { 
			{ 'B', 'N', 'E', 'Y', 'S' }, 
			{ 'H', 'E', 'D', 'E', 'S' }, 
			{ 'S', 'G', 'N', 'D', 'E' } };
		word = "DES".toCharArray();
		visited = new boolean[mat.length][mat[0].length];

		findWords();

	}

	private static void findWords() {
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[0].length; col++) {
				if (mat[row][col] == word[0])
					findwords(row, col, 0, "");
			}
		}
	}

	private static boolean findwords(int row, int col, int curPos, String res) {
		if (!isValidMatrixIndex(row, col)) {
			return false;
		}

		if (mat[row][col] != word[curPos])
			return false;

		res += mat[row][col] + "[" + row + "," + col + "] ";

		if (curPos == word.length - 1) {
			System.out.println(res);
			return true;
		}
		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {

			if (!isValidMatrixIndex(row + rowDir[i], col + colDir[i])) {
				continue;
			}
			findwords(row + rowDir[i], col + colDir[i], curPos + 1, res);
		}
		visited[row][col] = false;
		return false;

	}

	private static boolean isValidMatrixIndex(int row, int col) {
		return !(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length);
	}
}

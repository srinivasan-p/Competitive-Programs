package com.programs;

public class XPrint {
	public static void main(String[] args) {
		// printStringX("0123456".toCharArray());
		// System.out.println();
		// printStringX1("0123456".toCharArray());
		// printPsycho("PROGRAM".toCharArray());
		// printDiamond(5);
		// printInvisibleDiamond(5);
		// printPatternD(5);
		// pascal(5);
		// pascal1(5);
		// floyd(5);
		wierdDiamond(5);

	}

	private static void wierdDiamond(int n) {
		int sp = 0;
		boolean flag = false;
		for (int i = n - 1; i >= 0 && i < n;) {
			for (int j = 0; j <= sp; j++) {
				System.out.print("* ");
			}
			for (int j = 0; j < i * 4; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j <= sp; j++) {
				System.out.print(" *");
			}
			System.out.println();
			if (i == 0) {
				flag = true;
			}
			if (flag) {
				sp--;
				i++;
			} else {
				sp++;
				i--;
			}
		}

	}

	private static void floyd(int n) {
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(cnt++ + " ");
			}
			System.out.println();
		}
	}

	private static void pascal1(int n) {
		int arr[][] = new int[n][n]; // An auxiliary array to store generated
										// pscal triangle values

		// Iterate through every line and print integer(s) in it
		for (int line = 0; line < n; line++) {
			// Every line has number of integers equal to line number
			for (int i = 0; i <= line; i++) {
				// First and last values in every row are 1
				if (line == i || i == 0)
					arr[line][i] = 1;
				else // Other values are sum of values just above and left of
						// above
					arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
				System.out.print(arr[line][i]);
			}
			System.out.println();
		}
		printArray(arr);
	}

	private static void pascal(int n) {
		for (int line = 1; line <= n; line++) {
			int c = 1;
			for (int i = 1; i <= line; i++) {
				System.out.print(c);
				c = c * (line - i) / i;
			}
			System.out.println();
		}
	}

	private static void printPatternD(int n) {
		int i, j;

		// This is upper half of pattern
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= (2 * n); j++) {
				// Left part of pattern
				if (i > (n - j + 1))
					System.out.print(" ");
				else
					System.out.print("*");

				// Right part of pattern
				if ((i + n) > j)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.print("\n");
		}

		// This is lower half of pattern
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= (2 * n); j++) {
				// Right Part of pattern
				if (i < j)
					System.out.print(" ");
				else
					System.out.print("*");

				// Left Part of pattern
				if (i <= ((2 * n) - j))
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	private static void printInvisibleDiamond(int n) {
		int sp = n - 1;
		boolean flag = false;
		for (int i = 0; i < n && i >= 0;) {
			for (int j = 0; j <= sp; j++) {
				System.out.print("* ");
			}
			for (int j = 0; j < i * 4; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j <= sp; j++) {
				System.out.print(" *");
			}
			System.out.println();
			if (i == n - 1) {
				flag = true;
			}
			if (flag) {
				sp++;
				i--;
			} else {
				sp--;
				i++;
			}
		}

	}

	private static void printDiamond(int n) {
		int sp = n - 1;
		boolean flag = false;
		for (int i = 0; i < n && i >= 0;) {
			for (int j = 0; j < sp; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
			if (i == n - 1) {
				flag = true;
			}
			if (flag) {
				sp++;
				i--;
			} else {
				sp--;
				i++;
			}
		} /*
			 * sp = 0; for (int i = n - 1; i >= 0; i--) { for (int j = 0; j <
			 * sp; j++) { System.out.print(" "); } for (int j = 0; j <= i; j++)
			 * { System.out.print("* "); } System.out.println(); sp++; }
			 */
	}

	private static void printPsycho(char[] cs) {
		int n = cs.length;
		int mid = n / 2;
		for (int i = 0, sp = 0; i < cs.length; i++, sp += 2) {
			for (int z = 0; z < sp; z++) {
				System.out.print(" ");
			}
			for (int j = 0; j < cs.length - i; j++) {
				int a = (j + mid) % n;
				System.out.print(cs[a]);
			}
			System.out.println();
		}

	}

	private static void printStringX1(char[] cs) {
		for (int i = 0, j = cs.length - 1; i < cs.length && j >= 0; i++, j--) {
			if (i < j) {
				for (int x = 0; x < i; x++) {
					System.out.print("-");
				}
				System.out.print(cs[i]);
				for (int x = 0; x < j - i - 1; x++) {
					System.out.print("-");
				}
				System.out.print(cs[j]);
				for (int x = j + 1; x < cs.length; x++) {
					System.out.print("-");
				}
			}
			if (i == j) {
				for (int x = 0; x < i; x++) {
					System.out.print("-");
				}
				System.out.print(cs[j]);
				for (int x = i + 1; x < cs.length; x++) {
					System.out.print("-");
				}
			}
			if (i > j) {
				for (int x = 0; x < j; x++) {
					System.out.print("-");
				}
				System.out.print(cs[j]);
				for (int c = 0; c < i - j - 1; c++) {
					System.out.print("-");
				}
				System.out.print(cs[i]);
				for (int x = i + 1; x < cs.length; x++) {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}

	private static void printStringX(char[] cs) {
		for (int i = 0; i < cs.length; i++) {
			for (int j = 0; j < cs.length; j++) {
				if (i == j || j == (cs.length - 1 - i))
					System.out.print(cs[j]);
				else
					System.out.print("-");
			}
			System.out.println();
		}
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

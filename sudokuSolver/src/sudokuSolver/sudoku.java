package sudokuSolver;
// DSA project using backtracking

public class sudoku {
	public static boolean isSafe(int[][] board, int row, int col, int num) {

		// checking for row is the number present or not
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == num) {
				return false;
			}
		}

		// checking for column is the number present or not
		for (int i = 0; i < board.length; i++) {

			if (board[i][col] == num) {
				return false;
			}
		}

		// Checking for the grid sqrt(board.length) X sqrt(boars.length)

		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int i = boxRowStart; i < boxRowStart + sqrt; i++) {
			for (int j = boxColStart; j < boxColStart + sqrt; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean helper(int[][] grid, int n) {

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (grid[row][col] == 0) {
					for (int val = 0; val <= 9; val++) {
						if (isSafe(grid, row, col, val)) {
							grid[row][col] = val;

							if (helper(grid, n)) {
								return true;
							}
							// backtrack
							else {
								grid[row][col] = 0;
							}
						}

					}
					return false;
				}
			}
		}
		return true;
	}
//	public static boolean helper(int[][] board, int n) {
//		int row = 0;
//		int col = 0;
//		boolean isEmpty = true;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (board[i][j] == 0) {
//					row = i;
//					col = j;
//
//					// We still have some remaining
//					// missing values in Sudoku
//					isEmpty = false;
//					break;
//				}
//			}
//			if (!isEmpty) {
//				break;
//			}
//		}
//
//		// No empty space left
//		if (isEmpty) {
//			return true;
//		}
//
//		// Else for each-row backtrack
//		for (int num = 1; num <= n; num++) {
//			if (isSafe(board, row, col, num)) {
//				board[row][col] = num;
//				if (helper(board, n)) {
//					// print(board, n);
//					return true;
//				} else {
//					// replace it
//					board[row][col] = 0;
//				}
//			}
//		}
//		return false;
//	}

	public static void print(int[][] board, int N) {

		// We got the answer, just print it
		for (int r = 0; r < N; r++) {
			for (int d = 0; d < N; d++) {
				System.out.print(board[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");

			if ((r + 1) % (int) Math.sqrt(N) == 0) {
				System.out.print("");
			}
		}
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		System.out.println("Input=> ");
		for (int[] row : board) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		helper(board, board.length);
		System.out.println("Solution=> ");
		for (int[] row : board) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

}

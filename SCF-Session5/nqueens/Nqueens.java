package nqueens;
import java.util.Scanner;

public class Nqueens {
	private int board[][];
	static Scanner scan = new Scanner(System.in);

	Nqueens(int n) {
		board = new int[n][n];
	}

	public int[][] getBoard() {
		return this.board;
	}

	/**
	 * checking whether we can place the queen safely on board at a give row and
	 * column
	 * 
	 * @param row
	 * @param col
	 * @return
	 */

	public boolean isSafe(int row, int col) {
		// checking in column
		for (int index = row - 1; index >= 0; index--) { // checking if there is
															// a queen in the
															// upper column
			if (board[index][col] == 1) {
				return false;
			}
		}

		int x = row - 1;
		int y = col + 1;
		while (x >= 0 && y < board.length && y >= 0) { // checking if there is a
														// queen in right
														// diagonal
			if (board[x][y] == 1) {
				return false;
			}
			x--;
			y++;
		}

		x = row - 1;
		y = col - 1;
		while (x >= 0 && y < board.length && y >= 0) {
			if (board[x][y] == 1) { // checking if there is a queen in left
									// diagonal
				return false;
			}
			x--;
			y--;
		}
		return true; // if queen could be placed
	}

	/**
	 * rows will be zero initially
	 * 
	 * @param row
	 * @return
	 */
	public boolean solveNqueens(int row) {
		if (row == board.length) { // base case
		
			/*
		 * 
		 * for (int i = 0; i < board.length; i++) { for (int j = 0; j <
		 * board.length; j++) { System.out.print(board[i][j] + "  "); }
		 * System.out.println(); } System.out.println();
		 */

			return true; // successfully completed all the rows.

		}

		for (int column = 0; column < board.length; column++) {
			if (isSafe(row, column)) { // is safe check that queen is safe for
										// placing at position row,column
				board[row][column] = 1;
				boolean placeAhead = solveNqueens(row + 1); // returns true if
															// queen could be
															// placed safely in
															// next rows
				if (placeAhead) {
					return true;
				}
				board[row][column] = 0; // backtrack if false is returned
			}
		}
		return false;
	}

	public static void main(String args[]) {
		System.out.println("enter size of chess board :");
		int size = scan.nextInt();

		Nqueens objOfNqueens = new Nqueens(size);

		System.out.println("could queens be placed on board? " + objOfNqueens.solveNqueens(0));

		int[][] result = objOfNqueens.getBoard();

		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result.length; col++) {
				System.out.print(result[row][col] + " ");
			}
			System.out.println();
		}

	}
}

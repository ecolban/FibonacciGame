package org.jointheleague.erik.fibgame;

/**
 * The following game is borrowed from one of Martin Gardner's books:
 * 
 * The game is played between two players who take turns removing coins from a
 * pile of coins containing at least two coins. The player who removes the last
 * coin wins. The player who goes first must remove at least one coin but not
 * all the coins. Thereafter, each player must remove at least one coin, but not
 * more than twice the number that the other player removed last.
 * 
 * Martin Gardner provides the following hint on how to play this game: The
 * player who goes first can always win unless the initial number of coins is a
 * number in the Fibonacci sequence, in which case the player who goes second
 * can always win.
 * 
 * <ul>
 * <li>How many coins should the player who goes first remove if the initial
 * number of coins is 7?
 * <li>How many coins should the player who goes first remove if the initial
 * number of coins is 20?
 * </ul>
 * 
 * The answer to the second question above is not 7. If you remove 7, then your
 * opponent can remove 13 and win.
 * 
 * The purpose of this project is to provide an exercise in recursive functions.
 * The nature of the game itself leads to "recursive thinking". Can't win a game
 * of 20 by removing 7? Break the game into two games; one of 13 and the other
 * of 7. If you win the game of 7, then your opponent will be in a position
 * where there are 13 coins in the pile and he/she cannot remove them all.
 * 
 * @author Erik Colban
 * 
 */
public class Game {

	/**
	 * Returns the number of coins that the first player should remove to
	 * maintain a winning position. If the first player is not in a winning
	 * position, 1 is returned.
	 * 
	 * @param n
	 *            the number of coins in the pile
	 * @return the best possible first move
	 */
	static int firstMove(int n) {
		int a = greatestFib(n);
		int b = n - a;
		if (a == n) {
			return 1;
		} else if (2 * b < a) {
			return b;
		} else {
			return firstMove(b);
		}
	}

	/**
	 * Returns the number of coins that a player should remove to maintain a
	 * winning position, given that the other player removed lastMove coins in
	 * the previous move. If the player is not in a winning position, 1 is
	 * returned.
	 * 
	 * @param n
	 *            the number of coins currently in the pile
	 * @param lastMove
	 *            the number of coins that the other player removed in the
	 *            previous move.
	 * @return the best possible next move
	 */
	static int nextMove(int n, int lastMove) {
		if (n <= 2 * lastMove) {
			return n;
		} else {
			return nextMoveHelper(n, lastMove);
		}
	}

	/**
	 * Same as {@link #nextMove(int, int)}, but where removing all coins is not
	 * an option.
	 * 
	 * @param n
	 *            the number of coins currently in the pile
	 * @param lastMove
	 *            the number of coins that the other player removed in the
	 *            previous move.
	 * @return the best possible first move
	 */
	private static int nextMoveHelper(int n, int lastMove) {
		int a = greatestFib(n);
		int b = n - a;
		if (a == n) {
			return 1;
		} else if (2 * b < a && b <= 2 * lastMove) {
			return b;
		} else {
			return nextMoveHelper(b, lastMove);
		}
	}

	/**
	 * @param n
	 *            an integer greater than or equal to 2.
	 * @return the greatest number in the Fibonacci sequence that is less than
	 *         or equal to n.
	 */
	static int greatestFib(int n) {
		return greatestFibHelper(n, 2, 3);
	}

	/**
	 * @param n
	 *            a number greater than or equal to 2.
	 * @param i
	 *            a number in the Fibonacci sequence that is less than or equal
	 *            to n.
	 * @param j
	 *            the number in the Fibonacci sequence that follows i
	 * @return the greatest number in the Fibonacci sequence that is less than
	 *         or equal to n.
	 */
	private static int greatestFibHelper(int n, int i, int j) {
		return j > n ? i : greatestFibHelper(n, j, i + j);
	}

}

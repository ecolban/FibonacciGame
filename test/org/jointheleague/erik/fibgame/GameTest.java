package org.jointheleague.erik.fibgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public final void firstMoveTest() {
		assertEquals(Game.firstMove(2), 1);
		assertEquals(Game.firstMove(13), 1);
		assertEquals(Game.firstMove(8), 1);
		assertEquals(Game.firstMove(67), 12);
		assertEquals(Game.firstMove(20), 2);
		assertEquals(Game.firstMove(100), 11);
	}
	
	@Test
	public final void nextMoveTest() {
		assertEquals(1, Game.nextMove(12, 1));
		assertEquals(1, Game.nextMove(13, 4));
		assertEquals(13, Game.nextMove(13, 7));
		assertEquals(1, Game.nextMove(18, 2));
		assertEquals(2, Game.nextMove(20, 4));
		assertEquals(3, Game.nextMove(32, 2));
		assertEquals(2, Game.nextMove(54, 10));
		assertEquals(1, Game.nextMove(67, 2));
		assertEquals(1, Game.nextMove(89, 11));
		assertEquals(3, Game.nextMove(100, 3));
	}
	
	@Test
	public final void greatestFibTest() {
		assertEquals(2, Game.greatestFib(2));
		assertEquals(3, Game.greatestFib(3));
		assertEquals(3, Game.greatestFib(4));
		assertEquals(5, Game.greatestFib(5));
		assertEquals(13, Game.greatestFib(13));
		assertEquals(13, Game.greatestFib(14));
		assertEquals(13, Game.greatestFib(15));
		assertEquals(13, Game.greatestFib(20));
		assertEquals(21, Game.greatestFib(21));
		assertEquals(89, Game.greatestFib(100));
	}

}

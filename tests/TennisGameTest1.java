import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest1 {
	
	@Ignore
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect...", "love - love", score);		
	}

	@Test (expected = TennisGameException.class)
	public void getScoreTesPlayer1Winst() throws TennisGameException{
		
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		
		String score = game.getScore();
		assertEquals("player1 wins", score);
	}
	
	@Test (expected = TennisGameException.class)
	public void getScoreTestPlayer2Wins() throws TennisGameException{
		
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("player2 wins", score);
	}
	
	@Test (expected = TennisGameException.class)
	public void getScoreTestDeuce() throws TennisGameException{
		
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player1Scored();
		
		
		String score = game.getScore();
		assertEquals("deuce", score);
	}
	
	@Test (expected = TennisGameException.class)
	public void getScoreTestP2advantage() throws TennisGameException{
		
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		
		
		String score = game.getScore();
		assertEquals("player2 has advantage", score);
	}
	
	@Test (expected = TennisGameException.class)
	public void getScoreTestP1advantage() throws TennisGameException{
		
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		
		
		String score = game.getScore();
		assertEquals("player2 has advantage", score);
	}

}

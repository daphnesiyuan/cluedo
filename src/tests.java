import java.awt.Color;

import org.junit.*;

import GUI.Board;
import pieces.ColonelMustard;
import pieces.Piece;
import players.Player;
import static org.junit.Assert.*;
public class tests {




	@Test
	public void testGetPiece() {
		Piece p = new ColonelMustard(0, 0);
		Player play = new Player("Daphne",p);

		assert(p.equals(play.getPiece()));
	}


	@Test
	public void testGetName() {
		Piece p = new ColonelMustard(0, 0);
		Player play = new Player("Daphne",p);
		String name = play.getName();

		assert(name.equals("Daphne"));
	}

	@Test
	public void testDeck() {
		Board board = new Board();
		board.createDeck();

		int deckSize = board.getDeck().size();

		assert(deckSize==21);
	}

	@Test
	public void testfindPiece1() {
		Board board = new Board();
		board.createDeck();

		board.setUpPieces();

		Piece p = board.findPiece("ColonelMustard");

		assert( p.getX()==9 );
	}

	@Test
	public void testfindPiece2() {
		Board board = new Board();
		board.createDeck();

		board.setUpPieces();

		Piece p = board.findPiece("MissScarlett");

		assert( p.getY()==0 );
	}

	@Test
	public void testPieceColour() {
		Board board = new Board();
		board.createDeck();

		board.setUpPieces();

		Piece p = board.findPiece("MissScarlett");
		Color c = p.getColor();

		assert( c.equals(new Color(181,22,22)));
	}

	@Test
	public void testNextPlayer() {
		Board board = new Board();
		board.createDeck();
		board.setUpPieces();
		board.makePlayers();


		Player p = board.getCurrentPlayer();

		assert(  p.equals(board.getPlayers().get(0)) ) ;
	}

	@Test
	public void testDie() {
		Board board = new Board();
		board.createDeck();
		board.setUpPieces();
		board.makePlayers();


		board.rollDice();

		assert( board.getDie1()>=1 && board.getDie2()>=1 );
	}

	@Test
	public void testEndTurn() {
		Board board = new Board();
		board.createDeck();
		board.setUpPieces();
		board.makePlayers();
		board.endTurn();

		Player p = board.getCurrentPlayer();

		assert( p.equals(board.getPlayers().get(1)) );
	}

	@Test
	public void testSolution() {
		Board board = new Board();
		board.createDeck();
		board.setUpPieces();
		board.makePlayers();
		board.generateSolution();

		assert( board.getSolution().size()==3 );
	}

	@Test
	public void testSolution2() {
		Board board = new Board();
		board.createDeck();
		board.setUpPieces();
		board.makePlayers();

		board.addPlayer( new Player("Daphne",board.getPieces().get(4)) );

		assert( board.getPlayers().size()==4 );
	}



}

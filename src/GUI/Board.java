package GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import pieces.ColonelMustard;
import pieces.MissScarlett;
import pieces.MrsPeacock;
import pieces.MrsWhite;
import pieces.Piece;
import pieces.ProfessorPlum;
import pieces.ReverendGreen;
import players.Player;
import squares.DoorSquare;
import squares.HallwaySquare;
import squares.PortalSquare;
import squares.RoomSquare;
import squares.Square;
import cards.Card;
import cards.Person;
import cards.Room;
import cards.Weapon;

/**
 * The Board class represents a game of Cluedo.
 * @author Antonia Caskey & Daphne Wang
 */
public class Board {

	static ArrayList<Card> solution = new ArrayList<Card>();
	static ArrayList<Card> deck = new ArrayList<Card>();
	static ArrayList<Piece> pieces = new ArrayList<Piece>();
	static ArrayList<Player> players = new ArrayList<Player>();
	public final int size = 30;
	private int playerCount;
	private int die1;
	private int die2;
	private BoardFrame boardFrame;
	private int diceMoves = 0;
	private Player currentPlayer;
	private int cpIndex = 0;
	public boolean firstGame = true;
	public boolean diceRolled = false;

	public Board() {

		setUpPieces();
		boardFrame = new BoardFrame(this);
		for (Card c : solution) {
			//System.out.println(c);

		}

	}

	/**
	 *
	 * Creates a deck consisting of the 21 cards in the game and generates a
	 * solution
	 *
	 * @param players
	 */

	public void initaliseCards(int players) {
		firstGame = false;
		playerCount = players;
		createDeck();
		generateSolution();
		// printSolution();

	}

	/**
	 * This method is called after players have been initialised.
	 */

	public void startGame() {
		dealCards();
		SidePanel s = (SidePanel) (getBoardFrame().sidePanel);
		s.refreshDectectiveNotes();
		//printPlayerCards();
		boardFrame.redrawBottomPanel(currentPlayer);

	}

	/**
	 * This method is used when the user wants to create a new game It should
	 * clear the players, solution and the deck of cards, but NOT the pieces
	 * because these are initialised at the board constructor
	 */
	public void reset() {
		players.clear();
		solution.clear();
		deck.clear();
		resetPieceLocations();
		boardFrame.panel.repaint();

	}

	/**
	 * resets all the pieces in the game to their original starting positions
	 *
	 */

	public void resetPieceLocations() {

		int toX = 0;
		int toY = 0;

		for (Piece p : pieces) {
			if (p instanceof ColonelMustard) {
				toX = 9;
				toY = 0;
			} else if (p instanceof MissScarlett) {
				toX = 14;
				toY = 0;
			} else if (p instanceof MrsWhite) {
				toX = 23;
				toY = 6;
			} else if (p instanceof ProfessorPlum) {
				toX = 23;
				toY = 19;
			} else if (p instanceof ReverendGreen) {
				toX = 7;
				toY = 24;
			} else if (p instanceof MrsPeacock) {
				toX = 0;
				toY = 17;
			}

			Square fromSquare = boardFrame.panel.getSquareAt(p.getX() * size,
					p.getY() * size);
			Square toSquare = boardFrame.panel.getSquareAt(toX, toY);
			p.setX(toX);
			p.setY(toY);
			fromSquare.setContainsCharacter(false);
			toSquare.setContainsCharacter(true);
		}
	}

	/**
	 * Initialises the deck with an instance of each person/weapon/room card.
	 * Total of 21 cards.
	 */
	public void createDeck() {
		// iterates through the person-enums and creates a new card instance of
		// each one
		for (Person.PersonName p : Person.PersonName.values()) {
			deck.add(new Person(p));
		}
		for (Room.RoomName r : Room.RoomName.values()) {
			deck.add(new Room(r));
		}
		for (Weapon.WeaponType w : Weapon.WeaponType.values()) {
			deck.add(new Weapon(w));
		}

		// shuffle deck
		Collections.shuffle(deck);
	}

	/**
	 * Generates the solution consisting of one murder, one weapon, and one
	 * room. These cards are then removed from the deck.
	 */
	public void generateSolution() {
		boolean person = false;
		boolean room = false;
		boolean weapon = false;
		Person p = null;
		Room r = null;
		Weapon w = null;
		for (Card c : deck) {
			if (c instanceof Person && !person) {
				solution.add(c);
				p = (Person) c;
				person = true;
			} else if (c instanceof Room && !room) {
				solution.add(c);
				r = (Room) c;
				room = true;
			} else if (c instanceof Weapon && !weapon) {
				solution.add(c);
				w = (Weapon) c;
				weapon = true;
			}

			// if at any point all 3 have been satisifed, exit the for loop
			if (person && room && weapon) {
				deck.remove(p);
				deck.remove(r);
				deck.remove(w);
				return;
			}
		}
	}

	/**
	 * initialises all the pieces in the game and gives them a predetermined
	 * starting square on the board to be drawn in.
	 *
	 */

	public void setUpPieces() {

		ColonelMustard cm = new ColonelMustard(9, 0);
		MissScarlett ms = new MissScarlett(14, 0);
		MrsWhite mw = new MrsWhite(23, 6);
		ProfessorPlum pp = new ProfessorPlum(23, 19);
		ReverendGreen rg = new ReverendGreen(7, 24);
		MrsPeacock mp = new MrsPeacock(0, 17);

		pieces.add(cm);
		pieces.add(ms);
		pieces.add(mw);
		pieces.add(pp);
		pieces.add(rg);
		pieces.add(mp);
	}

	/**
	 * Deals the cards in the deck at the start of the game to the players.
	 *
	 */

	public void dealCards() {

		currentPlayer = players.get(0);

		int cardsPerPlayer = deck.size() % playerCount;
		int playerCount = 0;
		int cardCount = 0;

		while (cardCount < deck.size()) {

			if (playerCount == players.size()) { // if finished iterating
													// through all the players
				playerCount = 0; // reset
			}

			Player player = players.get(playerCount);
			player.dealCard(deck.get(cardCount));

			cardCount++;
			playerCount++;
		}
	}

	/**
	 *
	 * Creates a player object given a player's name and the name of it's piece
	 *
	 * @param name
	 * @param piece
	 */

	public void createPlayer(String name, String piece) {

		// System.out.println("create player method");
		Piece p = findPiece(piece);
		players.add(new Player(name, p));
		checkFirstPlayer();

		// System.out.println("players array size = " + players.size());
	}

	/**
	 * method for testing
	 */
	public void makePlayers() {
		Player daphne = new Player("daphne", pieces.get(0));
		Player antonia = new Player("antonia", pieces.get(1));
		Player chully = new Player("chully", pieces.get(2));
		Player anon = new Player("moses", pieces.get(3));

		players.add(daphne);
		players.add(antonia);
		players.add(chully);
		players.add(anon);
	}

	/**
	 *
	 * Checks if the first player needs to be initialised
	 *
	 */
	public void checkFirstPlayer() {
		if (currentPlayer == null) {
			currentPlayer = players.get(0);
		}
	}

	/**
	 *
	 * returns a piece from the pieces array given the piece's name
	 *
	 * @param s
	 * @return
	 */

	public Piece findPiece(String s) {

		if (s.equals("ColonelMustard")) {
			return pieces.get(0);
		} else if (s.equals("MissScarlett")) {
			return pieces.get(1);
		} else if (s.equals("MrsWhite")) {
			return pieces.get(2);
		} else if (s.equals("ProfessorPlum")) {
			return pieces.get(3);
		} else if (s.equals("ReverendGreen")) {
			return pieces.get(4);
		} else if (s.equals("MrsPeacock")) {
			return pieces.get(5);
		}

		return null;
	}

	/**
	 * Generates a random number between 1 and 6 representing a roll of a die.
	 *
	 * @return random integer representing a value from a die
	 */

	public int rollDice() {

		diceRolled = true;

		Random rn = new Random();
		die1 = rn.nextInt(6) + 1;
		die2 = rn.nextInt(6) + 1;
		diceMoves = die1 + die2;
		//System.out.println("dice 1=" + die1 + " dice 2 = " + die2);
		return diceMoves;

	}

	/*
	 * public void printPlayerCards() {
	 *
	 * for (int p = 0; p < players.size(); p++) {
	 * System.out.println("    Player: " + players.get(p).getName()); for (int i
	 * = 0; i < players.get(p).getHand().size(); i++) {
	 * System.out.println(players.get(p).getHand().get(i).toString()); } } }
	 */

	/**
	 * Checks if the move is valid depending on what type of square they are
	 * moving from compared to what type of square they are moving to. Also
	 * checks if the move is possible in terms of the number of moves the player
	 * has remaining that turn.
	 *
	 *
	 * @param x
	 *            the x value of the mouse click
	 * @param y
	 *            the y value of the mouse click
	 * @return true boolean if the move is valid
	 */

	public boolean isValidMove(int x, int y) {

		Square fromSquare = boardFrame.panel.getSquareAt(currentPlayer
				.getPiece().getX() * size, currentPlayer.getPiece().getY()
				* size);
		Square toSquare = boardFrame.panel.getSquareAt(x, y);
		int tXCoord = toSquare.getxPosition() / size;
		int tYCoord = toSquare.getyPosition() / size;
		int fXCoord = fromSquare.getxPosition() / size;
		int fYCoord = fromSquare.getyPosition() / size;
		if (toSquare.isContainsCharacter() || !(currentPlayer.getActive())) {
			return false;
		} else if (diceMoves == 0 && fromSquare instanceof DoorSquare
				&& toSquare instanceof RoomSquare) {
			if ((tXCoord - fXCoord >= -1) && (tXCoord - fXCoord <= 1)
					&& tYCoord - fYCoord == 0) {
				return true;
			}
			if ((tYCoord - fYCoord >= -1) && (tYCoord - fYCoord <= 1)
					&& tXCoord - fXCoord == 0) {
				return true;
			}
		}
		if (diceMoves == 0) {
			return false;
		}
		// calculate if can make move with current dice moves
		// toSquare x should be between -1 and 1 inclusive
		if (fromSquare instanceof HallwaySquare
				&& toSquare instanceof HallwaySquare
				|| fromSquare instanceof DoorSquare
				&& toSquare instanceof RoomSquare
				|| fromSquare instanceof RoomSquare
				&& toSquare instanceof DoorSquare
				|| fromSquare instanceof DoorSquare
				&& toSquare instanceof HallwaySquare
				|| fromSquare instanceof HallwaySquare
				&& toSquare instanceof DoorSquare
				|| fromSquare instanceof PortalSquare
				&& toSquare instanceof RoomSquare
				|| fromSquare instanceof RoomSquare
				&& toSquare instanceof PortalSquare
				|| fromSquare instanceof RoomSquare
				&& toSquare instanceof RoomSquare) {

			if ((tXCoord - fXCoord >= -1) && (tXCoord - fXCoord <= 1)
					&& tYCoord - fYCoord == 0) {
				return true;
			}
			if ((tYCoord - fYCoord >= -1) && (tYCoord - fYCoord <= 1)
					&& tXCoord - fXCoord == 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Moves the current player's piece according to where the mouse is clicked.
	 * Checks at first if the move is valid and then changes the square which
	 * contains the player's piece. Finally redraws the board. to reflect the
	 * change in the position of the piece.
	 *
	 *
	 * @param x
	 *            The x value of the mouse click
	 * @param y
	 *            The y value of the mouse click
	 */
	public void movePiece(int x, int y) {

		if (isValidMove(x, y)) {
			Square fromSquare = boardFrame.panel.getSquareAt(currentPlayer
					.getPiece().getX() * size, currentPlayer.getPiece().getY()
					* size);
			Square toSquare = boardFrame.panel.getSquareAt(x, y);

			if (toSquare instanceof PortalSquare) {
				int toX = ((PortalSquare) toSquare).getGoesToX();
				int toY = ((PortalSquare) toSquare).getGoesToY();
				toSquare = boardFrame.panel.getSquareAt(toX, toY);
			}
			currentPlayer.getPiece().setX(toSquare.getxPosition() / size);
			currentPlayer.getPiece().setY(toSquare.getyPosition() / size);
			fromSquare.setContainsCharacter(false);
			toSquare.setContainsCharacter(true);
			if (!(toSquare instanceof RoomSquare)) {
				diceMoves--;
				//System.out.println("Decremented. Remaining moves: " + diceMoves);
				}
			if (fromSquare instanceof DoorSquare
					&& toSquare instanceof RoomSquare) {
				diceMoves = 0;
			}
			boardFrame.panel.repaint();

		}

	}

	/**
	 * Changes the current player to the next player in the list
	 *
	 *
	 */
	public void endTurn() {
		diceRolled = false;
		setNextPlayer();
		SidePanel s = (SidePanel) (getBoardFrame().sidePanel);
		s.refreshDectectiveNotes();
	}

	public boolean isDiceRolled() {
		return diceRolled;
	}

	public void setDiceRolled(boolean diceRolled) {
		this.diceRolled = diceRolled;
	}

	/**
	 * Method is called when a player decides to make an accusation a count is
	 * incremented whenever a player has made a correct accusation for each type
	 * of card. If they have three points they win the game otherwise, they
	 * lose.
	 *
	 * @param p
	 *            String Person.toString()
	 * @param r
	 *            String Room.toString()
	 * @param w
	 *            String Weapon.toString()
	 */
	public void accuse(String p, String r, String w) {
		String realp = null;
		String realr = null;
		String realw = null;
		int count = 0;
		for (Card c : solution) {
			if (c instanceof Person) {
				realp = c.toString();
				if (p == c.toString()) {
					count++;

				}
			} else if (c instanceof Weapon) {
				realw = c.toString();
				if (w == c.toString()) {
					count++;

				}
			} else {
				realr = c.toString();
				if (r == c.toString()) {
					count++;

				}
			}
		}
		JOptionPane.showMessageDialog(boardFrame, "You selected " + p
				+ " with the " + w + " in the " + r + ".\n"
				+ "The solution says it was " + realp + " with the " + realw
				+ " in the " + realr + ".", "Accusation: ",
				JOptionPane.PLAIN_MESSAGE);
		if (count == 3) {
			// DO WINNING THING
			Object[] options = { "Yes", "No", "Cancel" };
			int n = JOptionPane.showOptionDialog(boardFrame,
					"You win the game! " + "Would you like to play again?",
					"Accusation:", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		} else {
			// DO LOSING THING
			currentPlayer.setActive(false);// think about potentially adding an
											// "is active"
			JOptionPane.showMessageDialog(boardFrame,
					"Your accusation was incorrect, you have lost the game.",
					"Accusation: ", JOptionPane.PLAIN_MESSAGE);
			// DEACTIVATE PLAYER HERE
		}
		diceMoves = 0;
		this.setDiceRolled(false);
		this.endTurn();
	}

	/**
	 * Goes through all the players playing the game and checks if their hand
	 * contains the desired card. If so then it shows the card in a popup box
	 *
	 * @param p
	 *            String Person.toString()
	 * @param r
	 *            String Room.toString()
	 * @param w
	 *            String Weapon.toSring()
	 */
	public void suggestion(String p, String r, String w) {
		Player nextPlayer = seeNextPlayer(currentPlayer);

		while (!nextPlayer.equals(currentPlayer)) {
			for (Card c : nextPlayer.getHand()) {
				String cs = c.toString();
				//System.out.println(cs);
				if (p == cs || r == cs || w == cs) {
					JOptionPane.showMessageDialog(boardFrame,
							nextPlayer.getName() + "'s hand contains the " + cs
									+ " card.", "Suggestion: ",
							JOptionPane.PLAIN_MESSAGE);
					diceMoves = 0;
					this.setDiceRolled(false);
					this.endTurn();
					// ADD TO CHECKLIST HERE
					return;
				}
			}
			nextPlayer = seeNextPlayer(nextPlayer);

		}

		// custom title, no icon
		JOptionPane.showMessageDialog(boardFrame,
				"Nobody else has any of the suggested cards.", "Suggestion: ",
				JOptionPane.PLAIN_MESSAGE);
		diceMoves = 0;
		this.setDiceRolled(false);
		this.endTurn();
		// DO NO ONE HAS CARD THING
	}

	/**
	 * returns the next player without
	 *
	 *
	 * @return
	 */
	public Player seeNextPlayer(Player p) {
		int pIndex = players.indexOf(p);
		if (pIndex == players.size() - 1) {
			return players.get(0);
		} else {
			int index = pIndex + 1;
			return players.get(index);
		}
	}

	public Player seeCurrentPlayer() {
		return players.get(cpIndex);
	}

	/**
	 *
	 * sets the current player to the next player in the list
	 *
	 * @return Player
	 */

	public void setNextPlayer() {

		if (cpIndex == players.size() - 1) {
			cpIndex = 0;
			currentPlayer = players.get(0);
		} else {
			cpIndex++;
			currentPlayer = players.get(cpIndex);
		}
		if (!currentPlayer.getActive()) {
			setNextPlayer();

		}
		boardFrame.redrawBottomPanel(currentPlayer);
	}

	public void printSolution() {
		//System.out.println("    SOLUTION:");
		for (int i = 0; i < solution.size(); i++) {
			//System.out.println(solution.get(i).toString());
		}
	}

	public int getDie1() {
		return die1;
	}

	public void setDie1(int die1) {
		this.die1 = die1;
	}

	public int getDie2() {
		return die2;
	}

	public void setDie2(int die2) {
		this.die2 = die2;
	}

	public BoardFrame getBoardFrame() {
		return boardFrame;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public List<Card> getSolution() {
		return solution;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void addPlayers(ArrayList<Player> a) {
		players = a;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

}

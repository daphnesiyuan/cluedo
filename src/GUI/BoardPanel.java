package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Piece;
import squares.BorderSquare;
import squares.DoorSquare;
import squares.HallwaySquare;
import squares.PortalSquare;
import squares.RoomSquare;
import squares.Square;

public class BoardPanel extends JPanel{

	static String row1 = 	"kkkkkpbbbhbbbbhbbbcccccc";
	static String row2 = 	"kkkkkkbhhhaaaahhhbcccccc";
	static String row3 = 	"kkkkkkhhaaaaaaaahhcccccc";
	static String row4 = 	"kkkkkkhhaaaaaaaahhcccccc";
	static String row5 = 	"kkkkkkhhaaaaaaaahhoccccc";
	static String row6 = 	"kkkkkkhhoaaaaaaohhhcccpb";
	static String row7 = 	"bkkkokhhaaaaaaaahhhhhhhh";
	static String row8 = 	"hhhhhhhhaoaaaaoahhhhhhhb";
	static String row9 = 	"bhhhhhhhhhhhhhhhhhiiiiii";
	static String row10 = 	"dddddhhhhhhhhhhhhhoiiiii";
	static String row11 = 	"ddddddddhhbbbbbhhhiiiiii";
	static String row12 = 	"ddddddddhhbbbbbhhhiiiiii";
	static String row13 = 	"dddddddohhbbbbbhhhiiiioi";
	static String row14 = 	"ddddddddhhbbbbbhhhhhhhhb";
	static String row15 = 	"ddddddddhhbbbbbhhhrrorrb";
	static String row16 = 	"ddddddodhhbbbbbhhrrrrrrr";
	static String row17 = 	"bhhhhhhhhhbbbbbhhorrrrrr";
	static String row18 = 	"hhhhhhhhhhhhhhhhhrrrrrrr";
	static String row19 = 	"bhhhhhhhhqqooqqhhhrrrrrb";
	static String row20 = 	"plllllohhqqqqqqhhhhhhhhh";
	static String row21 = 	"lllllllhhqqqqqohhhhhhhhb";
	static String row22 = 	"lllllllhhqqqqqqhhosssssp";
	static String row23 = 	"lllllllhhqqqqqqhhsssssss";
	static String row24 = 	"lllllllhhqqqqqqhhsssssss";
	static String row25 = 	"llllllbhbqqqqqqbhbssssss";

	BufferedImage image;
	static ArrayList<ArrayList<Square>> listOfRows = new ArrayList<ArrayList<Square>>();

	Board board;

	public BoardPanel(Board b, TopMenu c){
	       try {
	           //image = ImageIO.read(new File("cluedo1.png"));
	    	   image = ImageIO.read(BoardPanel.class.getResource("image/cluedo1.png"));
	        } catch (IOException ex) {
	             // handle exception...
	        }
		this.addMouseListener(c);
		this.board = b;
		ArrayList<String> str = new ArrayList<String>();
		str.add(row1);
		str.add(row2);
		str.add(row3);
		str.add(row4);
		str.add(row5);
		str.add(row6);
		str.add(row7);
		str.add(row8);
		str.add(row9);
		str.add(row10);
		str.add(row11);
		str.add(row12);
		str.add(row13);
		str.add(row14);
		str.add(row15);
		str.add(row16);
		str.add(row17);
		str.add(row18);
		str.add(row19);
		str.add(row20);
		str.add(row21);
		str.add(row22);
		str.add(row23);
		str.add(row24);
		str.add(row25);
		populateBoard(str);
	}

	/**
	 * This is the main repaint method called by repaint() in boardFrame() (?)
	 */
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		//paintPlayingBoard(g);
		paintComponent(g);
		drawPieces(g);
	}

	/**
	 * Draws all the Squares onto the GUI and then draws a line grid overlay.
	 *
	 * @param g Graphics
	 */

	public void paintPlayingBoard(Graphics g){
		for(ArrayList<Square> squares:listOfRows){
			for(Square sq: squares){
				sq.draw(g);
			}
		}

		for(int i = 0;i<25;i++){
				g.setColor(Color.BLACK);
				g.drawLine(i*30, 0, i*30, getHeight());
				g.drawLine(0, i*30, getWidth(),i*30);

		}
	}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
    }
	/**
	 *Draws all the pieces contained within board on the gui.
	 *
	 */
	public void drawPieces(Graphics g){
		for(Piece p: board.getPieces()){
			p.draw(g);
		}
	}

	/**
	 * Given an ArrayList of strings this methods creates new Squares depending on the
	 * characters in the strings and adds the square to a row, and then this row to listOfRows.
	 *
	 * @param strings An ArrayList of Strings
	 */

	public static void populateBoard(ArrayList<String> strings){
		int x = 0;
		int y = 0;
		for(String str: strings){
			ArrayList<Square> squares = new ArrayList<Square>();
			for(int i = 0;i<24;i++){
				Square squ = getSquareType(str.charAt(i),x,y);
				squares.add(squ);
				x++;
			}
			listOfRows.add(squares);
			x = 0;
			y++;
		}
	}

	/**
	 * Returns the square at a given pixel based position
	 *
	 * @param x
	 * @param y
	 * @return the square which point x,y is contained in
	 */

	public static Square getSquareAt(int x, int y){
		for(ArrayList<Square> squares:listOfRows){
			for(Square sq: squares){
				if(sq.containsPoint(x, y)){
					return sq;
				}
			}
		}
		return null;

	}

	/*
	 * KEY FOR STRINGS:
	 * K	=	KITCHEN
	 * P	=	PORTAL
	 * B	=	BORDER
	 * H	=	HALLWAY
	 * C	=	CONSERVATORY
	 * A	=	BALLROOM
	 * D	=	DINING ROOM
	 * I	=	BILLIARD
	 * R	=	LIBRARY
	 * L	=	LOUNGE
	 * Q	=	HALL
	 * S	=	STUDY
	 *
	 *
	 */

	/**
	 * creates a new square based on the character c that is passed in from the array
	 * of strings.
	 *
	 * @param c
	 * @param x
	 * @param y
	 * @return new square
	 */

	public static Square getSquareType(char c, int x, int y){
		if(c=='k'){
			return new RoomSquare(x,y,"Kitchen");}
		else if(c=='p'){
			PortalSquare portal;
			if(x == 5){portal = new PortalSquare(x,y,"Kitchen");}
			else if(x == 0){portal = new PortalSquare(x,y,"Lounge");}
			else if(x == 22){portal = new PortalSquare(x,y,"Conservatory");}
			else{portal = new PortalSquare(x,y,"Study");
			}
			return portal;
			}//Portals created without room
		else if(c=='b'){
			return new BorderSquare(x,y);}
		else if(c=='h'){
			return new HallwaySquare(x,y);}
		else if(c=='c'){
			return new RoomSquare(x,y,"Conservatory");}
		else if(c=='a'){

			return new RoomSquare(x,y,"Ballroom");}
		else if(c=='d'){

			return new RoomSquare(x,y,"DiningRoom");}
		else if(c=='i'){

			return new RoomSquare(x,y,"Billiard");}
		else if(c=='r'){

			return new RoomSquare(x,y,"Library");}
		else if(c=='l'){

			return new RoomSquare(x,y,"Lounge");}
		else if(c=='q'){

			return new RoomSquare(x,y,"Hall");}
		else if(c=='s'){

			return new RoomSquare(x,y,"Study");}
		else if(c == 'o'){
			return new DoorSquare(x,y);
		}
		return null;
	}

}

package pieces;

import java.awt.Color;
import java.awt.Graphics;

public class ReverendGreen extends Piece{

	/**
	 * constructor for the pieces at initialisation
	 * @param x: starting x position on the board
	 * @param y: starting y position on the board
	 */
	public ReverendGreen(int x, int y){
		realX = x;
		realY = y;
		colour = new Color(58,181,109);
	}

}

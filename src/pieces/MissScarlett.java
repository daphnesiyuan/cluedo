package pieces;

import java.awt.Color;
import java.awt.Graphics;

public class MissScarlett extends Piece{


	/**
	 * constructor for the pieces at initialisation
	 * @param x: starting x position on the board
	 * @param y: starting y position on the board
	 */
	public MissScarlett(int xPos, int yPos){
		realX=xPos;
		realY=yPos;
		colour = new Color(181,22,22);
	}

}
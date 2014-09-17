package pieces;

import java.awt.Color;
import java.awt.Graphics;

public class ProfessorPlum extends Piece{

	/**
	 * constructor for the pieces at initialisation
	 * @param x: starting x position on the board
	 * @param y: starting y position on the board
	 */
	public ProfessorPlum(int x, int y){
		realX=x;
		realY=y;
		colour= colour = new Color(117,28,153);
	}

}

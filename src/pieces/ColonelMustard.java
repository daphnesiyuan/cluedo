package pieces;

import java.awt.Color;
import java.awt.Graphics;

public class ColonelMustard extends Piece{

	/**
	 * constructor for the pieces at initialisation
	 * @param x: starting x position on the board
	 * @param y: starting y position on the board
	 */
	public ColonelMustard(int x, int y){
		realX = x;
		realY = y;
		colour = new Color(222,198,47);
	}

}


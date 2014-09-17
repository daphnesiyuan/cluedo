package pieces;

import java.awt.Color;
import java.awt.Graphics;

public class MrsWhite extends Piece{

	/**
	 * constructor for the pieces at initialisation
	 * @param x: starting x position on the board
	 * @param y: starting y position on the board
	 */
	public MrsWhite(int x, int y){
		realX=x;
		realY=y;
		colour=new Color(245,245,245);
	}

}

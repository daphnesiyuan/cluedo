package pieces;

/**
 * @author Antonia Caskey & Daphne Wang
 */

import java.awt.Color;
import java.awt.Graphics;

import GUI.Board;
import squares.Square;

public abstract class Piece {

	int realX;
	int realY;
	Color colour;
	int size = 20;
	int blockSize = 30;

	public int getX(){
		return realX;

	}

	public int getY(){
		return realY;

	}

	public void setX(int x){
		realX = x;
	}

	public void setY(int y){
		realY = y;
	}

	public void draw(Graphics g){
		g.setColor(colour);
		g.fillOval((realX*blockSize)+(size/4), (realY*blockSize)+(size/4), size, size);
		g.setColor(Color.BLACK);
		g.drawOval((realX*blockSize)+(size/4), (realY*blockSize)+(size/4), size, size);

	}

	public Color getColor(){
		return colour;

	}

	public  Square getCurrentSquare(Board b){
		return b.getBoardFrame().panel.getSquareAt(realX*blockSize, realY*blockSize);

	}//######################################

}

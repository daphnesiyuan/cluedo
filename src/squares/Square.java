package squares;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Antonia Caskey
 */
public abstract class Square {


	private int xPosition;	//contains the position of the square on the board (pixels)
	private int yPosition;	//contains the position of the square on the board (pixels)
	private Color color;	//the color of the square, depends on what type of square it is
	private boolean containsCharacter;	//whether or not it contains a character
	public final int size = 30;	//a square's width and height

	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isContainsCharacter() {
		return containsCharacter;
	}
	public void setContainsCharacter(boolean containsCharacter) {
		this.containsCharacter = containsCharacter;
	}
	/**
	 * returns true if the point
	 *
	 * @param x given x value contained within the parameters of the gui
	 * @param y given y value contained within the parameters of the gui
	 * @return boolean
	 */

	public boolean containsPoint(int x, int y){
		if(x>=xPosition && x<xPosition+size && y>=yPosition && y<yPosition+size){
			return true;
		}
		else return false;

	}

	/**
	 * Sets the color of the square and fills it at a given position.
	 *
	 * @param g Graphics
	 */

	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(xPosition, yPosition, size, size);

	}//methods
	@Override
	public String toString() {
		return "Square [xPosition=" + xPosition + ", yPosition=" + yPosition
				+ ", color=" + color + "]";
	}


}

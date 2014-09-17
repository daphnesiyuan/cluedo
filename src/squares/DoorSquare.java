package squares;
import java.awt.Color;


public class DoorSquare extends Square{

	public DoorSquare(int posX, int posY){
		this.setxPosition(posX*size);	//takes position in array and multiplies by the size to find graphical position
		this.setyPosition(posY*size);	//''
		Color col = new Color(48,30,17);
		this.setColor(col);	//Doors are currently black

	}

}

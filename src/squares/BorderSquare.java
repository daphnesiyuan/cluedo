package squares;
import java.awt.Color;


public class BorderSquare extends Square{

	public BorderSquare(int posX, int posY){
		this.setxPosition(posX*size);	//takes position in array and multiplies by the size to find graphical position
		this.setyPosition(posY*size);	//''
		this.setColor(Color.BLACK);	//Borders are currently light grey

	}

}

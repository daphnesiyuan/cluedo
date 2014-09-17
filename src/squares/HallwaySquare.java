package squares;
import java.awt.Color;


public class HallwaySquare extends Square{

	public HallwaySquare(int posX, int posY){
		this.setxPosition(posX*size);	//takes position in array and multiplies by the size to find graphical position
		this.setyPosition(posY*size);	//''
		Color col  = new Color(82,57,38);
		this.setColor(col);	//Hallways are currently light grey

	}

}

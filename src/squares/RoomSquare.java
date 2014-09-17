package squares;
import java.awt.Color;
import java.util.ArrayList;


public class RoomSquare extends Square{

	private boolean containsWeapon;
	private String nameOfRoom;
	private String name;


	public RoomSquare(int posX,int PosY,String name){
		this.setxPosition(posX*size);	//takes position in array and multiplies by the size to find graphical position
		this.setyPosition(PosY*size);	//''
		Color col = new Color(138,32,32);
		this.setColor(col);	//Rooms are currently dark grey
		this.name = name;
	}


	//####################################################

	public String getNameOfRoom() {
		return nameOfRoom;
	}
	
	//####################################################
}

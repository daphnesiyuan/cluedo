package squares;
import java.awt.Color;


public class PortalSquare extends Square{

	private int goesToX;
	private int goesToY;
	private String room;


	public PortalSquare(int posX, int posY, String room){
		this.setxPosition(posX*size);	//takes position in array and multiplies by the size to find graphical position
		this.setyPosition(posY*size);	//''
		this.room = room;
		Color col = new Color(91,162,186);
		this.setColor(col);	//Portals are currently GREEN
		//System.out.println("Room name: " + room);
		if(room == "Kitchen"){

			goesToX = 23*30;
			goesToY = 21*30;}
		else if(room == "Study"){

			goesToX = 5*30;
			goesToY = 0*30;}
		else if(room == "Lounge"){

			goesToX = 22*30;
			goesToY = 5*30;}
		else{

			goesToX = 0*30;
			goesToY = 19*30;}

	}


	public int getGoesToX() {
		return goesToX;
	}


	public int getGoesToY() {
		return goesToY;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}

}

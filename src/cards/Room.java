package cards;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cards.Person.PersonName;

public class Room implements Card {
	/**
	 * Represents s card of a room
	 *
	 */

	private RoomName room;

	public Room(RoomName r){
		this.room = r;
	}

	public enum RoomName {
		KITCHEN, BALLROOM, CONSERVATORY, BILLARDROOM, LIBRARY, STUDY, HALL, LOUNGE, DININGROOM;
	}


	/**
	 * A method to return specific ImageIcon for each room enum type
	 */

	@Override
	public ImageIcon cardIcon() {

		switch(this.room) {
			case KITCHEN:
				ImageIcon kit=new ImageIcon(Person.class.getResource("cardImages/Kitchen.jpg"));
				return kit;

			case BALLROOM:
				ImageIcon ball= new ImageIcon(Person.class.getResource("cardImages/Ball Room.jpg"));
				return ball;

			case CONSERVATORY:
				ImageIcon cons= new ImageIcon(Person.class.getResource("cardImages/Conservatory.jpg"));
				return cons;

			case BILLARDROOM:
				ImageIcon bill= new ImageIcon(Person.class.getResource("cardImages/Billard.jpg"));
				return bill;

			case LIBRARY:
				ImageIcon lib= new ImageIcon(Person.class.getResource("cardImages/Library.jpg"));
				return lib;

			case STUDY:
				ImageIcon stu= new ImageIcon(Person.class.getResource("cardImages/Study.jpg"));
				return stu;
			case HALL:
				ImageIcon hall= new ImageIcon(Person.class.getResource("cardImages/Hall.jpg"));
				return hall;
			case LOUNGE:
				ImageIcon loun= new ImageIcon(Person.class.getResource("cardImages/Lounge.jpg"));
				return loun;
			case DININGROOM:
				ImageIcon din= new ImageIcon(Person.class.getResource("cardImages/Dining Room.jpg"));
				return din;

		}
		return null;
	}

	//###############################################
	/**
	 * Returns a string containing the name of the card
	 */
	public String toString() {
		if (this instanceof Room) { // check if it is a valid room card
			// "Kitchen", "Ballroom", "Conservatory", "Billard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"
			Room r = (Room) this;
			if (r.room == RoomName.KITCHEN) {
				return "Kitchen";
			} else if (r.room == RoomName.BALLROOM) {
				return "Ballroom";
			} else if (r.room == RoomName.CONSERVATORY) {
				return "Conservatory";
			} else if (r.room == RoomName.BILLARDROOM) {
				return "Billard Room";
			} else if (r.room == RoomName.LIBRARY) {
				return "Library";
			} else if (r.room == RoomName.STUDY) {
				return "Study";
			} else if (r.room == RoomName.HALL) {
				return "Hall";
			} else if (r.room == RoomName.LOUNGE) {
				return "Lounge";
			} else if (r.room == RoomName.DININGROOM) {
				return "Dining Room";
			}
		}
		return null;
	}
	//###############################################
}

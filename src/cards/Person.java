package cards;

/**
 * Person class
 * @author Daphne Wang
 */


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Person implements Card {
	/**
	 * Represents the name of the character
	 *
	 *
	 */

	private PersonName character;

	public Person(PersonName c){
		this.character = c;
	}

	public enum PersonName {
		MISSSCARLETT, COLONELMUSTARD, MRSWHITE, REVERENDGREEN, MRSPEACOCK, PROFESSORPLUM;
	}

	/**
	 * A method to return specific ImageIcon for each person enum type
	 */

	@Override
	public ImageIcon cardIcon() {

		switch(this.character) {

			case MISSSCARLETT:
				ImageIcon ms= new ImageIcon(Person.class.getResource("cardImages/Miss Scarlet.jpg"));
				return ms;

			case COLONELMUSTARD:
				ImageIcon cm= new ImageIcon(Person.class.getResource("cardImages/Col Mustard.jpg"));
				return cm;

			case MRSWHITE:
				ImageIcon mw= new ImageIcon(Person.class.getResource("cardImages/Miss White.jpg"));
				return mw;

			case REVERENDGREEN:
				ImageIcon rg= new ImageIcon(Person.class.getResource("cardImages/Rev Green.jpg"));
				return rg;

			case MRSPEACOCK:
				ImageIcon mp= new ImageIcon(Person.class.getResource("cardImages/Mrs Peacock.jpg"));
				return mp;

			case PROFESSORPLUM:
				ImageIcon pp= new ImageIcon(Person.class.getResource("cardImages/Prof Plum.jpg"));
				return pp;

		}
		return null;
	}

	/**
	 * Returns a string containing the name of the card
	 */
	//###############################################
	public String toString() {
		// "Colonel Mustard", "Miss Scarlett", "Mrs Peacock", "Mrs White", "Professor Plum", "Reverend Green"
		if (this instanceof Person) { // check if it is a valid person card
			Person p = (Person) this;
			if (p.character == PersonName.MISSSCARLETT) {
				return "Miss Scarlett";
			} else if (p.character == PersonName.COLONELMUSTARD) {
				return "Colonel Mustard";
			} else if (p.character == PersonName.MRSWHITE) {
				return "Mrs White";
			} else if (p.character == PersonName.REVERENDGREEN) {
				return "Reverend Green";
			} else if (p.character == PersonName.MRSPEACOCK) {
				return "Mrs Peacock";
			} else if (p.character == PersonName.PROFESSORPLUM) {
				return "Professor Plum";
			}
		}
		return null;
	}
	//###############################################




}

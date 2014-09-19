package cards;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cards.Person.PersonName;

public class Weapon implements Card {

	/**
	 * Represents the type of the weapon it is
	 * @author: Daphne Wang
	 */

	private WeaponType weapon;

	public Weapon(WeaponType w){
		this.weapon = w;
	}

	public enum WeaponType {
		CANDLESTICK, DAGGER, LEADPIPE, REVOLVER, ROPE, SPANNER;
	}

	/**
	 * A method to return specific ImageIcon for each weapon enum type
	 */
	@Override
	public ImageIcon cardIcon() {

		switch(this.weapon) {
			case CANDLESTICK:
				ImageIcon cd= new ImageIcon(Person.class.getResource("cardImages/CandleStick.jpg"));
				return cd;

			case DAGGER:
				ImageIcon dg= new ImageIcon(Person.class.getResource("cardImages/Dagger.jpg"));
				return dg;

			case LEADPIPE:
				ImageIcon lp= new ImageIcon(Person.class.getResource("cardImages/Lead Piping.jpg"));
				return lp;

			case REVOLVER:
				ImageIcon rv= new ImageIcon(Person.class.getResource("cardImages/Revolver.jpg"));
				return rv;

			case ROPE:
				ImageIcon rp= new ImageIcon(Person.class.getResource("cardImages/Rope.jpg"));
				return rp;

			case SPANNER:
				ImageIcon sp= new ImageIcon(Person.class.getResource("cardImages/Spanner.jpg"));
				return sp;
		}
		return null;
	}

	//###############################################
	/**
	 * Returns a string containing the name of the card
	 */
	public String toString() {
		//"Candle Stick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner"
		if (this instanceof Weapon) { // check if it is a valid person card
			Weapon w = (Weapon) this;
			if (w.weapon == WeaponType.CANDLESTICK) {
				return "Candle Stick";
			} else if (w.weapon == WeaponType.DAGGER) {
				return "Dagger";
			} else if (w.weapon == WeaponType.LEADPIPE) {
				return "Lead Pipe";
			} else if (w.weapon == WeaponType.REVOLVER) {
				return "Revolver";
			} else if (w.weapon == WeaponType.ROPE) {
				return "Rope";
			} else if (w.weapon == WeaponType.SPANNER) {
				return "Spanner";
			}
		}
		return null;
	}
	//###############################################
}

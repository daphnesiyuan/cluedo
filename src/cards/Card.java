package cards;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public interface Card {

/**
 * An interface for the object of type Card
 * a card is either a person, weapon or room
 * @author Daphne Wang
 */
	public ImageIcon cardIcon();
	public String toString();

}

package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import squares.DoorSquare;
import squares.RoomSquare;
import squares.Square;

public class Decision extends JFrame {

	private JPanel panel;
	private Handler handler;

	private String person;
	private String room;
	private String weapon;


	private JComboBox peopleList;
	private JComboBox weaponList;
	private JComboBox roomList;
	private Board board;

	private boolean isAccuse; // true: decision is an accusation
								// false: decision is a suggestion

	public Decision(Board bd, boolean b) {
		isAccuse = b;
		board = bd;


		//this.setSize(400, 200);

		//panel = new JPanel();
		//panel.setLayout(new FlowLayout()); // change later

		//this.add(panel);
		//this.setAlwaysOnTop(true); // ensures it pops up in front
		//this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setPersonButtons();
		//setRoomButtons();
		//setWeaponButtons();
		//submit = new JButton("submit");
		//submit.addActionListener(handler);
		//panel.add(submit);
		//CHANGE ############################################################
		Square s = board.getCurrentPlayer().getPiece().getCurrentSquare(board);
		if(isAccuse){
			roomGroup();
			personGroup();
			weaponGroup();
		}
		else if(s instanceof RoomSquare){

			personGroup();
			weaponGroup();
			RoomSquare r = (RoomSquare)s;
			room = r.getNameOfRoom();
		}

		//NEED TO CALL ANTONIAS METHOD
		//accuse(String p, String r, String w)
		if(isAccuse){
			board.accuse(person,room,weapon);
		}
		else if(s instanceof RoomSquare){
			board.suggestion(person,room,weapon);
		}
		//CHANGE ############################################################ CHANGED AGAIN
	}




	public void personGroup(){
		String[] people = { "Colonel Mustard", "Miss Scarlett", "Mrs Peacock", "Mrs White", "Professor Plum", "Reverend Green" };

		//Indices start at 0, so 4 specifies the pig.
		//peopleList = new JComboBox(people);
		//peopleList.setSelectedIndex(4);
		//peopleList.addActionListener(handler);

		//panel.add(peopleList);


		person = (String) JOptionPane .showInputDialog( null,
				"Pick a character:", "Accusation",
				JOptionPane.QUESTION_MESSAGE, null, people, people[0]);
	}

	public void weaponGroup(){
		//CANDLESTICK, DAGGER, LEADPIPE, REVOLVER, ROPE, SPANNER;
		String[] weapons =  { "Candle Stick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner" };

		weapon = (String) JOptionPane .showInputDialog( null,
				"Pick a weapon:", "Accusation",
				JOptionPane.QUESTION_MESSAGE, null, weapons, weapons[0]);
	}

	public void roomGroup(){
		//KITCHEN, BALLROOM, CONSERVATORY, BILLARDROOM, LIBRARY, STUDY, HALL, LOUNGE, DININGROOM;
		String[] rooms = { "Kitchen", "Ballroom", "Conservatory", "Billard Room", "Library", "Study", "Hall", "Lounge", "Dining Room" };

		room = (String) JOptionPane .showInputDialog( null,
				"Pick a room:", "Accusation",
				JOptionPane.QUESTION_MESSAGE, null, rooms, rooms[0]);
	}

	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if( e.getSource()==peopleList ){
				person = (String) peopleList.getSelectedItem();
			}
			else if( e.getSource()== weaponList){
				weapon = (String) weaponList.getSelectedItem();
			}
			else if( e.getSource()==roomList ){
				room = (String) roomList.getSelectedItem();
			}
		}
	}

}

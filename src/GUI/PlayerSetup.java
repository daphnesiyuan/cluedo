package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PlayerSetup extends JFrame{

	private BoardFrame boardFrame;
	//private JFrame this;
	private JPanel jpanel;

	private JButton submit;
	private theHandler handler;
	private ButtonGroup buttonGroup;
	private JRadioButton selectedButton;
	private JTextField textField;
	private String name = null; // for the creation of a new player
	private String piece = null;
	private Board board;
	private int playerCount;

	public PlayerSetup(Board b, BoardFrame bf, int c) {
		boardFrame = bf;
		playerCount = c;
		board = b;

		handler = new theHandler();

		submit = new JButton("Submit");
		submit.addActionListener(handler);
	}

	public void discard() {
		dispose();
	}

	public void setup() {

		new JFrame("The set up menu");
		this.setSize(400, 200);

		jpanel = new JPanel();
		jpanel.setLayout(new FlowLayout()); // change later
		jpanel.add(new JLabel("Welcome to Cluedo! "
				+ "Fill in your player name and select a character"));

		jpanel.add(Box.createHorizontalStrut(50)); // a spacer

		this.add(jpanel);
		this.setAlwaysOnTop(true); // ensures it pops up in front
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// user inputs
		setTextField();
		setRadioButtons();
		jpanel.add(submit);
	}

	public void setTextField() {
		JLabel label = new JLabel("\nPlayer name:");
		label.setToolTipText("hit enter to finalise name input");
		textField = new JTextField(20);
		textField.getDocument().addDocumentListener(new MyDocumentListener());

		jpanel.add(label);
		jpanel.add(textField);
	}

	/**
	 * This is an inner class which handles changes made in the text box for
	 * player name
	 */
	private class MyDocumentListener implements DocumentListener {
		public void insertUpdate(DocumentEvent e) {
			name = textField.getText();
		}

		public void removeUpdate(DocumentEvent e) {
			name = textField.getText();
		}

		public void changedUpdate(DocumentEvent e) {
			// Plain text components do not fire these events
		}
	}

	/**
	 * This is a private class that implements action listener This class can
	 * handle events in the set-up GUI It contains one method:
	 * actionPerformed(e)
	 *
	 * @author Daphne
	 */

	private class theHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			//System.out.println("action listener");

			// responds to radiobuttons
			if ("ColonelMustard".equals(e.getActionCommand())) {
				selectedButton = (JRadioButton) e.getSource();
				piece = "ColonelMustard";
			} else if ("MissScarlett".equals(e.getActionCommand())) {
				selectedButton = (JRadioButton) e.getSource();
				piece = "MissScarlett";
			} else if ("MrsPeacock".equals(e.getActionCommand())) {
				selectedButton = (JRadioButton) e.getSource();
				piece = "MrsPeacock";
			} else if ("MrsWhite".equals(e.getActionCommand())) {
				selectedButton = (JRadioButton) e.getSource();
				piece = "MrsWhite";
			} else if ("ProfessorPlum".equals(e.getActionCommand())) {
				selectedButton = (JRadioButton) e.getSource();
				piece = "ProfessorPlum";
			} else if ("ReverendGreen".equals(e.getActionCommand())) {
				selectedButton = (JRadioButton) e.getSource();
				piece = "ReverendGreen";
			}

			// responds to the final submit, and forwards new player info onto
			// the board
			else if (e.getSource() == submit) {
				if (name != null && piece != null && name.length() > 0) { // valid
																			// inputs
					//System.out.println("submit the name " + name
					//		+ " and character " + piece);
					board.createPlayer(name, piece);
					// reset
					name = null;
					piece = null;
					playerCount--;
					textField.setText("");
					selectedButton.getModel().setEnabled(false);

					//System.out.println("playerCount=" + playerCount);
					if (playerCount == 0) { // CHANGES: ADDED THIS CHECK
						dispose();
						board.startGame(); // /CHANGES
					}

				} else {
					sendFailure();
				}
			}

		}

		public void sendFailure() {
			JFrame warning = new JFrame();
			JOptionPane.showMessageDialog(warning,
					"Please input valid details!");
		}
	}

	public void setRadioButtons() {
		jpanel.add(new JLabel("\nSelect a character:"));

		// initialise buttons
		JRadioButton ColonelMustard = new JRadioButton("Colonel Mustard");
		ColonelMustard.setMnemonic(KeyEvent.VK_B);
		ColonelMustard.setActionCommand("ColonelMustard");
		ColonelMustard.setSelected(false);

		JRadioButton MissScarlett = new JRadioButton("Miss Scarlett");
		MissScarlett.setMnemonic(KeyEvent.VK_B);
		MissScarlett.setActionCommand("MissScarlett");
		MissScarlett.setSelected(false);

		JRadioButton MrsPeacock = new JRadioButton("Mrs Peacock");
		MrsPeacock.setMnemonic(KeyEvent.VK_B);
		MrsPeacock.setActionCommand("MrsPeacock");
		MrsPeacock.setSelected(false);

		JRadioButton MrsWhite = new JRadioButton("Mrs White");
		MrsWhite.setMnemonic(KeyEvent.VK_B);
		MrsWhite.setActionCommand("MrsWhite");
		MrsWhite.setSelected(false);

		JRadioButton ProfessorPlum = new JRadioButton("Professor Plum");
		ProfessorPlum.setMnemonic(KeyEvent.VK_B);
		ProfessorPlum.setActionCommand("ProfessorPlum");
		ProfessorPlum.setSelected(false);

		JRadioButton ReverendGreen = new JRadioButton("Reverend Green");
		ReverendGreen.setMnemonic(KeyEvent.VK_B);
		ReverendGreen.setActionCommand("ReverendGreen");
		ReverendGreen.setSelected(false);

		// group the radio buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(ColonelMustard);
		buttonGroup.add(MissScarlett);
		buttonGroup.add(MrsPeacock);
		buttonGroup.add(MrsWhite);
		buttonGroup.add(ProfessorPlum);
		buttonGroup.add(ReverendGreen);

		// forward action listeners
		ColonelMustard.addActionListener(handler);
		MissScarlett.addActionListener(handler);
		MrsPeacock.addActionListener(handler);
		MrsWhite.addActionListener(handler);
		ProfessorPlum.addActionListener(handler);
		ReverendGreen.addActionListener(handler);

		jpanel.add(ColonelMustard);
		jpanel.add(MissScarlett);
		jpanel.add(MrsPeacock);
		jpanel.add(MrsWhite);
		jpanel.add(ProfessorPlum);
		jpanel.add(ReverendGreen);
	}

}

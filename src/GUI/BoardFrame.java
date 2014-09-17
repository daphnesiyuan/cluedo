package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import players.Player;

public class BoardFrame extends JFrame {

	private JMenuBar menuBar;
	private JMenu file, game;
	private JMenu newItem;
	public final BoardPanel panel;
	private Board board;
	private JMenuItem players3;
	private JMenuItem players4;
	private JMenuItem players5;
	private JMenuItem players6;
	private TopMenu c;

	private PlayerSetup playersetup;

	private int playerCount;
	public JPanel sidePanel;
	private BottomPanel bottomPanel;
	private final int size = 30;

	public BoardFrame(Board b) {

		super("Cluedo");
		board = b;
		c = new TopMenu(board);
		panel = new BoardPanel(board, c);
		setLayout(new BorderLayout()); // use border layout
		add(panel, BorderLayout.CENTER); // add canvas
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		closingWarningBox();

		setupSidePanel();
		setupBottomPanel();

		pack(); // pack components tightly together
		setupMenuBar();
		setResizable(false); // prevent us from being resizeable
		setVisible(true); // make sure we are visible!

	}

	/**
	 * repaints the panel
	 */

	public void repaint() {
		panel.repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		// return new Dimension(size * 25-20, 27 * size - 10);
		return new Dimension(size * 35 - 20, 35 * size - 10);

	}


	public JPanel getSidePanel() {
		return sidePanel;
	}

	/**
	 * calls the constructor of the side panel object
	 */
	public void setupSidePanel() {
		sidePanel = new SidePanel(this, board);
	}

	/**
	 * calls the constructor of the bottom panel object
	 */
	public void setupBottomPanel(){
		bottomPanel = new BottomPanel(this,board );
	}

	/**
	 * redraws the bottom panel object
	 */
	public void redrawBottomPanel(Player p){
		bottomPanel.drawCards(p);
	}

	/**
	 * The main method for the GUI involving game set up. This method uses a
	 * combination of helper methods that deal with player name inputs and
	 * character selections
	 *
	 * @param amount
	 *            of players
	 */

	public void setupPlayerMenu(int players) { // CHANGED NAME OF METHOD

		playerCount = players;
		playersetup = new PlayerSetup(board, this, playerCount);

		if (players > 0) {
			//System.out.println("amt of players= " + players);

			playersetup.setup(); // Method to prepare the JFrame and JPanel
									// involved with the player setups
			this.setVisible(true);

		} else {
			playersetup.discard();
		}
	}

	/**
	 * This is the main method dealing with the menu bar on top of the GUI It
	 * involves the initial set up for the amount of players for a new game.
	 */

	public void setupMenuBar() {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		menuBar.add(file);
		newItem = new JMenu("New Game");
		file.add(newItem);
		players3 = new JMenuItem("3 Players");
		players4 = new JMenuItem("4 Players");
		players5 = new JMenuItem("5 Players");
		players6 = new JMenuItem("6 Players");

		newItem.add(players3); // adds to the drop list under "New Game"
		players3.addActionListener(c);

		newItem.add(players4);
		players4.addActionListener(c);

		newItem.add(players5);
		players5.addActionListener(c);

		newItem.add(players6);
		players6.addActionListener(c);
		// file.setMnemonic(KeyEvent.VK_A);
		// ADD FILE ITEMS HERE
		game = new JMenu("Game");
		// ADD GAME ITEMS HERE
		menuBar.add(file);
		//menuBar.add(game);
		this.setJMenuBar(menuBar);
	}

	public void closingWarningBox() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to exit the game?", "Warning",
						JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
	}

}

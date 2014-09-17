package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Card;
import players.Player;

public class BottomPanel extends JPanel {

	private int size = 30;
	private BoardFrame boardFrame;
	private ArrayList<Card> currentHand;
	private JLabel[] cardLabels = new JLabel[6];
	private JPanel playerProfile;
	private Player currentPlayer;
	private Color bg = new Color(23, 39, 39);

	public BottomPanel(BoardFrame bf, Board b) {
		boardFrame = bf;
		boardFrame.add(this, BorderLayout.SOUTH);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(size * 15 - 20, size * 8));
		setBackground(bg);
		initialiseLabels();

	}

	public void initialiseLabels() {

		playerProfile = new JPanel();

		cardLabels[0] = new JLabel();
		cardLabels[1] = new JLabel();
		cardLabels[2] = new JLabel();
		cardLabels[3] = new JLabel();
		cardLabels[4] = new JLabel();
		cardLabels[5] = new JLabel();

		this.add(cardLabels[0]);
		this.add(cardLabels[1]);
		this.add(cardLabels[2]);
		this.add(cardLabels[3]);
		this.add(cardLabels[4]);
		this.add(cardLabels[5]);

		cardLabels[0].setAlignmentX(LEFT_ALIGNMENT);
		cardLabels[1].setAlignmentX(LEFT_ALIGNMENT);
		cardLabels[2].setAlignmentX(LEFT_ALIGNMENT);
		cardLabels[3].setAlignmentX(LEFT_ALIGNMENT);
		cardLabels[4].setAlignmentX(LEFT_ALIGNMENT);
		cardLabels[5].setAlignmentX(LEFT_ALIGNMENT);
	}

	public void drawCards(Player p) {
		currentPlayer = p;
		currentHand = p.getHand();

		this.removeAll(); // this refreshes the bottom panel for each new player
		initialiseLabels();

		int i = 0;
		for (Card c : currentHand) {
			this.add(Box.createRigidArea(new Dimension(12, 50)));
			ImageIcon card = c.cardIcon();
			//System.out.println(card.toString());
			cardLabels[i].setIcon(card);

			cardLabels[i].updateUI();

			i++;
		}

		drawProfile();

		this.revalidate();
		this.repaint();
		boardFrame.repaint();
	}

	public void drawProfile() {

		//System.out.println("drawing profile");
		// playerProfile.setPreferredSize(new Dimension(size * 1, size * 8));
		// playerProfile.setSize(size*2, size*8);
		// playerProfile.setBackground(Color.BLUE);
		// this.add(playerProfile);

		// playerProfile.setAlignmentX(RIGHT_ALIGNMENT);
		// playerProfile.setOpaque(true);

		JLabel playerProfile = new JLabel();
		playerProfile.setIcon(currentPlayer.getIcon());
		// playerProfile.setAlignmentX(LEFT_ALIGNMENT);
		playerProfile.updateUI();

		this.add(playerProfile);

	}

	public void drawBottomPanel(Graphics g) {
		super.paintComponent(g);
	}

}

package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import players.Player;


public class SidePanel extends JPanel {

	private BoardFrame boardFrame;

	private Board board;
	private handler h;
	private ArrayList<ImageIcon> images;

/*	SidePanel s = new SidePanel(null, null);
	s = (SidePanel)(getBoardFrame().sidePanel);
	s.refreshDectectiveNotes();
*/

	private JLabel diceLabel;	//	dice 1
	private JLabel diceLabel1;	//	dice 2
	private JLabel label2;		//	detective notes
	private JLabel label3;		//	people
	private JLabel label4;		//	rooms
	private JLabel label5;		//	weapons

	private JScrollPane pane3;	//	people
	private JScrollPane pane4;	//	rooms
	private JScrollPane pane5;	//	weapons

	private JTextArea text3;	//	people
	private JTextArea text4;	//	rooms
	private JTextArea text5;	//	weapons

	private JButton accuse;
	private JButton suggest;
	private JButton rollDice;
	private JButton endTurn;

	private final int size = 30;
	private final Color bg = new Color(23,39,39);

	public SidePanel(BoardFrame bf, Board b){
		board = b;
		boardFrame = bf;
		boardFrame.add(this, BorderLayout.EAST);
		h=new handler();
		setupDiceImages();

		this.setLayout( new BoxLayout(this, BoxLayout.PAGE_AXIS) );
		setPreferredSize( new Dimension( size*10+1,size*20-10 ) );
		setBackground(bg);


		createButtons();
		addButtons();
		setupDetectiveNotes();
	}
	public boolean gameStarted(){
		if(board.getPlayers().size()!=0) return true;

		return false;

	}

	public void setupDetectiveNotes(){
		this.add(Box.createRigidArea(new Dimension(0,25)));
		label2 = new JLabel("Detective Notes: ");
		label2.setForeground(Color.white);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label2);



		label3 = new JLabel("Suspects: ");
		label3.setForeground(Color.white);
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label3);

		text3 = new JTextArea();
		pane3 = new JScrollPane(text3);
		this.add(pane3);

		label4 = new JLabel("Murder weapons: ");
		label4.setForeground(Color.white);
		label4.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label4);


		text4 = new JTextArea();

		pane4 = new JScrollPane(text4);
		//pane4.add(text4);
		this.add(pane4);

		label5 = new JLabel("Locations: ");
		label5.setForeground(Color.white);
		label5.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label5);

		text5 = new JTextArea();
		pane5 = new JScrollPane(text5);
		this.add(pane5);
	}

	public void refreshDectectiveNotes(){
		Player p = board.getCurrentPlayer();
		text3.setText(p.getBox1());
		text4.setText(p.getBox2());
		text5.setText(p.getBox3());

	}

	/**
	 * Populates an arraylist containing images of the dice for the game
	 */

	public void setupDiceImages(){
		ImageIcon dice1 = new ImageIcon(SidePanel.class.getResource("diceImages/dice1.jpg"));
		ImageIcon dice2 = new ImageIcon(SidePanel.class.getResource("diceImages/dice2.jpg"));
		ImageIcon dice3 = new ImageIcon(SidePanel.class.getResource("diceImages/dice3.jpg"));
		ImageIcon dice4 = new ImageIcon(SidePanel.class.getResource("diceImages/dice4.jpg"));
		ImageIcon dice5 = new ImageIcon(SidePanel.class.getResource("diceImages/dice5.jpg"));
		ImageIcon dice6 = new ImageIcon(SidePanel.class.getResource("diceImages/dice6.jpg"));

		images = new ArrayList<ImageIcon>();
		images.add(dice1);
		images.add(dice2);
		images.add(dice3);
		images.add(dice4);
		images.add(dice5);
		images.add(dice6);

		this.add(Box.createRigidArea(new Dimension(0,5))); //spacer
		diceLabel = new JLabel(dice1);
		diceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		diceLabel1 = new JLabel(dice1);
		diceLabel1.setAlignmentX(Component.RIGHT_ALIGNMENT);

		this.add(diceLabel1);
		this.add(diceLabel);
	}


	public void createButtons(){
		accuse = new JButton("Accuse");
		suggest = new JButton("Suggest");
		rollDice = new JButton("Roll Dice");
		endTurn = new JButton("End Turn");

		accuse.setAlignmentX(Component.CENTER_ALIGNMENT);
		suggest.setAlignmentX(Component.CENTER_ALIGNMENT);
		rollDice.setAlignmentX(Component.CENTER_ALIGNMENT);
		endTurn.setAlignmentX(Component.CENTER_ALIGNMENT);


		accuse.addActionListener(h);
		suggest.addActionListener(h);
		rollDice.addActionListener(h);
		endTurn.addActionListener(h);
	}

	public void addButtons(){

		this.add(Box.createRigidArea(new Dimension(0,25)));
		add(rollDice);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		add(endTurn);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		add(suggest);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		add(accuse);
	}

	/**
	 *
	 * draws the images representing the dice given two random numbers generated in the board
	 *
	 * @param dice1
	 * @param dice2
	 */
	public void drawDice(int dice1, int dice2){
		if(dice1==1){
			//System.out.println("rolled 1");

			diceLabel.setIcon( images.get(0) );
			diceLabel.revalidate();
			this.repaint();
		}
		else if(dice1==2){
			//System.out.println("rolled 2");

			diceLabel.setIcon(images.get(1));
			diceLabel.revalidate();
			this.repaint();
		}
		else if(dice1==3){
			//System.out.println("rolled 3");

			diceLabel.setIcon(images.get(2));;
			diceLabel.revalidate();
			this.repaint();
		}
		else if(dice1==4){
			//System.out.println("rolled 4");

			diceLabel.setIcon(images.get(3));;
			diceLabel.revalidate();
			this.repaint();
		}
		else if(dice1==5){
			//System.out.println("rolled 5");

			diceLabel.setIcon(images.get(4));;
			diceLabel.revalidate();
			this.repaint();
		}
		else if(dice1==6){
			//System.out.println("rolled 6");

			diceLabel.setIcon(images.get(5));;
			diceLabel.revalidate();
			this.repaint();
		}

		if(dice2==1){
			//System.out.println("rolled 1");

			diceLabel1.setIcon( images.get(0) );
			diceLabel1.revalidate();
			this.repaint();
		}
		else if(dice2==2){
			//System.out.println("rolled 2");

			diceLabel1.setIcon(images.get(1));
			diceLabel1.revalidate();
			this.repaint();
		}
		else if(dice2==3){
			//System.out.println("rolled 3");

			diceLabel1.setIcon(images.get(2));;
			diceLabel1.revalidate();
			this.repaint();
		}
		else if(dice2==4){
			//System.out.println("rolled 4");

			diceLabel1.setIcon(images.get(3));;
			diceLabel1.revalidate();
			this.repaint();
		}
		else if(dice2==5){
			//System.out.println("rolled 5");

			diceLabel1.setIcon(images.get(4));;
			diceLabel1.revalidate();
			this.repaint();
		}
		else if(dice2==6){
			//System.out.println("rolled 6");

			diceLabel1.setIcon(images.get(5));;
			diceLabel1.revalidate();
			this.repaint();
		}
	}


	private class handler implements ActionListener{


		public void actionPerformed(ActionEvent e){

			if(e.getSource()==accuse && gameStarted()){
				//System.out.println("accuse button pressed");

				Decision d = new Decision(board,true);
			}

			else if(e.getSource()==suggest&& gameStarted()){
				//System.out.println("suggest button pressed");
				Decision d = new Decision(board,false);
			}

			else if(e.getSource()==rollDice&& gameStarted()&&!board.diceRolled){
				board.rollDice();
				int d1 =board.getDie1();
				int d2 = board.getDie2();
				board.setDiceRolled(true);
				drawDice(d1,d2);
			}

			else if(e.getSource()==endTurn&& gameStarted()){
				Player p = board.getCurrentPlayer();
				p.setBox1(text3.getText());
				p.setBox2(text4.getText());
				p.setBox3(text5.getText());
				board.setDiceRolled(false);
				board.endTurn();
				refreshDectectiveNotes();

			}

		}

	}
}

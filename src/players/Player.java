package players;


import java.util.ArrayList;

import javax.swing.ImageIcon;

import pieces.ColonelMustard;
import pieces.MissScarlett;
import pieces.MrsPeacock;
import pieces.MrsWhite;
import pieces.Piece;
import pieces.ProfessorPlum;
import pieces.ReverendGreen;
import cards.Card;

public class Player{
	//could take care of mouse listener

	protected ArrayList<Card> hand = new ArrayList<Card>();
	Piece piece;
	String name;
	private Boolean active = true;
	//CHANGED#################
	private String box1 = "Colonel Mustard\n Miss Scarlett\n Mrs Peacock\n Mrs White\n Professor Plum\n Reverend Green";
	private String box2 = "Candle Stick\n Dagger\n Lead Pipe\n Revolver\n Rope\n Spanner";
	private String box3 = "Kitchen\n Ballroom\n Conservatory\n Billard Room\n Library\n Study\n Hall\n Lounge\n Dining Room";
	//########################
	/** Constructor 2: no hand is dealt yet - but still initialises the player
	 * @param n: name of the player - string
	 * @param p: the piece of the  board they pick to represent the player
	 */
	public Player(String n, Piece p){
		name=n;
		piece=p;

	}

	public Piece getPiece() {
		return piece;
	}

	/** takes a card parameter and adds it to the hand of the player.
	 * this should be used during the initialisation stage, when distributing cards between players
	 * @param c: card to give to player
	 */
	public void dealCard(Card c){
		if( !hand.contains(c) ){ //duplicate check
			hand.add(c);
		}
	}

	public ArrayList<Card> getHand(){
		return hand;
	}

	public String getName(){
		return name;
	}

	public void movePiece(int x, int y){
		int squareSize = 30;
		int newX = x/squareSize; //gives the actual index of the squares
		int newY = y/squareSize;

		this.piece.setX(x);
		this.piece.setY(y);
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getBox1() {
		return box1;
	}

	public String getBox2() {
		return box2;
	}

	public String getBox3() {
		return box3;
	}

	public void setBox1(String box1) {
		this.box1 = box1;
	}

	public void setBox2(String box2) {
		this.box2 = box2;
	}

	public void setBox3(String box3) {
		this.box3 = box3;
	}


	public ImageIcon getIcon(){
        //return new ImageIcon(Player.class.getResource("avatars/msAvatar.jpg"));

        if(piece instanceof ColonelMustard){
                return new ImageIcon(Player.class.getResource("avatars/cmAvatar.jpg"));
        }
        else if(piece instanceof MissScarlett){
                return new ImageIcon(Player.class.getResource("avatars/msAvatar.jpg"));
        }
        else if(piece instanceof MrsPeacock){
                return new ImageIcon(Player.class.getResource("avatars/mpAvatar.jpg"));
        }
        else if(piece instanceof MrsWhite){
                return new ImageIcon(Player.class.getResource("avatars/mwAvatar.jpg"));
        }
        else if(piece instanceof ProfessorPlum){
                return new ImageIcon(Player.class.getResource("avatars/ppAvatar.jpg"));
        }
        else if(piece instanceof ReverendGreen){
                return new ImageIcon(Player.class.getResource("avatars/rgAvatar.jpg"));
        }
        return null; //for compile
}


}

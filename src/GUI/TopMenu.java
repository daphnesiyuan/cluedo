package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TopMenu implements MouseListener, ActionListener{

	private Board board;
	boolean mouse = false;

	public TopMenu(Board b){
		board = b;
	}



	/**
	 * Action performed to respond to the NEW GAME menu selecting the amount of players
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    if ("3 Players".equals(e.getActionCommand())) {
	    	//open up a menu for 3 players
	    	//System.out.println("3 players selected");
	    	if(board.firstGame==false){ //only call a reset if it isn't the first game
	    		//System.out.println("RESET");

	    		board.reset();
	    	}
	    	mouse = true;
		    board.getBoardFrame().setupPlayerMenu(3);
		    board.initaliseCards(3);


	    }
	    else if( "4 Players".equals(e.getActionCommand()) ){
	    	//System.out.println("4 players selected");
	    	if(board.firstGame==false){ //only call a reset if it isn't the first game
	    		//System.out.println("RESET");
	    		board.reset();
	    	}
	    	mouse = true;
		    board.getBoardFrame().setupPlayerMenu(4);
		    board.initaliseCards(4);
	    }
	    else if( "5 Players".equals(e.getActionCommand()) ){
	    	if(board.firstGame==false){ //only call a reset if it isn't the first game
	    		//System.out.println("RESET");
	    		board.reset();
	    	}
	    	mouse = true;
		    board.getBoardFrame().setupPlayerMenu(5);
		    board.initaliseCards(5);
	    }
	    else if("6 Players".equals(e.getActionCommand())){
	    	if(board.firstGame==false){ //only call a reset if it isn't the first game
	    		//System.out.println("RESET");
	    		board.reset();
	    	}
	    	mouse = true;
		    board.getBoardFrame().setupPlayerMenu(6);
		    board.initaliseCards(6);
	    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(mouse){
		int x = e.getX();
		int y = e.getY();
		board.movePiece(x, y);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

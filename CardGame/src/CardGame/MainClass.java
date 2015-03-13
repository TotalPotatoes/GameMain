package CardGame;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MainClass extends JFrame implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Player> players=new ArrayList<Player>();
	private GuiGame gameWindow;
	private Table table;
	
	public static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int gameState=0;
	private int playerturn;
	private CardLayout c;
	private Container cont;
	private HashSet<Character> keyState=new HashSet<Character>();
	
	public MainClass(){
		gameWindow=new GuiGame();
		c=new CardLayout();
		cont=new Container();
		this.add(cont);
		cont.setLayout(c);
		cont.add(gameWindow, "game");
		//c.show(cont, "menu");
		this.setSize(SCREEN);
		this.addKeyListener(this);

		this.setUndecorated(true);

		Thread t = new Thread(this);
		t.start();
		
	}

	public static void main(String[] args) {
		MainClass m=new MainClass();
		m.setVisible(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void run() {
		Player activePlayer;
		players.add(new Player());//testing code
		while(true){
			//note that most of this is just testing code because w.e
			switch(gameState){
				case 0:{
					if(keyState.contains('g')&&keyState.contains('h')){
						System.exit(0);
					}
					if(keyState.contains('a')){
						gameState=1;
					}
					break;
				}
				case 1:{
					if(keyState.contains('b')){
						gameState=0;
					}
					activePlayer=players.get(playerturn);
					if(keyState.contains('l')){
						JFileChooser fileC=new JFileChooser();
						/*
						try {
							activePlayer.loadDeck("idkyet");
						} catch (DeckCreationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/	
					}
					break;
				}
				case 2:{
					
				}
				default:{
					
				}
				
			}
			try {
				//this.repaint();
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyState.add(e.getKeyChar());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyState.remove(e.getKeyChar());
		// TODO Auto-generated method stub
		
	}

}

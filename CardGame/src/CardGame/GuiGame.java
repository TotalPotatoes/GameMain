package CardGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Gui Maybe?
 * @author Bernard Serbinowski
 * @author Seth Zebrack
 */



public class GuiGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		Card c=new Card("Default 2");
		System.out.println(c.getName());
		System.out.println(c.getCastTime());
		System.out.println(c.getResourceConvertable());
		System.out.println(c.getType());
		*/
		Deck d=new Deck();
		try {
			d.loadDeck("D:/repositories/GameMain/CardGame/src/CardGame/the best deck.txt");
		} catch (DeckCreationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiGame window = new GuiGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 115, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setBounds(10, 36, 37, 14);
		frame.getContentPane().add(lblStats);
		
		JLabel labelHP = new JLabel("Hp:    100/100");
		labelHP.setBounds(10, 56, 75, 14);
		frame.getContentPane().add(labelHP);
		
		JLabel labelAttack = new JLabel("Attack      6");
		labelAttack.setBounds(10, 76, 75, 14);
		frame.getContentPane().add(labelAttack);

		JLabel labelDefense = new JLabel("Defense    3");
		labelDefense.setBounds(10, 96, 75, 14);
		frame.getContentPane().add(labelDefense);
		
		JLabel labelSmarts = new JLabel("intellect    0");
		labelSmarts.setBounds(10,116, 75, 14);
		frame.getContentPane().add(labelSmarts);
		
		Canvas Picture = new Canvas();
		Picture.setBackground(new Color(0, 0, 0));
		Picture.setBounds(107, 31, 100, 100);
		frame.getContentPane().add(Picture);
		

	}
}
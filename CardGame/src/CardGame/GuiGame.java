package CardGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Color;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guione window = new Guione();
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
	public Guione() {
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
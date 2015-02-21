package CardGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GuiDeckBuilder {

	private JFrame frame;
	private JTextField NameInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDeckBuilder window = new GuiDeckBuilder();
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
	public GuiDeckBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		NameInput = new JTextField();
		NameInput.setText("Input");
		NameInput.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(NameInput);
		NameInput.setColumns(10);
		
		JButton Nameok = new JButton("Ok");
		Nameok.setBounds(10, 45, 89, 23);
		frame.getContentPane().add(Nameok);
	}
}

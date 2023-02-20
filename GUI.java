import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
  	public Match match;
	private JButton btnGuess;


	/**
	 * Create the frame.
	 */
	public GUI(Match m) {
    	this.match = m;
		setTitle("4 Board Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel board = new JPanel();
		contentPane.add(board, BorderLayout.CENTER);
		board.setLayout(new GridLayout(0, 5, 5, 10));
		
		JLabel lblNewLabel_6 = new JLabel("P4");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_6);
		
    	Icon icoDA = new ImageIcon("reddot.png");
		JButton btnDA = new JButton(icoDA);
		board.add(btnDA);
		
    	Icon icoDB = new ImageIcon("reddot.png");
		JButton btnDB = new JButton(icoDB);
		board.add(btnDB);
		
    	Icon icoDC = new ImageIcon("reddot.png");
		JButton btnDC = new JButton(icoDC);
		board.add(btnDC);
		
    	Icon icoDD = new ImageIcon("reddot.png");
		JButton btnDD = new JButton(icoDD);
		board.add(btnDD);
		
		JLabel lblNewLabel_9 = new JLabel("P3");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_9);
		
    	Icon icoCA = new ImageIcon("reddot.png");
		JButton btnCA = new JButton(icoCA);
		board.add(btnCA);
		
    	Icon icoCB = new ImageIcon("reddot.png");
		JButton btnCB = new JButton(icoCB);
		board.add(btnCB);
		
    	Icon icoCC = new ImageIcon("reddot.png");
		JButton btnCC = new JButton(icoCC);
		board.add(btnCC);
		
   	 	Icon icoCD = new ImageIcon("reddot.png");
		JButton btnCD = new JButton(icoCD);
		board.add(btnCD);
		
		JLabel lblNewLabel_8 = new JLabel("P2");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_8);
		
    	Icon icoBA = new ImageIcon("reddot.png");
		JButton btnBA = new JButton(icoBA);
		board.add(btnBA);
		
    	Icon icoBB = new ImageIcon("reddot.png");
		JButton btnBB = new JButton(icoBB);
		board.add(btnBB);
		
    	Icon icoBC = new ImageIcon("reddot.png");
		JButton btnBC = new JButton(icoBC);
		board.add(btnBC);
		
    	Icon icoBD = new ImageIcon("reddot.png");
		JButton btnBD = new JButton(icoBD);
		board.add(btnBD);
		
		JLabel lblNewLabel_7 = new JLabel("P1");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_7);
		
    	Icon icoAA = new ImageIcon("greendot.png");
		JButton btnAA = new JButton(icoAA);
		board.add(btnAA);
		
    	Icon icoAB = new ImageIcon("reddot.png");
		JButton btnAB = new JButton(icoAB);
		board.add(btnAB);
		
    	Icon icoAC = new ImageIcon("reddot.png");
		JButton btnAC = new JButton(icoAC);
		board.add(btnAC);
		
  		Icon icoAD = new ImageIcon("reddot.png");
		JButton btnAD = new JButton(icoAD);
		board.add(btnAD);
		
		JLabel lblNewLabel = new JLabel();
		board.add(lblNewLabel);
		
		JLabel lblNewLabel_13 = new JLabel("P1");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("P2");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("P3");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("P4");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		board.add(lblNewLabel_16);
		
		JPanel menu = new JPanel();
		contentPane.add(menu, BorderLayout.SOUTH);

   		JLabel lblGameInMatch = new JLabel("(1/10)");
		menu.add(lblGameInMatch);
		
		JLabel lblPrompt0 = new JLabel("Enter a Number: ");
		menu.add(lblPrompt0);
		
		textField = new JTextField();
		menu.add(textField);
		textField.setColumns(10);

		btnGuess = new JButton("Guess");
    	btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        //action listener for guess button
				
			}
		});
		menu.add(btnGuess);
		
		JLabel lblPrompt1 = new JLabel("Your Set: ");
		menu.add(lblPrompt1);
		
		JLabel lblUserSet = new JLabel("{ }");
		menu.add(lblUserSet);
		setVisible(true);
	} //end of constructor

} //end of class

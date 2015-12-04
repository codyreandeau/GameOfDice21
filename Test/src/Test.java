import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test {

	JFrame frmGameOfDice;
	private JTextField txtYourScore;
	private JTextField txtCompScore;
	private JLabel lblYourScore;
	private JLabel lblComputerScore;
	//Create scanner object for keyboard input
    Scanner keyboard = new Scanner(System.in);
    private JLabel lblDice1;
    private JLabel lblDice2;
    private JLabel lblDie1;
    private JLabel lblDie2;
    private int clickCounter = 0;
    private JButton btnRollAgain;
    Random dice = new Random();
    int dice1 = 0;
    int dice2 = 0;
    int compDice1 = 0;
    int compDice2 = 0;
    int userTotal = 0;
    int compTotal = 0;
    String input;
    private JButton lblStay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frmGameOfDice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOfDice = new JFrame();
		frmGameOfDice.getContentPane().setBackground(new Color(0, 204, 51));
		frmGameOfDice.setTitle("Game of 21!");
		frmGameOfDice.setBounds(100, 100, 382, 300);
		frmGameOfDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameOfDice.getContentPane().setLayout(null);
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.setForeground(Color.BLACK);
		btnRollDice.setBackground(Color.WHITE);
		btnRollDice.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clickCounter++;
				    
				    //Roll dice for the computer
				    if (clickCounter <= 1)
				    {
				    compDice1 = dice.nextInt(6) + 1;
				    compDice2 = dice.nextInt(6) + 1;
				    compTotal += compDice1 + compDice2;
				    
				    //Display the users first roll
				    dice1 = dice.nextInt(6) + 1;
				    dice2 = dice.nextInt(6) + 1;
				    
				    userTotal = dice1 + dice2;
				    txtYourScore.setText(Integer.toString(userTotal));
				    lblDie1.setText(Integer.toString(dice1));
				    lblDie2.setText(Integer.toString(dice2));
				    }
				    else if (clickCounter > 1)
				    {
				    	JOptionPane.showMessageDialog(null, "Please click the 'Roll Again' button for another roll");
				    }
				    
			}
				    
		});
		btnRollDice.setBounds(10, 125, 86, 43);
		frmGameOfDice.getContentPane().add(btnRollDice);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set values to zero
				 dice1 = 0;
			     dice2 = 0;
			     compDice1 = 0;
			     compDice2 = 0;
			     userTotal = 0;
			     compTotal = 0;
			     clickCounter = 0;
			     txtYourScore.setText("");
			     txtCompScore.setText("");
			     lblDie1.setText("");
			     lblDie2.setText("");
			}
		});
		btnNewGame.setForeground(Color.BLACK);
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewGame.setBackground(Color.WHITE);
		btnNewGame.setBounds(133, 192, 102, 43);
		frmGameOfDice.getContentPane().add(btnNewGame);
		
		lblYourScore = new JLabel("Your \r\nScore:");
		lblYourScore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourScore.setBounds(23, 27, 73, 54);
		frmGameOfDice.getContentPane().add(lblYourScore);
		
		lblComputerScore = new JLabel("Computer Score:");
		lblComputerScore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComputerScore.setBounds(190, 47, 114, 14);
		frmGameOfDice.getContentPane().add(lblComputerScore);
		
		txtYourScore = new JTextField();
		txtYourScore.setEditable(false);
		txtYourScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtYourScore.setBackground(Color.BLUE);
		txtYourScore.setForeground(Color.WHITE);
		txtYourScore.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtYourScore.setBounds(119, 32, 46, 43);
		frmGameOfDice.getContentPane().add(txtYourScore);
		txtYourScore.setColumns(10);
		
		txtCompScore = new JTextField();
		txtCompScore.setEditable(false);
		txtCompScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtCompScore.setForeground(Color.WHITE);
		txtCompScore.setBackground(Color.BLUE);
		txtCompScore.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtCompScore.setColumns(10);
		txtCompScore.setBounds(302, 29, 46, 43);
		frmGameOfDice.getContentPane().add(txtCompScore);
		
		lblDice1 = new JLabel("Dice 1:");
		lblDice1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDice1.setBounds(257, 140, 46, 14);
		frmGameOfDice.getContentPane().add(lblDice1);
		
		lblDice2 = new JLabel("Dice 2:");
		lblDice2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDice2.setBounds(257, 192, 46, 14);
		frmGameOfDice.getContentPane().add(lblDice2);
		
		lblDie1 = new JLabel("");
		lblDie1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDie1.setForeground(new Color(0, 0, 0));
		lblDie1.setBounds(302, 140, 46, 14);
		frmGameOfDice.getContentPane().add(lblDie1);
		
		lblDie2 = new JLabel("");
		lblDie2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDie2.setBounds(302, 192, 46, 14);
		frmGameOfDice.getContentPane().add(lblDie2);
		
		btnRollAgain = new JButton("Roll Again");
		btnRollAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clickCounter >= 1)
				{
				compDice1 = dice.nextInt(6) + 1;
			    compDice2 = dice.nextInt(6) + 1;
			    compTotal += compDice1 + compDice2;
			    
			    //Display the users first roll
			    dice1 = dice.nextInt(6) + 1;
			    dice2 = dice.nextInt(6) + 1;
			    
			    userTotal += dice1 + dice2;
			    txtYourScore.setText(Integer.toString(userTotal));
			    lblDie1.setText(Integer.toString(dice1));
			    lblDie2.setText(Integer.toString(dice2));
			    
			    //If user gets a blackjack
			      if(userTotal == 21)
			      {
			    	  JOptionPane.showMessageDialog(null, "BLACKJACK! YOU WIN!");
			    	  dice1 = 0;
					     dice2 = 0;
					     compDice1 = 0;
					     compDice2 = 0;
					     userTotal = 0;
					     compTotal = 0;
					     clickCounter = 0;
					     txtYourScore.setText("");
					     txtCompScore.setText("");
					     lblDie1.setText("");
					     lblDie2.setText("");
			      }
			      //If user goes over 21
			      else if (userTotal > 21)
			      {
			    	  JOptionPane.showMessageDialog(null, "Sorry, you went over 21. the computer wins by default.");
			    	  dice1 = 0;
					     dice2 = 0;
					     compDice1 = 0;
					     compDice2 = 0;
					     userTotal = 0;
					     compTotal = 0;
					     clickCounter = 0;
					     txtYourScore.setText("");
					     txtCompScore.setText("");
					     lblDie1.setText("");
					     lblDie2.setText("");
			      }
				}
			else
				JOptionPane.showMessageDialog(null, "Please hit the 'Roll Dice' button first.");
				
			}
		});
		btnRollAgain.setForeground(Color.BLACK);
		btnRollAgain.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRollAgain.setBackground(Color.WHITE);
		btnRollAgain.setBounds(10, 192, 102, 43);
		frmGameOfDice.getContentPane().add(btnRollAgain);
		
		lblStay = new JButton("Stay");
		lblStay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (clickCounter >= 1)
				{
				txtCompScore.setText(Integer.toString(compTotal));
				
				if(compTotal > 21)
			    {
			      JOptionPane.showMessageDialog(null, "The computer went over 21. You win!");;
			      dice1 = 0;
				     dice2 = 0;
				     compDice1 = 0;
				     compDice2 = 0;
				     userTotal = 0;
				     compTotal = 0;
				     clickCounter = 0;
				     txtYourScore.setText("");
				     txtCompScore.setText("");
				     lblDie1.setText("");
				     lblDie2.setText("");
			    }
			    //If the computer gets a blackjack
			    else if(compTotal == 21)
			    {
			    	JOptionPane.showMessageDialog(null, "The computer got a blackjack. You lose.");
			    	dice1 = 0;
				     dice2 = 0;
				     compDice1 = 0;
				     compDice2 = 0;
				     userTotal = 0;
				     compTotal = 0;
				     clickCounter = 0;
				     txtYourScore.setText("");
				     txtCompScore.setText("");
				     lblDie1.setText("");
				     lblDie2.setText("");
			    }
			    else if(compTotal == userTotal)
			    {
			    	JOptionPane.showMessageDialog(null, "DRAW! You and the computer have the same score!");
			    	dice1 = 0;
				     dice2 = 0;
				     compDice1 = 0;
				     compDice2 = 0;
				     userTotal = 0;
				     compTotal = 0;
				     clickCounter = 0;
				     txtYourScore.setText("");
				     txtCompScore.setText("");
				     lblDie1.setText("");
				     lblDie2.setText("");
			    }
				
				if (compTotal > userTotal && compTotal < 21)
			    {
					JOptionPane.showMessageDialog(null, "The computers score is: " + compTotal + ". Your score is: " + userTotal +
							". Sorry, you lose.");
					dice1 = 0;
				     dice2 = 0;
				     compDice1 = 0;
				     compDice2 = 0;
				     userTotal = 0;
				     compTotal = 0;
				     clickCounter = 0;
				     txtYourScore.setText("");
				     txtCompScore.setText("");
				     lblDie1.setText("");
				     lblDie2.setText("");
			    }
			    //If the user wins
			    else if (userTotal > compTotal)
			    {
			    	JOptionPane.showMessageDialog(null, "The computers score is: " + compTotal + ". Your score is: " + userTotal +
							". You Win!");
			    	dice1 = 0;
				     dice2 = 0;
				     compDice1 = 0;
				     compDice2 = 0;
				     userTotal = 0;
				     compTotal = 0;
				     clickCounter = 0;
				     txtYourScore.setText("");
				     txtCompScore.setText("");
				     lblDie1.setText("");
				     lblDie2.setText("");
			    }
				}
				else
					JOptionPane.showMessageDialog(null, "Please hit the 'Roll Dice' button first.");
					
				
			}
		});
		lblStay.setForeground(Color.BLACK);
		lblStay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStay.setBackground(Color.WHITE);
		lblStay.setBounds(119, 125, 95, 43);
		frmGameOfDice.getContentPane().add(lblStay);
	}
}

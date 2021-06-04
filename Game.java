package adv;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container content;
	JPanel gamePanel, startPanel, gameScreenPanel, buttonChoices;
	JLabel gameLabel;
	JButton startButton;
	Font titleSize = new Font("Times New Roman", Font.PLAIN, 30);
	Font startSize = new Font("Times New Roman", Font.PLAIN, 25);
	JTextArea gameText;
	
	TitleScreenhandler tsHandler = new TitleScreenhandler();
	
	public static void main (String args[]) {
		new Game();
	}
	
	public Game() {
		window = new JFrame();
		window.setSize(800,600); // size of the JFrame window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows for proper close of the application
		window.getContentPane().setBackground(Color.BLACK); // background color
		window.setLayout(null);
		content = window.getContentPane();
		
		gamePanel = new JPanel(); //creates a panel to add content
		gamePanel.setBounds(100,100,600,150); //boundary for the panel
		gamePanel.setBackground(Color.black);
		gameLabel = new JLabel("ADVENTURE QUESTING");
		gameLabel.setForeground(Color.YELLOW); //sets text color for title;
		gameLabel.setFont(titleSize); //sets size of the Title
		
		startPanel = new JPanel();
		startPanel.setBounds(300, 400, 200, 100);
		startPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.YELLOW);
		startButton.setFont(startSize);
		startButton.addActionListener(tsHandler);
		
		gamePanel.add(gameLabel);
		startPanel.add(startButton);
		
		content.add(gamePanel); //creates an area within the JFrame
		content.add(startPanel);
		
		// leave on bottom as JButton not showing up if placed at the top
		window.setVisible(true); //allows Jframe window to be seen

	}
	
	public void gameScreen() {
		gamePanel.setVisible(false);
		startPanel.setVisible(false);
		
		gameScreenPanel = new JPanel();
		gameScreenPanel.setBounds(100,100,600,250);
		gameScreenPanel.setBackground(Color.blue);
		content.add(gameScreenPanel);
		
		gameText = new JTextArea();
		gameText.setBounds(100,100,600,250);
		gameText.setBackground(Color.black);
		gameText.setForeground(Color.white);
		gameText.setFont(startSize);
		gameText.setLineWrap(true);
		gameScreenPanel.add(gameText);
		
		buttonChoices = new JPanel();
		buttonChoices.setBounds(250,350,300,150);
		buttonChoices.setBackground(Color.red);
		content.add(buttonChoices);
	}
	
	public class TitleScreenhandler implements ActionListener{
		public void actionPerformed (ActionEvent event) {
			gameScreen();
		}
	}
}

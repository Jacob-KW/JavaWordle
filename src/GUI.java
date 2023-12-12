import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;

public class GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	int totalNumberOfGuesses = 6;
	int totalLettersInWord = 5;
	
	JLabel[][] arrayChars = new JLabel[totalNumberOfGuesses][totalLettersInWord];
		
	int guessNumber = 0;
	
	String[] possibleWords = {"quick"};
	
	String correctWord = "";
	
	JPanel mainPanel = new JPanel();
	JPanel mainPlayspace = new JPanel();
	Border blacklineThin = BorderFactory.createLineBorder(Color.BLACK, 1);

	GridLayout customGridLayout = new GridLayout(totalNumberOfGuesses, totalLettersInWord);
	
	GridBagConstraints c = new GridBagConstraints();
	
	//Bottom panel 
	
	JPanel bottomPanel = new JPanel();
	JTextField enterGuess = new JTextField(15);
	JButton enterButton = new JButton("Enter");
	
	public void addToGUI() {
		for (int i = 0; i < totalNumberOfGuesses; i++) {
			for (int j = 0; j < totalLettersInWord; j++) {
				JLabel lbl = new JLabel("", SwingConstants.CENTER);
				lbl.setPreferredSize(new Dimension(50, 50));
				lbl.setBorder(blacklineThin);
				lbl.setOpaque(true);
				arrayChars[i][j] = lbl;
			}
		}
	}

	public void mainSettings() {
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.DARK_GRAY);
		customGridLayout.setHgap(5);
		customGridLayout.setVgap(5);
		mainPlayspace.setLayout(customGridLayout);
		mainPlayspace.setBackground(Color.DARK_GRAY);
	}
	
	public void bottomSettings() {
		
	}
	
	public void frameSettings() {
		setLayout(new BorderLayout());
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BTEC Wordle");
		setResizable(false);
	}
	
	public void populateMain() {
		mainPanel.add(mainPlayspace, c);
		for (int i = 0; i < totalNumberOfGuesses; i++) {
			for (int j = 0; j < totalLettersInWord; j++) {
				mainPlayspace.add(arrayChars[i][j]);
			}
		}
	}
	
	public void populateBottom() {
		bottomPanel.add(enterGuess);
		bottomPanel.add(enterButton);
	}
	
	public void populateFrame() {
		add(mainPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public void chooseRandomWord() {
      	Random r = new Random();        
      	int randomNumber=r.nextInt(possibleWords.length);
      	correctWord = possibleWords[randomNumber];
	}
	
	public void addWord() {
		String text = enterGuess.getText();
		if (text.length() != totalLettersInWord) {
			enterGuess.setText("");
			System.out.println("Test");
			return;
		} 
		
		if(checkForWin(text.toUpperCase(), correctWord.toUpperCase())) {
			new Congratulations(correctWord.toUpperCase(), totalLettersInWord);
		}

		for (int i = 0; i < correctWord.length(); i++) {
			boolean didBreak = false;
			char currentChar = text.charAt(i);
			for (int j = 0; j < correctWord.length(); j++) {
				if (currentChar == correctWord.charAt(i)) {
					arrayChars[guessNumber][i].setBackground(Color.GREEN);
					didBreak = true;
					break;
				}
				if (currentChar == correctWord.charAt(j)) {
					arrayChars[guessNumber][i].setBackground(Color.ORANGE);
					didBreak = true;
					break;
				}
			}
			if(!didBreak) {
				arrayChars[guessNumber][i].setBackground(Color.LIGHT_GRAY);
			}
			arrayChars[guessNumber][i].setText(String.valueOf(Character.toUpperCase(currentChar)));
		}
		
			
		guessNumber++;
		enterGuess.setText("");

	}
	
	public boolean checkForWin(String goal, String input) {
		return goal.equals(input);
	}
	
	public void updateTiles() {
		mainPlayspace.removeAll();
		for (int i = 0; i < totalNumberOfGuesses; i++) {
			for (int j = 0; j < totalLettersInWord; j++) {
				mainPlayspace.add(arrayChars[i][j]);
			}
		}
	}
	
	public void addActionListeners() {
		enterButton.addActionListener(this);
	}
	
	public GUI() {
		
		chooseRandomWord();
		
		addActionListeners();
		addToGUI();
		
		mainSettings();
		bottomSettings();
		frameSettings();
		
		populateMain();
		populateBottom();
		populateFrame();
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton) {
			addWord();
			updateTiles();
		}
	}
	
	public static void main(String[] args) {
		new GUI();
	}

}

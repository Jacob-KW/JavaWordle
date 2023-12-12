import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Congratulations extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	int totalNumberOfGuesses;
	int totalLettersInWord;
	
	JLabel[] arrayChars;
	
	JLabel winText = new JLabel();
	
	JPanel mainPanel = new JPanel();
	JPanel mainPlayspace = new JPanel();
	JPanel winTextPanel = new JPanel();
	Border blacklineThin = BorderFactory.createLineBorder(Color.BLACK, 1);
	
	GridLayout customGridLayout = new GridLayout(totalLettersInWord, 1);
	GridBagConstraints c = new GridBagConstraints();
	
	public Congratulations(String text, int totalLettersInWord) {
		arrayChars = new JLabel[totalLettersInWord];
		for (int i = 0; i < totalLettersInWord; i++) {
			JLabel lbl = new JLabel(String.valueOf(text.charAt(i)), SwingConstants.CENTER);
			lbl.setPreferredSize(new Dimension(50, 50));
			lbl.setBorder(blacklineThin);
			lbl.setOpaque(true);
			lbl.setBackground(Color.GREEN);
			arrayChars[i] = lbl;

		}
		
		
		mainPanel.add(mainPlayspace, c);
		
		winText.setText("Congratulations! The winning word was " + text + "!");
		
		winTextPanel.add(winText);
		
		for (int i = 0; i < totalLettersInWord; i++) {
			mainPlayspace.add(arrayChars[i]);
		}
		
		
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPlayspace.setBackground(Color.DARK_GRAY);
		
		setLayout(new BorderLayout());
		setSize(400, 130);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Congratulations!");
		setResizable(false);
		
		add(mainPanel, BorderLayout.CENTER);
		add(winTextPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}

}

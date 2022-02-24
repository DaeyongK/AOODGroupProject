import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Options extends QPanel implements ActionListener{
	private boolean allQuestions;
	private boolean shuffleQuestions;
	private JComboBox dropdown;
	private EstablisherButton numCorrectButton;
	private EstablisherButton allQuestionsButton;
	private EstablisherButton shuffleQuestionsButton;
	private EstablisherButton firstLastButton;
	private TransitionButton doneButton;
	private JPanel panel;
	
	Options(String title, Quizit q){
		super(title, q);
		panel = new JPanel();
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.\
		//dropdown menu
		dropdown =  new JComboBox();
		dropdown.addActionListener(this);
		panel.add(dropdown);
		//number correct button
		numCorrectButton = new EstablisherButton(this, 100, 40, Color.WHITE, "Questions with number of correct answers", 1);
		numCorrectButton.addActionListener(this);
		panel.add(numCorrectButton);
		//all questions button
		allQuestionsButton = new EstablisherButton(this, 100, 40, Color.WHITE, "All Questions", 2);
		allQuestionsButton.addActionListener(this);
		panel.add(allQuestionsButton);
		//shuffle questions button
		shuffleQuestionsButton = new EstablisherButton(this, 100, 40, Color.WHITE, "Shuffle Questions", 3);
		shuffleQuestionsButton.addActionListener(this);
		panel.add(shuffleQuestionsButton);
		//first last button
		firstLastButton = new EstablisherButton(this, 100, 40, Color.WHITE, "First to Last", 4);
		firstLastButton.addActionListener(this);
		panel.add(firstLastButton);
		//done button
		TransitionButton doneButton = new TransitionButton(this, 50, 25, Color.WHITE, "Done", 1, 5);
		doneButton.addActionListener(this);
		panel.add(doneButton);
	}
	
	Options(String title, Quizit q, boolean allQuestionsTrue, boolean shuffleQuestionsTrue){
		super(title, q);
		//sets value of allQuestions
		if(allQuestionsTrue) {
			allQuestions = true;
		} else {
			allQuestions = false;
		}
		//sets value of shuffleQuestions
		if(shuffleQuestionsTrue) {
			shuffleQuestions = true;
		} else {
			shuffleQuestions = false;
		}
	}
	
	public void radioClick() {
		
	}
	
	public boolean getShuffled() {
		return shuffleQuestions;
	}
	
	public boolean getAllQuestions() {
		return allQuestions;
	}
	
	public int getScreenID(){
		return 4;
	}

	@Override
	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buttonClicked(int buttonID) {
		// TODO Auto-generated method stub
		if(buttonID == 1) {
			//send to main menu screen
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(TITLE_COLOR);
	}
	
	public void actionPerformed(ActionEvent e){
		//when doneButton is pressed
		//when numCorrectButton is pressed
		//when allQuestionsButton is pressed
		//when shuffleQuestionsButton is pressed
		//when firstLastButton is pressed
		//when pfp3 is clicked
	}

}

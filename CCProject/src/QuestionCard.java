import java.awt.Color;
import java.awt.image.*;

import javax.swing.*;

public class QuestionCard extends QPanel{
	String question;
	Profile profile;
	Question currentQ;
	String answer;
	Quizit quizit;
	EstablisherButton ansBtn, knewAnsBtn, notKnewAnsBtn, nextQuestBtn, delQuestBtn, yesDelQuestBtn, noDelQuestBtn;
	TransitionButton editQuestBtn, backBtn;
	JLabel askedNumTimesText, correctNumTimesText, answerText, questionText, domainNameText;
	BufferedImage questImage;
	
	QuestionCard(String title, Quizit quiz) {
		super(title,quiz);
		quizit=quiz;
		currentQ=quiz.getQuestion();
		profile=quiz.getProfile();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		//make text boxes 
		askedNumTimesText= new JLabel("Asked: "+profile.getTimesAsked(currentQ.getID())+ " times");
		correctNumTimesText= new JLabel("Correct: "+profile.getAnsweredRight(currentQ.getID())+ " times");
		answerText= new JLabel(currentQ.getAnswer());
		answerText.setEnabled(false);
		questionText = new JLabel(currentQ.getQuestion());		
		domainNameText = new JLabel("Current Domain: "+quizit.getDomain().getDomainName());
		
		//make buttons
		editQuestBtn = new TransitionButton(this, 100,50, Color.white, "Edit Question", 12,5);
		
		backBtn = new TransitionButton(this, 100,50, Color.white, "Exit", 5,0);
		
		ansBtn = new EstablisherButton(this,100,50, Color.white, "Answer", 1);
		
		knewAnsBtn = new EstablisherButton(this, 90,40, Color.white, "I knew the answer", 2);
		knewAnsBtn.setEnabled(false);
		
		notKnewAnsBtn = new EstablisherButton(this, 90,40, Color.white, "I didn't know", 3);
		notKnewAnsBtn.setEnabled(false);
		
		nextQuestBtn = new EstablisherButton(this,100,50, Color.white, "Next Question", 4);
		nextQuestBtn.setEnabled(false);
		
		delQuestBtn = new EstablisherButton(this,100,50, Color.white, "Delete Question", 6);
		delQuestBtn.setEnabled(false);
		
		yesDelQuestBtn = new EstablisherButton(this,100,50, Color.white, "Yes", 7);
		yesDelQuestBtn.setEnabled(false);
		
		noDelQuestBtn = new EstablisherButton(this,100,50, Color.white, "No", 8);
		noDelQuestBtn.setEnabled(false);
		
		//add buttons and text to contentPane
		contentPane.add(ansBtn);
		contentPane.add(knewAnsBtn);
		contentPane.add(notKnewAnsBtn);
		contentPane.add(nextQuestBtn);
		contentPane.add(editQuestBtn);
		contentPane.add(delQuestBtn);
		contentPane.add(yesDelQuestBtn);
		contentPane.add(noDelQuestBtn);
		contentPane.add(backBtn);
		
		contentPane.add(askedNumTimesText);
		contentPane.add(correctNumTimesText);
		contentPane.add(answerText);
		contentPane.add(questionText);
		contentPane.add(domainNameText);
	}
	
	public int getScreenID() {
		return 6;
	}
	
	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	public void buttonClicked(int buttonID) {
		// buttID 0 = back button
		// buttID 1 = answer button
		// buttID 2 = knew answer button
		// buttID 3 = didn't know answer button
		// buttID 4 = next question button
		// buttID 5 = edit question button
		// buttID 6 = delete question button
		// buttID 7 = yes delete question button
		// buttID 8 = no don't delete question button
		
		if(buttonID==0) {
			quizit.changeScreen(12);
		} else if (buttonID==1) {
			ansBtn.setEnabled(false);
			knewAnsBtn.setEnabled(true);
			notKnewAnsBtn.setEnabled(true);
			answerText.setEnabled(true);
			profile.asked(currentQ.getID());
			askedNumTimesText.setText(profile.getTimesAsked(currentQ.getID())+"");
		} else if(buttonID==2) {
			knewAnsBtn.setEnabled(false);
			notKnewAnsBtn.setEnabled(false);
			nextQuestBtn.setEnabled(true);
			profile.answeredCorrectly(currentQ.getID());
			correctNumTimesText.setText(profile.getAnsweredRight(currentQ.getID())+"");
		} else if(buttonID==3) {
			knewAnsBtn.setEnabled(false);
			notKnewAnsBtn.setEnabled(false);
			nextQuestBtn.setEnabled(true);
		} else if(buttonID==4) {
			
		}
		
	}
	public void buttonClicked(int width, int height, Color color, String text, int screenID, int buttonID) {
		// TODO Auto-generated method stub
		
	}
}

import java.awt.Color;
import java.awt.image.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class QuestionCard extends QPanel{
	String question;
	Profile profile;
	Question currentQ;
	String answer;
	Quizit quizit;
	EstablisherButton ansBtn;
	EstablisherButton knewAnsBtn;
	EstablisherButton notKnewAnsBtn;
	EstablisherButton nextQuestBtn;
	TransitionButton editQuestBtn;
	BufferedImage questImage;
	
	QuestionCard(String title, Quizit quiz) {
		super(title,quiz);
		quizit=quiz;
		currentQ=quiz.getQuestion();
		profile=quiz.getProfile();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		ansBtn = new EstablisherButton(this,100,50, Color.white, "Answer", 0);
		knewAnsBtn = new EstablisherButton(this, 90,40, Color.white, "I knew the answer", 1);
		notKnewAnsBtn = new EstablisherButton(this, 90,40, Color.white, "I didn't know", 2);
		nextQuestBtn = new EstablisherButton(this,100,50, Color.white, "Next Question", 3;
		editQuestBtn = new TransitionButton(this, 100,50, Color.white, "Edit Question", 11,4);
		contentPane.add(ansBtn);
		contentPane.add(knewAnsBtn);
		contentPane.add(notKnewAnsBtn);
		contentPane.add(nextQuestBtn);
		contentPane.add(editQuestBtn);
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
		// buttID 5 = delete question button
		// buttID 6 = edit question button
		if(buttonID==0) {
			qui
		}
		
	}
	public void buttonClicked(int width, int height, Color color, String text, int screenID, int buttonID) {
		// TODO Auto-generated method stub
		
	}
}

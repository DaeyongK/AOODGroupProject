import java.awt.Color;
import java.awt.image.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class QuestionCard extends QPanel{
	String question;
	Profile profile;
	Question currentQ;
	String answer;
	EstablisherButton ansBtn;
	EstablisherButton knewAnsBtn;
	EstablisherButton notKnewAnsBtn;
	EstablisherButton nextQuestBtn;
	TransitionButton editQuestBtn;
	BufferedImage questImage;
	
	QuestionCard(String title, Question currentQuestion, Profile currentProfile) {
		super(title);
		currentQ=currentQuestion;
		profile=currentProfile;
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		Quizit game = new Quizit();
		ansBtn = new EstablisherButton(100,50, Color.white, "Answer", 0);
		knewAnsBtn = new EstablisherButton(90,40, Color.white, "I knew the answer", 1);
		notKnewAnsBtn = new EstablisherButton(90,40, Color.white, "I didn't know", 2);
		nextQuestBtn = new EstablisherButton(100,50, Color.white, "Next Question", 3);
		editQuestBtn = new TransitionButton(100,50, Color.white, "Edit Question", 11/*or 12?*/,4);
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
		// TODO Auto-generated method stub
		
	}
	public void buttonClicked(int width, int height, Color color, String text, int screenID, int buttonID) {
		// TODO Auto-generated method stub
		
	}
}

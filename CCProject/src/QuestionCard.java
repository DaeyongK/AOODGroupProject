import java.awt.Color;
import java.awt.image.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class QuestionCard extends QPanel{
	String question;
	String answer;
	EstablisherButton ansBtn;
	EstablisherButton knewAnsBtn;
	EstablisherButton notKnewAnsBtn;
	EstablisherButton nextQuesBtn;
	TransitionButton editQuestBtn;
	BufferedImage questImage;
	
	QuestionCard(String t) {
		super(t);
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
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

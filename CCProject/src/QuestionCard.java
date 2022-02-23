import java.awt.image.*;

public class QuestionCard extends QPanel{
	QuestionCard(String t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	String question;
	String answer;
	EstablisherButton ansBtn;
	EstablisherButton knewAnsBtn;
	EstablisherButton notKnewAnsBtn;
	EstablisherButton nextQuesBtn;
	BufferedImage questImage;
	@Override
	public int getScreenID() {
		// TODO Auto-generated method stub
		return 6;
	}
	@Override
	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void buttonClicked(int buttonID) {
		// TODO Auto-generated method stub
		
	}
}

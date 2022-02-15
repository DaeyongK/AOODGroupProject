import java.awt.image.*;

public class Question {
	String questionString;
	String answerString;
	BufferedImage graphic;
	int ID;
	
	Question(String question, String answer){
		questionString=question;
		answerString=answer;
	}
	Question(String question, String answer, String imagePath){
		questionString=question;
		answerString=answer;
		this.setImage(imagePath);
	}
	
	public void setImage(String imagePath) {
		//look at Roll.java for how to use file names to pull pictures from the computer
	}
	public boolean detachImage() {
		//detaches previous image
		//returns true if it works
		return true;
	}

	public String getQuestion() {
		return questionString;
	}
	
	public BufferedImage getImage() {
		return graphic;
	}
	public String getAnswer() {
		return answerString;
	}
	
	public int getID() {
		return ID;
	}
}

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

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
	
	public boolean setImage(String imagePath) {
		try {
		graphic= ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	public void detachImage() {
		graphic=null;
	}

	public BufferedImage getImage() {
		return graphic;
	}
	
	public String getQuestion() {
		return questionString;
	}
	
	public String getAnswer() {
		return answerString;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setQuestion(String question) {
		questionString=question;
	}
	
	public void setAnswer(String answer) {
		answerString=answer;
	}
	
}

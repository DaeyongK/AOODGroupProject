import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Question {
	String questionString;
	String answerString;
	String graphicString;
	BufferedImage graphic;
	int ID;
	
	Question(String question, String answer){
		questionString=question;
		answerString=answer;
		ID = (int) (Math.random()*1000000000);
	}
	Question(String question, String answer, String imagePath){
		questionString=question;
		answerString=answer;
		this.setImage(imagePath);
	}
	
	public boolean setImage(String imagePath) {
		try {
		graphicString = imagePath;
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
	
	public String getGraphicPath() {
		return graphicString;
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
	
	//public int setID() {
		
	//}
	
	public void setQuestion(String question) {
		questionString=question;
	}
	
	public void setAnswer(String answer) {
		answerString=answer;
	}
	
}

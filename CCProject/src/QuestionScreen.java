//QuestionScreen is front-end class made by Kai C.

import java.awt.*;
import javax.swing.*;

public class QuestionScreen extends QPanel {
	private String title;
	private int id;
	private boolean graphicDetected;
	private JTextField questionBox;
	private JTextField answerBox;
	
	private establisherBtn attachGraphic;
	private establisherBtn detachGraphic;
	private transitionBtn backBtn;

	QuestionScreen(String t) {
		super(t);//Will this set the title variable in this class to t?
		if (t.equals("Create a Question"))
		    id = 12;
		else
		    id = 13;
	}
	public int getScreenID() {
		return id;
	}
	public boolean popup(String text) {
		
	}
	public void buttonClicked(int buttonID) {
		if(buttonID == 0) {
			
		}
		else if(buttonID == 1) {
			
		}
		else if (buttonID == 2) {
			
		}
		else if (buttonID == 3) {
			
		}
		else if (buttonID == 4) {
			
		}
		else {
			
		}
	}
	private void radioClick() {
		
	}
	public void main paintComponent(Graphic g) {
		g.drawRectangle(1280,720,
	}
	public static void main(String[] arg) {
		new QuestionScreen("QuestionScreen Test");
	}
}

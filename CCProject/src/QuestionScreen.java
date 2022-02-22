//QuestionScreen is front-end class made by Kai C.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuestionScreen extends QPanel implements ActionListener {
	private String title;
	private int screenId;
	private int questionId;
	private boolean graphicDetected;
	
	private JTextField questionBox;
	private JTextField answerBox;
	private JTextField changeRight;
	private JTextField changeAsked;
	
	private EstablisherBtn attachGraphic;
	private EstablisherBtn detachGraphic;
	private TransitionBtn doneBtn;
	private TransitionBtn backBtn;
	
	QuestionScreen(int id) {
		questionId = getID();
		if (id<0) {
			super("Create a Question");
			ScreenId=12;
			questionBox = new JTextField("Enter a new question here: ");
			answerBox = new JTextField("Enter its answer here: ");
		}
		else {
			//Will this set the title variable in this class to t?
			super("Edit Question "+id);
			ScreenId=13
			//Figure out how to access the question by ID
			questionBox = new JTextField(getQuestion());
			answerBox = new JTextField(getAnswer());
			//Figure out how to access #times asked/right in profile
			changeRight = new JTextField("Correct: "+getAnsweredRight(questionId)+" times");
			changeAsked = new JTextField("Asked: "+getTimesAsked(questionId)+" times");
		}
		
		questionBox.setHorizontalAlignment(JTextField.LEFT);
		answerBox.setHorizontalAlignment(JTextField.LEFT);
		attachGraphic = new EstablisherBtn(161,44,Color.BLACK,"Attach",0);
		detachGraphic = new EstablisherBtn(161,44,Color.BLACK,"Detach",1);
		doneBtn = new TransitionBtn(175,134,Color.BLACK,"Done",2);
		backBtn = new TransitionBtn(175,67,Color.BLACK,"Back",3);
	}
	public int getScreenID() {
		return id;
	}
	public boolean popup(String text) {
		if(text.equals("AttachGraphics")) { 
			
		}
	}
	public void buttonClicked(int buttonID) {
		if(buttonID == 0) {
			popup("Attach Graphics")
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
	public void paintComponent(Graphics g) {
		g.setColor(BACKGROUND_COLOR);
		g.drawRectangle(0,0,1280,720);
		g.setColor(TITLE_COLOR);
		g.setFont(font);
		g.drawString(title, 300, 50);
	}
	public static void main(String[] arg) {
		new QuestionScreen();
	}
}

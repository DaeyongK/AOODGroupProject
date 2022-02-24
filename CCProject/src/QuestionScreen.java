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
	
	QuestionScreen(String t, int id) {
		super(t);
		questionId = new Question().getID(); //Find questionID from profile or domain
		if (id<0) {
			ScreenId=12;
			questionBox = new JTextField("Enter a new question here: ");
			answerBox = new JTextField("Enter its answer here: ");
		}
		else {
			title = "Edit Question #" + id;
			ScreenId=13;
			//Figure out how to access the question by ID
			questionBox = new JTextField(getQuestion());
			answerBox = new JTextField(getAnswer());
			//Figure out how to access #times asked/right in profile class
			changeRight = new JTextField("Correct: "+getProfile().getAnsweredRight(questionId)+" times");
			changeAsked = new JTextField("Asked: "+getProfile().getTimesAsked(questionId)+" times");
		}
		questionBox.setBounds(121,399,438,124);
		answerBox.setBounds(720,399,438,124);
		changeRight.setBounds(953,161,283,56);
		changeAsked.setBounds(953,242,283,56);
		attachGraphic = new EstablisherBtn(161,44,Color.BLACK,"Attach",0);
		detachGraphic = new EstablisherBtn(161,44,Color.BLACK,"Detach",1);
		doneBtn = new TransitionBtn(175,134,Color.BLACK,"Done",2);
		backBtn = new TransitionBtn(175,67,Color.BLACK,"Back",3);
	}
	public int getScreenID() {
		return id;
	}
	public boolean popup(String text) {
		if(text.equals("Attach Graphics")) { 
			
		}
		
	}
	public void buttonClicked(int buttonID) {
		if(buttonID == 0) {
			popup("Attach Graphics");
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
		g.setColor(TITLE_COLOR);
		g.setFont(font);
		if (title.equals("Create a Question"))
			g.drawString(title,690,86);
		else
			g.drawString(title,465,86);
		g.setColor(Color.WHITE);
		g.drawRect(121,160,438,166);
		g.drawString("No Graphic Preview",216,218);
	}
	public static void main(String[] arg) {
		new QuestionScreen();
	}
}

//QuestionScreen is front-end class made by Kai C.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuestionScreen extends QPanel implements ActionListener {
	private String title;
	private int id;
	private boolean graphicDetected;
	private JLabel titleLabel;
	private JTextField questionBox;
	private JTextField answerBox;
	
	private EstablisherBtn attachGraphic;
	private EstablisherBtn detachGraphic;
	private TransitionBtn backBtn;

	QuestionScreen(String t) {
		super(t);//Will this set the title variable in this class to t?
		if (t.equals("Create a Question"))
		    id = 12;
		else
		    id = 13;
		titleLabel = new JLabel(title);
		titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		titleLabel.setAlignmentY(JLabel.TOP_ALIGNMENT);
		attachGraphic = new EstablisherBtn(161,44,Color.BLACK,"Attach",0);
		detachGraphic = new EstablisherBtn(161,44,Color.BLACK,"Detach",1);
		backBtn = new TransitionBtn(175,67,Color.BLACK,"Back",2);
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
	public void paintComponent(Graphics g) {
		g.setColor(BACKGROUND_COLOR);
		g.drawRectangle(0,0,1280,720);
	}
	public static void main(String[] arg) {
		new QuestionScreen("QuestionScreen Test");
	}
}

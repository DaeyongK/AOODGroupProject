//QuestionScreen is front-end class made by Kai C.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuestionScreen extends QPanel implements ActionListener {
	private String title;
	private int screenId;
	private int questionId;
	private boolean edit;
	private boolean graphicDetected;
	
	private JTextField questionBox;
	private JTextField answerBox;
	private JTextField changeRight;
	private JTextField changeAsked;
	
	private EstablisherButton attachGraphic;
	private EstablisherButton detachGraphic;
	private TransitionButton doneBtn;
	private TransitionButton backBtn;
	
	private QPanel thisScreen;
	private Question question;
	private Profile profile;
	
	QuestionScreen(String t) {
		super(t);
		title = "Create a Question";
		thisScreen = this;
		ScreenId=11;
		edit = false;
		graphicDetected = false;
		questionBox = new JTextField("Enter a new question here: ");
		answerBox = new JTextField("Enter its answer here: ");
		
		attachGraphic = new EstablisherButton(161,44,Color.BLACK,"Attach",0);
		detachGraphic = new EstablisherButton(161,44,Color.BLACK,"Detach",1);
		doneBtn = new TransitionButton(161,69,Color.BLACK,"Done",2);
		backBtn = new TransitionButton(175,67,Color.BLACK,"Back",3);
		
		attachGraphic.setBounds(121,327,161,44);
		detachGraphic.setBounds(398,327,161,44);
		doneBtn.setBounds(559,570,161,69);
		backBtn.setBounds(49,42,175,67);
		
		this.add(questionBox);
		this.add(answerBox);
		this.add(attachGraphic);
		this.add(detachGraphic);
		this.add(doneBtn);
		this.add(backBtn);
	}
	QuestionScreen(String t, QuizIt q) {
		super(t);
		question = q.currentQuestion();
		questionId = question.getID();
		profile = q.currentProfle();
		title = "Edit Question #" + questionId;
		thisScreen = this;
		ScreenId=12;
		edit = true;
		if (question.getImage() != null)
			graphicDetected = true;
		else
			graphicDetected = false;
		questionBox = new JTextField(question.getQuestion());
		answerBox = new JTextField(question.getAnswer());
		questionBox.setBounds(121,399,438,124);
		answerBox.setBounds(720,399,438,124);
		
		changeRight = new JTextField("Correct: "+profile.getAnsweredRight(questionId)+" times");
		changeAsked = new JTextField("Asked: "+profile.getTimesAsked(questionId)+" times");
		changeRight.setBounds(953,161,283,56);
		changeAsked.setBounds(953,242,283,56);
		
		attachGraphic = new EstablisherButton(161,44,Color.BLACK,"Attach",0);
		detachGraphic = new EstablisherButton(161,44,Color.BLACK,"Detach",1);
		doneBtn = new TransitionButton(161,69,Color.BLACK,"Done",2);
		backBtn = new TransitionButton(175,67,Color.BLACK,"Back",3);
		
		attachGraphic.setBounds(121,327,161,44);
		detachGraphic.setBounds(398,327,161,44);
		doneBtn.setBounds(559,570,161,69);
		backBtn.setBounds(49,42,175,67);
		
		this.add(questionBox);
		this.add(answerBox);
		this.add(changeRight);
		this.add(changeAsked);
		this.add(attachGraphic);
		this.add(detachGraphic);
		this.add(doneBtn);
		this.add(backBtn);
	}
	public int getScreenID() {
		return screenId;
	}
	public boolean popup(String text) {
		JPanel pop = new JPanel();
		JLabel message = new JLabel(text);
		pop.add(message);
		pop.setBackGround(TITLE_COLOR);
		
		if (message.includes("Select")) {
			EstablisherButton select = new EstablisherButton(60,25,Color.WHITE,"Select",10);
			select.setBackground(Color.WHITE);
			select.setForeground(Color.BLACK);
			select.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Somehow prompt to get image
					thisScreen.remove(pop);
					if(!graphicDetected) {
						if(popup("Attach Graphic\n\nAre you sure?"));
							//Replaces graphic with selected graphic
						else;
							//Keeps the previous graphic
					}
					else {
						//Selected graphic is picked
					}
					
					return true;
				}
			});
			pop.add(select);
		}
		else if (message.includes("leave")) {
			//Backbtn popup yes/no
			TransitionButton yes = new EstablisherButton(40,25,Color.WHITE,"Yes",screenID,13);
			yes.setBackground(Color.WHITE);
			yes.setForeground(Color.BLACK);
			yes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thisScreen.remove(pop);
					return true;
				}
			});
			pop.add(yes);
			TransitionButton no = new EstablisherButton(40,25,Color.WHITE,"No",screenID,14);
			no.setBackground(Color.WHITE);
			no.setForeground(Color.BLACK);
			no.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					thisScreen.remove(pop);
					return false;
				}
			});
			pop.add(no);
		}
		else {
			//General popup yes/no
			EstablisherButton yes = new EstablisherButton(40,25,Color.WHITE,"Yes",15);
			yes.setBackground(Color.WHITE);
			yes.setForeground(Color.BLACK);
			yes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thisScreen.remove(pop);
					return true;
				}
			});
			pop.add(yes);
			EstablisherButton no = new EstablisherButton(40,25,Color.WHITE,"No",16);
			no.setBackground(Color.WHITE);
			no.setForeground(Color.BLACK);
			no.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					thisScreen.remove(pop);
					return false;
				}
			});
			pop.add(no);
		}
	}
	public void buttonClicked(int buttonID) {
		QPanel nextScreen = thisScreen;
		switch(buttonID){
			case 0:
				if(popup("Attach Graphic\n\nSelect File")) {
					//Attach Graphic Select File popup
					//Leads to being prompted to get image
				}
				break;
			case 1:
				if(popup("DetachGraphic\n\nAre you sure?")) {
					question.detachImage();
				}
				else
					question.setImage();
				break;
			case 2:
				//DoneBtn
				//Checks if all textfields are entered
				if (edit) {
					if (!questionBox.getText().equals("") && 
					    !answerBox.getText().equals("") &&
					    !changeRight.getText().equals("") &&
					    ((int)changeRight.getText()>=0)) &&
						changeAsked.getText().equals("") &&
						((int)changeAsked.getText()>=0)) &&
						(((int)changeRight.getText())<=((int)changeAsked.getText()))) {
						
						question.setQuestion(questionBox.getText());
						question.setAnswer(answerBox.getText());
						profile.setNumCorrect(questionId,(int)changeRight.getText());
						profile.setNumAsked(quetionId,(int)changeAsked.getText());
					}
				}
				else
					if (!questionBox.getText().equals("") && 
					    !answerBox.getText().equals("")) {
						question.setQuestion(questionBox.getText());
						question.setAnswer(answerBox.getText());
					}
				break;
			case 3:
				//BackBtn
				if(popup("Are you sure you want to leave?")) {
					//Transitions to domain
				}
				break;
		}
	}
	private void radioClick() {
		//empty for now
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
}

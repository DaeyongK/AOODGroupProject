//QuestionScreen is front-end class made by Kai C.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		super(t,null);
		title = "Create a Question";
		thisScreen = this;
		screenId=11;
		edit = false;
		graphicDetected = false;
		questionBox = new JTextField("Enter a new question here: ");
		answerBox = new JTextField("Enter its answer here: ");
		
		attachGraphic = new EstablisherButton(this,161,44,Color.BLACK,"Attach",0);
		detachGraphic = new EstablisherButton(this,161,44,Color.BLACK,"Detach",1);
		doneBtn = new TransitionButton(this,161,69,Color.BLACK,"Done",8,2);
		backBtn = new TransitionButton(this,175,67,Color.BLACK,"Back",8,3);
		
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
	QuestionScreen(String t, Quizit q) {
		super(t,q);
		question = q.getQuestion();
		questionId = question.getID();
		profile = q.getProfile();
		title = "Edit Question #" + questionId;
		thisScreen = this;
		screenId=12;
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
		
		attachGraphic = new EstablisherButton(this,161,44,Color.BLACK,"Attach",0);
		detachGraphic = new EstablisherButton(this,161,44,Color.BLACK,"Detach",1);
		doneBtn = new TransitionButton(this,161,69,Color.BLACK,"Done",6,2);
		backBtn = new TransitionButton(this,175,67,Color.BLACK,"Back",6,3);
		
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
		pop.setBackground(TITLE_COLOR);

		if (message.getText().contains("Select")) {
			EstablisherButton select = new EstablisherButton(this,60,25,Color.WHITE,"Select",10);
			select.setBackground(Color.WHITE);
			select.setForeground(Color.BLACK);
			select.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Somehow prompt to get image
					thisScreen.remove(pop);
					if(!graphicDetected) {
						if(popup("Attach Graphic\n\nAre you sure?"));

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
		else if (message.getText().contains("leave")) {
			//Backbtn popup yes/no
			//If create, screenId is 8, if edit, figure it out
			TransitionButton yes = new TransitionButton(this,40,25,Color.WHITE,"Yes",6,13);
			yes.setBackground(Color.WHITE);
			yes.setForeground(Color.BLACK);
			yes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thisScreen.remove(pop);
					return true;
				}
			});
			pop.add(yes);
			TransitionButton no = new TransitionButton(this,40,25,Color.WHITE,"No",6,14);
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
			EstablisherButton yes = new EstablisherButton(this,40,25,Color.WHITE,"Yes",15);
			yes.setBackground(Color.WHITE);
			yes.setForeground(Color.BLACK);
			yes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thisScreen.remove(pop);
					return true;
				}
			});
			pop.add(yes);
			EstablisherButton no = new EstablisherButton(this,40,25,Color.WHITE,"No",16);
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
				//need if statement for changeAsked and changeRight to check if they're ints
				if (edit) {
					try {
						if (!questionBox.getText().equals("") &&
								!answerBox.getText().equals("") &&
								!changeRight.getText().equals("") &&
								Integer.parseInt(changeRight.getText()) >= 0 &&
								changeAsked.getText().equals("") &&
								Integer.parseInt(changeAsked.getText()) >= 0 &&
								Integer.parseInt(changeRight.getText()) <= (Integer.parseInt(changeAsked.getText()))) {


							question.setQuestion(questionBox.getText());
							question.setAnswer(answerBox.getText());
							profile.setNumCorrect(questionId, Integer.parseInt(changeRight.getText()));
							profile.setNumAsked(questionId, Integer.parseInt(changeAsked.getText()));
						}
					} catch (NumberFormatException e) {
						//do nothing
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

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}

//QuestionScreen is front-end class made by Kai C

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QuestionScreen extends QPanel implements ActionListener {
    private String title;
    private int screenId;
    private int questionId;
    private boolean edit;
    private boolean graphicDetected;

    private JLabel titleLabel;
    private JTextField questionBox;
    private JTextField answerBox;
    private JTextField changeRight;
    private JTextField changeAsked;

    private EstablisherButton attachGraphic;
    private EstablisherButton detachGraphic;
    private TransitionButton doneBtn;
    private TransitionButton backBtn;
	
	private Quizit thisQuizit;
	private JFrame thisFrame;
    private QPanel thisScreen;
    private Question question;
    private Profile profile;

    QuestionScreen(String t, Quizit q) {
        super(t,q);
		thisQuizit = q;
		thisFrame = thisQuizit.getFrame();
		thisScreen = this;
		
		if (t.contains("Create")) {
			question = new Question();
			title = "Create a Question";
			screenId = 11;
			edit = false;
			graphicDetected = false;
			titleLabel = new JLabel(title);
			titleLabel.setBounds(464, 86, 351, 32);
			questionBox = new JTextField("Enter a new question here: ");
			answerBox = new JTextField("Enter its answer here: ");
		}
		else {
			question = q.getQuestion();
			questionId = question.getID();
			profile = q.getProfile();
			title = "Edit Question #" + questionId;
			thisScreen = this;
			screenId = 12;
			edit = true;
			graphicDetected = question.getImage() != null;
			
			titleLabel = new JLabel(title);
			titleLabel.setBounds(464, 86, 360, 32);
			questionBox = new JTextField(question.getQuestion());
			answerBox = new JTextField(question.getAnswer());

			changeRight = new JTextField("Correct: " + profile.getAnsweredRight(questionId) + " times");
			changeAsked = new JTextField("Asked: " + profile.getTimesAsked(questionId) + " times");
			changeRight.setBounds(953, 161, 283, 56);
			changeAsked.setBounds(953, 242, 283, 56);
			this.add(changeRight);
			this.add(changeAsked);
		}
		attachGraphic = new EstablisherButton(this, 161, 44, Color.BLACK, "Attach", 0);
		detachGraphic = new EstablisherButton(this, 161, 44, Color.BLACK, "Detach", 1);
		doneBtn = new TransitionButton(this, 161, 69, Color.BLACK, "Done", 8, 2);
		backBtn = new TransitionButton(this, 175, 67, Color.BLACK, "Back", 8, 3);

		questionBox.setBounds(121, 399, 438, 124);
		answerBox.setBounds(720, 399, 438, 124);
		attachGraphic.setBounds(121, 327, 161, 44);
		detachGraphic.setBounds(398, 327, 161, 44);
		doneBtn.setBounds(559, 570, 161, 69);
		backBtn.setBounds(49, 42, 175, 67);
		
		this.add(titleLabel);
		this.add(questionBox);
		this.add(answerBox);
		this.add(attachGraphic);
		this.add(detachGraphic);
		this.add(doneBtn);
		this.add(backBtn);
    }
    public int getScreenID() {
        return screenId;
    }
    public boolean popup(String text, boolean select) {
        int result = JOptionPane.showConfirmDialog(this, text);
        if (select) {
            JOptionPane.showMessageDialog(thisScreen, "Select a Graphic");
            if (result == JOptionPane.OK_OPTION) {
                //Fancy bufferedImage code here
                return popup("Attach a Graphic", false);
            }
        } else {
            JOptionPane.showMessageDialog(thisScreen, "Are you sure?");
			result == JOptionPane.YES_OPTION;
        }
        return false;
    }
    public void buttonClicked(int buttonID) {
        QPanel nextScreen = thisScreen;
        switch (buttonID) {
            case 0:
                if (popup("Attach Graphic", true)) {
                    //Figure out bufferedImage stuff
					//question.setImage();
                }
                break;
            case 1:
                if (graphicDetected) {
                    if (popup("Detach Graphic", false))
                        question.detachImage();
                }
                break;
            case 2:
                //DoneBtn
                //Checks if all textfields are entered
                if (edit) {
                    try {
                        if (!questionBox.getText().equals("") &&
                                !answerBox.getText().equals("") &&
                                !changeRight.getText().equals("") &&
                                Integer.parseInt(changeRight.getText()) >= 0 &&
                                changeAsked.getText().equals("") &&
                                Integer.parseInt(changeAsked.getText()) >= 0 &&
                                Integer.parseInt(changeRight.getText()) <= 
								Integer.parseInt(changeAsked.getText())) {
							
							//Set code to use setQuestion();
                            question.setQuestion(questionBox.getText());
                            question.setAnswer(answerBox.getText());
                            profile.setNumCorrect(questionId, Integer.parseInt(changeRight.getText()));
                            profile.setNumAsked(questionId, Integer.parseInt(changeAsked.getText()));
                            quizit.changeScreen(6);
                        }
                    } catch (NumberFormatException ignored) {
                    }
                } else
                    try {
                        if (!questionBox.getText().equals("") &&
                                !answerBox.getText().equals("")) {
                            //Change code to use setQuestion();
							question.setQuestion(questionBox.getText());
                            question.setAnswer(answerBox.getText());
                            quizit.changeScreen(6);
                        }
                    } catch (NullPointerException ignored) {
                    }
                break;
            case 3:
                //BackBtn
                if (popup("Are you sure you want to leave?", false)) {
					thisQuizit.changeScreen(8);
				}
                break;
        }
    }

    private void radioClick() {
        //empty for now
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //empty for now
    }
	public void paintComponent(Graphics g) {
			
			g.setColor(Color.WHITE);
			g.drawRect(121,160,438,166);
			g.drawString("No Graphic Preview",216,218);
	}
}

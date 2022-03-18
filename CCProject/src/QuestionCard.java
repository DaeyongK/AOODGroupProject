import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class QuestionCard extends QPanel {
	private Profile profile;
	private Question currentQ;
	private String currentQStr;
	private int currentQIndex;
	private int nextLine;
	private Domain currentDomain;
	private ArrayList<Question> questions = new ArrayList<>(), intermediateDomain;
	private Quizit quizit;
	private EstablisherButton ansBtn, knewAnsBtn, notKnewAnsBtn, nextQuestBtn, delQuestBtn;
	private TransitionButton editQuestBtn, backBtn;
	private JLabel askedNumTimesText, correctNumTimesText, answerText, questionText, questionText2, questionText3,
			questionGraphic;
	private BufferedImage questImage;
	private LinkedHashMap<Integer, int[]> questionHash;
	private Graphics g = this.getGraphics();

	QuestionCard(String title, Quizit quiz) {
		super(title, quiz);
		quizit = quiz;
		currentDomain = quiz.getDomain();
		profile = quiz.getProfile();

		// different profile settings ||||
		// VVVV
		if (profile.getPossible() && !profile.getOrder()) {
			for (int i = 0; i < currentDomain.getDomainSize(); i++) {
				questions.add(currentDomain.getQuestions().get(i));
			}
		} else if (profile.getPossible() && profile.getOrder()) {
			intermediateDomain = new ArrayList<>(currentDomain.getQuestions());
			Collections.shuffle(intermediateDomain);
			for (int i = 0; i < currentDomain.getDomainSize(); i++) {
				questions.add(intermediateDomain.get(i));
			}
		} else if (!profile.getPossible() && !profile.getOrder()) {
			questionHash = new LinkedHashMap<>(profile.getHashMap());
			for (int x = 0; x < profile.getThreshold(); x++) {
				for (int i = 0; i < currentDomain.getQuestions().size(); i++) {
					if (questionHash.get(currentDomain.getQuestions().get(i).getID())[0] < profile.getThreshold()) {
						questions.add(currentDomain.getQuestions().get(i));
					}
				}
			}
		} else if (!profile.getPossible() && profile.getOrder()) {
			questionHash = new LinkedHashMap<>(profile.getHashMap());
			intermediateDomain = new ArrayList<>(currentDomain.getQuestions());
			Collections.shuffle(intermediateDomain);
			questionHash = new LinkedHashMap<>(profile.getHashMap());
			for (int x = 0; x < profile.getThreshold(); x++) {
				for (int i = 0; i < intermediateDomain.size(); i++) {
					if (questionHash.get(intermediateDomain.get(i).getID())[0] < profile.getThreshold()) {
						questions.add(intermediateDomain.get(i));
					}
				}
			}
		}
		currentQIndex = 0;
		currentQ = questions.get(currentQIndex);
		quizit.setQuestion(currentQ);
		currentQStr = currentQ.getQuestion();
		this.setLayout(null);

		// make text boxes
		askedNumTimesText = new JLabel("   Asked: " + profile.getTimesAsked(currentQ.getID()) + " times");
		askedNumTimesText.setFont(new Font("SanSerif", Font.PLAIN, 20));
		askedNumTimesText.setOpaque(true);
		askedNumTimesText.setBounds(50, 150, 350, 40);
		askedNumTimesText.setBackground(new Color(255, 244, 150));
		correctNumTimesText = new JLabel("   Correct: " + profile.getAnsweredRight(currentQ.getID()) + " times");
		correctNumTimesText.setFont(new Font("SanSerif", Font.PLAIN, 20));
		correctNumTimesText.setOpaque(true);
		correctNumTimesText.setBounds(450, 150, 400, 40);
		correctNumTimesText.setBackground(new Color(255, 244, 150));
		answerText = new JLabel(" Answer: " + currentQ.getAnswer());
		answerText.setFont(new Font("SanSerif", Font.PLAIN, 17));
		answerText.setOpaque(true);
		answerText.setBounds(50, 630, 800, 40);
		answerText.setVisible(false);
		questionText = new JLabel(currentQStr);
		questionText.setFont(new Font("SanSerif", Font.PLAIN, 17));
		questionText.setOpaque(true);
		questionText.setBounds(70, 240, 760, 40);
		// this adds a second line for question in case the question is too long.
		if (currentQStr.length() > 85) {
			nextLine = currentQStr.substring(75, 84).indexOf(' ') + 75;
			questionText2 = new JLabel(" " + currentQStr.substring(nextLine));
			questionText2.setFont(new Font("SanSerif", Font.PLAIN, 17));
			questionText2.getText().length();
			questionText2.setOpaque(true);
			questionText2.setBounds(70, 279, 760, 40);
			questionText.setText(currentQStr.substring(0, nextLine));
			this.add(questionText2);
		}
		questionGraphic = new JLabel(new ImageIcon(currentQ.getGraphicPath()));
		questionGraphic.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		questionGraphic.setBounds(70, 340, 760, 250);
		questionGraphic.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		questionGraphic.setOpaque(true);

		// make buttons
		editQuestBtn = new TransitionButton(this, 100, 50, Color.white, "Edit Question", 12, 5);
		editQuestBtn.setBounds(850, 25, 200, 50);

		backBtn = new TransitionButton(this, 100, 50, Color.white, "Exit", 5, 0);
		backBtn.setBounds(25, 25, 200, 50);

		ansBtn = new EstablisherButton(this, 100, 50, Color.white, "Answer", 1);
		ansBtn.setBounds(1000, 350, 250, 50);

		knewAnsBtn = new EstablisherButton(this, 90, 40, Color.white, "I knew the answer", 2);
		knewAnsBtn.setBounds(1000, 325, 250, 50);
		knewAnsBtn.setVisible(false);

		notKnewAnsBtn = new EstablisherButton(this, 90, 40, Color.white, "I didn't know", 3);
		notKnewAnsBtn.setBounds(1000, 380, 250, 50);
		notKnewAnsBtn.setVisible(false);

		nextQuestBtn = new EstablisherButton(this, 100, 50, Color.white, "Next Question", 4);
		nextQuestBtn.setBounds(1000, 350, 250, 50);
		nextQuestBtn.setVisible(false);

		delQuestBtn = new EstablisherButton(this, 100, 50, Color.white, "Delete Question", 6);
		delQuestBtn.setBounds(1060, 25, 200, 50);

		// add buttons and text to contentPane
		this.add(ansBtn);

		this.add(knewAnsBtn);
		this.add(notKnewAnsBtn);
		this.add(nextQuestBtn);
		this.add(editQuestBtn);
		this.add(delQuestBtn);
		this.add(backBtn);

		this.add(askedNumTimesText);
		this.add(correctNumTimesText);
		this.add(answerText);
		this.add(questionText);
		this.add(questionGraphic);
		// Draw background stuff
		this.revalidate();
		this.repaint();
	}

	public int getScreenID() {
		return 6;
	}

	public void buttonClicked(int buttonID) {
		// buttID 0 = back button
		// buttID 1 = answer button
		// buttID 2 = knew answer button
		// buttID 3 = didn't know answer button
		// buttID 4 = next question button
		// buttID 5 = edit question button
		// buttID 6 = delete question button

		if (buttonID == 0) {
			quizit.changeScreen(5);
		} else if (buttonID == 1) {
			ansBtn.setVisible(false);
			knewAnsBtn.setVisible(true);
			notKnewAnsBtn.setVisible(true);
			answerText.setVisible(true);
			answerText.setText(" Answer: " + currentQ.getAnswer());
			profile.asked(currentQ.getID());
			askedNumTimesText.setText("   Asked: " + profile.getTimesAsked(currentQ.getID()) + " times");
		} else if (buttonID == 2) {
			knewAnsBtn.setVisible(false);
			notKnewAnsBtn.setVisible(false);
			nextQuestBtn.setVisible(true);
			profile.answeredCorrectly(currentQ.getID());
			correctNumTimesText.setText("   Correct: " + profile.getAnsweredRight(currentQ.getID()) + " times");
		} else if (buttonID == 3) {
			knewAnsBtn.setVisible(false);
			notKnewAnsBtn.setVisible(false);
			nextQuestBtn.setVisible(true);
		} else if (buttonID == 4) {
			if (currentQIndex <= (questions.size() - 2)) {
				nextQ();
				questionGraphic.setIcon(new ImageIcon(currentQ.getGraphicPath()));
				questionGraphic.setAlignmentX(JLabel.CENTER_ALIGNMENT);
				questionGraphic.setBounds(70, 330, 760, 270);
				questionGraphic.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
				questionGraphic.setOpaque(true);
				ansBtn.setVisible(true);
				knewAnsBtn.setVisible(false);
				notKnewAnsBtn.setVisible(false);
				answerText.setVisible(false);
				nextQuestBtn.setVisible(false);
				questionText.setText(currentQ.getQuestion());
				askedNumTimesText.setText(("   Asked: " + profile.getTimesAsked(currentQ.getID()) + " times"));
				correctNumTimesText.setText("   Correct: " + profile.getAnsweredRight(currentQ.getID()) + " times");
			} else if (currentQIndex == (questions.size() - 1)) {
				Boolean popupResult = popup2("You have completed all the questions in this domain. \n" + "\n"
						+ "Would you like to restart this domain?\n");
				if (popupResult == null) {

				} else if (popupResult) {
					quizit.changeScreen(6);
				} else if (!popupResult) {
					quizit.changeScreen(5);
				}
			}

		} else if (buttonID == 5) {
			quizit.changeScreen(12);
		} else if (buttonID == 6) {
			if (popup("Are you sure?")) {
				if (currentQIndex == 0 && questions.size() > 1) {
					currentQIndex += 1;
					quizit.getDomain().deleteQuestion(currentQIndex - 1);
					questions.remove(currentQIndex - 1);
					currentQ = questions.get(currentQIndex);
					quizit.setQuestion(currentQ);
					ansBtn.setVisible(true);
					knewAnsBtn.setVisible(false);
					notKnewAnsBtn.setVisible(false);
					answerText.setVisible(false);
					nextQuestBtn.setVisible(false);
					questionText.setText(currentQ.getQuestion());
					askedNumTimesText.setText(("   Asked: " + profile.getTimesAsked(currentQ.getID()) + " times"));
					correctNumTimesText.setText("   Correct: " + profile.getAnsweredRight(currentQ.getID()) + " times");
					questionGraphic.setIcon(new ImageIcon(currentQ.getGraphicPath()));
					questionGraphic.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					questionGraphic.setBounds(70, 340, 760, 250);
					questionGraphic.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
					questionGraphic.setOpaque(true);
					repaint();
				} else if (currentQIndex > 0 && currentQIndex < questions.size()) {
					currentQIndex -= 1;
					quizit.getDomain().deleteQuestion(currentQIndex + 1);

					questions.remove(currentQIndex + 1);
					currentQ = questions.get(currentQIndex);
					quizit.setQuestion(currentQ);
					ansBtn.setVisible(true);
					knewAnsBtn.setVisible(false);
					notKnewAnsBtn.setVisible(false);
					answerText.setVisible(false);
					nextQuestBtn.setVisible(false);
					questionText.setText(currentQ.getQuestion());
					askedNumTimesText.setText(("   Asked: " + profile.getTimesAsked(currentQ.getID()) + " times"));
					correctNumTimesText.setText("   Correct: " + profile.getAnsweredRight(currentQ.getID()) + " times");
					questionGraphic.setIcon(new ImageIcon(currentQ.getGraphicPath()));
					questionGraphic.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					questionGraphic.setBounds(70, 340, 760, 250);
					questionGraphic.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
					questionGraphic.setOpaque(true);
					repaint();
				} else if (currentQIndex == questions.size() - 1 && currentQIndex == 0) {
					quizit.getDomain().deleteQuestion(currentQIndex);
					questions.remove(currentQIndex);
					Boolean popupResult = popup3(
							"There are no more questions in this domain. \n" + "\n" + "Returning to Domain Select.\n");
					if (popupResult || !popupResult) {
						quizit.changeScreen(5);
					}
				}

			}
		}

	}

	public void buttonClicked(int width, int height, Color color, String text, int screenID, int buttonID) {
		// TODO Auto-generated method stub

	}

	public void nextQ() {
		currentQIndex++;
		currentQ = questions.get(currentQIndex);
		quizit.setQuestion(currentQ);
	}

	public void previousQ() {
		currentQIndex--;
		currentQ = questions.get(currentQIndex);
		quizit.setQuestion(currentQ);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(230, 220, 0));
		g.fillRect(50, 230, 800, 380);
		g.setColor(Color.gray);
		g.fillRect(0, 0, 1280, 100);
		g.setColor(Color.white);
		g.setFont(new Font("SanSerif", Font.BOLD, 17));
		g.drawString("Current Domain: " + currentDomain.getDomainName(), 275, 55);
	}

	public Boolean popup2(String text) {
		int result = JOptionPane.showConfirmDialog(quizit.getFrame(), text);
		switch (result) {
		case JOptionPane.YES_OPTION:
			return true;

		case JOptionPane.NO_OPTION:
			return false;

		case JOptionPane.CLOSED_OPTION:
			break;
		}
		return null;
	}

	public Boolean popup3(String text) {
		int result = JOptionPane.showConfirmDialog(quizit.getFrame(), text, text, 1);
		switch (result) {
		case JOptionPane.OK_OPTION:
			return true;

		case JOptionPane.CLOSED_OPTION:
			return true;
		}
		return true;
	}

	public static void main(String[] args) {
		Quizit q = new Quizit();
	}
}

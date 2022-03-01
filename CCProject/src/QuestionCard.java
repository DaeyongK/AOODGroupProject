import java.awt.Color;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import javax.swing.*;

public class QuestionCard extends QPanel {
	private Profile profile;
	private Question currentQ;
	private int currentQIndex;
	private Domain currentDomain;
	private ArrayList<Question> questions = new ArrayList<Question>(), intermediateDomain;
	private Quizit quizit;
	private EstablisherButton ansBtn, knewAnsBtn, notKnewAnsBtn, nextQuestBtn, delQuestBtn;
	private TransitionButton editQuestBtn, backBtn;
	private JLabel askedNumTimesText, correctNumTimesText, answerText, questionText, domainNameText;
	private BufferedImage questImage;
	private LinkedHashMap<Integer, int[]> questionHash;

	QuestionCard(String title, Quizit quiz) {
		super(title, quiz);
		quizit = quiz;
		currentDomain = quiz.getDomain();
		profile = quiz.getProfile();

		// different profile settings ||||
		//                            VVVV
		if (profile.getPossible() && profile.getOrder()) {
			for (int i = 0; i < currentDomain.getDomainSize(); i++) {
				questions.add(currentDomain.getQuestions().get(i));
			}
		} else if (profile.getPossible() && !profile.getOrder()) {
			intermediateDomain = (ArrayList) currentDomain.getQuestions().clone();
			Collections.shuffle(intermediateDomain);
			for (int i = 0; i < currentDomain.getDomainSize(); i++) {
				questions.add(intermediateDomain.get(i));
			}
		} else if (!profile.getPossible() && profile.getOrder()) {
			questionHash = (LinkedHashMap) profile.getHashMap().clone();
			for (Question q : currentDomain.getQuestions()) {
				if (questionHash.get(q.getID())[0] < profile.getThreshold()) {
					questions.add(q);
				}
			}
		} else if (!profile.getPossible() && !profile.getOrder()) {
			questionHash = (LinkedHashMap) profile.getHashMap().clone();
			intermediateDomain = (ArrayList) currentDomain.getQuestions().clone();
			Collections.shuffle(intermediateDomain);
			for (Question q : intermediateDomain) {
				if (questionHash.get(q.getID())[0] < profile.getThreshold()) {
					questions.add(q);
				}
			}
		}
		currentQIndex = 0;
		currentQ = questions.get(currentQIndex);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		// make text boxes
		askedNumTimesText = new JLabel("Asked: " + profile.getTimesAsked(currentQ.getID()) + " times");
		correctNumTimesText = new JLabel("Correct: " + profile.getAnsweredRight(currentQ.getID()) + " times");
		answerText = new JLabel(currentQ.getAnswer());
		answerText.setEnabled(false);
		questionText = new JLabel(currentQ.getQuestion());
		domainNameText = new JLabel("Current Domain: " + quizit.getDomain().getDomainName());

		// make buttons
		editQuestBtn = new TransitionButton(this, 100, 50, Color.white, "Edit Question", 12, 5);

		backBtn = new TransitionButton(this, 100, 50, Color.white, "Exit", 5, 0);

		ansBtn = new EstablisherButton(this, 100, 50, Color.white, "Answer", 1);

		knewAnsBtn = new EstablisherButton(this, 90, 40, Color.white, "I knew the answer", 2);
		knewAnsBtn.setEnabled(false);

		notKnewAnsBtn = new EstablisherButton(this, 90, 40, Color.white, "I didn't know", 3);
		notKnewAnsBtn.setEnabled(false);

		nextQuestBtn = new EstablisherButton(this, 100, 50, Color.white, "Next Question", 4);
		nextQuestBtn.setEnabled(false);

		delQuestBtn = new EstablisherButton(this, 100, 50, Color.white, "Delete Question", 6);

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
		this.add(domainNameText);
	}

	public int getScreenID() {
		return 6;
	}

	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
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
			quizit.changeScreen(12);
		} else if (buttonID == 1) {
			ansBtn.setEnabled(false);
			knewAnsBtn.setEnabled(true);
			notKnewAnsBtn.setEnabled(true);
			answerText.setEnabled(true);
			profile.asked(currentQ.getID());
			askedNumTimesText.setText(profile.getTimesAsked(currentQ.getID()) + "");
		} else if (buttonID == 2) {
			knewAnsBtn.setEnabled(false);
			notKnewAnsBtn.setEnabled(false);
			nextQuestBtn.setEnabled(true);
			profile.answeredCorrectly(currentQ.getID());
			correctNumTimesText.setText(profile.getAnsweredRight(currentQ.getID()) + "");
		} else if (buttonID == 3) {
			knewAnsBtn.setEnabled(false);
			notKnewAnsBtn.setEnabled(false);
			nextQuestBtn.setEnabled(true);
		} else if (buttonID == 4) {
			if (currentQIndex <= (questions.size() - 2)) {
				ansBtn.setEnabled(true);
				knewAnsBtn.setEnabled(false);
				notKnewAnsBtn.setEnabled(false);
				answerText.setEnabled(false);
				nextQ();
				questionText.setText(currentQ.getQuestion());
				askedNumTimesText.setText(profile.getTimesAsked(currentQ.getID()) + "");
				correctNumTimesText.setText(profile.getAnsweredRight(currentQ.getID()) + "");
			} else if(currentQIndex==(questions.size()-1)){
				if (popup("You have completed all the questions in this domain. \n" + "\n"
						+ "Would you like to exit this domain or restart this domain?\n")) {
					quizit.changeScreen(6);
				} else if (!popup("You have completed all the questions in this domain. \n" + "\n"
						+ "Would you like to exit this domain or restart this domain?\n")) {
					quizit.changeScreen(5);
				}
			}

		} else if (buttonID == 5) {
			quizit.changeScreen(12);
		} else if (buttonID == 6) {
			if (popup("Are you sure?")) {
				quizit.getDomain().deleteQuestion(currentQIndex);
			} else if(!popup("Are you sure?")) {
				//hide pop up
			}
		}

	}

	public void buttonClicked(int width, int height, Color color, String text, int screenID, int buttonID) {
		// TODO Auto-generated method stub

	}

	public void nextQ() {
		currentQIndex++;
		currentQ = questions.get(currentQIndex);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QuestionCard test= new QuestionCard("", new Quizit());
		frame.setContentPane(test);
		frame.pack();
		frame.setSize(1280, 720);
		frame.setVisible(true);
	}
}

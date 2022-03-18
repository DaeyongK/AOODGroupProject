//QuestionScreen is front-end class made by Kai C

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class QuestionScreen extends QPanel implements ActionListener {
	private int screenId;
	private int questionId;
	private boolean edit;
	private boolean graphicDetected;

	private JLabel imageLabel;
	private JTextField questionBox;
	private JTextField answerBox;
	private JTextField changeRight;
	private JTextField changeAsked;

	private Question question;
	private Profile profile;
	private Domain domain;

	QuestionScreen(String t, Quizit q) {
		super(t, q);
		String title;
		JLabel titleLabel;
		domain = q.getDomain();
		setLayout(null);
		setBackground(BACKGROUND_COLOR);

		if (t.toLowerCase().contains("create")) {
			question = new Question();
			questionId = questionIdFinder();
			title = "Create a Question";
			screenId = 11;
			edit = false;
			graphicDetected = false;
			titleLabel = new JLabel(title);
			titleLabel.setBounds(464, 86, 351, 32);
			imageLabel = new JLabel();
			imageLabel.setVisible(false);
			questionBox = new JTextField("");
			answerBox = new JTextField("");
		}
		else {
			question = q.getQuestion();
			questionId = questionIdFinder();
			profile = q.getProfile();
			title = "Edit Question #" + questionId;
			screenId = 12;
			edit = true;
			graphicDetected = question.getImage() != null;

			titleLabel = new JLabel(title);
			titleLabel.setBounds(464, 86, 360, 32);
			if (graphicDetected) {
				imageLabel = new JLabel(new ImageIcon(question.getGraphicPath()));
				imageLabel.setIcon(new ImageIcon(question.getGraphicPath()));
                		imageLabel.setVisible(true);
			}
			else {
				imageLabel = new JLabel();
				imageLabel.setVisible(false);
			}

			changeRight = new JTextField(profile.getAnsweredRight(questionId));
			changeAsked = new JTextField(profile.getTimesAsked(questionId));
			changeRight.setBackground(Color.WHITE);
			changeAsked.setBackground(Color.WHITE);
			changeRight.setBounds(953, 161, 283, 56);
			changeAsked.setBounds(953, 242, 283, 56);
			add(changeRight);
			add(changeAsked);

			JLabel rightLabel = new JLabel("Correct:     ");
			JLabel askedLabel = new JLabel("Asked:     ");
			rightLabel.setForeground(Color.white);
			askedLabel.setForeground(Color.white);

			rightLabel.setBounds(660,161,300,56);
			askedLabel.setBounds(660,242,300,56);
			rightLabel.setHorizontalAlignment(JLabel.RIGHT);
			askedLabel.setHorizontalAlignment(JLabel.RIGHT);
			add(rightLabel);
			add(askedLabel);
		}
		JLabel questionLabel = new JLabel("Enter a question here:");
		JLabel answerLabel = new JLabel("Enter an answer here:");
		questionBox = new JTextField(question.getQuestion());
		answerBox = new JTextField(question.getAnswer());

		EstablisherButton attachGraphic = new EstablisherButton(
				this, 161, 44, Color.WHITE, "Attach", 0);
		EstablisherButton detachGraphic = new EstablisherButton(
				this, 161, 44, Color.WHITE, "Detach", 1);
		TransitionButton doneBtn = new TransitionButton(
				this, 161, 69, Color.WHITE, "Done", 8, 2);
		TransitionButton backBtn = new TransitionButton(
				this, 175, 67, Color.WHITE, "Back", 8, 3);

		questionLabel.setForeground(Color.WHITE);
		answerLabel.setForeground(Color.WHITE);
		questionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		answerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
		titleLabel.setForeground(TITLE_COLOR);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setBounds(121, 157, 435, 166);

		questionLabel.setBounds(121,385,200,20);
		answerLabel.setBounds(720,385,200,20);
		questionBox.setBounds(121, 405, 438, 124);
		answerBox.setBounds(720, 405, 438, 124);
		attachGraphic.setBounds(121, 327, 161, 44);
		detachGraphic.setBounds(398, 327, 161, 44);
		doneBtn.setBounds(559, 570, 161, 69);
		backBtn.setBounds(49, 42, 175, 67);

		add(titleLabel);
		add(imageLabel);
		add(questionLabel);
		add(answerLabel);
		add(questionBox);
		add(answerBox);
		add(attachGraphic);
		add(detachGraphic);
		add(doneBtn);
		add(backBtn);
		revalidate();
		repaint();
	}
	public int getScreenID() {
		return screenId;
	}
	public boolean popup(String text) {
		int result;

		if (text.toLowerCase().contains("select")) {
			result = JOptionPane.showConfirmDialog(quizit.getFrame(), text, text, JOptionPane.OK_CANCEL_OPTION);

			if (result == JOptionPane.OK_OPTION) {
				JFileChooser jfc = new JFileChooser();

				//only show img files by default
				//wont stop user from just changing it to be all files so accept() is still needed
				FileNameExtensionFilter filter = new FileNameExtensionFilter("img files",
						"png", "jpg", "jpeg", "gif");
				jfc.setFileFilter(filter);

				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File img = jfc.getSelectedFile();
					if (accept(img)) {
						if (popup("Are you sure you want to attach the image?")) {
							question.setImage(img.getPath());
							graphicDetected = true;
							imageLabel.setIcon(new ImageIcon(question.getGraphicPath()));
							imageLabel.setVisible(true);
							revalidate();
							repaint();
						}
					}
				}
			}
		} else if (text.toLowerCase().contains("detach")) {
			if (graphicDetected) {
				if (popup("Are you sure you want to remove the image?")) {
					question.detachImage();
					graphicDetected = false;
					imageLabel.setIcon(null);
					imageLabel.setVisible(false);
					revalidate();
					repaint();
				}
			}
		} else if (text.toLowerCase().contains("are you sure")) {
			result = JOptionPane.showConfirmDialog(quizit.getFrame(), text, text, JOptionPane.YES_NO_OPTION);
			return result == JOptionPane.YES_OPTION;
		}

		return false;
	}
	private boolean accept(File f) {
		String name = f.toString();
		int index = name.lastIndexOf('.');
		if (index > 0) {
			String extension = name.substring(index + 1);
			return extension.equals("png") || extension.equals("jpg") ||
					extension.equals("jpeg") || extension.equals("gif");
		}
		return false;
	}
	public void buttonClicked(int buttonID) {
		switch (buttonID) {
		case 0:
			if (popup("Select File")) {
				question.setImage(question.getGraphicPath());
			}
			break;
		case 1:
			if (graphicDetected) {
				if (popup("Detach Graphic"))
					question.detachImage();
			}
			break;
		case 2:
			//DoneBtn
			if (edit) {
				try {
					if (!questionBox.getText().equals("") &&
							!answerBox.getText().equals("") &&
							Integer.parseInt(changeRight.getText()) >= 0 &&
							Integer.parseInt(changeAsked.getText()) >= 0 &&
							Integer.parseInt(changeRight.getText()) <=
							Integer.parseInt(changeAsked.getText())) {
						question.setQuestion(questionBox.getText());
						question.setAnswer(answerBox.getText());
						profile.setNumCorrect(questionId, Integer.parseInt(changeRight.getText()));
						profile.setNumAsked(questionId, Integer.parseInt(changeAsked.getText()));
						if (graphicDetected)
							domain.addQuestion(new Question(question.getQuestion(),
									question.getAnswer(), question.getGraphicPath(), quizit));
						else
							domain.addQuestion(new Question(question.getQuestion(),
									question.getAnswer(), quizit));
						quizit.changeScreen(8);
					}
				} catch (NullPointerException | NumberFormatException ignored) {}
			} else
				try {
					if (!questionBox.getText().equals("") &&
							!answerBox.getText().equals("") &&
							!questionBox.getText().equals("Enter a new question here: ") &&
							!answerBox.getText().equals("Enter its answer here: ")) {
						question.setQuestion(questionBox.getText());
						question.setAnswer(answerBox.getText());
						if (graphicDetected)
							domain.addQuestion(new Question(question.getQuestion(),
									question.getAnswer(), question.getGraphicPath(), quizit));
						else
							domain.addQuestion(new Question(question.getQuestion(),
									question.getAnswer(), quizit));
						quizit.changeScreen(8);
					}
				} catch (NullPointerException ignored) {
				}

			break;

		case 3:
			//BackBtn
			if (popup("Are you sure you want to leave?")) {
				quizit.changeScreen(8);
			}
			break;
		}
	}
	private int questionIdFinder() {
		idFound = false;
		int index = 0;
		int questionId = 1;
		while (index<getQuestions.size()) {
			if (getQuestion(index).getID == question.getID)
				questionId = index + 1;
		}
		return questionId;
	}
	/*private void changeImgSize() {
        BufferedImage graphic = question.getImage();
        int pixW = graphic.getWidth();
        int pixH = graphic.getHeight();
        if (pixH <= 166 && pixW <= 438) {

            new BufferedImage();
        }
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawRect(121, 160, 438, 166);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.drawString("No Graphic Preview", 250, 245);
	}
	//FOR TESTING PURPOSES!!
	public static void main(String[] arg) {
		/*JFrame testFrame = new JFrame("QuestionScreen Test");
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.pack();
		testFrame.setSize(1280, 720);
		testFrame.add(new QuestionScreen("Create a Question", new Quizit()));
		testFrame.setVisible(true);*/

		Quizit q = new Quizit();
		q.changeScreen(11);
	}
}

//QuestionScreen is front-end class made by Kai C

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class QuestionScreen extends QPanel implements DocumentListener {
	private int screenId;
	private boolean edit;
	private boolean graphicDetected;

	private JLabel imagePreview;
	private JLabel imageLabel;
	private JTextField questionBox;
	private JTextField answerBox;
	private JTextField changeRight;
	private JTextField changeAsked;
	private TransitionButton doneBtn;
	private Quizit quizit;
	private Question question;
	private Profile profile;

	QuestionScreen(String t, Quizit q) {
		super(t, q);
		String title;
		JLabel titleLabel;
		imagePreview = new JLabel("No Graphic Preview");
		quizit = q;
		setLayout(null);
		setBackground(BACKGROUND_COLOR);
		if (t.toLowerCase().contains("create")) {
			
			question = new Question();
			title = "Create a Question";
			screenId = 11;
			edit = false;
			graphicDetected = false;
			titleLabel = new JLabel(title);
			imageLabel = new JLabel();
			imageLabel.setIcon(null);
			imageLabel.setVisible(false);
			imagePreview.setVisible(true);
			questionBox = new JTextField("");
			answerBox = new JTextField("");
			
		}
		else {
			question = q.getQuestion();
			profile = q.getProfile();
			title = "Edit Question";
			screenId = 12;
			edit = true;

			titleLabel = new JLabel(title);
			graphicDetected = !question.getGraphicPath().equals("");
			if (graphicDetected) {
				imageLabel = new JLabel(new ImageIcon(question.getGraphicPath()));
				imageLabel.setIcon(new ImageIcon(question.getGraphicPath()));
				imageLabel.setVisible(true);
				imagePreview.setVisible(false);
				question.setImage(question.getGraphicPath());

				resizeImg();

			}
			else {
				imageLabel = new JLabel();
				imageLabel.setIcon(null);
				imageLabel.setVisible(false);
				imagePreview.setVisible(true);
			}
			changeRight = new JTextField(""+profile.getAnsweredRight(question.getID()));
			changeAsked = new JTextField(""+profile.getTimesAsked(question.getID()));
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
			changeRight.getDocument().addDocumentListener(this);
			changeAsked.getDocument().addDocumentListener(this);
			
		}
		JLabel questionLabel = new JLabel("Enter a question here:");
		JLabel answerLabel = new JLabel("Enter an answer here:");
		questionBox = new JTextField(question.getQuestion());
		answerBox = new JTextField(question.getAnswer());

		EstablisherButton attachGraphic = new EstablisherButton(
				this, 161, 44, Color.WHITE, "Attach", 0);
		EstablisherButton detachGraphic = new EstablisherButton(
				this, 161, 44, Color.WHITE, "Detach", 1);
		doneBtn = new TransitionButton(
				this, 161, 69, Color.WHITE, "Save", 8, 2);
		TransitionButton backBtn = new TransitionButton(
				this, 175, 67, Color.WHITE, "Back", 8, 3);

		imagePreview.setForeground(Color.WHITE);
		imagePreview.setFont(new Font("Arial", Font.BOLD, 18));
		questionLabel.setForeground(Color.WHITE);
		answerLabel.setForeground(Color.WHITE);
		questionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		answerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
		titleLabel.setForeground(TITLE_COLOR);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		imagePreview.setHorizontalAlignment(JLabel.CENTER);
		imagePreview.setVerticalAlignment(JLabel.CENTER);
		imagePreview.setBounds(122, 161, 438, 166);
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
		imageLabel.setBounds(122, 161, 437, 166);
		titleLabel.setBounds(464, 86, 351, 32);
		questionLabel.setBounds(121,385,200,20);
		answerLabel.setBounds(720,385,200,20);
		questionBox.setBounds(121, 405, 438, 124);
		answerBox.setBounds(720, 405, 438, 124);
		attachGraphic.setBounds(121, 327, 161, 44);
		detachGraphic.setBounds(398, 327, 161, 44);
		doneBtn.setBounds(559, 570, 161, 69);
		backBtn.setBounds(49, 42, 175, 67);
		add(titleLabel);
		add(imagePreview);
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
		questionBox.getDocument().addDocumentListener(this);
		answerBox.getDocument().addDocumentListener(this);
		if (edit) {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						Integer.parseInt(changeRight.getText()) >= 0 &&
						Integer.parseInt(changeAsked.getText()) >= 0 &&
						(Integer.parseInt(changeRight.getText()) <=
						Integer.parseInt(changeAsked.getText()))) {
					doneBtn.setEnabled(true);
				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException | NumberFormatException ignored) {}
		} else {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						!questionBox.getText().equals("Enter a new question here: ") &&
						!answerBox.getText().equals("Enter its answer here: ")) {
					doneBtn.setEnabled(true);
				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException ignored) {
			}
		}
		
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
							resizeImg();
							imageLabel.setVisible(true);
							imagePreview.setVisible(false);
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
					imagePreview.setVisible(true);
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
							(Integer.parseInt(changeRight.getText()) <=
							Integer.parseInt(changeAsked.getText()))) {
						question.setQuestion(questionBox.getText());
						question.setAnswer(answerBox.getText());
						profile.setNumCorrect(question.getID(), Integer.parseInt(changeRight.getText()));
						profile.setNumAsked(question.getID(), Integer.parseInt(changeAsked.getText()));
						quizit.setQuestion(question);
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
							quizit.setQuestion(new Question(question.getQuestion(),
									question.getAnswer(), question.getGraphicPath(), quizit));
						else
							quizit.setQuestion(new Question(question.getQuestion(),
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
	private void resizeImg() {
		BufferedImage thisImg = question.getImage();
		int pixW = thisImg.getWidth();
		int pixH = thisImg.getHeight();
		//If img too small
		if(pixW<438 && pixH<166) {
			while(pixW<438 && pixH<166) {
				pixW++;
				pixH++;
			}
		}
		//If img height too big
		else if (pixW<438 && pixH>166) {
			while(pixW>1 && pixH>166) {
				pixW--;
				pixH--;
			}
		}
		//If img width too big
		else if (pixW>438 && pixH<166) {
			while(pixH>1 && pixW>438) {
				pixW--;
				pixH--;
			}
		}
		//If img too big
		else {
			while (pixW>438 && pixH>166) {
				pixW--;
				pixH--;
			}
		}
		imageLabel.setIcon(new ImageIcon(thisImg.getScaledInstance(pixW,pixH,Image.SCALE_SMOOTH)));
	}
	@Override
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawRect(121, 160, 438, 166);
	}

	public static void main(String[] arg) {
		Quizit q = new Quizit();
		q.changeScreen(11);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if (edit) {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						Integer.parseInt(changeRight.getText()) >= 0 &&
						Integer.parseInt(changeAsked.getText()) >= 0 &&
						(Integer.parseInt(changeRight.getText()) <=
						Integer.parseInt(changeAsked.getText()))) {
					doneBtn.setEnabled(true);
				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException | NumberFormatException ignored) {}
		} else {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						!questionBox.getText().equals("Enter a new question here: ") &&
						!answerBox.getText().equals("Enter its answer here: ")) {
					doneBtn.setEnabled(true);

				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException ignored) {
			}
		}
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if (edit) {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						Integer.parseInt(changeRight.getText()) >= 0 &&
						Integer.parseInt(changeAsked.getText()) >= 0 &&
						(Integer.parseInt(changeRight.getText()) <=
						Integer.parseInt(changeAsked.getText()))) {
					doneBtn.setEnabled(true);
				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException | NumberFormatException ignored) {}
		} else {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						!questionBox.getText().equals("Enter a new question here: ") &&
						!answerBox.getText().equals("Enter its answer here: ")) {
					doneBtn.setEnabled(true);

				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException ignored) {
			}
		}
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		if (edit) {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						Integer.parseInt(changeRight.getText()) >= 0 &&
						Integer.parseInt(changeAsked.getText()) >= 0 &&
						(Integer.parseInt(changeRight.getText()) <=
						Integer.parseInt(changeAsked.getText()))) {
					doneBtn.setEnabled(true);
				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException | NumberFormatException ignored) {}
		} else {
			try {
				if (!questionBox.getText().equals("") &&
						!answerBox.getText().equals("") &&
						!questionBox.getText().equals("Enter a new question here: ") &&
						!answerBox.getText().equals("Enter its answer here: ")) {
					doneBtn.setEnabled(true);

				}else {
					doneBtn.setEnabled(false);

				}
			} catch (NullPointerException ignored) {
			}
		}		
	}
}

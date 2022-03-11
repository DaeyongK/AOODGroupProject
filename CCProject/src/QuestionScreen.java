//QuestionScreen is front-end class made by Kai C

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class QuestionScreen extends QPanel implements ActionListener {
    private String title;
    private int screenId;
    private int questionId;
    private boolean edit;
    private boolean graphicDetected;

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JTextField questionBox;
    private JTextField answerBox;
    private JTextField changeRight;
    private JTextField changeAsked;

    private EstablisherButton attachGraphic;
    private EstablisherButton detachGraphic;
    private TransitionButton doneBtn;
    private TransitionButton backBtn;

    private Question question;
    private Profile profile;
    private Domain domain;

    QuestionScreen(String t, Quizit q) {
        super(t, q);
        domain = q.getDomain();
        setLayout(null);
        setBackground(BACKGROUND_COLOR);

        if (t.toLowerCase().contains("create")) {
            question = new Question();
            questionId = question.getID();
            title = "Create a Question";
            screenId = 11;
            edit = false;
            graphicDetected = false;
            titleLabel = new JLabel(title);
            titleLabel.setBounds(464, 86, 351, 32);
            imageLabel = new JLabel();
            questionBox = new JTextField("Enter a new question here: ");
            answerBox = new JTextField("Enter its answer here: ");
        } else {
            question = q.getQuestion();
            questionId = question.getID();
            profile = q.getProfile();
            title = "Edit Question #" + questionId;
            screenId = 12;
            edit = true;
            graphicDetected = question.getImage() != null;

            titleLabel = new JLabel(title);
            titleLabel.setBounds(464, 86, 360, 32);
            if (graphicDetected)
                imageLabel = new JLabel(new ImageIcon(question.getGraphicPath()));
            else
                imageLabel = new JLabel();

            questionBox = new JTextField(question.getQuestion());
            answerBox = new JTextField(question.getAnswer());
            changeRight = new JTextField("Correct: " + profile.getAnsweredRight(questionId) + " times");
            changeAsked = new JTextField("Asked: " + profile.getTimesAsked(questionId) + " times");
            changeRight.setBounds(953, 161, 283, 56);
            changeAsked.setBounds(953, 242, 283, 56);
            add(changeRight);
            add(changeAsked);
        }
        attachGraphic = new EstablisherButton(this, 161, 44, Color.WHITE, "Attach", 0);
        detachGraphic = new EstablisherButton(this, 161, 44, Color.WHITE, "Detach", 1);
        doneBtn = new TransitionButton(this, 161, 69, Color.WHITE, "Done", 8, 2);
        backBtn = new TransitionButton(this, 175, 67, Color.WHITE, "Back", 8, 3);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(TITLE_COLOR);
        imageLabel.setBounds(121, 160, 438, 166);
        questionBox.setBounds(121, 399, 438, 124);
        answerBox.setBounds(720, 399, 438, 124);
        attachGraphic.setBounds(121, 327, 161, 44);
        detachGraphic.setBounds(398, 327, 161, 44);
        doneBtn.setBounds(559, 570, 161, 69);
        backBtn.setBounds(49, 42, 175, 67);

        add(titleLabel);
        add(imageLabel);
        add(questionBox);
        add(answerBox);
        add(attachGraphic);
        add(detachGraphic);
        add(doneBtn);
        add(backBtn);
    }

    //FOR TESTING PURPOSES!!
    public static void main(String[] arg) {
//        JFrame testFrame = new JFrame("QuestionScreen Test");
//        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        testFrame.pack();
//        testFrame.setSize(1280, 720);
//        testFrame.add(new QuestionScreen("Create a Question", new Quizit()));
//        testFrame.setVisible(true);

        Quizit q = new Quizit();
        q.changeScreen(11);
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
                FileNameExtensionFilter filter = new FileNameExtensionFilter("img files", "png", "jpg", "jpeg", "gif");
                jfc.setFileFilter(filter);

                int returnValue = jfc.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File img = jfc.getSelectedFile();
                    if (accept(img)) {
                        if (popup("Are you sure you want to attach the image?")) {
                            question.setImage(img.getPath());
                            graphicDetected = true;
                            imageLabel = new JLabel(new ImageIcon(question.getGraphicPath()));
                        }
                    }
                }
            }
        } else if (text.toLowerCase().contains("detach")) {
            if (graphicDetected) {
                if (popup("Are you sure you want to remove the image?")) {
                    question.detachImage();
                    graphicDetected = false;
                    imageLabel = new JLabel();
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
            return extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("gif");
        }
        return false;
    }

    public void buttonClicked(int buttonID) {
        switch (buttonID) {
            case 0:
                if (popup("Select File")) {
                    //Figure out bufferedImage stuff
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
                //Checks if all textFields are entered
                if (edit) {
                    try {
                        if (!questionBox.getText().equals("") &&
                                !answerBox.getText().equals("") &&
                                !changeRight.getText().equals("") &&
                                !changeAsked.getText().equals("") &&
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
                    } catch (NullPointerException | NumberFormatException ignored) {
                    }
                } else
                    try {
                        if (!questionBox.getText().equals("") &&
                                !answerBox.getText().equals("")) {
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

    private void radioClick() {
        //empty for now
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //empty for now
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawRect(121, 160, 438, 166);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("No Graphic Preview", 216, 218);
    }
}

//QuestionScreen is front-end class made by Kai C

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
    private Domain domain;

    QuestionScreen(String t, Quizit q) {
        super(t, q);
        thisQuizit = q;
        thisFrame = q.getFrame();
        thisScreen = this;
        domain = q.getDomain();
        setLayout(null);
        setBackground(BACKGROUND_COLOR);

        if (t.contains("Create")) {
            question = new Question();
            questionId = question.getID();
            title = "Create a Question";
            screenId = 11;
            edit = false;
            graphicDetected = false;
            titleLabel = new JLabel(title);
            titleLabel.setBounds(464, 86, 351, 32);
            questionBox = new JTextField("Enter a new question here: ");
            answerBox = new JTextField("Enter its answer here: ");
        } else {
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
        attachGraphic = new EstablisherButton(this, 161, 44, Color.WHITE, "Attach", 0);
        detachGraphic = new EstablisherButton(this, 161, 44, Color.WHITE, "Detach", 1);
        doneBtn = new TransitionButton(this, 161, 69, Color.WHITE, "Done", 8, 2);
        backBtn = new TransitionButton(this, 175, 67, Color.WHITE, "Back", 8, 3);

        titleLabel.setFont(new Font("Arial",Font.BOLD,25));
        titleLabel.setForeground(TITLE_COLOR);
        questionBox.setBounds(121, 399, 438, 124);
        answerBox.setBounds(720, 399, 438, 124);
        attachGraphic.setBounds(121, 327, 161, 44);
        detachGraphic.setBounds(398, 327, 161, 44);
        doneBtn.setBounds(559, 570, 161, 69);
        backBtn.setBounds(49, 42, 175, 67);
        
        add(titleLabel);
        add(questionBox);
        add(answerBox);
        add(attachGraphic);
        add(detachGraphic);
        add(doneBtn);
        add(backBtn);
    }

    //FOR TESTING PURPOSES!!
    public static void main(String[] arg) {
        JFrame testFrame = new JFrame("QuestionScreen Test");
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.pack();
        testFrame.setSize(1280, 720);
        testFrame.add(new QuestionScreen("Create a Question", new Quizit()));
        testFrame.setVisible(true);
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
                graphicDetected = true;
                return popup("Attach a Graphic", false);
            }
        } else {
            JOptionPane.showMessageDialog(thisScreen, "Are you sure?");
            result = JOptionPane.YES_OPTION;
        }
        return false;
    }

    public void buttonClicked(int buttonID) {
        QPanel nextScreen = thisScreen;
        switch (buttonID) {
            case 0:
                if (popup("Attach Graphic", true)) {
                    //Figure out bufferedImage stuff
                    question.setImage(question.getGraphicPath());
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
                            quizit.changeScreen(6);
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
                                        question.getAnswer(), question.getGraphicPath(), thisQuizit));
                            else
                                domain.addQuestion(new Question(question.getQuestion(),
                                        question.getAnswer(), thisQuizit));
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
        g.drawRect(121, 160, 438, 166);
        g.setFont(new Font("Arial",Font.BOLD,18));
        g.drawString("No Graphic Preview", 216, 218);
    }
}

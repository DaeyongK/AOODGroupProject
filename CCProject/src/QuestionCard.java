import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class QuestionCard extends QPanel {
    private Profile profile;
    private Question currentQ;
    private int currentQIndex;
    private Domain currentDomain;
    private ArrayList<Question> questions = new ArrayList<>(), intermediateDomain;
    private Quizit quizit;
    private EstablisherButton ansBtn, knewAnsBtn, notKnewAnsBtn, nextQuestBtn, delQuestBtn;
    private TransitionButton editQuestBtn, backBtn;
    private JLabel askedNumTimesText, correctNumTimesText, answerText, questionText;
    private BufferedImage questImage;
    private LinkedHashMap<Integer, int[]> questionHash;
    private Graphics g=this.getGraphics();

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
            intermediateDomain = new ArrayList<>(currentDomain.getQuestions());
            Collections.shuffle(intermediateDomain);
            for (int i = 0; i < currentDomain.getDomainSize(); i++) {
                questions.add(intermediateDomain.get(i));
            }
        } else if (!profile.getPossible() && profile.getOrder()) {
            questionHash = new LinkedHashMap<>(profile.getHashMap());
            for (Question q : currentDomain.getQuestions()) {
                if (questionHash.get(q.getID())[0] < profile.getThreshold()) {
                    questions.add(q);
                }
            }
        } else if (!profile.getPossible() && !profile.getOrder()) {
            questionHash = new LinkedHashMap<>(profile.getHashMap());
            intermediateDomain = new ArrayList<>(currentDomain.getQuestions());
            Collections.shuffle(intermediateDomain);
            for (Question q : intermediateDomain) {
                if (questionHash.get(q.getID())[0] < profile.getThreshold()) {
                    questions.add(q);
                }
            }
        }
        currentQIndex = 0;
        currentQ = questions.get(currentQIndex);
        this.setLayout(null);
        

        // make text boxes
        askedNumTimesText = new JLabel("   Asked: " + profile.getTimesAsked(currentQ.getID()) + " times");
        askedNumTimesText.setFont(new Font("SanSerif",Font.PLAIN,20));
        askedNumTimesText.setOpaque(true);
        askedNumTimesText.setBounds(50, 150, 350, 40);
        askedNumTimesText.setBackground(new Color(255, 244, 150));
        correctNumTimesText = new JLabel("   Correct: " + profile.getAnsweredRight(currentQ.getID()) + " times");
        correctNumTimesText.setFont(new Font("SanSerif",Font.PLAIN,20));
        correctNumTimesText.setOpaque(true);
        correctNumTimesText.setBounds(450, 150, 400, 40);
        correctNumTimesText.setBackground(new Color(255, 244, 150));
        answerText = new JLabel(" Answer: "+currentQ.getAnswer());
        answerText.setFont(new Font("SanSerif",Font.PLAIN,17));
        answerText.setOpaque(true);
        answerText.setBounds(50, 630, 800, 40);
        answerText.setVisible(false);
        questionText = new JLabel(currentQ.getQuestion());
        questionText.setFont(new Font("SanSerif",Font.PLAIN,17));
        questionText.setOpaque(true);
        questionText.setBounds(70, 240, 760, 40);

        // make buttons
        editQuestBtn = new TransitionButton(this, 100, 50, Color.white, "Edit Question", 12, 5);
        editQuestBtn.setBounds(850, 25, 200, 50);

        backBtn = new TransitionButton(this, 100, 50, Color.white, "Exit", 5, 0);
        backBtn.setBounds(25,25,200,50);

        ansBtn = new EstablisherButton(this, 100, 50, Color.white, "Answer", 1);
        ansBtn.setBounds(1000, 350, 250, 50);

        knewAnsBtn = new EstablisherButton(this, 90, 40, Color.white, "I knew the answer", 2);
        knewAnsBtn.setBounds(1000, 325, 250, 50);
        knewAnsBtn.setEnabled(false);
        knewAnsBtn.setVisible(false);

        notKnewAnsBtn = new EstablisherButton(this, 90, 40, Color.white, "I didn't know", 3);
        notKnewAnsBtn.setBounds(1000, 380, 250, 50);
        notKnewAnsBtn.setEnabled(false);
        notKnewAnsBtn.setVisible(false);

        nextQuestBtn = new EstablisherButton(this, 100, 50, Color.white, "Next Question", 4);
        nextQuestBtn.setBounds(1000, 350, 250, 50);
        nextQuestBtn.setEnabled(false);
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
        
        //Draw background stuff
        this.revalidate();
        this.repaint();
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
            ansBtn.setVisible(false);
            knewAnsBtn.setEnabled(true);
            knewAnsBtn.setVisible(true);
            notKnewAnsBtn.setEnabled(true);
            notKnewAnsBtn.setVisible(true);
            answerText.setEnabled(true);
            answerText.setVisible(true);
            profile.asked(currentQ.getID());
            askedNumTimesText.setText("   Asked: " +profile.getTimesAsked(currentQ.getID()) + "");
        } else if (buttonID == 2) {
            knewAnsBtn.setEnabled(false);
            knewAnsBtn.setVisible(false);
            notKnewAnsBtn.setEnabled(false);
            notKnewAnsBtn.setVisible(false);
            nextQuestBtn.setEnabled(true);
            nextQuestBtn.setVisible(true);
            profile.answeredCorrectly(currentQ.getID());
            correctNumTimesText.setText("   Correct: " +profile.getAnsweredRight(currentQ.getID()) + " times");
        } else if (buttonID == 3) {
            knewAnsBtn.setEnabled(false);
            knewAnsBtn.setVisible(false);
            notKnewAnsBtn.setEnabled(false);
            notKnewAnsBtn.setVisible(false);
            nextQuestBtn.setEnabled(true);
            nextQuestBtn.setVisible(true);
        } else if (buttonID == 4) {
            if (currentQIndex <= (questions.size() - 2)) {
                ansBtn.setEnabled(true);
                ansBtn.setVisible(true);
                knewAnsBtn.setEnabled(false);
                knewAnsBtn.setVisible(true);
                notKnewAnsBtn.setEnabled(false);
                notKnewAnsBtn.setVisible(false);
                answerText.setEnabled(false);
                answerText.setVisible(false);
                nextQ();
                questionText.setText(currentQ.getQuestion());
                askedNumTimesText.setText(profile.getTimesAsked(currentQ.getID()) + "");
                correctNumTimesText.setText(profile.getAnsweredRight(currentQ.getID()) + "");
            } else if (currentQIndex == (questions.size() - 1)) {
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
            } else if (!popup("Are you sure?")) {
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
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(new Color (230,220,0));
    	g.fillRect(50, 230, 800, 380);
    	g.setColor(Color.gray);
    	g.fillRect(0, 0, 1280, 100);
    	g.setColor(Color.white);
    	g.setFont(new Font("SanSerif",Font.BOLD, 17));
    	g.drawString("Current Domain: "+currentDomain.getDomainName(), 275, 55);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QuestionCard test = new QuestionCard("", new Quizit());
        frame.setContentPane(test);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setVisible(true);
    }
}

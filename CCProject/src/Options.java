import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends QPanel implements ActionListener {
    private boolean allQuestions;
    private boolean shuffleQuestions;
    private JComboBox<String> dropdown;
    private EstablisherButton numCorrectButton;
    private EstablisherButton allQuestionsButton;
    private EstablisherButton shuffleQuestionsButton;
    private EstablisherButton firstLastButton;
    private Quizit quizitReference;
    private int numCorrectNumber;

    Options(String title, Quizit q) {
        super(title, q);
        this.setLayout(null);
        quizitReference = q;
        //panel setup
        this.setBackground(this.BACKGROUND_COLOR);

        allQuestions = q.getProfile().getPossible();
        shuffleQuestions = q.getProfile().getOrder();
        numCorrectNumber = q.getProfile().getThreshold();

//        this.addMouseListener(this);

        //create buttons and ui aspects. adds action listeners. then adds to qpanel

        //number correct button
        numCorrectButton = new EstablisherButton(this, 300, 40, Color.WHITE, "Questions with number of correct answers", 1);
        numCorrectButton.setBounds(150, 170, 320, 90);
        numCorrectButton.addActionListener(this);
        this.add(numCorrectButton);

        //dropdown menu
        String[] names = {"<5", "<10", "<15", "<20", "<30"};
        dropdown = new JComboBox<>(names);
        dropdown.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
        dropdown.setSelectedIndex(0);
        dropdown.setBounds(500, 200, 100, 25);
        dropdown.addActionListener(this);

        if(numCorrectNumber == 5) {
            dropdown.setSelectedIndex(0);
        } else if(numCorrectNumber == 10) {
            dropdown.setSelectedIndex(1);
        } else if(numCorrectNumber == 15) {
            dropdown.setSelectedIndex(2);
        } else if(numCorrectNumber == 20) {
            dropdown.setSelectedIndex(3);
        } else if(numCorrectNumber == 30) {
            dropdown.setSelectedIndex(4);
        }

        this.add(dropdown);

        //all questions button
        allQuestionsButton = new EstablisherButton(this, 100, 40, Color.WHITE, "All Questions", 2);
        allQuestionsButton.setBounds(800, 170, 320, 90);
        allQuestionsButton.setFont(new Font("Arial", Font.BOLD, 20));
        allQuestionsButton.addActionListener(this);
        this.add(allQuestionsButton);

        //shuffle questions button
        shuffleQuestionsButton = new EstablisherButton(this, 100, 40, Color.WHITE, "Shuffle Questions", 3);
        shuffleQuestionsButton.setBounds(150, 425, 320, 90);
        shuffleQuestionsButton.setFont(new Font("Arial", Font.BOLD, 20));
        shuffleQuestionsButton.addActionListener(this);
        this.add(shuffleQuestionsButton);

        //first last button
        firstLastButton = new EstablisherButton(this, 100, 40, Color.WHITE, "First to Last", 4);
        firstLastButton.setBounds(800, 425, 320, 90);
        firstLastButton.setFont(new Font("Arial", Font.BOLD, 20));
        firstLastButton.addActionListener(this);
        this.add(firstLastButton);

        //done button
        TransitionButton doneButton = new TransitionButton(this, 50, 25, Color.WHITE, "Done", 1, 5);
        doneButton.setBounds(560, 550, 150, 50);
        doneButton.addActionListener(this);
        this.add(doneButton);

        if(allQuestions) {
            allQuestionsButton.setText("All Questions <-");
            numCorrectButton.setText("Questions with number of correct answers");
        } else {
            allQuestionsButton.setText("All Questions");
            numCorrectButton.setText("Questions with number of correct answers <-");
        }

        if(shuffleQuestions) {
            shuffleQuestionsButton.setText("Shuffle Questions <-");
            firstLastButton.setText("First to Last");
        } else {
            shuffleQuestionsButton.setText("Shuffle Questions");
            firstLastButton.setText("First to Last <-");
        }
    }

    public boolean getShuffled() {
        return shuffleQuestions;
    }

    public boolean getAllQuestions() {
        return allQuestions;
    }

    //if user selects number correct option, this is the accessor for the actual number of questions correct
    public int getNumCorrectNumber() {
        return numCorrectNumber;
    }

    public int getScreenID() {
        return 4;
    }

    @Override
    public boolean popup(String text) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void buttonClicked(int buttonID) {
        // TODO Auto-generated method stub
        switch (buttonID) {
            case 1:
                //allQuestions is false
                allQuestions = false;
                quizit.getProfile().setPossQuestions(false);
                allQuestionsButton.setText("All Questions");
                numCorrectButton.setText("Questions with number of correct answers <-");
                break;
            case 2:
                //allQuestions is true
                allQuestions = true;
                quizit.getProfile().setPossQuestions(true);
                allQuestionsButton.setText("All Questions <-");
                numCorrectButton.setText("Questions with number of correct answers");
                break;
            case 3:
                //shuffleQuestions is true
                quizit.getProfile().setOrderQuestions(true);
                shuffleQuestionsButton.setText("Shuffle Questions <-");
                firstLastButton.setText("First to Last");

                shuffleQuestions = true;
                break;
            case 4:
                //shuffleQuestions is false
                quizit.getProfile().setOrderQuestions(false);
                shuffleQuestionsButton.setText("Shuffle Questions");
                firstLastButton.setText("First to Last <-");

                shuffleQuestions = false;
                break;
            case 5:
                //go to main menu
                //QPanel nextScreen = new MainMenu("", quizitReference);
                String holder = (String) dropdown.getSelectedItem();
                if (holder.contentEquals("<5")) {
                    numCorrectNumber = 5;
                } else if (holder.contentEquals("<10")) {
                    numCorrectNumber = 10;
                } else if (holder.contentEquals("<15")) {
                    numCorrectNumber = 15;
                } else if (holder.contentEquals("<20")) {
                    numCorrectNumber = 20;
                } else if (holder.contentEquals("<30")) {
                    numCorrectNumber = 30;
                }
                quizit.getProfile().setThreshold(numCorrectNumber);
                quizitReference.changeScreen(1);
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(TITLE_COLOR);
        //font bigger???
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Quizzing Options", 530, 100);
    }

    public void actionPerformed(ActionEvent e) {

    }

}

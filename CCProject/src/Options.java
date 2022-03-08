import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Options extends QPanel implements MouseListener {
    private boolean allQuestions;
    private boolean shuffleQuestions;
    private JComboBox<String> dropdown;
    private EstablisherButton numCorrectButton;
    private EstablisherButton allQuestionsButton;
    private EstablisherButton shuffleQuestionsButton;
    private EstablisherButton firstLastButton;
    private TransitionButton doneButton;
    private Quizit quizitReference;
    Options(String title, Quizit q) {
        super(title, q);
        this.setLayout(null);
        quizitReference = q;
        //panel setup
        this.setBackground(this.BACKGROUND_COLOR);
        this.addMouseListener(this);

        //create buttons and ui aspects. adds action listeners. then adds to qpanel

        //number correct button
        numCorrectButton = new EstablisherButton(this, 300, 40, Color.WHITE, "Questions with number of correct answers", 1);
        numCorrectButton.setBounds(150, 170, 320, 90);
        this.add(numCorrectButton);

        //dropdown menu
        String[] names = {"<5", "<10", "<15", "<20", "<30"};
        dropdown = new JComboBox<>(names);
        dropdown.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
        dropdown.setSelectedIndex(0);
        dropdown.setBounds(500, 200, 50, 25);
        this.add(dropdown);

        //all questions button
        allQuestionsButton = new EstablisherButton(this, 100, 40, Color.WHITE, "All Questions", 2);
        allQuestionsButton.setBounds(800, 170, 320, 90);
        this.add(allQuestionsButton);

        //shuffle questions button
        shuffleQuestionsButton = new EstablisherButton(this, 100, 40, Color.WHITE, "Shuffle Questions", 3);
        shuffleQuestionsButton.setBounds(150, 425, 320, 90);
        this.add(shuffleQuestionsButton);

        //first last button
        firstLastButton = new EstablisherButton(this, 100, 40, Color.WHITE, "First to Last", 4);
        firstLastButton.setBounds(800, 425, 320, 90);
        this.add(firstLastButton);

        //done button
        TransitionButton doneButton = new TransitionButton(this, 50, 25, Color.WHITE, "Done", 1, 5);
        doneButton.setBounds(560, 550, 150, 50);
        this.add(doneButton);
    }

    Options(String title, Quizit q, boolean allQuestionsTrue, boolean shuffleQuestionsTrue) {
        super(title, q);
        //sets value of allQuestions
        allQuestions = allQuestionsTrue;
        //sets value of shuffleQuestions
        shuffleQuestions = shuffleQuestionsTrue;
    }

    public void radioClick() {

    }

    public boolean getShuffled() {
        return shuffleQuestions;
    }

    public boolean getAllQuestions() {
        return allQuestions;
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
                break;
            case 2:
                //allQuestions is true
                allQuestions = true;
                break;
            case 3:
                //shuffleQuestions is true
                shuffleQuestions = true;
                break;
            case 4:
                //shuffleQuestions is false
                shuffleQuestions = false;
                break;
            case 5:
                //go to main menu
                //QPanel nextScreen = new MainMenu("", quizitReference);
                quizitReference.changeScreen(1);
                break;
        }
    }
    
	public void paintComponent(Graphics g) {
//		g.setColor(this.TITLE_COLOR);
//		g.drawString("Quizzing Options", id, id);
	}

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}

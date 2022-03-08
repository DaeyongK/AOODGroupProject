import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SelectProfile extends QPanel implements MouseListener {
    private JScrollPane scrollable;
    private ArrayList<Profile> profiles;
    private TransitionButton done;
    private TransitionButton createNewProfileButton;
    private Profile currentProfile;
    private Quizit quizitReference;
    private JScrollBar verticalBar;

    SelectProfile(String title, Quizit q) {
        super(title, q);
        quizitReference = q;
        profiles = q.getAllProfiles();
        //panel setup
        this.setBackground(this.BACKGROUND_COLOR);
        this.setLayout(null);

        //create buttons and ui aspects. adds action listeners. then adds to jpanel.
        //create profile button inside the jscrollpane somehow???
        createNewProfileButton = new TransitionButton(this, 75, 35, Color.WHITE, "Create New Profile", 3, 2);

        //scroll pane???
        scrollable = new JScrollPane();
        JPanel scrollablePane = new JPanel();
        int increment = 3;
        for (Profile p : profiles) {
            EstablisherButton holder = new EstablisherButton(this, 75, 35, Color.WHITE, p.getName(), increment);
            scrollablePane.add(holder);
            increment++;
        }
        scrollablePane.add(createNewProfileButton);
        verticalBar = new JScrollBar(JScrollBar.VERTICAL);
        scrollable.add(scrollablePane);
        scrollable.add(verticalBar);

        //insert code needed to add in profiles
        this.addMouseListener(this);
        scrollable.addMouseListener(this);
        scrollable.setBounds(475, 200, 300, 300);
        this.add(scrollable);

        //done button
        done = new TransitionButton(this, 50, 25, Color.WHITE, "Done", 1, 1);
        done.setBounds(560, 550, 150, 50);
        this.add(done);
    }

    public void radioClick() {

    }

    public int getScreenID() {
        return 2;
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
                //send to main menu
                //QPanel nextScreen = new MainMenu("", quizitReference);
                quizitReference.changeScreen(1);
                break;
            case 2:
                //send to create a profile
                //nextScreen = new CreateProfile("", quizitReference);
                quizitReference.changeScreen(3);
                break;
        }
        if (buttonID > 2) {
            quizitReference.setProfile(currentProfile);
        }
    }

    public void paintComponent(Graphics g) {
        //draw background
        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

}

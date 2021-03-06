import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfile extends QPanel implements ActionListener {
    private TransitionButton create;
    private TransitionButton exit;
    private JTextField textField;
    private int imageIndex;
    private String profileName;

    public CreateProfile(String title, Quizit q) {
        super(title, q);
        this.setLayout(null);
        //panel setup
        this.setBackground(this.BACKGROUND_COLOR);

        //create buttons and ui aspects. adds action listeners. then adds to qpanel
        //exit button
        exit = new TransitionButton(this, 50, 25, TITLE_COLOR, "Exit", -1, 5);
        exit.setBounds(30, 30, 100, 30);
        exit.addActionListener(this);
        this.add(exit);

        //text field
        textField = new JTextField();
        textField.setSize(70, 5);
        textField.setBounds(500, 200, 250, 50);
        textField.addActionListener(this);
        this.add(textField);

        //create button
        create = new TransitionButton(this, 50, 25, Color.WHITE, "Create", 4, 1);
        create.setBounds(560, 600, 100, 30);
        create.addActionListener(this);
        this.add(create);
    }

    public int getScreenID() {
        return 3;
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
                //move to options
                profileName = textField.getText();
                Profile createdProfile = new Profile(profileName, imageIndex);
                quizit.addProfile(createdProfile);
                quizit.changeScreen(4);
                break;
            case 2:
                //selects shrek
                imageIndex = 1;
                break;
            case 3:
                //selects fiona
                imageIndex = 2;
                break;
            case 4:
                //selects donkey
                imageIndex = 3;
                break;
            case 5:
                //exit button
                quizit.changeScreen(1);
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(TITLE_COLOR);
        //font bigger???
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Create Profile", 530, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

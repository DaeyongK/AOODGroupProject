import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends QPanel implements ActionListener {
    private TransitionButton select;
    private TransitionButton create;
    private TransitionButton importBtn;
    private TransitionButton export;
    private TransitionButton detach;
    private EstablisherButton profile;
    private TransitionButton changeProfile;
    private TransitionButton options;
    private TransitionButton exit;
    private JLabel titleCard;
    private JPanel containsButtons;
    private QPanel menu;
    private int currentQID = 0;
    private boolean popupBool;
    private Quizit theQuizit;

    public MainMenu(String title, Quizit q) {
        super(title, q);
        this.setLayout(new BorderLayout(60,40));
        //for use outside the constructor
        menu = this;
        theQuizit = q;
        //the jpanel for the center of the screen
        containsButtons = new JPanel();
        containsButtons.setBackground(QPanel.TITLE_COLOR);
        containsButtons.setLayout(new BoxLayout(containsButtons,BoxLayout.Y_AXIS));
        //title name/title card
        titleCard = new JLabel(title);
        containsButtons.add(titleCard);
        //select domain
        select = new TransitionButton(this, 75, 25, Color.WHITE, "Select Domain", 5, 11){
            {
                setSize(500,100);
                setMaximumSize(getSize());
            }
        };
        select.addActionListener(this);
        containsButtons.add(select);
        select.setAlignmentX(CENTER_ALIGNMENT);
        //create domain
        create = new TransitionButton(this, 75, 25, Color.WHITE, "Create Domain", 8, 12){
            {
                setSize(500,100);
                setMaximumSize(getSize());
            }
        };
        create.addActionListener(this);
        containsButtons.add(create);
        create.setAlignmentX(CENTER_ALIGNMENT);
        //import domain
        importBtn = new TransitionButton(this, 75, 25, Color.WHITE, "Import Domain", 7, 13){
            {
                setSize(500,100);
                setMaximumSize(getSize());
            }
        };
        importBtn.addActionListener(this);
        containsButtons.add(importBtn);
        importBtn.setAlignmentX(CENTER_ALIGNMENT);
        //export domain
        export = new TransitionButton(this, 75, 25, Color.WHITE, "Export Domain", 9, 14){
            {
                setSize(500,100);
                setMaximumSize(getSize());
            }
        };
        export.addActionListener(this);
        containsButtons.add(export);
        export.setAlignmentX(CENTER_ALIGNMENT);
        //detach domain
        detach = new TransitionButton(this, 75, 25, Color.WHITE, "Detach Domain", 10, 15){
            {
                setSize(500,100);
                setMaximumSize(getSize());
            }
        };
        detach.addActionListener(this);
        containsButtons.add(detach);
        detach.setAlignmentX(CENTER_ALIGNMENT);
        //resize, and add everything to the center panel
        JPanel filler = new JPanel();
        filler.setBackground(this.BACKGROUND_COLOR);
        JPanel filler2 = new JPanel();
        filler2.setBackground(this.BACKGROUND_COLOR);
        this.add(filler, BorderLayout.LINE_START);
        this.add(filler2, BorderLayout.LINE_END);
        this.add(containsButtons, BorderLayout.CENTER);

        //open profile popup button
        profile = new EstablisherButton(this, 75, 25, Color.WHITE, q.getProfile().getName(), 21);
        profile.addActionListener(this);
        this.add(profile, BorderLayout.PAGE_START);
        //change profile (in popup)
        changeProfile = new TransitionButton(this, 75, 25, Color.WHITE, "Change Profile", 2, 22);
        //quizzing options (in popup)
        options = new TransitionButton(this, 75, 25, Color.WHITE, "Quizzing Options", 4, 23);
        //exit application button
        exit = new TransitionButton(this, 50, 25, Color.WHITE, "Exit", 1, 16);
        exit.addActionListener(e -> System.exit(0));
        this.add(exit,BorderLayout.PAGE_END);
        
    }

    public int getScreenID() {
        return 1;
    }

    public boolean popup(String text) {
        JPanel pop = new JPanel();
        pop.setLayout(new BoxLayout(pop, BoxLayout.Y_AXIS));
        pop.setBackground(QPanel.TITLE_COLOR);
        JLabel profileName = new JLabel(text);
        pop.add(profileName);
        //add buttons to the popup; changeProfile is true, options is false
        changeProfile.addActionListener(e -> popupBool = true);
        pop.add(changeProfile);
        options.addActionListener(e -> popupBool = false);
        pop.add(options);
        //add the popup to the menu
        menu.add(pop, BorderLayout.LINE_END);
        menu.revalidate();
        menu.repaint();
        return popupBool;
    }

    public void buttonClicked(int buttonID) {
    	switch (buttonID) {
            case 11:
                //go to select domain (5)
                if(theQuizit.getProfile().getDomains().size()==0)
                    quizit.changeScreen(8);
                else
                    quizit.changeScreen(5);
                break;
            case 12:
                //go to create domain (8)
                quizit.changeScreen(8);
                break;
            case 13:
                //go to import domain (7)
                quizit.changeScreen(7);
                break;
            case 14:
                //go to export domain (9)
                quizit.changeScreen(9);
                break;
            case 15:
                //go to detach domain (10)
                quizit.changeScreen(10);
                break;
            case 16:
                //exit the application
            	System.exit(0);
                break;
            case 21:
                popup(quizit.getProfile().getName())
                break;
            case 22:
                //go to change profile (2)
                quizit.changeScreen(2);
                break;
            case 23:
                //go to quizzing options (4)
                quizit.changeScreen(4);
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        //empty??
    }
}

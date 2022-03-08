import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Quizit {
    private Profile currentProfile;
    private Question currentQuestion;
    private Domain currentDomain;
    private ArrayList<Profile> profiles = new ArrayList<>();
    private MainMenu screen1;
    private SelectProfile screen2;
    private CreateProfile screen3;
    private Options screen4;
    private SelectDomain screen5;
    private QuestionCard screen6;
    private ImportScreen screen7;
    private EditDomain screen8;
    private ExportDomain screen9;
    private DetachDomain screen10;
    private QuestionScreen screen11, screen12;
    private JFrame frame;

    Quizit() {
        currentProfile = new Profile("Default", 1);
        profiles.add(currentProfile);
        File[] profilexmls = new File("Profiles").listFiles();
        for (File file : profilexmls) {
            profiles.add(new Profile(file, this));
        }
        setDomain(currentProfile.getDomains().get(0));
        setQuestion(currentDomain.getQuestion(0));
        System.out.println("yee");
        screen1 = new MainMenu("", this);
        screen2 = new SelectProfile("Select Profile", this);
        screen3 = new CreateProfile("Create Profile", this);
        screen4 = new Options("Quizzing Options", this);
        screen5 = new SelectDomain("Select Domain", this);
        screen6 = new QuestionCard("", this);
        screen7 = new ImportScreen("Import Domain", this);
        screen8 = new EditDomain("Edit Domain", this);
        screen9 = new ExportDomain("Export Domain", this);
        screen10 = new DetachDomain("Detach Domain", this);
        screen11 = new QuestionScreen("Create Question", this);
        screen12 = new QuestionScreen("Edit Question", this);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Quizit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(screen1);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setVisible(true);
        
    }

    public Profile getProfile() {
        return currentProfile;
    }

    public void setProfile(Profile profile) {
        currentProfile = profile;
    }

    public ArrayList<Profile> getAllProfiles() {
        return profiles;
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public Question getQuestion() {
        return currentQuestion;
    }

    public void setQuestion(Question question) {
        currentQuestion = question;
    }

    public Domain getDomain() {
        return currentDomain;
    }

    public void setDomain(Domain domain) {
        currentDomain = domain;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void changeScreen(int screenID) {
        switch (screenID) {
            case 1:
                screen1 = new MainMenu("", this);
                frame.setContentPane(screen1);
                break;
            case 2:
                screen2 = new SelectProfile("Select Profile", this);
                frame.setContentPane(screen2);
                break;

            case 3:
                screen3 = new CreateProfile("Create Profile", this);
                frame.setContentPane(screen3);
                break;

            case 4:
                screen4 = new Options("Quizzing Options", this);
                frame.setContentPane(screen4);
                break;

            case 5:
                screen5 = new SelectDomain("Select Domain", this);
                frame.setContentPane(screen5);
                break;

            case 6:
                screen6 = new QuestionCard("", this);
                frame.setContentPane(screen6);
                break;

            case 7:
                screen7 = new ImportScreen("Import Domain", this);
                frame.setContentPane(screen7);
                break;

            case 8:
                screen8 = new EditDomain("Edit Domain", this);
                frame.setContentPane(screen8);
                break;

            case 9:
                screen9 = new ExportDomain("Export Domain", this);
                frame.setContentPane(screen9);
                break;

            case 10:
                screen10 = new DetachDomain("Detach Domain", this);
                frame.setContentPane(screen10);
                break;

            case 11:
                screen11 = new QuestionScreen("Create Question", this);
                frame.setContentPane(screen11);
                break;

            case 12:
                screen12 = new QuestionScreen("Edit Question", this);
                frame.setContentPane(screen12);
                break;
                
        }
        JPanel pane = (JPanel) frame.getContentPane();
        pane.revalidate();
        pane.repaint();
        frame.repaint();
    }
}

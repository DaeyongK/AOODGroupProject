import javax.swing.*;
import java.io.File;
import java.util.*;
public class Quizit {
    private Profile currentProfile;
    private Question currentQuestion;
    private Domain currentDomain;
    private ArrayList<Profile> profiles = new ArrayList<Profile>();
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
        File[] profilexmls = new File("CCProject/Profiles").listFiles();
        for(File file : profilexmls) {
            profiles.add(new Profile(file));
        }
        currentProfile = profiles.get(0);
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
        screen11 = new QuestionScreen("Create Question");
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
    public void changeScreen(int screenID) {
        switch(screenID) {
            case 1:
                screen1 = new MainMenu("", this);
                frame.setContentPane(screen1);
            case 2:
                screen2 = new SelectProfile("Select Profile", this);
                frame.setContentPane(screen2);
            case 3:
                screen3 = new CreateProfile("Create Profile", this);
                frame.setContentPane(screen3);
            case 4:
                screen4 = new Options("Quizzing Options", this);
                frame.setContentPane(screen4);
            case 5:
                screen5 = new SelectDomain("Select Domain", this);
                frame.setContentPane(screen5);
            case 6:
                screen6 = new QuestionCard("", this);
                frame.setContentPane(screen6);
            case 7:
                screen7 = new ImportScreen("Import Domain", this);
                frame.setContentPane(screen7);
            case 8:
                screen8 = new EditDomain("Edit Domain", this);
                frame.setContentPane(screen8);
            case 9:
                screen9 = new ExportDomain("Export Domain", this);
                frame.setContentPane(screen9);
            case 10:
                screen10 = new DetachDomain("Detach Domain", this);
                frame.setContentPane(screen10);
            case 11:
                screen11 = new QuestionScreen("Create Question");
                frame.setContentPane(screen11);
            case 12:
                screen12 = new QuestionScreen("Edit Question", this);
                frame.setContentPane(screen12);
        }
    }
}

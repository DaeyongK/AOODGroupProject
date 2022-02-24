import javax.swing.*;
import java.awt.*;
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
    private SelectDomains screen5;
    private QuestionCard screen6;
    private ImportScreen screen7;
    private EditDomain screen8;
    private ExportDomain screen9;
    private DetachDomain screen10;
    private QuestionScreen screen11, screen12;
    Quizit() {
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
        frame = new JFrame("Quizit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

}

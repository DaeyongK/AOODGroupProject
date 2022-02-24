import javax.swing.*;
import java.awt.*;
public class Quizit {
    private Profile currentProfile;
    private Question currentQuestion;
    private Domain currentDomain;
    private Profile[] allProfiles;
    private
    Quizit() {
        MainMenu screen1 = new MainMenu("Main Menu");
        SelectProfile screen2 = new SelectProfile("Select Profile");
        CreateProfile screen3 = new CreateProfile("Create Profile");
        Options screen4 = new Options("Quizzing Options");
        SelectDomain screen5 = new SelectDomain("Select Domain");
        QuestionCard screen6 = new QuestionCard("Question Card");
        ImportScreen screen7 = new ImportScreen("Import Domain");
        EditDomain screen8 = new EditDomain("Edit Domain");
        ExportDomain screen9 = new ExportDomain("Export Domain");
        DetachDomain screen10 = new DetachDomain("Detach Domain");
        CreateQuestion screen11 = new CreateQuestion("Create Question");
        EditQuestion screen12 = new EditQuestion("Edit Question");
        frame = new JFrame("Quizit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

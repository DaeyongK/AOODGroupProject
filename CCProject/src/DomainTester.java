import java.io.File;
import java.util.ArrayList;


public class DomainTester {
    public static void main(String[] args) {
        Quizit quiz = new Quizit();
        Question q1 = new Question("Opposite of red", "blue", "QuestionGraphics/mathPic.jpg", quiz);
        Question q2 = new Question("red and yellow makes", "orange", quiz);
        Question q3 = new Question("blue and yellow makes", "green", quiz);
        Question q4 = new Question("purple is?", "red+blue", quiz);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        Domain n = new Domain("Simple Colors", questions);
        for (int i = 0; i < n.getDomainSize(); i++) {
            System.out.println(n.getQuestion(i).getGraphicPath());
            System.out.println(n.getQuestion(i).getQuestion());
            System.out.println(n.getQuestion(i).getAnswer() + "\n");
        }
        System.out.println(n.export().toString());
//        Domain n1 = new Domain(new File("Domains/test.xml"), quiz);
//        System.out.println(n1.getDomainName());
//        System.out.println(n1.getDomainSize());
//        for (int i = 0; i < n1.getDomainSize(); i++) {
//            System.out.println(n1.getQuestion(i).getQuestion());
//            System.out.println(n1.getQuestion(i).getAnswer());
//            System.out.println(n1.getQuestion(i).getGraphicPath());
//        }
    }
}

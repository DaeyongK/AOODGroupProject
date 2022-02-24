import java.io.File;
import java.util.*;


public class DomainTester {
	public static void main(String args[]) {
		Question q1= new Question("1+1?", "2", "QuestionGraphics/mathPic.jpg");
		Question q2= new Question("1+2?", "3");
		Question q3= new Question("1+3?", "4");
		Question q4= new Question("1+4?", "5");
		Question q5= new Question("1+5?", "6");
		Question q6= new Question("1+6?", "7");
		Question q7= new Question("1+7?", "8");
		Question q8= new Question("1+8?", "9");
		Question q9= new Question("1+9?", "10");
		Question q10= new Question("1+10?", "11");
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
		questions.add(q6);
		questions.add(q7);
		questions.add(q8);
		questions.add(q9);
		questions.add(q10);
		Domain n = new Domain("Simple Math", questions);
		for(int i=0; i<n.getDomainSize(); i++) {
			System.out.println(n.getQuestion(i).getGraphicPath());
			System.out.println(n.getQuestion(i).getQuestion());
			System.out.println(n.getQuestion(i).getAnswer()+"\n");
		}
		System.out.println(n.export().toString());
		Domain n1 = new Domain(new File("Domains/test.xml"));
		System.out.println(n1.getDomainName());
		System.out.println(n1.getDomainSize());
		for(int i=0; i<n1.getDomainSize(); i++) {
			System.out.println(n1.questions.get(i).getQuestion());
		}
	}
}

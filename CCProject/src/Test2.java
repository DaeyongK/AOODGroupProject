import javax.swing.JFrame;

public class Test2 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Quizit qRef = new Quizit();
//		CreateProfile test = new CreateProfile("Test Create Profile", qRef);
        Testit t = new Testit();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Options test = new Options("Options Test Screen", t);
        frame.setContentPane(test);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setVisible(true);
	}

}

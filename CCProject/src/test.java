import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
public class test {
	public static void main(String[] args) {
		Testit t = new Testit();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImportScreen test= new ImportScreen("Test Domain", t);
		frame.setContentPane(test);
		frame.pack();
		frame.setSize(1280, 720);
		frame.setVisible(true);
	}
}
class Testit extends Quizit{
	Testit(){
		ArrayList<Question> thing = new ArrayList<Question>();
		setProfile(new Profile(null, this));
		addProfile(getProfile());
		setDomain(new Domain("uwu", thing));
		getProfile().addDomain(new Domain("yes", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));
		getProfile().addDomain(new Domain("no", thing));



	}
}
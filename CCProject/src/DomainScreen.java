import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class DomainScreen extends QPanel{
	protected ArrayList<EstablisherButton> domainButtons;
	protected TransitionButton exit;
	protected ArrayList<Domain> domains;
	DomainScreen(String input, Quizit quizit){
		/*
		button ids:
		exit = -1
		domain buttons = index in allDomains
		 */
		super(input, quizit);
		System.out.print(popup("yeah"));

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		domains = quizit.getProfile().getDomains();
		domainButtons = new ArrayList<EstablisherButton>();
		for(int i = 0; i< domains.size();i++) {
			domainButtons.add(new EstablisherButton(this, 800, 50,Color.white,domains.get(i).getDomainName(),i));
		}
		if(domainButtons!=null) {
			for(EstablisherButton button : domainButtons) {
				add(button);
				button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			}
		}
		
		JScrollPane scroll = new JScrollPane(this);
		scroll.setSize(500,500);
		exit = new TransitionButton(this, 100, 50, TITLE_COLOR, "Exit", 1, -1);
		
		exit.setBounds(50, 50, 50, 50);
		add(exit);

	}



	public String getName() {
		return title; 
	}
	public abstract void buttonClicked(int buttonID);

	private void radioClick() {

	}
	public void paintComponent(Graphics g) {
	}
	public static void main(String[] args) {
		Testit t = new Testit();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DomainScreenTester test= new DomainScreenTester("Test Domain", t);
		frame.setContentPane(test);
		frame.pack();
		frame.setSize(1280, 720);
		frame.setVisible(true);
		int result = JOptionPane.showConfirmDialog(frame, "hi");
		switch (result) {
		case JOptionPane.YES_OPTION:
			System.out.print("hi");
			
		case JOptionPane.NO_OPTION:
			System.out.print("hi");
			
		case JOptionPane.CANCEL_OPTION:
			System.out.println("Cancel");
			break;
		case JOptionPane.CLOSED_OPTION:
			System.out.println("Closed");
			break;
		}
		System.out.print("hi");
	}
}
class Testit extends Quizit{
	Testit(){
		ArrayList<Question> thing = new ArrayList<Question>();
		setProfile(new Profile(null, this));
		addProfile(getProfile());
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
class DomainScreenTester extends DomainScreen{

	DomainScreenTester(String input, Quizit quizit) {
		super(input,quizit);
	}
	

	@Override
	public void buttonClicked(int buttonID) {
		// TODO Auto-generated method stub
		System.out.println(buttonID);
	}

	@Override
	public int getScreenID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}

}

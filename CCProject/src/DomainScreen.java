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
		domain buttons = index in all domains
		 */
		super(input, quizit);
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		Quizit gimmeDomains = new Quizit();
		domains = gimmeDomains.getProfile().getDomains();
		for(int i = 0; i< domains.size();i++) {
			domainButtons.add(new EstablisherButton(this, 800, 50,Color.white,domains.get(i).getDomainName(),i));
		}
		if(domainButtons!=null) {
			for(EstablisherButton button : domainButtons) {
				pane.add(button);
				button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			}
		}
		
		JScrollPane scroll = new JScrollPane(pane);
		add(scroll);
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
		g.drawString(title, 300, 50);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DomainScreenTester test= new DomainScreenTester("Test Domain", new Quizit());
		frame.setContentPane(test);
		frame.pack();
		frame.setSize(1280, 720);
		frame.setVisible(true);
	}
}
class DomainScreenTester extends DomainScreen{

	DomainScreenTester(String input, Quizit quizit) {
		super(input,quizit);
	}

	@Override
	public void buttonClicked(int buttonID) {
		// TODO Auto-generated method stub

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

import java.awt.*;
import java.util.*;
import javax.swing.*;
public abstract class DomainScreen extends QPanel{
	protected ArrayList<EstablisherButton> domainButtons;
	protected TransitionButton exit;
	DomainScreen(String input, Profile profile){
		super(input);
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

		ArrayList<Domain> domains = profile.getDomains();
		for(int i = 0; i< domains.size();i++) {
			domainButtons.add(new EstablisherButton(800, 50,Color.white,domains.get(i).getDomainName(),i));
		}
	
		for(EstablisherButton button : domainButtons) {
			pane.add(button);
			button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		}
		JScrollPane scroll = new JScrollPane(pane);
		add(scroll);
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
		
	}
}
class DomainScreenTester extends DomainScreen{

	DomainTester(String input, Profile profile) {
		super(input, profile);
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

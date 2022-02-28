import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelectProfile extends QPanel implements MouseListener{
	private JScrollPane scrollable;
	private ArrayList<Profile> profiles;
	private TransitionButton done;
	private TransitionButton createNewProfileButton;
	private JPanel panel;
	private Profile currentProfile;
	private Quizit quizitReference;
	
	SelectProfile(String title, Quizit q){
		super(title, q);
		quizitReference = q;
		profiles = q.getAllProfiles();
		//panel setup
		panel = new JPanel();
		panel.setBackground(QPanel.TITLE_COLOR);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.
		//scroll pane???
		scrollable = new JScrollPane();
		//insert code needed to add in profiles
		//create profile button inside the jscrollpane somehow???
		createNewProfileButton = new TransitionButton(this, 75, 35, Color.WHITE, "Create New Profile", 3, 2);
		panel.add(createNewProfileButton);
		panel.addMouseListener(this);
		scrollable.addMouseListener(this);
		panel.add(scrollable);
		//done button
		done = new TransitionButton(this, 50, 25, Color.WHITE, "Done", 1, 1);
		panel.add(done);
	}
	
	public void radioClick() {
		
	}
	
	public int getScreenID(){
		return 2;
	}

	@Override
	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buttonClicked(int buttonID) {
		// TODO Auto-generated method stub
		switch(buttonID){
			case 1:
				//send to main menu
				//QPanel nextScreen = new MainMenu("", quizitReference);
				quizitReference.changeScreen(1);
				break;
			case 2:
				//send to create a profile
				//nextScreen = new CreateProfile("", quizitReference);
				quizitReference.changeScreen(3);
		    	break;
		}
		if(buttonID > 2) {
			quizitReference.setProfile(currentProfile);
		}
	}
	
	public void paintComponent(Graphics g) {
		//draw background
		super.paintComponent(g);
		//draw title
		g.setColor(TITLE_COLOR);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

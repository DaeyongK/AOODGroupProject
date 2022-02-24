import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelectProfile extends QPanel implements ActionListener{
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
		panel = new JPanel();
		profiles = new ArrayList<Profile>();
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.
		//scroll pane
		scrollable = new JScrollPane();
		scrollable.addMouseListener(this);
		panel.add(scrollable);
		//done button
		done = new TransitionButton(this, 50, 25, Color.WHITE, "Done", 1, 1);
		done.addActionListener(this);
		panel.add(done);
		//create profile button
		createNewProfileButton = new TransitionButton(this, 75, 35, Color.WHITE, "Create New Profile", 3, 2);
		createNewProfileButton.addActionListener(this);
		panel.add(createNewProfileButton);
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
				QPanel nextScreen = new MainMenu("", quizitReference);
				break;
			case 2:
				//send to create a profile
				nextScreen = new CreateProfile("", quizitReference);
		    	break;
		}
		if(buttonID > 2) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		//draw background
		super.paintComponent(g);
		//draw title
		g.setColor(TITLE_COLOR);
		
	}
	
	public void actionPerformed(ActionEvent e){
		//when done button is clicked
		//when profile is clicked
		//when create a new profile is clicked
		//when mouse hovers over buttons/profiles
	}

}

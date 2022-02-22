import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelectProfile extends QPanel implements ActionListener{
	private JScrollPane scrollable;
	private ArrayList<Profile> profiles;
	private TransitionButton done;
	private TransitionButton createNewProfileButton;
	
	SelectProfile(String title){
		//creating buttons and ui aspects. specify parameters
		scrollable = new JScrollPane();
		profiles = new ArrayList<Profile>();
		done = new TransitionButton(int width, int height, Color color, "Done", 1, int buttonID);
		createNewProfileButton = new TransitionButton(int width, int height, Color color, "Create New Profile", 3, int buttonID);
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
		super(buttonID);
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

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends QPanel implements ActionListener{
	private TransitionButton select;
	private TransitionButton create;
	private TransitionButton importBtn;
	private TransitionButton export;
	private TransitionButton detach;
	private EstablisherButton profile;
	private TransitionButton changeProfile;
	private TransitionButton options;
	private TransitionButton exit;

	public MainMenu(String title){
		super(title);
		//select domain
		select = new TransitionButton(width, height, Color.WHITE, “Select Domain”, 5, 11);
		select.addActionListener(this);
		this.add(select);
		//create domain
		create = new TransitionButton(w, h, Color.WHITE, “Create Domain”, 9, 12);
		create.addActionListener(this);
		this.add(create);
		//import domain
		importBtn = new TransitionButton(w, h, Color.WHITE, “Import Domain”, 8, 13);
		importBtn.addActionListener(this);
		this.add(import);
		//export domain
		export = new TransitionButton(w, h, Color.WHITE, “Export Domain”, 10, 14);
		export.addActionListener(this);
		this.add(export);
		//detach domain
		detach = new TransitionButton(w, h, Color.WHITE, “Detach Domain”, 11, 15);
		detach.addActionListener(this);
		this.add(detach);
		//open profile popup
		profile = new EstablishedButton(w, h, c, “Profile”, 1, 21);
		profile.addActionListener(this);
		//change profile (in popup)
		changeProfile = new TransitionButton(w, h, Color.WHITE, “Change Profile”, 2, 22);
		changeProfile.addActionListener(this);
		//quizzing options (in profile)
		options = new TransitionButton(w, h, Color.WHITE, “Quizzing Options”, 4, 23);
		options.addActionListener(this);
		//exit application button
		exit = new TransitionButton(w, h, c, “Exit”, ID(???), 16); //just full on exit the screen??
		exit.addActionListener(this);
		this.add(exit);

		//NOTE: make exit smaller than other buttons (same height, shorter width)
	}

	public int getScreenID(){
		return 1;
	}
	public boolean popup(String text){
		//change profile is true, quizzing options is false
	}
	public void buttonClicked(int buttonID){
		switch(buttonID){
			case 11:
			//go to select domain (5)
			break;
			case 12:
			//go to create domain (9)
			break;
			case 13:
			//go to import domain (8)
			break;
			case 14:
			//go to export domain (10)
			break;
			case 15:
			//go to detach domain (11)
			case 16:
			//exit the application
			break;
			case 21:
			popup(Profile.getName());
			break;
			case 22:
			//go to change profile (2)
			break;
			case 23:
			//go to quizzing options (4)
			break;
		}
	}
	
	public void actionPerformed(ActionEvent e){
		//empty??
	}
}

import java.awt.*;
import javax.swing.*;

public class MainMenu extends QPanel{
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
				this.add(select);
				//create domain
				create = new TransitionButton(w, h, Color.WHITE, “Create Domain”, 9, 12);
				this.add(create);
				//import domain
				importBtn = new TransitionButton(w, h, Color.WHITE, “Import Domain”, 8, 13);
				this.add(import);
				//export domain
				export = new TransitionButton(w, h, Color.WHITE, “Export Domain”, 10, 14);
				this.add(export);
				//detach domain
				detach = new TransitionButton(w, h, Color.WHITE, “Detach Domain”, 11, 15);
				this.add(detach);
				//open profile popup
				profile = new EstablishedButton(w, h, c, “Profile”, 1, 21);
				//change profile (in popup)
				changeProfile = new TransitionButton(w, h, Color.WHITE, “Change Profile”, 2, 22);
				//quizzing options (in profile)
				options = new TransitionButton(w, h, Color.WHITE, “Quizzing Options”, 4, 23);
				//exit application button
				exit = new TransitionButton(w, h, c, “Exit”, ID(???), 16); //just full on exit the screen??
				this.add(exit);

				//NOTE: make exit smaller than other buttons (same height, shorter width)
	}

	public int getScreenID(){
		return 1;
	}
	public boolean popup(String text){
		//for the profile popup
	}
	public void buttonClicked(int buttonID){
		switch(buttonID){
		///////////////////////////////
		}
	}
}

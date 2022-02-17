import java.util.ArrayList;

public class SelectProfile extends QPanel{
	private JScrollPane scrollable;
	private ArrayList<Profile> profiles;
	private TransitionButton done;
	private EstablisherButton create;
	
	SelectProfile(String title){
		//creating buttons and ui aspects. specify parameters
		scrollable = new JScrollPane();
		profiles = new ArrayList<Profile>();
		done = new TransitionButton(int width, int height, Color color, String text, int screenID, int buttonID);
		create = new EstablisherButton(int width, int height, Color color, String text, int screenID, int buttonID);
	}
	
	private radioClick() {
		
	}

}

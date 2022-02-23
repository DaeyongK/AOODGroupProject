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
	private JLabel titleCard;
	private JPanel containsButtons;
	private QPanel menu;
	private int currentQID = 0;

	public MainMenu(String title){
		super(title);
		this.setLayout(new BorderLayout());
		//the jpanel for the center of the screen
		containsButtons = new JPanel();
		//title name/title card
		titleCard = new JLabel(title);
		containsButtons.add(titleCard);
		//select domain
		select = new TransitionButton(75, 25, Color.WHITE, “Select Domain”, 5, 11);
		select.addActionListener(this);
		containsButtons.add(select);
		//create domain
		create = new TransitionButton(75, 25, Color.WHITE, “Create Domain”, 9, 12);
		create.addActionListener(this);
		containsButtons.add(create);
		//import domain
		importBtn = new TransitionButton(75, 25, Color.WHITE, “Import Domain”, 8, 13);
		importBtn.addActionListener(this);
		containsButtons.add(import);
		//export domain
		export = new TransitionButton(75, 25, Color.WHITE, “Export Domain”, 10, 14);
		export.addActionListener(this);
		containsButtons.add(export);
		//detach domain
		detach = new TransitionButton(75, 25, Color.WHITE, “Detach Domain”, 11, 15);
		detach.addActionListener(this);
		containsButtons.add(detach);
		//add everything to the center panel
		this.add(containsButtons, BorderLayout.CENTER);
		
		//open profile popup button
		profile = new EstablishedButton(75, 25, Color.WHITE, Profile.getName(), 21);
		profile.addActionListener(this);
		this.add(profile, BorderLayout.PAGE_START);
		//change profile (in popup)
		changeProfile = new TransitionButton(75, 25, Color.WHITE, “Change Profile”, 2, 22);
		//quizzing options (in popup)
		options = new TransitionButton(75, 25, Color.WHITE, “Quizzing Options”, 4, 23);
		//exit application button
		exit = new TransitionButton(50, 25, Color.WHITE, “Exit”, 1, 16);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		this.add(exit);
		
		//for use outside the constructor
		menu = this;
	}

	public int getScreenID(){
		return 1;
	}
	public boolean popup(String text){
		JPanel pop = new JPanel(new BoxLayout(BoxLayout.Y_AXIS);
		JLabel profileName = new JLabel(text);
		pop.add(profileName);
		//add buttons to the popup; changeProfile is true, options is false
		changeProfile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				return true;
			}
		});
		pop.add(changeProfile);
		options.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				return false;
			}
		});
		pop.add(options);
		//add the popup to the menu
		menu.add(pop, BorderLayout.LINE_END);
	}
	public void buttonClicked(int buttonID){
		QPanel nextScreen = menu;
		switch(buttonID){
			case 11:
				//go to select domain (5)
				nextScreen = new SelectDomain("");
				break;
			case 12:
				//go to create domain (9)
				nextScreen = new CreateDomain("");
				break;
			case 13:
				//go to import domain (8)
				nextScreen = new ImportDomain("");
				break;
			case 14:
				//go to export domain (10)
				nextScreen = new ExportDomain("");
				break;
			case 15:
				//go to detach domain (11)
				nextScreen = new DetachDomain("");
				break;
			case 16:
				//exit the application
				break;
			case 21:
				if(popup(Profile.getName())){
					//go to change profile (2)
					nextScreen = new ChangeProfile("");
				} else{
					//go to quizzing options (4)
					nextScreen = new QuizzingOptions("");
				}
				break;
		}
	}
	
	public void actionPerformed(ActionEvent e){
		//empty??
	}
}

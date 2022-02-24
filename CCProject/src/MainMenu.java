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
	private Quizit theQuizit;

	public MainMenu(String title, Quizit q){
		super(title);
		theQuizit = q;
		this.setLayout(new BorderLayout());
		//the jpanel for the center of the screen
		containsButtons = new JPanel();
		containsButtons.setBackground(QPanel.TITLE_COLOR);
		//title name/title card
		titleCard = new JLabel(title);
		containsButtons.add(titleCard);
		//select domain
		select = new TransitionButton(this,75, 25, Color.WHITE, “Select Domain”, 5, 11);
		select.addActionListener(this);
		containsButtons.add(select);
		//create domain
		create = new TransitionButton(this,75, 25, Color.WHITE, “Create Domain”, 8, 12);
		create.addActionListener(this);
		containsButtons.add(create);
		//import domain
		importBtn = new TransitionButton(this,75, 25, Color.WHITE, “Import Domain”, 7, 13);
		importBtn.addActionListener(this);
		containsButtons.add(import);
		//export domain
		export = new TransitionButton(this,75, 25, Color.WHITE, “Export Domain”, 9, 14);
		export.addActionListener(this);
		containsButtons.add(export);
		//detach domain
		detach = new TransitionButton(this,75, 25, Color.WHITE, “Detach Domain”, 10, 15);
		detach.addActionListener(this);
		containsButtons.add(detach);
		//add everything to the center panel
		this.add(containsButtons, BorderLayout.CENTER);
		
		//open profile popup button
		profile = new EstablishedButton(this,75, 25, Color.WHITE, Profile.getName(), 21);
		profile.addActionListener(this);
		this.add(profile, BorderLayout.PAGE_START);
		//change profile (in popup)
		changeProfile = new TransitionButton(this,75, 25, Color.WHITE, “Change Profile”, 2, 22);
		//quizzing options (in popup)
		options = new TransitionButton(this,75, 25, Color.WHITE, “Quizzing Options”, 4, 23);
		//exit application button
		exit = new TransitionButton(this,50, 25, Color.WHITE, “Exit”, 1, 16);
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
		pop.setBackground(QPanel.TITLE_COLOR);
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
		switch(buttonID){
			case 11:
				//go to select domain (5)
				theQuizit.changeScreen(5);
				break;
			case 12:
				//go to create domain (8)
				theQuizit.changeScreen(8);
				break;
			case 13:
				//go to import domain (7)
				theQuizit.changeScreen(7);
				break;
			case 14:
				//go to export domain (9)
				theQuizit.changeScreen(9);
				break;
			case 15:
				//go to detach domain (10)
				theQuizit.changeScreen(10);
				break;
			case 16:
				//exit the application
				break;
			case 21:
				if(popup(Profile.getName())){
					//go to change profile (2)
					theQuizit.changeScreen(2);
				} else{
					//go to quizzing options (4)
					theQuizit.changeScreen(4);
				}
				break;
		}
	}
	
	public void actionPerformed(ActionEvent e){
		//empty??
	}
}

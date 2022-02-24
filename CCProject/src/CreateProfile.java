import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CreateProfile extends QPanel implements ActionListener{
	private TransitionButton done;
	private TransitionButton create;
	private TransitionButton exit;
	private CircularButton shrek;
	private CircularButton fiona;
	private CircularButton donkey;
	private JPanel panel;
	
	public CreateProfile(String title){
		super(title);
		panel = new JPanel();
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.
		//exit button
		exit = new TransitionButton(50, 25, TITLE_COLOR, "Exit", -1, int buttonID);
		exit.addActionListener(this);
		panel.addComponant(exit);
		//create button
		create = new TransitionButton(50, 25, Color.WHITE, "Create", 4, int buttonID);
		create.addActionListener(this);
		panel.addComponant(create);
		//shrek pfp
		shrek = new CircularButton();
		shrek.addActionListener(this);
		panel.addComponant(shrek);
		//fiona pfp
		fiona = new CircularButton();
		fiona.addActionListener(this);
		panel.addComponant(fiona);
		//donkey pfp
		donkey = new CircuarButton();
		donkey.addActionListener(this);
		panel.addComponant(donkey);
		//setup
		super(title);
		this.setLayout(new BorderLayout());
	}
	
	public void radioClick() {
		
	}
	
	public int getScreenID(){
		return 3;
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
		case -1:
			//exit app
			break;
		case 4:
			//send to options
	    	break;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(TITLE_COLOR);
	}
	
	public void actionPerformed(ActionEvent e){
		//when exit is pressed
		//when create is pressed
		//when textbox is pressed
		//when pfp1 is clicked
		//when pfp2 is cicked
		//when pfp3 is clicked
	}

}

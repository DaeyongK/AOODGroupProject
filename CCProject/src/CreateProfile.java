import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateProfile extends QPanel implements ActionListener{
	private TransitionButton done;
	private TransitionButton create;
	private TransitionButton exit;
	private CircularButton shrek;
	private CircularButton fiona;
	private CircularButton donkey;
	private JTextField textField;
	private JPanel panel;
	
	public CreateProfile(String title, Quizit q){
		super(title, q);
		panel = new JPanel();
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.
		//exit button
		exit = new TransitionButton(this, 50, 25, TITLE_COLOR, "Exit", -1, 5);
		exit.addActionListener(this);
		panel.add(exit);
		//text field
		textField = new JTextField();
		textField.addActionListener(this);
		panel.add(textField);
		//create button
		create = new TransitionButton(this, 50, 25, Color.WHITE, "Create", 4, 1);
		create.addActionListener(this);
		panel.add(create);
		//shrek pfp
		shrek = new CircularButton();
		shrek.addActionListener(this);
		panel.add(shrek);
		//fiona pfp
		fiona = new CircularButton();
		fiona.addActionListener(this);
		panel.add(fiona);
		//donkey pfp
		donkey = new CircularButton();
		donkey.addActionListener(this);
		panel.add(donkey);
		//setup
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
		case 1:
			//exit app
			break;
		case 5:
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
		//when pfp2 is clicked
		//when pfp3 is clicked
	}

}

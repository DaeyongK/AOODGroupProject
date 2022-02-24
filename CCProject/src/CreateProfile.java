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
	private Quizit quizitReference;
	private int imageIndex;
	private String profileName;
	
	public CreateProfile(String title, Quizit q){
		super(title, q);
		quizitReference = q;
		panel = new JPanel();
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.
		//exit button
		exit = new TransitionButton(this, 50, 25, TITLE_COLOR, "Exit", -1, 5);
		exit.addActionListener(this);
		panel.add(exit);
		//text field
		textField = new JTextField();
		textField.setSize(70, 5);
		textField.addActionListener(this);
		panel.add(textField);
		//create button
		create = new TransitionButton(this, 50, 25, Color.WHITE, "Create", 4, 1);
		create.addActionListener(this);
		panel.add(create);
		//shrek pfp
		shrek = new CircularButton(this, 50, 50, Color.WHITE, title, 2, null);
		shrek.addActionListener(this);
		panel.add(shrek);
		//fiona pfp
		fiona = new CircularButton(this, 50, 50, Color.WHITE, title, 3, null);
		fiona.addActionListener(this);
		panel.add(fiona);
		//donkey pfp
		donkey = new CircularButton(this, 50, 50, Color.WHITE, title, 4, null);
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
			//move to options
			Profile createdProfile = new Profile("", imageIndex);
			QPanel nextScreen = new Options("", quizitReference);
			break;
		case 2:
			//selects shrek
			imageIndex = 1;
			break;
		case 3:
			//selects fiona
			imageIndex = 2;
			break;
		case 4:
			//selects donkey
			imageIndex = 3;
			break;
		case 5:
			//exit button
			nextScreen = new MainMenu("", quizitReference);
	    	break;
		}
	}
	
	public void actionPerformed(ActionEvent e){
		String string1 = textField.getText();
		profileName = string1;
	}

}

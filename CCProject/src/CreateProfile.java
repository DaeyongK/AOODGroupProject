import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateProfile extends QPanel implements MouseListener{
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
		
		//panel setup
		panel = new JPanel();
		panel.setBackground(QPanel.TITLE_COLOR);
		panel.addMouseListener(this);
		GridBagConstraints c = new GridBagConstraints();
		
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.
		//exit button
		exit = new TransitionButton(this, 50, 25, TITLE_COLOR, "Exit", -1, 5);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(exit, c);
		
		//text field
		textField = new JTextField();
		textField.setSize(70, 5);
		c.anchor = GridBagConstraints.PAGE_START;
		panel.add(textField, c);
		
		//shrek pfp
		File shrekFile = new File("shrek.jpeg");
		Image shrekImage = null;
		try {
			shrekImage = ImageIO.read(shrekFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage shrekPFP = (BufferedImage) shrekImage;
		shrek = new CircularButton(this, 50, 50, Color.WHITE, title, 2, shrekPFP);
		c.anchor = GridBagConstraints.LINE_START;
		panel.add(shrek, c);
		
		//fiona pfp
		File fionaFile = new File("fiona.jpeg");
		Image fionaImage = null;
		try {
			fionaImage = ImageIO.read(fionaFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage fionaPFP = (BufferedImage) fionaImage;
		fiona = new CircularButton(this, 50, 50, Color.WHITE, title, 3, fionaPFP);
		c.anchor = GridBagConstraints.CENTER;
		panel.add(fiona, c);
		
		//donkey pfp
		File donkeyFile = new File("donkey.jpeg");
		Image donkeyImage = null;
		try {
			donkeyImage = ImageIO.read(donkeyFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage donkeyPFP = (BufferedImage) donkeyImage;
		donkey = new CircularButton(this, 50, 50, Color.WHITE, title, 4, donkeyPFP);
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(donkey, c);
		
		//create button
		create = new TransitionButton(this, 50, 25, Color.WHITE, "Create", 4, 1);
		c.anchor = GridBagConstraints.PAGE_END;
		panel.add(create, c);
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
			Profile createdProfile = new Profile(profileName, imageIndex);
			quizitReference.addProfile(createdProfile);
			quizitReference.changeScreen(4);
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
			quizitReference.changeScreen(1);
	    	break;
		}
	}
	
	public void actionPerformed(ActionEvent e){
		String string1 = textField.getText();
		profileName = string1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

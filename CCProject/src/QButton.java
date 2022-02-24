import javax.swing.*;
import java.awt.*;
//Abner Ben
abstract class QButton extends JButton{
	final Color BACKGROUND_COLOR = new Color(32,18,77);//purple
	final Color TITLE_COLOR = new Color(240,193,67);//yellow
	private int buttonId;
	QButton(QPanel Panel,int width, int height, Color color, String text, int buttonID){
		Panel.buttonClicked(buttonID);
		JButton b = new JButton(text);  
		b.setBounds(50,50,width,height);
		b.setBackground(TITLE_COLOR);
		buttonId = buttonID;
	}
	public abstract void mousePressed();	
	public abstract void mouseOver();
}

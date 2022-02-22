import javax.swing.*;
import java.awt.*;
//Abner Ben
public class TransitionButton extends QButton{
	private int screenId;
	TransitionButton(int width, int height, Color color, String text, int screenID, int buttonID){
		super(width,height,color,text,buttonID);
		JButton b = new JButton("text");  
		b.setBounds(50,50,width,height);
		b.setBackground(TITLE_COLOR);
		screenId = screenID;
	}
	public void mousePressed() {
		QPanel b = new QPanel() {};
		b.buttonClicked(3);
	}
	public void mouseOver() {
	}
}

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
//Abner Ben
public class TransitionButton extends QButton{
	private QPanel panel;
	private Color Color;
	private int buttonId;
	private int Width;
	private int Height;
	private String Text;
	private int screenId;
	TransitionButton(QPanel Panel,int width, int height, Color color, String text, int screenID, int buttonID){
		super(Panel,width,height,color,text,buttonID);
		JButton b = new JButton(text);  
		b.setBounds(50,50,width,height);
		b.setBackground(color);
		screenId = screenID;
		buttonId=buttonID;
		Color=color;
		panel=Panel;
		Text=text;
		Width=width;
		Height=height;
	}
	public void mousePressed() {
		addMouseMotionListener(new MouseInputAdapter() {
			public void MousePressed(MouseEvent e) {
				EstablisherButton button = new EstablisherButton(panel,Width,Height,TITLE_COLOR,Text,buttonId);
				panel.buttonClicked(buttonId);
			}
		});
	}
	public void mouseOver() {
		addMouseMotionListener(new MouseInputAdapter() {
			public void MouseOver(MouseEvent e) {
				
			}
		});
	}
}

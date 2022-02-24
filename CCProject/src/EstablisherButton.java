import javax.swing.*;

import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import java.awt.event.ActionListener;
//Abner Ben
public class EstablisherButton extends QButton{
	private QPanel panel;
	private Color Color;
	private int buttonId;
	private int Width;
	private int Height;
	private String Text;
	EstablisherButton(QPanel Panel,int width, int height, Color color, String text, int buttonID){
		super(Panel,width,height,color,text,buttonID);
		JButton b = new JButton(text);  
		b.setBounds(50,50,width,height);
		b.setBackground(color);
		buttonId=buttonID;
		Color=color;
		panel=Panel;
		Text=text;
		Width=width;
		Height=height;
	}
	public int getButtonID(){
		return buttonId;
	}
	public void mousePressed() {
		public void actionPerformed(ActionEvent event) {
				EstablisherButton button = new EstablisherButton(panel,Width,Height,TITLE_COLOR,Text,buttonId);
				panel.buttonClicked(buttonId);
			
		}
	}
	public void mouseOver() {
		EstablisherButton button = new EstablisherButton(panel,Width,Height,Color,Text,buttonId);
		addMouseMotionListener(new MouseInputAdapter() {
			public void MouseOver(MouseEvent e) {
				
			}
		});
	}

}

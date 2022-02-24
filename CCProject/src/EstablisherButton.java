import javax.swing.*;

import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import java.awt.event.ActionListener;
//Abner Ben
public class EstablisherButton extends QButton implements ActionListener {
	private QPanel panel;
	private Color Color;
	private int buttonId;
	private int Width;
	private int Height;
	private String Text;
	EstablisherButton(QPanel Panel,int width, int height, Color color, String text, int buttonID){
		super(Panel,width,height,color,text,buttonID);
		addActionListener(this);
	}
	public int getButtonID(){
		return buttonId;
	}
	public void actionPerformed(ActionEvent event) {
		panel.buttonClicked(buttonId);
	}
	public void mouseOver() {
		EstablisherButton button = new EstablisherButton(panel,Width,Height,Color,Text,buttonId);
		addMouseMotionListener(new MouseInputAdapter() {
			public void MouseEnter(MouseEvent e) {
				
			}
		});
	}

}

import javax.swing.*;

import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import java.awt.event.ActionListener;
//Abner Ben
public class EstablisherButton extends QButton{
	private int buttonId;
	EstablisherButton(QPanel Panel,int width, int height, Color color, String text, int buttonID){
		super(Panel,width,height,color,text,buttonID);
	}
	public int getButtonID(){
		return buttonId;
	}
	public void mouseOver() {
		addMouseMotionListener(new MouseInputAdapter() {
			public void MouseEnter(MouseEvent e) {
				
			}
		});
	}

}

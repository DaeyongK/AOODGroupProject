import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Abner Ben
public class TransitionButton extends QButton {
	private int buttonId;
	private int screenId;
	TransitionButton(QPanel Panel,int width, int height, Color color, String text, int screenID, int buttonID){
		super(Panel,width,height,color,text,buttonID); 
		addActionListener(this);
		screenId = screenID;
	}
	public int getButtonID(){
		return buttonId;
	}
	public int getScreenID(){
		return screenId;
	}
	public void mouseOver() {
		addMouseMotionListener(new MouseInputAdapter() {
			public void MouseEnter(MouseEvent e) {
				
			}
		});
	}
}

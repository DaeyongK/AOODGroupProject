import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
//Abner Ben
public class EstablisherButton extends QButton{
	private int buttonId;
	EstablisherButton(int width, int height, Color color, String text, int buttonID){
		super(width,height,color,text,buttonID);
		JButton b = new JButton(text);  
		b.setBounds(50,50,width,height);
		b.setBackground(TITLE_COLOR);
		buttonId=buttonID;
	}
	public void mousePressed() {
		addMouseMotionListener(new MouseInputAdapter() {
			public void MousePressed(MouseEvent e) {
				
			}
		});
	}
	public void mouseOver() {
		addMouseMotionListener(new MouseInputAdapter() {
			public void MouseEnter(MouseEvent e) {
				
			}
		});
	}

}

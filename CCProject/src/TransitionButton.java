import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Abner Ben
public class TransitionButton extends QButton implements ActionListener{
	private QPanel panel;
	private Color Color;
	private int buttonId;
	private int Width;
	private int Height;
	private String Text;
	private int screenId;
	TransitionButton(QPanel Panel,int width, int height, Color color, String text, int screenID, int buttonID){
		super(Panel,width,height,color,text,buttonID); 
		addActionListener(this);
		screenId = screenID;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panel.buttonClicked(buttonId);
	}
	public void mouseOver() {
		addMouseMotionListener(new MouseInputAdapter() {
			public void MouseOver(MouseEvent e) {
				
			}
		});
	}
}

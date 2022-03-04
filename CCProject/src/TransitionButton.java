import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;

//Abner Ben
public class TransitionButton extends QButton {
	private int buttonId;
	private int screenId;
	TransitionButton(QPanel Panel,int width, int height, Color color, String text, int screenID, int buttonID){
		super(Panel,width,height,color,text,buttonID); 
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

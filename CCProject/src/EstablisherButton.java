import javax.swing.*;
import java.awt.*;
//Abner Ben
public class EstablisherButton extends QButton{
	EstablisherButton(int width, int height, Color color, String text, int screenID, int buttonID){
		super(width,height,color,text,buttonID);
		JButton b=new JButton("text");  
		b.setBounds(50,50,width,height);
		b.setBackground(TITLE_COLOR);
		
	}
	public void mousePressed() {
		
	}
	public void mouseOver() {
	}

}

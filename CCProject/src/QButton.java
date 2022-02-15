import javax.swing.*;
import java.awt.*;
abstract class QButton extends JButton{
	final Color BACKGROUND_COLOR= new Color(32,18,77);//purple
	final Color TITLE_COLOR= new Color(240,193,67);//yellow
	private int buttonID;
	QButton(int width, int height, Color color, String text, int buttonID){
		
	}
	public abstract void mousePressed();	
	public abstract void mouseOver();
}

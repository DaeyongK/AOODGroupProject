import javax.swing.*;
import java.awt.*;
//Abner Ben
abstract class QButton extends JButton{
	final Color BACKGROUND_COLOR = new Color(32,18,77);//purple
	final Color TITLE_COLOR = new Color(240,193,67);//yellow
	private int buttonId;
	private QPanel panel;
	private Color Color;
	private int Width;
	private int Height;
	private String Text;
	QButton(QPanel Panel,int width, int height, Color color, String text, int buttonID){
		setText(text);
		setBounds(50,50,width,height);
		setBackground(color);
		buttonId = buttonID;
		Color=color;
		panel=Panel;
		Text=text;
		Width=width;
		Height=height;
	}	
	public abstract void mouseOver();
}

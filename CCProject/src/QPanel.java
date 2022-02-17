import java.awt.*;
import javax.swing.*;

public abstract class QPanel extends JPanel {
	public final Color BACKGROUND_COLOR = new Color(32,18,77);
	public final Color TITLE_COLOR = new Color(240,193,67);
	public final Font font = new Font(Font.SANS_SERIF,Font.PLAIN,20);
	String title;
	int id = 0; //id of the current profile?? dunno where that’s stored??

	public QPanel(String t){
		title = t;
		this.setBackground(BACKGROUND_COLOR);
	}

	public abstract int getScreenID();
	public abstract boolean popup(String text);
	public abstract void buttonClicked(int buttonID);
}

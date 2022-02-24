import java.awt.*;
import javax.swing.*;

public abstract class QPanel extends JPanel {
	public final Color BACKGROUND_COLOR = new Color(32,18,77);
	public static final Color TITLE_COLOR = new Color(240,193,67);
	public final Font font = new Font(Font.SANS_SERIF,Font.PLAIN,20);
	protected String title;
	protected int id = 0;
	protected Quizit quizit;

	QPanel(String t, Quizit quizit){
		title = t;
		this.setBackground(BACKGROUND_COLOR);
		this.quizit = quizit;
	}

	public abstract int getScreenID();
	public abstract boolean popup(String text);
	public abstract void buttonClicked(int buttonID);
}

//QuestionScreen is front-end class made by Kai C.

import java.awt.*;
import javax.swing.*;

public class QuestionScreen extends QPanel {
	private String title;
	private int id = 0;

	QuestionScreen(String t) {
		super(t);
	}
	public int getScreenID() {
		return id;
	}
	public boolean popup(String text) {
		
	}
	public void buttonClicked(int buttonID) {
		
	}
	public static void main(String[] arg) {
		new QuestionScreen("QuestionScreen Test");
	}
}

import java.awt.*;

public abstract class DomainScreen extends QPanel{
	DomainScreen(String input){
		super(input);
	}
	public String getName() {
		return title; 
	}
	public abstract void buttonClicked(int buttonID);
		
	private void radioClick() {
		
	}
	public void paintComponent(Graphics g) {
		g.drawString(title, 300, 50);
	}
}

import java.io.File;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList; //Allows me to use ArrayLists.
public class ExportDomain extends QPanel implements ActionListener {
	private JScrollPane domains;
	private JPanel insideScroll; //JPanel to be scrolled
	ArrayList<Domain> dList = new ArrayList<Domain>(); //Daeyong pls give me access to domain arraylist uwu
	ArrayList<EstablisherButton> buttons = new ArrayList<EstablisherButton>();
	public ExportDomain(String t) {
		super(t);
		domains = new JScrollPane();
		domains.setPreferredSize(new Dimension(900,300));
		domains.setLayout(new ScrollPaneLayout());
		
		insideScroll = new JPanel();
		insideScroll.setLayout(new BoxLayout(insideScroll,BoxLayout.Y_AXIS));
		
		for(int i = 0; i < dList.size(); i++) { //Creates all the domain buttons, need domain arraylist
			buttons.add(new EstablisherButton(850, 25, Color.WHITE, dList.get(i).toString(), 40*i+30));
			insideScroll.add(buttons.get(i));
			buttons.get(i).setActionCommand(i + "");
			buttons.get(i).addActionListener(this);
		}
	}

	public int getScreenID() {
		return 10;
	}

	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	public void buttonClicked(int buttonID) {
		File exported = dList.get(buttonID).export(); //where do you want the file to be stored?
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventName = e.getActionCommand();
		buttonClicked(Integer.parseInt(eventName));
	}

}

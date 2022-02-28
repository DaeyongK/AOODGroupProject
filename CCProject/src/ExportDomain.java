import java.io.File;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ExportDomain extends QPanel implements ActionListener {
	private JScrollPane domains;
	private JPanel insideScroll;
	private Quizit q;
	ArrayList<Domain> dList = new ArrayList<Domain>(); //Daeyong pls give me access to domain arraylist uwu
	ArrayList<EstablisherButton> buttons = new ArrayList<EstablisherButton>();
	public ExportDomain(String t, Quizit q) {
		super(t, q);
		this.q = q;
		domains = new JScrollPane();
		domains.setPreferredSize(new Dimension(900,300));
		domains.setLayout(new ScrollPaneLayout());
		
		insideScroll = new JPanel();
		insideScroll.setLayout(new BoxLayout(insideScroll,BoxLayout.Y_AXIS));
		
		for(int i = 0; i < dList.size(); i++) { //replace 3 with all domains within a profile
			buttons.add(new EstablisherButton(this, 850, 25, Color.WHITE, dList.get(i).toString(), 9));
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
		q.changeScreen(1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventName = e.getActionCommand();
		buttonClicked(Integer.parseInt(eventName));
	}

}

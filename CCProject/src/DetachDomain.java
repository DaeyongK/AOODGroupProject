import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DetachDomain extends DomainScreen{

	DetachDomain(String t, Quizit quizit) {
		super(t, quizit);
		exit = new TransitionButton(100, 50, TITLE_COLOR, "Exit", -1, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getScreenID() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public boolean popup(String text) {
		int result = JOptionPane.showConfirmDialog(this, text);
		switch (result) {
		case JOptionPane.YES_OPTION:
			return true;
			
		case JOptionPane.NO_OPTION:
			return false;
			
		case JOptionPane.CANCEL_OPTION:
			System.out.println("Cancel");
			break;
		case JOptionPane.CLOSED_OPTION:
			System.out.println("Closed");
			break;
		}
		return false;
	}

	@Override
	public void buttonClicked(int buttonID) {
		if(buttonID != -1 ) {
			if(popup("Are you sure?")) {
				ArrayList<Domain> domains = quizit.getProfile.getDomains();
				quizit.getProfile.detachDomain(domains.get(buttonID));
			}
		}else {
			quizit.changeScreen(1);
		}

	}

}

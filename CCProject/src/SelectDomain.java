import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class SelectDomain extends DomainScreen implements MouseListener{
	private boolean dClick = false;
	private EstablisherButton launch, edit,delete;
	SelectDomain(String input, Quizit quizit) {
		super(input, quizit); 
		exit = new TransitionButton(this, 100, 50, TITLE_COLOR, "Exit", 1, -1);
		launch = new EstablisherButton(this, 100, 50, Color.WHITE, "Launch", -2);
		edit = new EstablisherButton(this, 100, 50, Color.WHITE, "Edit", -3);
		delete = new EstablisherButton(this, 100, 50, Color.WHITE, "Delete", -4);
		launch.setEnabled(false);
		edit.setEnabled(false);
		delete.setEnabled(false);
		add(launch);
		add(edit);
		add(delete);
	}

	@Override
	public void buttonClicked(int buttonID) {
		if(buttonID == -1) {
			return;
		}
		if(buttonID <0) {
			if(buttonID == -2) {
				quizit.setDomain(domains.get(buttonID));
				quizit.changeScreen(6);
			}
			if(buttonID == -3) {
				quizit.setDomain(domains.get(buttonID));
				quizit.changeScreen(8);
			}
			if(buttonID == -4) {
				if(popup("Are you sure?")) {
					quizit.getProfile().getDomains();
					quizit.getProfile().detachDomain(domains.get(buttonID));
				}
			}
		}
		if(dClick) {
			quizit.setDomain(domains.get(buttonID));
			quizit.changeScreen(6);
		}else {
			launch.setEnabled(true);
			edit.setEnabled(true);
			delete.setEnabled(true);
			launch.setBounds(700,domainButtons.get(buttonID).getY(),100,50);
			edit.setBounds(825,domainButtons.get(buttonID).getY(),100,50);
			delete.setBounds(950,domainButtons.get(buttonID).getY(),100,50);

		}

	}

	@Override
	public int getScreenID() {
		return 5;
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
	public void mouseClicked(MouseEvent event)
	{
		dClick = event.getClickCount() == 2 && event.getButton() == MouseEvent.BUTTON1;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

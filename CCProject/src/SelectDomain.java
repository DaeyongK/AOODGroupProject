import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SelectDomain extends DomainScreen implements MouseListener, ChangeListener {
	private boolean dClick = false;
	private EstablisherButton launch;
	private EstablisherButton edit;
	private EstablisherButton delete;
	private int domainSelected;
	private boolean first;

	private JLayeredPane anotherLayeredPane;

	SelectDomain(String input, Quizit quizit) {
		super(input, quizit);
		repaint();
		first = true;
		exit = new TransitionButton(this, 100, 50, TITLE_COLOR, "Exit", 1, -1);
		launch = new EstablisherButton(this, 100, 50, Color.WHITE, "Launch", -2);
		edit = new EstablisherButton(this, 100, 50, Color.WHITE, "Edit", -3);
		delete = new EstablisherButton(this, 100, 50, Color.WHITE, "Detach", -4);
		anotherLayeredPane = new JLayeredPane();
		anotherLayeredPane.setLayout(null);
		anotherLayeredPane.add(scroll, 1);
		pane.setBounds(150, 150, 900, 400);
		for (EstablisherButton button : domainButtons) {
			button.addMouseListener(this);

		}
		add(anotherLayeredPane);
		anotherLayeredPane.setBounds(0, 0, 1280, 720);
		scroll.getViewport().addChangeListener(this);

		JPanel top = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(BACKGROUND_COLOR);

				g.fillRect(0, 0, 400, 151);
			}
		};

		anotherLayeredPane.add(top, 30, 0);
		top.setBounds(700, 0, 400, 155);
		JPanel bot = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(BACKGROUND_COLOR);

				g.fillRect(0, 0, 400, 151);
			}
		};
		anotherLayeredPane.add(bot, 30, 0);
		bot.setBounds(700, 550, 400, 500);
	}

	@Override
	public void buttonClicked(int buttonID) {
		if (first) {
			anotherLayeredPane.add(launch, 20, 0);
			anotherLayeredPane.add(edit, 20, 0);
			anotherLayeredPane.add(delete, 20, 0);
			first = false;
		}

		if (buttonID == -1) {
			quizit.changeScreen(1);
			return;
		} else if (buttonID < 0) {
			if (buttonID == -2) {
				quizit.setDomain(domains.get(domainSelected));
				quizit.changeScreen(6);

			}
			if (buttonID == -3) {
				quizit.setDomain(domains.get(domainSelected));
				quizit.changeScreen(8);
			}
			if (buttonID == -4) {
				if (popup("Are you sure?")) {
					quizit.getProfile().detachDomain(domains.get(domainSelected));
					pane.remove(domainButtons.get(domainSelected));

					domainButtons.remove(domainSelected);
					repaint();
					quizit.changeScreen(5);
				}
			}
		} else if(!dClick) {
			if (quizit.getProfile().getDomains().get(buttonID).getQuestions().size() == 0)
				launch.setEnabled(false);
			else
				launch.setEnabled(true);

			domainSelected = buttonID;
			edit.setEnabled(true);
			delete.setEnabled(true);

			//int y =(int)SwingUtilities.convertPoint(domainButtons.get(buttonID), domainButtons.get(buttonID).getX(), domainButtons.get(buttonID).getY(), this).getY();
			int y = domainButtons.get(buttonID).getY() + 152;


			launch.setBounds(700, y - ((int) scroll.getViewport().getViewPosition().getY()), 100, 50);
			edit.setBounds(810, y - ((int) scroll.getViewport().getViewPosition().getY()), 100, 50);
			delete.setBounds(920, y - ((int) scroll.getViewport().getViewPosition().getY()), 100, 50);

		}
		repaint();

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

		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		dClick = (event.getClickCount() == 2 && event.getButton() == MouseEvent.BUTTON1);
		if (dClick) {
			if (quizit.getProfile().getDomains().get(domainSelected).getQuestions().size() == 0) {

			} else {

				quizit.setDomain(domains.get(domainSelected));
				quizit.changeScreen(6);

			}
			dClick = false;

		}
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

	@Override
	public void stateChanged(ChangeEvent e) {
		try {
			int y = domainButtons.get(domainSelected).getY() + 152;

			launch.setBounds(700, y - ((int) scroll.getViewport().getViewPosition().getY()), 100, 50);
			edit.setBounds(810, y - ((int) scroll.getViewport().getViewPosition().getY()), 100, 50);
			delete.setBounds(920, y - ((int) scroll.getViewport().getViewPosition().getY()), 100, 50);
		}catch(Exception auodh) {

		}
	}

}

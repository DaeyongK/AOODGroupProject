import javax.swing.*;
import java.util.ArrayList;

public class DetachDomain extends DomainScreen {

    DetachDomain(String t, Quizit quizit) {
        super(t, quizit);
        exit = new TransitionButton(this, 100, 50, TITLE_COLOR, "Exit", -1, 1);
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
    	repaint();
        if (buttonID != -1) {
            if (popup("Are you sure?")) {
                ArrayList<Domain> domains = quizit.getProfile().getDomains();
                pane.remove(titleLabel);
                quizit.getProfile().detachDomain(domains.get(buttonID));
            }
        } else {
            quizit.changeScreen(1);
        }

    }

}

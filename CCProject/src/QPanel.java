import javax.swing.*;
import java.awt.*;

public abstract class QPanel extends JPanel {
    public final Color BACKGROUND_COLOR = new Color(32, 18, 77);
    public static final Color TITLE_COLOR = new Color(240, 193, 67);
    public final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
    protected String title;
    protected int id = 0;
    protected Quizit quizit;
    protected JLabel titleLabel;

    QPanel(String t, Quizit quizit) {
    	title = t;
        titleLabel = new JLabel(title);
        titleLabel.setLocation(600, 30);
        titleLabel.setForeground(TITLE_COLOR);
        setBackground(BACKGROUND_COLOR);
        add(titleLabel);
        this.quizit = quizit;
    }

    public abstract int getScreenID();

    public boolean popup(String text) {
        int result = JOptionPane.showConfirmDialog(quizit.getFrame(), text);
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

    public abstract void buttonClicked(int buttonID);
}

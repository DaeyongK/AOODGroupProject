import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class DomainScreen extends QPanel {
    protected ArrayList<EstablisherButton> domainButtons;
    protected TransitionButton exit;
    protected ArrayList<Domain> domains;
    protected JLayeredPane pane;
    protected JScrollPane scroll;

    DomainScreen(String input, Quizit quizit) {
		/*
		button ids:
		exit = -1
		domain buttons = index in allDomains
		 */
        super(input, quizit);


        setOpaque(true);
        setLayout(null);

        domains = quizit.getProfile().getDomains();
        domainButtons = new ArrayList<>();
        for (int i = 0; i < domains.size(); i++) {
            String name = domains.get(i).getDomainName();
            if (domains.get(i).getDomainName().length() > 30) {
                name = name.substring(0, 30) + "...";
            }
            domainButtons.add(new EstablisherButton(this, 800, 50, Color.white, name, i));
        }
        pane = new JLayeredPane();
        scroll = new JScrollPane(pane);
        add(scroll);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        if (domainButtons != null) {
            for (int i = 0; i < domainButtons.size(); i++) {
                if (domainButtons.size() < 7) {
                    pane.setLayout(new GridLayout(7, 1));

                } else {
                    pane.setLayout(new GridLayout(domainButtons.size(), 1));

                }
                EstablisherButton button = domainButtons.get(i);

                pane.add(button, 1, 0);
                button.setPreferredSize(new Dimension(800, 50));


            }
        }
        scroll.setBounds(150, 150, 900, 400);
        exit = new TransitionButton(this, 100, 50, TITLE_COLOR, "Exit", 1, -1);
        exit.setBounds(50, 50, 80, 50);

        titleLabel.setBounds(400, 50, 400, 100);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        add(exit);
        repaint();

    }


    public String getName() {
        return title;
    }

    public abstract void buttonClicked(int buttonID);

    private void radioClick() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public static void main(String[] args) {
        Quizit t = new Quizit();
    }
}


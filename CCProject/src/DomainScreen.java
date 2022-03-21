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
        
//		System.out.print(popup("yeah"));
        setOpaque(true);
        setLayout(null);
        System.out.print(quizit.getProfile().getDomains().size());

        domains = quizit.getProfile().getDomains();
        domainButtons = new ArrayList<>();
        for (int i = 0; i < domains.size(); i++) {
            domainButtons.add(new EstablisherButton(this, 800, 50, Color.white, domains.get(i).getDomainName(), i));
        }
        pane = new JLayeredPane();
        scroll = new JScrollPane(pane);
//        scroll.setSize(500, 500);
        add(scroll);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        if (domainButtons != null) {
            for (int i =0; i<domainButtons.size(); i++) {
//       		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
            	if(domainButtons.size()<7) {
            		pane.setLayout(new GridLayout(7, 1));

            	}else {
            		pane.setLayout(new GridLayout(domainButtons.size(), 1));

            	}
            	EstablisherButton button = domainButtons.get(i);

            	pane.add(button, 1,0);
        		button.setPreferredSize(new Dimension(800, 50));

            	//pane.setLayout(null);
//        		button.setBounds(20,80*i+20,360,50);
//            	pane.add(button);
            }
        }
        scroll.setBounds(150,150,900,400);
        exit = new TransitionButton(this, 100, 50, TITLE_COLOR, "Exit", 1, -1);
        exit.setBounds(50,50,80,50);
//       	EstablisherButton button = new EstablisherButton(this, 1280, 720, BACKGROUND_COLOR, "", -99);
//       	button.setBounds(0, 0, 1280, 720);
//       	add(button);
//       	button.setVisible(false);
        titleLabel.setBounds(400,50,400,100);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        add(exit);
        repaint();
//        

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
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        DetachDomain test = new DetachDomain("Detach Domain", t);
//        frame.setContentPane(test);
//        frame.pack();
//        frame.setSize(1280, 720);
//        frame.setVisible(true);

    }
}

class Testit extends Quizit {
    Testit() {
        ArrayList<Question> thing = new ArrayList<>();
        setProfile(new Profile(null, this));
        addProfile(getProfile());
        getProfile().addDomain(new Domain("yes", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));


    }
}

class DomainScreenTester extends DomainScreen {

    DomainScreenTester(String input, Quizit quizit) {
        super(input, quizit);
    }


    @Override
    public void buttonClicked(int buttonID) {
        // TODO Auto-generated method stub
        System.out.println(buttonID);
    }

    @Override
    public int getScreenID() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean popup(String text) {
        // TODO Auto-generated method stub
        return false;
    }

}

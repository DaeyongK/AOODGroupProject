import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

public class ExportDomain extends DomainScreen implements ActionListener {
    private JScrollPane domains;
    private JPanel insideScroll;
    ArrayList<EstablisherButton> buttons = new ArrayList<>();

    public ExportDomain(String t, Quizit q) {
        super(t, q);
        domains = new JScrollPane();
        domains.setPreferredSize(new Dimension(900, 300));
        domains.setLayout(new ScrollPaneLayout());

        insideScroll = new JPanel();
        insideScroll.setLayout(new BoxLayout(insideScroll, BoxLayout.Y_AXIS));

        for (int i = 0; i < quizit.getProfile().getDomains().size(); i++) { //replace 3 with all domains within a profile
            buttons.add(new EstablisherButton(this, 850, 25, Color.WHITE, quizit.getProfile().getDomains().get(i).toString(), 9));
            insideScroll.add(buttons.get(i));
            buttons.get(i).setActionCommand(i + "");
            buttons.get(i).addActionListener(this);
            System.out.println("working");
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
        File exported = quizit.getProfile().getDomains().get(buttonID).export(); //where do you want the file to be stored?
        String path = test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath;
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
	        decodedPath =decodedPath.substring(0, decodedPath.substring(0,decodedPath.lastIndexOf("/")).lastIndexOf("/"));
//	        File f = new File(decodedPath + "/Domains");
//	        f.createNewFile();
		} catch (Exception e) {}
        quizit.changeScreen(1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventName = e.getActionCommand();
        buttonClicked(Integer.parseInt(eventName));
    }

}

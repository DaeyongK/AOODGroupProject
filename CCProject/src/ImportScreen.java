import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class ImportScreen extends QPanel implements ActionListener {
    private TransitionButton done;
    private TransitionButton back;
    private EstablisherButton chooseFile;
    private File selectedFile;
    private JLabel fileName = new JLabel("");
    private JFileChooser jfc;

    ImportScreen(String title, Quizit q) {
    	super(title, q);
        int width = 150;
        int height = 50;

        back = new TransitionButton(this, width, height, Color.WHITE, "Back", 7, 0);
        back.setBounds(20, 20, width, height);
        back.setActionCommand("back");
        add(back);

        done = new TransitionButton(this, width, height, Color.WHITE, "Done", 7, 1);
        done.setBounds(600, 600, width, height);
        done.setActionCommand("done");
        add(done);
        done.setVisible(false);

        chooseFile = new EstablisherButton(this, width, height, Color.WHITE, "Choose File", 2);
        chooseFile.setBounds(480, 560, width, height);
        chooseFile.setActionCommand("choose");
        add(chooseFile);

        fileName.setBounds(600, 560, 100, 40);
    }

    public int getScreenID() {
        return 7;
    }

    public boolean popup(String text) {
        return true;
    }

    public void buttonClicked(int buttonID) {
        System.out.println(buttonID);
        switch (buttonID) {
            case 0:
                quizit.changeScreen(1);
                break;
            case 1:
                quizit.getProfile().addDomain(new Domain(selectedFile, quizit));
                quizit.changeScreen(1);
                break;
            //send to main menu and parse selectedFile into a domain
            case 2:
                jfc = new JFileChooser();

                //only show xml files by default
                //wont stop user from just changing it to be all files so accept() is still needed
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
                jfc.setFileFilter(filter);

                int returnValue = jfc.showOpenDialog(null);
                // int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = jfc.getSelectedFile();
                    if (accept(selectedFile)) {
                        done.setVisible(true);
                        fileName = new JLabel(selectedFile.toString());
                    }

                }
                break;
        }
    }

    private boolean accept(File f) {
        String name = f.toString();
        fileName = new JLabel(name);
        int index = name.lastIndexOf('.');
        if (index > 0) {
            String extension = name.substring(index + 1);
            return extension.equals("xml");
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        int id;
        switch (e.getActionCommand()) {
            case "done":
                id = 1;
                break;
            case "choose":
                id = 2;
                break;
            default:
                id = 0;
                break;
        }
        buttonClicked(id);
    }
}
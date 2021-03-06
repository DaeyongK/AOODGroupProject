import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class ImportScreen extends QPanel implements ActionListener {
    public static void main(String[] args) {
        Quizit q = new Quizit();
    }

    private TransitionButton done;
    private TransitionButton back;
    private EstablisherButton chooseFile;
    private File selectedFile;
    private JLabel fileName;
    private JFileChooser jfc;

    ImportScreen(String title, Quizit q) {
        super(title, q);

        setLayout(null);
        setBackground(BACKGROUND_COLOR);
        int width = 150;
        int height = 40;

        titleLabel = new JLabel(title);
        titleLabel.setBounds(550, 86, 700, 32);

        fileName = new JLabel("");
        fileName.setBounds(666, 500, 250, 40);
        fileName.setForeground(Color.WHITE);

        chooseFile = new EstablisherButton(this, width, height, Color.WHITE, "Choose File", 2);
        done = new TransitionButton(this, width, height, Color.WHITE, "Done", 8, 1);
        back = new TransitionButton(this, width, height, Color.WHITE, "Back", 8, -1);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(TITLE_COLOR);
        chooseFile.setBounds(440, 500, width, height);
        back.setBounds(86, 80, width, height);
        done.setBounds(550, 580, width, height);
        done.setVisible(false);

        add(fileName);
        add(titleLabel);
        add(chooseFile);
        add(done);
        add(back);
    }

    public int getScreenID() {
        return 7;
    }

    public boolean popup(String text) {
        return true;
    }

    public void buttonClicked(int buttonID) {
        switch (buttonID) {
            case -1:
                quizit.changeScreen(1);
                break;
            case 1:
                Domain tempDomain = new Domain(selectedFile, quizit);
                quizit.getProfile().addDomain(tempDomain); //domain not adding, premature end of file error
                for (Question question : tempDomain.getQuestions()) {
                    quizit.getProfile().addQuestion(question.getID(), new int[]{0, 0});
                }
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
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = jfc.getSelectedFile();
                    if (accept(selectedFile)) {
                        done.setVisible(true);
                        fileName.setText(selectedFile.toString().substring(selectedFile.toString().lastIndexOf("\\") + 1));
                    }

                }
                break;
        }
    }

    private boolean accept(File f) {
        String name = f.toString();
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
                id = -1;
                break;
        }
        buttonClicked(id);
    }
}
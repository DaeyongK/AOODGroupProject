import javax.swing.*;

public class test {
    public static void main(String[] args) {
        Testit t = new Testit();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImportScreen test = new ImportScreen("Import Screen", t);
        frame.setContentPane(test);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setVisible(true);
    }
}
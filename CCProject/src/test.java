import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.io.File;
import javax.swing.*;

public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Testit t = new Testit();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExportDomain test1 = new ExportDomain("Import Screen", t);
        ImportScreen test2 = new ImportScreen("Import Screen", t);

        frame.setContentPane(test1);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setVisible(true);
    }
}
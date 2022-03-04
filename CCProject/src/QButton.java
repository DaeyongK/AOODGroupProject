import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Abner Ben
abstract class QButton extends JButton implements ActionListener {
    final Color BACKGROUND_COLOR = new Color(32, 18, 77);//purple
    final Color TITLE_COLOR = new Color(240, 193, 67);//yellow
    private int buttonId;
    private QPanel panel;
    private int Width;
    private int Height;
    private String Text;

    QButton(QPanel Panel, int width, int height, Color color, String text, int buttonID) {
        setText(text);
        setBackground(color);
        addActionListener(this);
        buttonId = buttonID;
        panel = Panel;
        Text = text;
        Width = width;
        Height = height;
    }

    public void actionPerformed(ActionEvent event) {
        panel.buttonClicked(buttonId);
        EstablisherButton button = new EstablisherButton(panel, Width, Height, TITLE_COLOR, Text, buttonId);
    }

    public abstract void mouseOver();

    public int getButtonID() {
        return buttonId;
    }
}

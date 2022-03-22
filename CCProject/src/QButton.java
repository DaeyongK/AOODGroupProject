import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Abner Ben
abstract class QButton extends JButton implements ActionListener {
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
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(TITLE_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBackground(color);
            }
        });
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

    public int getButtonID() {
        return buttonId;
    }
}

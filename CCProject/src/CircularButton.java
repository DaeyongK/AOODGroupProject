import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CircularButton extends EstablisherButton{
    CircularButton(QPanel Panel, int width, int height, Color color, String text, int buttonID, BufferedImage img) {
        super(Panel, width, height, color, text, buttonID);

        JButton b = new JButton(text);
        b.setBounds(50,50,width,height);
        b.setBackground(color);
        b.setBorder(new RoundedBorder(10)); //how big to make it?
        b.setIcon(new ImageIcon(img));
    }

    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}

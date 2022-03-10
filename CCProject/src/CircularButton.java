import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class CircularButton extends EstablisherButton {
	private BufferedImage bim;
    CircularButton(QPanel Panel, int width, int height, Color color, String text, int buttonID, BufferedImage img) {
        super(Panel, width, height, color, text, buttonID);
        setButtonImage(img);
        setBorder(new RoundedBorder(width)); //how big to make it? 
        Graphics2D g2 = img.createGraphics();
        g2.setClip(new Ellipse2D.Float(20, 400, width, width));
        g2.drawImage(img, 20, 400, width, width, null);
        Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH );
        setContentAreaFilled(false);
        setIcon(new ImageIcon(newimg));
    }
    protected void paintComponent(Graphics g) {
        g.setClip(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));  // set the area that shall be painted
        g.drawImage(bim, 0, 0, getWidth(), getHeight(), null);    // draw the image, if available
        if (getModel().isArmed()) {      // show a slight gray shading when pressing the button
            g.setColor(new Color(127, 127, 127, 80));   // gray with 80 as alpha
            g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        }
        super.paintComponent(g);
    }
    public void setButtonImage(BufferedImage pbim) {
        bim = pbim;
        repaint();
    }
    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
    
}

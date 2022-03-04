import org.w3c.dom.events.MouseEvent;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;

//Abner Ben
public class EstablisherButton extends QButton {
    EstablisherButton(QPanel Panel, int width, int height, Color color, String text, int buttonID) {
        super(Panel, width, height, color, text, buttonID);
    }
    public void mouseOver(EstablisherButton b) {
        addMouseMotionListener(new MouseInputAdapter() {
            public void MouseEnter(MouseEvent e) {
            	b.setBackground(TITLE_COLOR);
            }
            public void mouseExited(MouseEvent evt){
               b.setBackground(null);
            }
        });
    }
}

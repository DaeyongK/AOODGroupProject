import org.w3c.dom.events.MouseEvent;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;

//Abner Ben
public class TransitionButton extends QButton {
    private int screenId;
    TransitionButton(QPanel Panel, int width, int height, Color color, String text, int screenID, int buttonID) {
        super(Panel, width, height, color, text, buttonID);
        screenId = screenID;
    }
    public int getScreenID() {
        return screenId;
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ImportScreen extends QPanel{
  private boolean filePresent = false;
  private TransitionButton done = new TransitionButton(200, 50, Color.WHITE, "Done", 8, 0);
  done.setVisible(false);
  private TransitionButton back = new TransitionButton(200, 50, Color.WHITE, "Back", 8, 1);
  private EstablisherButton chooseFile;
  private String title;
  private QPanel importPain = new QPanel("Import Domain");
  private JLabel fileName;
  ImportScreen(){
    importPain.setLayout(new BoxLayout(importPain, BoxLayout.Y_AXIS));
    importPain.add(new JLabel(title));
  }
  public int getScreenID(){
    return 8; 
  }
	public boolean popup(String text){
    return true;
  }
  public buttonClicked(int buttonID){
    switch(buttonID){
      case 0:
        Domain d = new Domain(file);
        break;
      case 1:
        break;
    }      
  }
  public boolean accept(File f) {
    if (f.isDirectory()) {
        return true;
    }
    private boolean accept(File f){
      String extension = Utils.getExtension(f);
      if (extension != null) {
        if (extension.equals(Utils.xml)) {
          return true;
        } else {
          return false;
        }
      }

      return false;
    }
}
}

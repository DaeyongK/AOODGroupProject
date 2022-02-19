import java.awt.*;
import java.awt.event.*;
import java.io.File;
//Button IDs: Done = 1, Back = 0, chooseFile = 2
import javax.swing.*;
class ImportScreen extends QPanel implements ActionListener{
  private boolean filePresent = false;
  private TransitionButton done;
  private TransitionButton back;
  private EstablisherButton chooseFile;
  private JLabel fileName = new JLabel("");
  ImportScreen(String title){
    super(title);
    int width = 80;
    int height = 40;
    
    back = new TransitionButton(width, height, Color.WHITE, "Back", 8, 0);
    back.setActionCommand("back");
    back.addActionListener(this);
    
    done = new TransitionButton(width, height, Color.WHITE, "Done", 8, 1);
    done.setActionCommand("done");
    done.addActionListener(this);
    done.setVisible(false);
    
    chooseFile = new EstablisherButton(width, height, Color.WHITE, "Choose File", 8, 2);
    chooseFile.setActionCommand("choose");
    chooseFile.addActionListener(this);
  }
  public int getScreenID(){
    return 8; 
  }
	public boolean popup(String text){
    return true;
  }
  public void buttonClicked(int buttonID){
    switch(buttonID){
      case 0:
        //send to main menu
        break;
      case 1:
        break;
        //send to main menu
      case 2:
    	  break;
    }      
  }
  private boolean accept(File f){
      String name = f.toString();
      fileName = new JLabel(name);
      int index = name.lastIndexOf('.');
      if(index > 0) {
        String extension = name.substring(index + 1);
        if(extension.equals("xml")) 
        	return true;
      }
      return false;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		int id = 0;
		switch(e.getActionCommand()) {
			case "done":
				id = 1;
				break;
			case "choose":
				id = 2;
				break;
			case "back":
				id = 0;
				break;
		}
		buttonClicked(id);
	}
}


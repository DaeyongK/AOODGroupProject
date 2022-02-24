import java.awt.*;
import java.awt.event.*;
import java.io.File;
//Button IDs: Done = 1, Back = 0, chooseFile = 2
import javax.swing.*;
class ImportScreen extends QPanel implements ActionListener{
  private TransitionButton done;
  private TransitionButton back;
  private EstablisherButton chooseFile;
  private File selectedFile;
  private JLabel fileName = new JLabel("");
  private JFileChooser jfc;
  ImportScreen(String title, Quizit q){
    super(title);
    int width = 80;
    int height = 40;
    
    back = new TransitionButton(this, width, height, Color.WHITE, "Back", 7, 0);
    back.setBounds(20,20, width, height);
    back.setActionCommand("back");
    back.addActionListener(this);
    
    done = new TransitionButton(this, width, height, Color.WHITE, "Done", 7, 1);
    done.setBounds(600,600, width, height);
    done.setActionCommand("done");
    done.addActionListener(this);
    done.setVisible(false);
    
    chooseFile = new EstablisherButton(width, height, Color.WHITE, "Choose File", 7, 2);
    chooseFile.setBounds(480,560, width, height);
    chooseFile.setActionCommand("choose");
    chooseFile.addActionListener(this);
    
    fileName.setBounds(600, 560, 100, 40);
  }
  public int getScreenID(){
    return 7; 
  }
	public boolean popup(String text){
    return true;
  }
  public void buttonClicked(int buttonID){
    switch(buttonID){
      case 0:
        q.changeScreen(1);
	//send to main menu and pls matthew stop being a deadweight leader, useless 
        break;	
      case 1:
	q.getProfile().addDomain(new Domain(fileName));
	q.changeScreen(1);
    	break;
        //send to main menu and parse selectedFile into a domain
      case 2:
    	jfc = new JFileChooser();

  		int returnValue = jfc.showOpenDialog(null);
  		// int returnValue = jfc.showSaveDialog(null);

  		if (returnValue == JFileChooser.APPROVE_OPTION) {
  			selectedFile = jfc.getSelectedFile();
  			if(accept(selectedFile)) {
  				done.setVisible(true);
  				fileName = new JLabel(selectedFile.toString());
  			}
  			
  		}
    	break;
    }      
  }
  private boolean accept(File f){
      String name = f.toString();
      fileName = new JLabel(name);
      int index = name.lastIndexOf('.');
      if(index > 0) {
        String extension = name.substring(index + 1);
        if(extension.equals("xml")) {
        	return true;
        }
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


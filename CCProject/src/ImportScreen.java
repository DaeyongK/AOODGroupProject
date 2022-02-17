class ImportScreen extends QPanel{
  private File xmlToBeConverted;
  private boolean filePresent = false;
  ImportScreen(){
    //Add QButtons and stuff, along with a file 
    TransitionButton done = new TransitionButton(200, 50, Color.WHITE, "Done", Quizit.IMPORTID, 0)
    TransitionButton back = new TransitionButton(200, 50, Color.WHITE, "Done", Quizit.IMPORTID, 1);
    EstablisherButton chooseFile;
  }
  public int getScreenID(){
    return Quizit.IMPORTID; 
  }
  public buttonClicked(int buttonID){
    switch(buttonID){
      case 0:
        returnDomain(xmlTOBeConverted);
        break;
      case 2:
        break;     
    }      
  }
  private Domain returnDomain(File f){
    return new Domain(f);
  }
}

class ImportScreen{
  private File xmlToBeConverted;
  private boolean filePresent = false;
  ImportScreen(){
    //Add QButtons and stuff, along with a file 
    TransitionButton done = new TransitionButton(200, 50, Color.WHITE, "Done", Quizit.IMPORTID, int buttonID)
    TransitionButton back;
    EstablisherButton chooseFile;
  }
  private Domain returnDomain(File f){
    return new Domain(f);
  }
}

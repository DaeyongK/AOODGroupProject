
public class Options extends QPanel{
	private boolean allQuestions;
	private boolean shuffleQuestions;
	private JComboBox dropdown;
	private EstablisherButton numCorrectButton;
	private EstablisherButton allQuestionsButton;
	private EstablisherButton shuffleQuestionsButton;
	private TransitionButton doneButton;
	private EstablisherButton firstLastButton;
	
	Options(String title){
		//creating buttons and ui elements
		dropdown =  new JComboBox();
		numCorrectButton = new EstablisherButton(int width, int height, Color color, String text, int screenID, int buttonID);
		allQuestionsButton = new EstablisherButton(int width, int height, Color color, String text, int screenID, int buttonID);
		shuffleQuestionsButton = new EstablisherButton(int width, int height, Color color, String text, int screenID, int buttonID);
		TransitionButton doneButton = new TransitionButton(int width, int height, Color color, String text, int screenID, int buttonID);
		firstLastButton = new EstablisherButton(int width, int height, Color color, String text, int screenID, int buttonID);
	}
	
	Options(boolean allQuestionsTrue, boolean shuffleQuestionsTrue){
		//sets value of allQuestions
		if(allQuestionsTrue) {
			allQuestions = true;
		} else {
			allQuestions = false;
		}
		//sets value of shuffleQuestions
		if(shuffleQuestionsTrue) {
			shuffleQuestions = true;
		} else {
			shuffleQuestions = false;
		}
	}
	
	private radioClick() {
		
	}
	
	public boolean getShuffled() {
		return shuffleQuestions;
	}
	
	public boolean getAllQuestions() {
		return allQuestions;
	}

}

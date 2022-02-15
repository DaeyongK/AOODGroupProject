
public class Options extends QPanel{
	boolean allQuestions;
	boolean shuffleQuestions;
	JComboBox dropdown;
	EstablisherButton numCorrectButton;
	EstablisherButton allQuestionsButton;
	EstablisherButton shuffleQuestionsButton;
	TransitionButton doneButton;
	EstablisherButton firstLastButton;
	
	Options(String title){
		
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

import javax.swing.*;

public class Options extends QPanel implements ActionListener{
	private boolean allQuestions;
	private boolean shuffleQuestions;
	private JComboBox dropdown;
	private EstablisherButton numCorrectButton;
	private EstablisherButton allQuestionsButton;
	private EstablisherButton shuffleQuestionsButton;
	private EstablisherButton firstLastButton;
	private TransitionButton doneButton;
	
	Options(String title){
		//creating buttons and ui elements
		dropdown =  new JComboBox();
		numCorrectButton = new EstablisherButton(int width, int height, Color.WHITE, "Questions with number of correct answers", int buttonID);
		allQuestionsButton = new EstablisherButton(int width, int height, Color.WHITE, "All Questions", int buttonID);
		shuffleQuestionsButton = new EstablisherButton(int width, int height, Color.WHITE, "Shuffle Questions", int buttonID);
		firstLastButton = new EstablisherButton(int width, int height, Color.WHITE, "First to Last", int buttonID);
		TransitionButton doneButton = new TransitionButton(int width, int height, Color color, String text, int screenID, int buttonID);
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
	
	public void radioClick() {
		
	}
	
	public boolean getShuffled() {
		return shuffleQuestions;
	}
	
	public boolean getAllQuestions() {
		return allQuestions;
	}
	
	public int getScreenID(){
		return 4;
	}

	@Override
	public boolean popup(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buttonClicked(int buttonID) {
		// TODO Auto-generated method stub
		super(buttonID);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(TITLE_COLOR);
	}
	
	public void actionPerformed(ActionEvent e){
		//when doneButton is pressed
		//when numCorrectButton is pressed
		//when allQuestionsButton is pressed
		//when shuffleQuestionsButton is pressed
		//when firstLastButton is pressed
		//when pfp3 is clicked
	}

}

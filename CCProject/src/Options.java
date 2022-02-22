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
	private JPanel panel;
	
	Options(String title){
		super(title);
		panel = new JPanel();
		//create buttons and ui aspects. adds action listeners. then adds to jpanel.\
		//dropdown menu
		dropdown =  new JComboBox();
		dropdown.addActionListener(this);
		panel.addComponant(dropdown);
		//number correct button
		numCorrectButton = new EstablisherButton(100, 40, Color.WHITE, "Questions with number of correct answers", int buttonID);
		numCorrecButton.addActionListener(this);
		panel.addComponant(numCorrectButton);
		//all questions button
		allQuestionsButton = new EstablisherButton(100, 40, Color.WHITE, "All Questions", int buttonID);
		allQuestionsButton.addActionListener(this);
		panel.addComponant(allQuestionsButton);
		//shuffle questions button
		shuffleQuestionsButton = new EstablisherButton(100, 40, Color.WHITE, "Shuffle Questions", int buttonID);
		shuffleQuestionsButton.addActionListener(this);
		panel.addComponant(shuffleQuestionsButton);
		//first last button
		firstLastButton = new EstablisherButton(100, 40, Color.WHITE, "First to Last", int buttonID);
		firstLastButton.addActionListener(this);
		panel.addComponant(firstLastButton);
		//done button
		TransitionButton doneButton = new TransitionButton(50, 25, Color.WHITE, "Done" 1, int buttonID);
		doneButton.addActionListener(this);
		panel.addComponant(doneButton);
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

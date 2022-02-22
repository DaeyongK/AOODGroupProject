
public class CreateProfile extends QPanel implements ActionListener{
	private TransitionButton done;
	private TransitionButton create;
	private CircularButton shrek;
	private CircularButton fiona;
	private CircularButton donkey;
	
	CreateProfile(String title){
		//create buttons and ui aspects. specify parameters
		exit = new TransitionButton(int width, int height, TITLE_COLOR, "Exit", int screenID, int buttonID);
		create = new TransitionButton(int width, int height, Color.WHITE, "Create", 4, int buttonID);
		shrek = new CircularButton();
		fiona = new CircularButton();
		donkey = new CircuarButton();
	}
	
	public void radioClick() {
		
	}
	
	public int getScreenID(){
		return 3;
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
		//when exit is pressed
		//when create is pressed
		//when textbox is pressed
		//when pfp1 is clicked
		//when pfp2 is cicked
		//when pfp3 is clicked
	}

}


public class CreateProfile extends QPanel{
	private TransitionButton done;
	private EstablisherButton create;
	
	CreateProfile(String title){
		//create buttons and ui aspects. specify parameters
		done = new TransitionButton(int width, int height, Color color, String text, int screenID, int buttonID);
		create = new EstablisherButton(int width, int height, Color color, String text, int screenID, int buttonID);
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
		
	}

}

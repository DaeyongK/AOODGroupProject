
public class SelectDomain extends DomainScreen{

	SelectDomain(String input, Profile profile) {
		super(input,profile);
	}

	@Override
	public void buttonClicked(int buttonID) {
		
	}

	@Override
	public int getScreenID() {
		return 5;
	}

	@Override
	public boolean popup(String text) {
		return false;
	}

}
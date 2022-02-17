import java.awt.*;
import javax.swing.*;

public class EditDomain extends DomainScreen{
	private JTextField nameEdit;
	private JScrollPane questions;
	private TransitionButton save;
	private TransitionButton createNewQ;
	private TransitionButton editQ;
	private TransitionButton deleteQ;
	//exit button??

	public EditDomain(Domain d, String t){
		super(t);
		//save button
		save = new TransitionButton(w, h, Color.WHITE, “Save”, 5, 11);
		this.add(save);
		//create new question button
		createNewQ = new TransitionButton(w, h, Color.WHITE, “Create New Question”, 12, 12);
		this.add(createNewQ);
		//edit question button, on questions
		editQ = new TransitionButton(w, h, QPanel.TITLE_COLOR, “Edit”, 13, 21);
		this.add(editQ);
		//delete question button, on questions
		deleteQ = new EstablisherButton(w, h, QPanel.TITLE_COLOR, “Delete”, 9, 22);
		this.add(deleteQ);
		//text for name
		nameEdit = new JTextField(“”); //how to get the name of the domain???
		this.add(nameEdit);
		//scroll pane for questions
	}

	public int getScreenID(){
		return 9;
	}
	public boolean popup(String text){
		//for the possible delete questions or exiting the screen
		//if/else .include for the text
	}
	public void buttonClicked(int buttonID){
		switch(buttonID){
		///////////////////////////////
		}
	}
	public void getName(){
		return ""; //how to get domain  name??
	}
}

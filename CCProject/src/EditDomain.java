import java.awt.*;
import javax.swing.*;

public class EditDomain extends DomainScreen impliments ActionListener{
	private JTextField nameEdit;
	private JScrollPane questions;
	private TransitionButton save;
	private TransitionButton createNewQ;
	private TransitionButton editQ;
	private TransitionButton deleteQ;
	private Domain currentDomain;
	private JPanel insideScroll;
	//back button
	
	public EditDomain(Domain d, String t){
		super(t);
		currentDomain = d;
		//save button
		save = new TransitionButton(w, h, Color.WHITE, “Save”, 5, 11);
		save.addActionListener(this);
		this.add(save);
		//create new question button
		createNewQ = new TransitionButton(w, h, Color.WHITE, “Create New Question”, 12, 12);
		createNeqQ.addActionListener(this);
		this.add(createNewQ);
		//edit question button, on questions
		editQ = new TransitionButton(w, h, QPanel.TITLE_COLOR, “Edit”, 13, 21);
		editQ.addActionListener(this);
		//this.add(editQ);
		//delete question button, on questions
		deleteQ = new EstablisherButton(w, h, QPanel.TITLE_COLOR, “Delete”, 9, 22);
		deleteQ.addActionListener(this);
		//this.add(deleteQ);
		//text for name
		nameEdit = new JTextField(d.getDomainName());
		nameEdit.addActionListener(this);
		this.add(nameEdit);
		//scroll pane for questions, and the jpanel of buttons
		questions = new JScrollPane();
		questions.setPreferredSize(500,300); //new Dimension(500,300)
		//the jpanel and the questions ???
		insideScroll = new JPanel();
		questions.setViewportView(insideScroll);
		this.add(questions);
		
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
		return currentDomain.getDomainName();
	}
}

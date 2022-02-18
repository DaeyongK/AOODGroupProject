import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EditDomain extends DomainScreen impliments MouseListener, MouseMotionListener{
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
		//text for name
		nameEdit = new JTextField(d.getDomainName());
		nameEdit.addActionListener(this);
		this.add(nameEdit);
		//scroll pane for questions, and the jpanel of buttons
		questions = new JScrollPane();
		questions.setPreferredSize(new Dimension(500,300));
		questions.setLayout(new ScrollPaneLayout());
		//the jpanel and the questions ???
		insideScroll = new JPanel();
		insideScroll.setLayout(new BoxLayout(insideScroll,BoxLayout.Y_AXIS));
		//for loop to iterate through the questions and add everything to insidescroll (1 line .add)
		questions.setViewportView(insideScroll);
		this.add(questions);
		
		//save button
		save = new TransitionButton(w, h, Color.WHITE, “Save”, 5, 11);
		save.addActionListener(this);
		this.add(save);
		//create new question button
		createNewQ = new TransitionButton(w, h, Color.WHITE, “Create New Question”, 12, 12);
		createNewQ.addActionListener(this);
		this.add(createNewQ);
		//edit question button, on questions
		editQ = new TransitionButton(w, h, QPanel.TITLE_COLOR, “Edit”, 13, 21);
		editQ.addActionListener(this);
		//delete question button, on questions
		deleteQ = new EstablisherButton(w, h, QPanel.TITLE_COLOR, “Delete”, 9, 22);
		deleteQ.addActionListener(this);
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
			case 11:
			//read the screen, finalize changes, go to select domain(5)
			break;
			case 12:
			//go to create question for a blank question(12)
			break;
			case 21:
			//go to edit question for the right question(13)
			break;
			case 22:
			//popup for delete question
			break;
		}
	}
	public void getName(){
		return currentDomain.getDomainName();
	}
	
	// TODO add mouse listener somewhere??? on the buttons???
	// ^^ can do a loop to create all the buttons by concatenating their names as "q"+i
	
	public void mouseDragged(MouseEvent e) {
		//for dragging the buttons
		// TODO determine how to know you're in a button?? redo button names??
	}
	public void mouseClicked(MouseEvent e) {
		//for determining single or double clicks
		// TODO if e.clickCount()==2...
	}

	public void mouseMoved(MouseEvent e) {
		//empty??
	}
	public void mousePressed(MouseEvent e) {
		//empty??
	}
	public void mouseReleased(MouseEvent e) {
		//empty??
	}
	public void mouseEntered(MouseEvent e) {
		//empty??
	}
	public void mouseExited(MouseEvent e) {
		//empty??
	}
}

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
	private EstablisherButton back;
	ArrayList<EstablisherButton> buttons = new ArrayList<EstablisherButton>();
	private QPanel thisScreen;
	
	public EditDomain(Domain d, String t){
		super(t);
		currentDomain = d;
		//for use outside the constructor
		thisScreen = this;
		//exit button
		back = new EstablisherButton(40, 20, Color.WHITE, “Back”, 13)
		//text for name, size 70 height
		nameEdit = new JTextField(d.getDomainName());
		nameEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(nameEdit.getText()==""||nameEdit.getText().length()>64)
					nameEdit.setText(d.getDomainName());
			}
		});
		this.add(nameEdit);
		//scroll pane for questions, and the jpanel of buttons
		questions = new JScrollPane();
		questions.setPreferredSize(new Dimension(900,300));
		questions.setLayout(new ScrollPaneLayout());
		//the jpanel and the questions
		insideScroll = new JPanel();
		insideScroll.setLayout(new BoxLayout(insideScroll,BoxLayout.Y_AXIS));
		for(int i=0;i<???;i++){ //how to find the number of questions?
			buttons.add(new EstablisherButton(850, 25, Color_WHITE, d.getQuestion(i).getQuestion(),
				d.getQuestion(i).getID());
			insideScroll.add(buttons.get(i));
		}
		deleteQ = new EstablisherButton(25, 15, QPanel.TITLE_COLOR, “Delete”, 9, 22);
		//mouse listeners
		for(int i=0;i<buttons.size();i++){
			final int workaround = i;
			buttons.get(i).addMouseMotionListener(new MouseMotionListener() {
				public void mouseDragged(MouseEvent e) {
					//drag n drop
				}
				public void mouseMoved(MouseEvent e) {
					// not needed?
				}
			});
			buttons.get(i).addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1) {
						editQ = new TransitionButton(25, 15, QPanel.TITLE_COLOR, “Edit”, 13, 
							e.getSource().getID); //i don't know if those are the right methods, i'll check later
						buttons.get(workaround).add(editQ);
						deleteQ = new EstablisherButton(25, 15, QPanel.TITLE_COLOR, “Delete”, 9, 21);
						buttons.get(workaround).add(deleteQ);
					} else if(e.getClickCount()==2) {
						QPanel goScreen = thisScreen;
						thisScreen = new QuestionScreen(e.getSource().getID,false);
					}
				}
				public void mousePressed(MouseEvent e) {
					// not needed?
				}
				public void mouseReleased(MouseEvent e) {
					// not needed?
				}
				public void mouseEntered(MouseEvent e) {
					// not needed?
				}
				public void mouseExited(MouseEvent e) {
					// not needed?
				}
			});
		}
		// mouse listeners
		questions.setViewportView(insideScroll);
		this.add(questions);
		
		//save button
		save = new TransitionButton(35, 25, Color.WHITE, “Save”, 5, 11);
		this.add(save);
		//create new question button
		createNewQ = new TransitionButton(100, 25, Color.WHITE, “Create New Question”, 12, 12);
		this.add(createNewQ);
	}
	
	public int getScreenID(){
		return 9;
	}
	public boolean popup(String text){
		//for the possible delete questions or exiting the screen
		//if/else .include for the text
	}
	public void buttonClicked(int buttonID){
		QPanel nextScreen = thisScreen;
		switch(buttonID){
			case 11:
				//read the screen, finalize changes, go to select domain(5)
				d.setDomainName(nameEdit.getText());
				for(int i=0;i<buttons.size();i++){
					//reorder the questions in the domain based on order in array list??
				}
				break;
			case 12:
				//go to create question for a blank question(12)
				nextScreen = QuestionScreen(-1,true);
				break;
			case 13:
				if(popup(“Are you sure you want to leave?\n(Changes may not be saved)")){
					
				} else{
					
				}
				break;
			default:
				if(buttonID==21){
					
				} else{
					nextScreen = QuestionScreen(buttonID,false);
				}
		}
	}
	public void getName(){
		return currentDomain.getDomainName();
	}
	
	public void mouseDragged(MouseEvent e) {
		//empty
	}
	public void mouseClicked(MouseEvent e) {
		//empty
	}

	public void mouseMoved(MouseEvent e) {
		//empty
	}
	public void mousePressed(MouseEvent e) {
		//empty
	}
	public void mouseReleased(MouseEvent e) {
		//empty
	}	
	public void mouseEntered(MouseEvent e) {
		//empty
	}
	public void mouseExited(MouseEvent e) {
		//empty
	}
}

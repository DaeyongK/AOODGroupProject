import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EditDomain extends DomainScreen impliments MouseListener, MouseMotionListener,ActionListener{
	private JTextField nameEdit;
	private JScrollPane questions;
	private TransitionButton save;
	private TransitionButton createNewQ;
	private TransitionButton editQ;
	private EstablisherButton deleteQ;
	private Domain currentDomain;
	private JPanel insideScroll;
	private EstablisherButton back;
	private ArrayList<EstablisherButton> buttons = new ArrayList<EstablisherButton>();
	private ArrayList<EstablisherButton> buttonsWorkaround = new ArrayList<EstablisherButton>();
	private QPanel thisScreen;
	private int currentQID = 0;
	private boolean popResult;

	//for dragging and dropping.
	private EstablisherButton beingDragged = new EstablisherButton(this,0,0,Color.WHITE,””,-2);
	private EstablisherButton aboveSpot = new EstablisherButton(this,0,0,Color.WHITE,””,-2);
	private int draggedIndex = -1;
	private int droppedIndex = -1;
	private EstablisherButton currentButton = new EstablisherButton(this,0,0,Color.WHITE,””,-2);
	
	public EditDomain(String t, Quizit q){
		super(t);
		currentDomain = q.getDomain();
		//for use outside the constructor
		thisScreen = this;
		//exit button
		back = new EstablisherButton(this,40, 20, Color.WHITE, “Back”, 13);
		back.addActionListener(this);
		this.add(back);
		//text for name, size 70 height
		nameEdit = new JTextField(currentDomain.getDomainName());
		nameEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(nameEdit.getText().equals(“”)||nameEdit.getText().length()>64)
					nameEdit.setText(currentDomain.getDomainName());
			}
		});
		this.add(nameEdit);
		//scroll pane for questions, and the jpanel of buttons
		questions = new JScrollPane();
		questions.setPreferredSize(new Dimension(900,300));
		questions.setLayout(new ScrollPaneLayout());
		//the jpanel and the questions
		insideScroll = new JPanel();
		insideScroll.setBackground(QPanel.TITLE_COLOR);
		insideScroll.setLayout(new BoxLayout(insideScroll,BoxLayout.Y_AXIS));
		for(int i=0;i<currentDomain.getDomainSize();i++){
			buttons.add(new EstablisherButton(this,850, 25, Color.WHITE,
				currentDomain.getQuestion(i).getQuestion(),currentDomain.getQuestion(i).getID());
			insideScroll.add(buttons.get(i));
		}
		//mouse listeners
		for(int i=0;i<buttons.size();i++){
			final int workaround = i;
			buttons.get(i).addMouseMotionListener(new MouseMotionListener() {
				public void mouseDragged(MouseEvent e) {
					beingDragged = (EstablisherButton) e.getSource();
					draggedIndex = workaround;
				}
				public void mouseMoved(MouseEvent e) {
					// not needed?
				}
			});
			buttons.get(i).addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1) {
						currentButton.remove(editQ);
						currentButton.remove(deleteQ);
						currentButton = (EstablisherButton) e.getSource();
						editQ = new TransitionButton(thisScreen,25, 15, QPanel.TITLE_COLOR,“Edit”, 12, 22);
						buttons.get(workaround).add(editQ);
						deleteQ = new EstablisherButton(thisScreen,25, 15, QPanel.TITLE_COLOR, “Delete”, 9, 21);
						buttons.get(workaround).add(deleteQ);
						EstablisherButton currentB = (EstablisherButton) e.getSource();
						currentQID = currentB.getID();
					} else if(e.getClickCount()==2) {
						QPanel goScreen = thisScreen;
						goScreen = new QuestionScreen(e.getSource().getID,false);
					}
				}
				public void mousePressed(MouseEvent e) {
					// not needed?
				}
				public void mouseReleased(MouseEvent e) {
					// for when you’re done dragging
					JButton b = (JButton) e.getSource();
					if(b.getParent().equals(insideScroll)&&draggedIndex>-1){
						aboveSpot = (EstablisherButton) e.getSource();
						buttons.remove(draggedIndex);
						//needs to be tested; reworking array list
						for(int i=0;i<=droppedIndex;i++){
							if(i!=draggedIndex)
								buttonsWorkaround.add(buttons.get(i));
						}
						for(int i=droppedIndex+1;i<buttons.size();i++){
							if(i==droppedIndex+1)
								buttonsWorkaround.add(buttons.get(draggedIndex);
							else
								buttonsWorkaround.add(buttons.get(i);
						}
						for(int i=0;i<buttonsWorkaround.size();i++){
							buttons.get(i) = buttonsWorkaround.get(i);
						}
						//end needs to be tested; reworking array list
						insideScroll.removeAll();
						for(int i=0;i<buttons.size();i++) {
							insideScroll.add(buttons.get(i));
						}
						insideScroll.revalidate();
						insideScroll.repaint();
					}
				}
				public void mouseEntered(MouseEvent e) {
					droppedIndex = workaround;
				}
				public void mouseExited(MouseEvent e) {
					// not needed?
				}
			});
		}
		// end mouse listeners
		questions.setViewportView(insideScroll);
		this.add(questions);
		
		//save button
		save = new TransitionButton(this,35, 25, Color.WHITE, “Save”, 5, 11);
		save.addActionListener(this);
		this.add(save);
		//create new question button
		createNewQ = new TransitionButton(this,100, 25, Color.WHITE, “Create New Question”, 11, 12);
		createNewQ.addActionListener(this);
		this.add(createNewQ);
	}
	
	public int getScreenID(){
		return 8;
	}
	public boolean popup(String text){
		//for the possible delete questions or exiting the screen
		JPanel pop = new JPanel();
		JLabel message = new JLabel(text);
		pop.add(message);
		//determining which popup to display, displaying it
		if(text.includes(“leave”){
			TransitionButton yes = new TransitionButton(thisScreen,40,25,Color.WHITE,”Yes”,5,31);
			yes.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					popResult = true;
				}
			});
			pop.add(yes);
			EstablisherButton no = new EstablisherButton(thisScreen,40,25,Color.WHITE,”No”,32);
			no.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					thisScreen.remove(pop);
					popResult = false;
				}
			});
			pop.add(no);
		} else{
			EstablisherButton yes = new EstablisherButton(thisScreen,40,25,Color.WHITE,”Yes”,31);
			yes.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					thisScreen.remove(pop);
					popResult = true;
				}
			});
			pop.add(yes);
			EstablisherButton no = new EstablisherButton(thisScreen,40,25,Color.WHITE,”No”,32);
			no.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					thisScreen.remove(pop);
					popResult = false;
				}
			});
			pop.add(no);
		}
		thisScreen.add(pop);
		return popResult;
	}
	public void buttonClicked(int buttonID){
		switch(buttonID){
			case 11:
				//read the screen, finalize changes, go to select domain(5)
				d.setDomainName(nameEdit.getText());
				//reorder the questions based on the screen
				for(int i=0;i<buttons.size();i++)
					currentDomain.deleteQuestion(buttons.get(i).getID());
				for(int i=0;i<buttons.size();i++)
					currentDomain.addQuestion(buttons.get(i));
				//end reordering
				theQuizit.changeScreen(5);
				break;
			case 12:
				//go to create question for a blank question(11)
				theQuizit.changeScreen(11);
				break;
			case 13:
				if(popup(“Are you sure you want to leave?\n(Changes may not be saved)")){
					theQuizit.changeScreen(5);
				}
				break;
			case 21:
				if(popup(“Delete Question\n\nAre you sure?”)){
					currentDomain.deleteQuestion(currentQID);
					insideScroll.remove(currentButton);
					buttons.remove(currentButton);
					//needs to be tested; reworking array list
					for(int i=0;i<=droppedIndex;i++){
					if(i!=draggedIndex)
						buttonsWorkaround.add(buttons.get(i));
					}
					for(int i=droppedIndex+1;i<buttons.size();i++){
						if(i==droppedIndex+1)
							buttonsWorkaround.add(buttons.get(draggedIndex);
						else
							buttonsWorkaround.add(buttons.get(i);
					}
					for(int i=0;i<buttonsWorkaround.size();i++){
						buttons.get(i) = buttonsWorkaround.get(i);
					}
					//end needs to be tested; reworking array list
					insideScroll.removeAll();
					for(int i=0;i<buttons.size();i++) {
						insideScroll.add(buttons.get(i));
					}
					insideScroll.revalidate();
					insideScroll.repaint();
				}
				break;
			case 22:
				theQuizit.changeScreen(12);
				break;
		}
	}
	public String getName(){
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

	public void actionPerformed(ActionEvent e){
		//empty??
	}
}

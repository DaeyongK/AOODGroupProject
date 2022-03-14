import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditDomain extends QPanel implements MouseListener, MouseMotionListener, ActionListener {
	private JTextField nameEdit;
	private JScrollPane questions;
	private TransitionButton save;
	private TransitionButton createNewQ;
	private TransitionButton editQ;
	private EstablisherButton deleteQ;
	private Domain currentDomain;
	private JPanel insideScroll;
	private EstablisherButton back;
	private ArrayList<EstablisherButton> buttons = new ArrayList<>();
	private ArrayList<EstablisherButton> buttonsWorkaround = new ArrayList<>();
	private QPanel thisScreen;
	private int currentQID = 0;
	private boolean popResult;

	//for dragging and dropping.
	private EstablisherButton beingDragged = new EstablisherButton(this, 0, 0, Color.WHITE, "", -2);
	private EstablisherButton aboveSpot = new EstablisherButton(this, 0, 0, Color.WHITE, "", -2);
	private int draggedIndex = -1;
	private int droppedIndex = -1;
	private EstablisherButton currentButton = new EstablisherButton(this, 0, 0, Color.WHITE, "", -2);
	private ArrayList<Question> domainQuestions = new ArrayList<>();
	private ArrayList<Question> questionsWorkaround = new ArrayList<>();
	private boolean wasCreate = false;
	public EditDomain(String t, Quizit q) {
		super(t, q);
		currentDomain = q.getDomain();
		//for use outside the constructor
		thisScreen = this;
		//exit button
		setLayout(null);

		back = new EstablisherButton(this, 40, 20, Color.WHITE, "Back", 13);
		back.addActionListener(this);
		back.setBounds(50,50,80,50);
		this.add(back);
		//text for name, size 70 height
		if(currentDomain != null) {
			nameEdit = new JTextField(currentDomain.getDomainName());
			nameEdit.addActionListener(e -> {
				if (nameEdit.getText().equals("") || nameEdit.getText().length() > 64)
					nameEdit.setText(currentDomain.getDomainName());
			});
		}else {
			wasCreate = true;
			nameEdit = new JTextField("Insert Name");
			nameEdit.addActionListener(e -> {
				if (nameEdit.getText().equals("") || nameEdit.getText().length() > 64)
					nameEdit.setText(" ");
			});
		}
		this.add(nameEdit);
		nameEdit.setBounds(500,50,280,50);
		//scroll pane for questions, and the jpanel of buttons
		insideScroll = new JPanel();

		questions = new JScrollPane(insideScroll);
		questions.setPreferredSize(new Dimension(900, 300));
		//the jpanel and the questions
		insideScroll.setBackground(QPanel.TITLE_COLOR);
		insideScroll.setLayout(new BoxLayout(insideScroll, BoxLayout.Y_AXIS));
		if(currentDomain!= null)
			
			for (int i = 0; i < currentDomain.getDomainSize(); i++) {
				domainQuestions.add(currentDomain.getQuestion(i));
				buttons.add(new EstablisherButton(this, 850, 25, Color.WHITE,
						currentDomain.getQuestion(i).getQuestion(), currentDomain.getQuestion(i).getID()));
				insideScroll.add(buttons.get(i));
			}

		//mouse listeners
		for (int i = 0; i < buttons.size(); i++) {
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
					if (e.getClickCount() == 1) {
						currentButton.remove(editQ);
						currentButton.remove(deleteQ);
						currentButton = (EstablisherButton) e.getSource();
						editQ = new TransitionButton(thisScreen, 25, 15, QPanel.TITLE_COLOR, "Edit", 12, 22);
						buttons.get(workaround).add(editQ);
						deleteQ = new EstablisherButton(thisScreen, 25, 15, QPanel.TITLE_COLOR, "Delete", 21); //HERE
						buttons.get(workaround).add(deleteQ);
						EstablisherButton currentB = (EstablisherButton) e.getSource();
						currentQID = currentB.getButtonID();
					} else if (e.getClickCount() == 2) {
						quizit.changeScreen(12);
					}
				}

				public void mousePressed(MouseEvent e) {
					// not needed?
				}

				public void mouseReleased(MouseEvent e) {
					// for when you’re done dragging
					JButton b = (JButton) e.getSource();
					if (b.getParent().equals(insideScroll) && draggedIndex > -1) {
						aboveSpot = (EstablisherButton) e.getSource();
						//reworking array lists
						for (int i = 0; i < buttons.size(); i++) {
							if (i <= droppedIndex) {
								if (i != draggedIndex) {
									buttonsWorkaround.add(buttons.get(i));
									questionsWorkaround.add(domainQuestions.get(i));
								}
							} else {
								if (i == droppedIndex + 1) {
									buttonsWorkaround.add(buttons.get(draggedIndex));
									buttonsWorkaround.add(buttons.get(droppedIndex + 1));
									questionsWorkaround.add(domainQuestions.get(draggedIndex));
									questionsWorkaround.add(domainQuestions.get(draggedIndex + 1));
								} else {
									buttonsWorkaround.add(buttons.get(i));
									questionsWorkaround.add(domainQuestions.get(i));
								}
							}
						}
						buttons.clear();
						domainQuestions.clear();
						for (int i = 0; i < buttonsWorkaround.size(); i++) {
							buttons.add(buttonsWorkaround.get(i));
							questionsWorkaround.add(questionsWorkaround.get(i));
						}
						buttonsWorkaround.clear();
						questionsWorkaround.clear();
						//end reworking array lists
						insideScroll.removeAll();
						for (EstablisherButton button : buttons) {
							insideScroll.add(button);
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
		questions.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		questions.setBounds(150,150,900,400);
		//save button
		save = new TransitionButton(this, 35, 25, Color.WHITE, "Save", 5, 11);
		save.addActionListener(this);
		save.setBounds(300,600, 100,40);
		this.add(save);
		//create new question button

		createNewQ = new TransitionButton(this, 100, 25, Color.WHITE, "Create New Question", 11, 12);
		createNewQ.addActionListener(this);
		createNewQ.setBounds(450,600,300,45);

		this.add(createNewQ);
		if(currentDomain == null) {
			currentDomain = new Domain("Insert Name", domainQuestions);
			quizit.setDomain(currentDomain);
		}

	}

	public int getScreenID() {
		return 8;
	}

	//	public boolean popup(String text) {
	//		//for the possible delete questions or exiting the screen
	//		JPanel pop = new JPanel();
	//		JLabel message = new JLabel(text);
	//		pop.add(message);
	//		//determining which popup to display, displaying it
	//		if (text.contains("leave")) {
	//			TransitionButton yes = new TransitionButton(thisScreen, 40, 25, Color.WHITE, "Yes", 5, 31);
	//			yes.addActionListener(e -> {
	//				quizit.changeScreen(5);
	//				popResult = true;
	//			});
	//			pop.add(yes);
	//			EstablisherButton no = new EstablisherButton(thisScreen, 40, 25, Color.WHITE, "No", 32);
	//			no.addActionListener(e -> {
	//				thisScreen.remove(pop);
	//				thisScreen.revalidate();
	//				thisScreen.repaint();
	//				popResult = false;
	//			});
	//			pop.add(no);
	//		} else {
	//			EstablisherButton yes = new EstablisherButton(thisScreen, 40, 25, Color.WHITE, "Yes", 31);
	//			yes.addActionListener(e -> {
	//				currentDomain.deleteQuestion(currentQID);
	//				insideScroll.remove(currentButton);
	//				buttons.remove(currentButton);
	//				//reworking array lists
	//				for (int i = 0; i < buttons.size(); i++) {
	//					if (i <= droppedIndex) {
	//						if (i != draggedIndex) {
	//							buttonsWorkaround.add(buttons.get(i));
	//							questionsWorkaround.add(domainQuestions.get(i));
	//						}
	//					} else {
	//						if (i == droppedIndex + 1) {
	//							buttonsWorkaround.add(buttons.get(draggedIndex));
	//							buttonsWorkaround.add(buttons.get(droppedIndex + 1));
	//							questionsWorkaround.add(domainQuestions.get(draggedIndex));
	//							questionsWorkaround.add(domainQuestions.get(draggedIndex + 1));
	//						} else {
	//							buttonsWorkaround.add(buttons.get(i));
	//							questionsWorkaround.add(domainQuestions.get(i));
	//						}
	//					}
	//				}
	//				buttons.clear();
	//				domainQuestions.clear();
	//				for (int i = 0; i < buttonsWorkaround.size(); i++) {
	//					buttons.add(buttonsWorkaround.get(i));
	//					questionsWorkaround.add(questionsWorkaround.get(i));
	//				}
	//				buttonsWorkaround.clear();
	//				questionsWorkaround.clear();
	//				//end reworking array lists
	//				insideScroll.removeAll();
	//				for (EstablisherButton button : buttons) {
	//					insideScroll.add(button);
	//				}
	//				insideScroll.revalidate();
	//				insideScroll.repaint();
	//				thisScreen.remove(pop);
	//				thisScreen.revalidate();
	//				thisScreen.repaint();
	//				popResult = true;
	//			});
	//			pop.add(yes);
	//			EstablisherButton no = new EstablisherButton(thisScreen, 40, 25, Color.WHITE, "No", 32);
	//			no.addActionListener(e -> {
	//				thisScreen.remove(pop);
	//				thisScreen.revalidate();
	//				thisScreen.repaint();
	//				popResult = false;
	//			});
	//			pop.add(no);
	//		}
	//		thisScreen.add(pop);
	//		thisScreen.revalidate();
	//		thisScreen.repaint();
	//		return popResult;
	//	}

	public void buttonClicked(int buttonID) {
		switch (buttonID) {
		case 11:
			//read the screen, finalize changes, go to select domain(5)
			currentDomain.setDomainName(nameEdit.getText());
			boolean create = false;
			for(int i=0;i<quizit.getProfile().getDomains().size();i++){
				if(currentDomain.getDomainName().equals(quizit.getProfile().getDomains().get(i).getDomainName()))
					create = true;
			}
			if(create){
				quizit.getProfile().addDomain(new Domain(nameEdit.getText(), domainQuestions));
			} else{
				//reorder the questions based on the screen
				for (EstablisherButton establisherButton : buttons)
					currentDomain.deleteQuestion(establisherButton.getButtonID());
				for (int i = 0; i < buttons.size(); i++)
					currentDomain.addQuestion(domainQuestions.get(i));
				//end reordering
			}
			quizit.changeScreen(5);
			break;
		case 12:
			//go to create question for a blank question(11)
			quizit.changeScreen(11);
			break;
		case 13:
			System.out.print("hi");
			if(popup("Are you sure you want to leave?\n(Changes may not be saved)"))
				quizit.changeScreen(1);;
				break;
		case 21:
			popup("Delete Question\n\nAre you sure?");
			break;
		case 22:
			quizit.changeScreen(12);
			break;
		default:
			quizit.changeScreen(1);
			break;
		}
	}

	public String getName() {
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

	public void actionPerformed(ActionEvent e) {
		//empty??
	}
}

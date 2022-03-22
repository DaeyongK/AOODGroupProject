import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class EditDomain extends QPanel implements MouseListener, MouseMotionListener, ActionListener, ChangeListener {
	private JTextField nameEdit;
	private JScrollPane questions;
	private TransitionButton save;
	private TransitionButton createNewQ;
	private TransitionButton editQ;
	private EstablisherButton deleteQ;
	private Domain currentDomain;
	private JLayeredPane insideScroll;
	private EstablisherButton back;
	private ArrayList<EstablisherButton> buttons = new ArrayList<>();
	private ArrayList<EstablisherButton> buttonsWorkaround = new ArrayList<>();
	private int currentQID = 0;
	private boolean first = true;
	private JLayeredPane anotherLayeredPane;
	private boolean draggable = false;

	private ArrayList<Question> domainQuestions = new ArrayList<>();
	private boolean wasCreate = false;
	public EditDomain(String t, Quizit q) {
		super(t, q);
		editQ = new TransitionButton(this, 100, 50, Color.WHITE, "Edit", 5, 22);
		deleteQ = new EstablisherButton(this, 100, 50, Color.WHITE, "Delete", 21);
		currentDomain = q.getDomain();

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
		insideScroll = new JLayeredPane();

		questions = new JScrollPane(insideScroll);
		questions.setPreferredSize(new Dimension(900, 300));
		//the jpanel and the questions
		insideScroll.setBackground(QPanel.TITLE_COLOR);
		insideScroll.setLayout(new BoxLayout(insideScroll, BoxLayout.Y_AXIS));
		if(currentDomain!= null)
			for (int i = 0; i < currentDomain.getQuestions().size(); i++) {
				domainQuestions.add(currentDomain.getQuestion(i));
				String name = currentDomain.getQuestions().get(i).getQuestion();
				if(currentDomain.getQuestions().get(i).getQuestion().length()>50){
					name = name.substring(0, 50)+"...";
				}
				EstablisherButton tempButton = new EstablisherButton(this, 800, 50, Color.white, name, -i);
				buttons.add(tempButton);
				buttonsWorkaround.add(tempButton);
				tempButton.addActionListener(this);
				tempButton.addMouseListener(this);

			}

		if (buttons != null) {
			for (int i =buttons.size()-1; i>-1; i--) {
				if(buttons.size()<7) {
					insideScroll.setLayout(new GridLayout(7, 1));

				}else {
					insideScroll.setLayout(new GridLayout(buttons.size(), 1));

				}
				EstablisherButton button = buttons.get(i);

				insideScroll.add(button, 1,0);
				button.setPreferredSize(new Dimension(800, 50));


			}
		}

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
		anotherLayeredPane = new JLayeredPane();
		anotherLayeredPane.setLayout(null);
		anotherLayeredPane.add(questions,1);
		anotherLayeredPane.setBounds(0,0,1280,720);
		add(anotherLayeredPane);
		questions.getViewport().addChangeListener(this);

		JPanel top = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(BACKGROUND_COLOR);

				g.fillRect(0, 0, 400, 151);
			}
		};

		anotherLayeredPane.add(top,30,0);
		top.setBounds(700,0,400,155);
		JPanel bot = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(BACKGROUND_COLOR);

				g.fillRect(0, 0, 400, 151);
			}
		};
		anotherLayeredPane.add(bot,30,0);
		bot.setBounds(700,550,400,500);
		//		insideScroll.addMouseListener(this);
		//		questions.addMouseListener(this);
	}

	public int getScreenID() {
		return 8;
	}


	public void buttonClicked(int buttonID) {
		if(first) {
			anotherLayeredPane.add(editQ,20,0);
			anotherLayeredPane.add(deleteQ,20,0);
			first = false;
		}
		if(buttonID<=0) {
			quizit.setQuestion(domainQuestions.get(-buttonID));

			currentQID = -buttonID;
		}


		switch (buttonID) {
			case 11:
			//read the screen, finalize changes, go to select domain(5)
			currentDomain.setDomainName(nameEdit.getText());
			//			boolean create = false;
			//			for(int i=0;i<quizit.getProfile().getDomains().size();i++){
			//				if(currentDomain.getDomainName().equals(quizit.getProfile().getDomains().get(i).getDomainName()))
			//					create = true;
			//			}
			if(wasCreate){
				quizit.getProfile().addDomain(new Domain(nameEdit.getText(), domainQuestions));
			}

			for(int i = 0; i<buttons.size(); i++) {
				currentDomain.deleteQuestion(0);
			}

			for (EstablisherButton button : buttons) {
				currentDomain.addQuestion(domainQuestions.get(-button.getButtonID()));
			}

			quizit.changeScreen(5);
			break;
		case 12:
			currentDomain.setDomainName(nameEdit.getText());

			//go to create question for a blank question(11)
			if(wasCreate){
				Domain tempDomain = new Domain(nameEdit.getText(), domainQuestions);
				quizit.getProfile().addDomain(tempDomain);
				quizit.setDomain(tempDomain);
			}

			for(int i = 0; i<buttons.size(); i++) {
				currentDomain.deleteQuestion(0);
			}

			for(int i = 0; i<buttons.size(); i++) {
				currentDomain.addQuestion(domainQuestions.get(-buttons.get(i).getButtonID()));
			}

			quizit.changeScreen(11);
			break;
		case 13:
			if(popup("Are you sure you want to leave?\n(Changes may not be saved)"))
				quizit.changeScreen(1);
			break;
		case 21:
			if(popup("Delete Question\n\nAre you sure?")) {

				repaint();
				currentDomain.deleteQuestion(currentQID);
				insideScroll.remove(buttons.get(currentQID));
				buttons.remove(currentQID);
				repaint();
				quizit.changeScreen(8);

			}
			break;
		case 22:
			quizit.changeScreen(12);
			break;
		default:

			break;
		}
	}

	public String getName() {
		return currentDomain.getDomainName();
	}

	public void mouseDragged(MouseEvent e) {


	}

	public void mouseClicked(MouseEvent e) {
		//empty
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		//empty
		int y = buttons.get(currentQID).getY()+152;
		draggable = true;

		editQ.setBounds(810, y-((int) questions.getViewport().getViewPosition().getY()), 100, 50);
		deleteQ.setBounds(920, y-((int) questions.getViewport().getViewPosition().getY()), 100, 50);
		TimerTask move = new TimerTask() {
			private int counter =0;
			boolean first = true;
			EstablisherButton draggedButton;
			public void run() {
				counter ++;
				if(counter <10) {
					return;
				}
				draggedButton = buttonsWorkaround.get(currentQID);

				if(draggable&&first) {
				EstablisherButton clicked =(EstablisherButton) e.getComponent();
				currentQID = -clicked.getButtonID();
				for(int i = 0; i<buttons.size(); i++) {
					if(draggedButton.getButtonID() == buttons.get(i).getButtonID())
						buttons.remove(i);
				}

				insideScroll.remove(draggedButton);
				repaint();
				insideScroll.add(draggedButton,5, 0);
				editQ.setVisible(false);
				deleteQ.setVisible(false);
				first = false;
				}
				if(draggable) {
					repaint();

					draggedButton.setBounds(0, (int)MouseInfo.getPointerInfo().getLocation().getY()-220+((int) questions.getViewport().getViewPosition().getY()), 900, 50);
				}else {
					int buttonAbove= -1;
					for(int i = 0; i<buttons.size(); i++) {
						EstablisherButton button = buttons.get(i);
						if(	draggedButton.getY()>button.getY()) {
							buttonAbove = i;
						}
					}
					buttons.add(buttonAbove+1, draggedButton);
					insideScroll.removeAll();
					if (buttons != null) {
						for (int i =buttons.size()-1; i>-1; i--) {
							//       		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
							if(buttons.size()<7) {
								insideScroll.setLayout(new GridLayout(7, 1));

							}else {
								insideScroll.setLayout(new GridLayout(buttons.size(), 1));

							}
							EstablisherButton button = buttons.get(i);

							insideScroll.add(button, 1,0);
							button.setPreferredSize(new Dimension(800, 50));

							//pane.setLayout(null);
							//        		button.setBounds(20,80*i+20,360,50);
							//            	pane.add(button);
						}
					}
					//					insideScroll.add(draggedButton,1, 0);
					repaint();
					int y = 0;

					for (EstablisherButton button : buttons) {
						if (draggedButton.getButtonID() == button.getButtonID())
							y = draggedButton.getY() + 152;

					}
					editQ.setBounds(810, y-((int) questions.getViewport().getViewPosition().getY()), 100, 50);
					deleteQ.setBounds(920, y-((int) questions.getViewport().getViewPosition().getY()), 100, 50);
					editQ.setVisible(true);
					deleteQ.setVisible(true);

					cancel();
				}

			}
		};


		Timer timer = new Timer();
		timer.schedule(move, 0, 1000/24);
	}

	public void mouseReleased(MouseEvent e) {
		//empty
		draggable = false;
	}

	public void mouseEntered(MouseEvent e) {
		//empty
	}

	public void mouseExited(MouseEvent e) {
		//empty
	}

	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		try {
			int y = buttons.get(currentQID).getY()+152;

			editQ.setBounds(810, y-((int) questions.getViewport().getViewPosition().getY()), 100, 50);
			deleteQ.setBounds(920, y-((int) questions.getViewport().getViewPosition().getY()), 100, 50);
		}catch(Exception ignored) {

		}
	}
}

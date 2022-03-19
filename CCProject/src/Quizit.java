import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Quizit {
	private ArrayList<Profile> profiles = new ArrayList<>();
	private Profile currentProfile;
	private Question currentQuestion;
	private Domain currentDomain;
	private MainMenu screen1;
	private SelectProfile screen2;
	private CreateProfile screen3;
	private Options screen4;
	private SelectDomain screen5;
	private QuestionCard screen6;
	private ImportScreen screen7;
	private EditDomain screen8;
	private ExportDomain screen9;
	private DetachDomain screen10;
	private QuestionScreen screen11, screen12;
	private JFrame frame;

	Quizit() {
		currentProfile = new Profile("Profile", 1);

		File[] profilexmls = new File("Profiles").listFiles();
		for (File file : profilexmls) {

			profiles.add(new Profile(file, this));
		}

		currentProfile= profiles.get(0);

		setDomain(currentProfile.getDomains().get(0));
		setQuestion(currentDomain.getQuestion(0));
		screen1 = new MainMenu("Quizit", this);
		screen2 = new SelectProfile("Select Profile", this);
		screen3 = new CreateProfile("Create Profile", this);
		screen4 = new Options("Quizzing Options", this);
		screen5 = new SelectDomain("Select Domain", this);
		screen6 = new QuestionCard("", this);
		screen7 = new ImportScreen("Import Domain", this);
		screen8 = new EditDomain("Edit Domain", this);
		screen9 = new ExportDomain("Export Domain", this);
		screen10 = new DetachDomain("Detach Domain", this);
		screen11 = new QuestionScreen("Create Question", this);
		screen12 = new QuestionScreen("Edit Question", this);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Quizit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(screen1);
		frame.pack();
		frame.setSize(1280, 720);
		frame.setVisible(true);
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			public void run()
			{
				exportDomains();
				exportProfiles();
				System.out.print("saved on close");
			}
		});

	}

	public Profile getProfile() {
		return currentProfile;
	}

	public void setProfile(Profile profile) {
		currentProfile = profile;
	}

	public ArrayList<Profile> getAllProfiles() {
		return profiles;
	}

	public void addProfile(Profile profile) {
		profiles.add(profile);
	}

	public Question getQuestion() {
		return currentQuestion;
	}

	public void setQuestion(Question question) {
		currentQuestion = question;
	}

	public Domain getDomain() {
		return currentDomain;
	}

	public void setDomain(Domain domain) {
		currentDomain = domain;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void exportDomains() {

		for (int x = 0; x < currentProfile.getDomains().size(); x++) {
			currentProfile.getDomains().get(x).export();
		}

	}

	public File exportProfiles() {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			Element root = document.createElement("profiles");
			document.appendChild(root);


			Element profiles = document.createElement("profile");
			root.appendChild(profiles);

			Element profileName = document.createElement("profileName");
			profileName.setTextContent(currentProfile.getName().replace(' ', '-'));
			profiles.appendChild(profileName);

			Element threshold = document.createElement("threshold");
			threshold.setTextContent("_" + currentProfile.getThreshold());
			profiles.appendChild(threshold);

			Element order = document.createElement("order");
			order.setTextContent(currentProfile.getOrder() + "");
			profiles.appendChild(order);

			Element allQuestions = document.createElement("allQuestions");
			allQuestions.setTextContent(currentProfile.getPossible() + "");
			profiles.appendChild(allQuestions);

			Element questions = document.createElement("questions");
			profiles.appendChild(questions);
			System.out.println(currentProfile.getHashMap().keySet());
			for (int key : currentProfile.getHashMap().keySet()) {
				Element id = document.createElement("id");
				id.setTextContent("_" + key);
				questions.appendChild(id);

				Element numRight = document.createElement("numRight");
				numRight.setTextContent("_" + currentProfile.getHashMap().get(key)[0]);

				questions.appendChild(numRight);

				Element numAsked = document.createElement("numAsked");
				numAsked.setTextContent("_" + currentProfile.getHashMap().get(key)[1]);
				questions.appendChild(numAsked);

			}
			Element domains = document.createElement("domains");
			profiles.appendChild(domains);
			for (int x = 0; x < currentProfile.getDomains().size(); x++) {
				String interimName = currentProfile.getDomains().get(x).getDomainName()
						.replace(' ', '-').replace('/', '-');
				Element domainPath = document.createElement("domainPath");
				domainPath.setTextContent("Domains_" + interimName + ".xml");
				domains.appendChild(domainPath);
			}


			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("Profiles/profile1.xml"));
			transformer.transform(domSource, streamResult);
			System.out.println("Done creating XML File");
			return new File("Profiles/profile1.xml");
		} catch (ParserConfigurationException | TransformerException pce) {
			pce.printStackTrace();
		}
		return new File("Profiles/profile1.xml");
	}

	public void changeScreen(int screenID) {
		switch (screenID) {
		case 1:
			screen1 = new MainMenu("Quizit", this);
			frame.setContentPane(screen1);
			break;
		case 2:
			screen2 = new SelectProfile("Select Profile", this);
			frame.setContentPane(screen2);
			break;

		case 3:
			screen3 = new CreateProfile("Create Profile", this);
			frame.setContentPane(screen3);
			break;

		case 4:
			screen4 = new Options("Quizzing Options", this);
			frame.setContentPane(screen4);
			break;

		case 5:
			screen5 = new SelectDomain("Select Domain", this);
			frame.setContentPane(screen5);
			break;

		case 6:
			screen6 = new QuestionCard("", this);
			frame.setContentPane(screen6);
			break;

		case 7:
			screen7 = new ImportScreen("Import Domain", this);
			frame.setContentPane(screen7);
			break;

		case 8:
			screen8 = new EditDomain("Edit Domain", this);
			frame.setContentPane(screen8);
			break;

		case 9:
			screen9 = new ExportDomain("Export Domain", this);
			frame.setContentPane(screen9);
			break;

		case 10:
			screen10 = new DetachDomain("Detach Domain", this);
			frame.setContentPane(screen10);
			break;

		case 11:
			screen11 = new QuestionScreen("Create Question", this);
			frame.setContentPane(screen11);
			break;

		case 12:
			screen12 = new QuestionScreen("Edit Question", this);
			frame.setContentPane(screen12);
			break;

		}
		JPanel pane = (JPanel) frame.getContentPane();
		pane.revalidate();
		pane.repaint();
		frame.repaint();
	}
}

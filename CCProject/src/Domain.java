import java.io.*;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.util.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Domain {
	ArrayList<Question> questions = new ArrayList<Question>();
	String domainName;

	Domain(String name, ArrayList<Question> quest) {
		domainName = name;
		for (int i = 0; i < quest.size(); i++) {
			questions.add(quest.get(i));
		}
	}

	public Question getQuestion(int numQ) {
		return questions.get(numQ);
	}

	Domain(File file) {
		// import questions from xml file into each element of the array list questions
		/*
		 * 
		 * DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		 * DocumentBuilder db = dbf.newDocumentBuilder(); Document doc = db.parse(xml);
		 * doc.getDocumentElement().normalize(); Node profile =
		 * doc.getElementsByTagName("profile").item(0); Element pf = (Element) profile;
		 * NodeList qs = doc.getElementsByTagName("question"); for(int i = 0; i <
		 * qs.getLength(); i++) { Node question = qs.item(i); Element q = (Element)
		 * question;
		 * questions.put(Integer.parseInt(q.getElementsByTagName("id").item(0).
		 * getTextContent()), new int[]
		 * {Integer.parseInt(q.getElementsByTagName("numRight").item(0).getTextContent()
		 * ),
		 * Integer.parseInt(q.getElementsByTagName("numAsked").item(0).getTextContent())
		 * }); } NodeList ds = doc.getElementsByTagName("domainPath"); for(int i = 0; i
		 * < ds.getLength(); i++) { String domain = ds.item(i).getTextContent();
		 * domains.add(new Domain(new File(domain))); } } catch (Exception e) {}
		 */
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println(getDomainName() + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("student");
			// nodeList is not iterable, so we are using for loop
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("Student id: " + eElement.getElementsByTagName("id").item(0).getTextContent());
					System.out.println(
							"First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println(
							"Last Name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Subject: " + eElement.getElementsByTagName("subject").item(0).getTextContent());
					System.out.println("Marks: " + eElement.getElementsByTagName("marks").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteQuestion(int questionNum) {
		questions.remove(questionNum);
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public void setDomainName(String newName) {
		domainName = newName;
	}

	public int getDomainSize() {
		return questions.size();
	}

	public String getDomainName() {
		return "Name"+domainName;
	}

	public static final String xmlFilePath = "Domains/test.xml";

	public File export() {

		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			// root element
			Element root = document.createElement("domain");
			document.appendChild(root);

			Element name = document.createElement(getDomainName());
			root.appendChild(name);

			for (int i = 0; i < this.questions.size(); i++) {
				Element question = document.createElement("question");
				name.appendChild(question);

				Element id = document.createElement("id");
				id.setTextContent(this.questions.get(0).getID() + "");
				question.appendChild(id);

				Element ques = document.createElement("Question" + i);
				ques.setTextContent(questions.get(i).getQuestion());
				question.appendChild(ques);

				Element ans = document.createElement("Answer" + i);
				ans.setTextContent(questions.get(i).getAnswer());
				question.appendChild(ans);

				Element image = document.createElement("QuestionGraphic");
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			// If you use
			// StreamResult result = new StreamResult(System.out);
			// the output will be pushed to the standard output ...
			// You can use that for debugging

			transformer.transform(domSource, streamResult);
			System.out.println("Done creating XML File");
			return new File(xmlFilePath);
		} catch (

		ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return new File(xmlFilePath);
	}
}

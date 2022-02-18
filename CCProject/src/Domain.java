import java.io.*;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
	}

	public Question getQuestion(int numQ) {
		return questions.get(numQ);
	}

	Domain(File file) {
		// import questions from xml file into each element of the array list questions
		try {
			// creating a constructor of file class and parsing an XML file
			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
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

	public void deleteQuestion(int questionID) {
		questions.remove(questionID);
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public void setDomainName(String newName) {
		domainName = newName;
	}

	public String getDomainName() {
		return domainName;
	}

	public File export() {
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

		Document document = documentBuilder.newDocument();

		// root element
		Element root = document.createElement("company");
		document.appendChild(root);

		// employee element
		Element employee = document.createElement("employee");

		root.appendChild(employee);

		// set an attribute to staff element
		Attr attr = document.createAttribute("id");
		attr.setValue("10");
		employee.setAttributeNode(attr);

		// you can also use staff.setAttribute("id", "1") for this

		// firstname element
		Element firstName = document.createElement("firstname");
		firstName.appendChild(document.createTextNode("James"));
		employee.appendChild(firstName);

		// lastname element
		Element lastname = document.createElement("lastname");
		lastname.appendChild(document.createTextNode("Harley"));
		employee.appendChild(lastname);

		// email element
		Element email = document.createElement("email");
		email.appendChild(document.createTextNode("james@example.org"));
		employee.appendChild(email);

		// department elements
		Element department = document.createElement("department");
		department.appendChild(document.createTextNode("Human Resources"));
		employee.appendChild(department);

		// create the xml file
		// transform the DOM Object to an XML File
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

	}catch(

	ParserConfigurationException pce)
	{
		pce.printStackTrace();
	}catch(
	TransformerException tfe)
	{
		tfe.printStackTrace();
	}
}}

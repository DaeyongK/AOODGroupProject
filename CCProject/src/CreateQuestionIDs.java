import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateQuestionIDs {
	public static final String xmlFilePath = "QuestionIDs/questionIDs.xml";
	public static final String xmlFilePath1 = "QuestionIDs/questionIDs2.xml";
	public static final String xmlFilePath2 = "QuestionIDs/questionIDs3.xml";
	public static final String xmlFilePath3 = "QuestionIDs/questionIDs4.xml";
	public static final String xmlFilePath4 = "QuestionIDs/questionIDs5.xml";
	public static final String xmlFilePath5 = "QuestionIDs/questionIDs6.xml";
	public static final String xmlFilePath6 = "QuestionIDs/questionIDs7.xml";
	public static final String xmlFilePath7 = "QuestionIDs/questionIDs8.xml";
	public static final String xmlFilePath8 = "QuestionIDs/questionIDs9.xml";
	public static final String xmlFilePath9 = "QuestionIDs/questionIDs10.xml";

	public static void main(String args[]) {
		for (int i = 0; i < 10; i++) {
			try {
				DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

				DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

				Document document = documentBuilder.newDocument();

				// root element
				Element root = document.createElement("QuestionIDs");
				document.appendChild(root);

				for (int x = i * 100; x < (i + 1) * 100; x++) {
					Element ID = document.createElement("ID");
					ID.setTextContent(x + "");
					root.appendChild(ID);
				}

				// create the xml file
				// transform the DOM Object to an XML File
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource domSource = new DOMSource(document);
				// StreamResult result = new StreamResult(System.out);
				StreamResult streamResult;
				if (i == 0) {
					streamResult = new StreamResult(new File("QuestionIDs/questionIDs.xml"));
				} else {
					streamResult = new StreamResult(new File("QuestionIDs/questionIDs" + (i+1) + ".xml"));
				}

				// If you use
				// StreamResult result = new StreamResult(System.out);
				// the output will be pushed to the standard output ...
				// You can use that for debugging

				transformer.transform(domSource, streamResult);
				System.out.println("Done creating XML File");
			} catch (

			ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch (TransformerException tfe) {
				tfe.printStackTrace();
			}
		}
	}
}

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class Domain {
    private ArrayList<Question> questions = new ArrayList<>();
    private String domainName = "";

    Domain(String name, ArrayList<Question> quest) {
        domainName = name;
        questions.addAll(quest);
    }

    public Question getQuestion(int numQ) {
        return questions.get(numQ);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    // FOR TESTING PURPOSES ONLY ||||||
    // VVVVVV
    // Domain(File file) {
    // try {
    // DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    // DocumentBuilder db = dbf.newDocumentBuilder();
    // Document doc = db.parse(file);
    // doc.getDocumentElement().normalize();
    // NodeList dN1 = doc.getElementsByTagName("domain");
    // Node domain= dN1.item(0);
    // Element dom = (Element) domain;
    // NamedNodeMap nnm = dom.getAttributes();
    // Node dName = nnm.item(0);
    // String dNameHolder = dName.getTextContent();
    // domainName = dNameHolder.replace('-', ' ');
    // NodeList qs = doc.getElementsByTagName("question");
    //
    // for (int itr = 0; itr < qs.getLength(); itr++) {
    // //Node question = qs.item(itr);
    // Element q = (Element) question;
    // questions.add(new
    // Question(q.getElementsByTagName("Question"+(itr+1)).item(0).getTextContent()
    // ,q.getElementsByTagName("Answer"+(itr+1)).item(0).getTextContent(),q.getElementsByTagName("QuestionGraphic").item(0).getTextContent()));
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    // FOR TESTING PURPOSES ONLY ^^^^^^
    // ||||||

    Domain(File file, Quizit quiz) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList dN1 = doc.getElementsByTagName("domain");
            Node domain = dN1.item(0);
            Element dom = (Element) domain;
            NamedNodeMap nnm = dom.getAttributes();
            Node dName = nnm.item(0);
            String dNameHolder = dName.getTextContent();
            domainName = dNameHolder.replace('-', ' ');
            NodeList qs = doc.getElementsByTagName("question");

            for (int itr = 0; itr < qs.getLength(); itr++) {
                Node question = qs.item(itr);
                Element q = (Element) question;
                questions.add(new Question(q.getElementsByTagName("Question" + (itr + 1)).item(0).getTextContent(),
                        q.getElementsByTagName("Answer" + (itr + 1)).item(0).getTextContent(), 
                        q.getElementsByTagName("QuestionGraphic").item(0).getTextContent(), quiz));
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
        return domainName;
    }

    private String xmlFilePath2="";

    public File export() {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("domain");
            document.appendChild(root);

            String newDomainName = getDomainName().replace(' ', '-');
            xmlFilePath2="Domains/"+newDomainName+".xml";
            
            Attr dname = document.createAttribute("DomainName");
            dname.setTextContent(newDomainName);
            root.setAttributeNode(dname);

            for (int i = 0; i < this.questions.size(); i++) {
                Element question = document.createElement("question");
                root.appendChild(question);

                Element id = document.createElement("id");
                id.setTextContent(this.questions.get(i).getID() + "");
                question.appendChild(id);

                Element ques = document.createElement("Question" + (i + 1));
                ques.setTextContent(questions.get(i).getQuestion());
                question.appendChild(ques);

                Element ans = document.createElement("Answer" + (i + 1));
                ans.setTextContent(questions.get(i).getAnswer());
                question.appendChild(ans);

                Element image = document.createElement("QuestionGraphic");
                image.setTextContent(questions.get(i).getGraphicPath());
                question.appendChild(image);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath2));
            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
            return new File(xmlFilePath2);
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
        return new File(xmlFilePath2);
    }
}

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;
public class readingXML {
    public static void main(String args[]) {
        try {
            System.out.println("Printing XML stuff");
            File file = new File("sampleProfile.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            Node profile = doc.getElementsByTagName("profile").item(0);
            Element pf = (Element) profile;
            System.out.println("Name: " + pf.getElementsByTagName("profileName").item(0).getTextContent());
            System.out.println("Threshold: " + pf.getElementsByTagName("threshold").item(0).getTextContent());
            System.out.println("Image: " + pf.getElementsByTagName("image").item(0).getTextContent());
            System.out.println("Order: " + pf.getElementsByTagName("order").item(0).getTextContent());
            System.out.println("All Questions: " + pf.getElementsByTagName("allQuestions").item(0).getTextContent());
            NodeList questions = doc.getElementsByTagName("question");
            LinkedHashMap<Integer, int[]> map = new LinkedHashMap<Integer, int[]>();
            for(int i = 0; i < questions.getLength(); i++) {
                Node question = questions.item(i);
                Element q = (Element) question;
                map.put(Integer.parseInt(q.getElementsByTagName("id").item(0).getTextContent()),
                new int[] {Integer.parseInt(q.getElementsByTagName("numRight").item(0).getTextContent()),
                Integer.parseInt(q.getElementsByTagName("numAsked").item(0).getTextContent())});
            }
            for (Integer name: map.keySet()) {
                String values = Arrays.toString(map.get(name));
                System.out.println(name.toString() + " " + values);
            }
            NodeList domains = doc.getElementsByTagName("domainPath");
            ArrayList<Domain> domains = new ArrayList<Domain>();
            for(int i = 0; i < domains.getLength(); i++) {
                String domain = domains.item(i).getTextContent();
                domains.add(new Domain(new File(domain)));
            }
        } catch (Exception e) {
            System.out.println("I'm so sorry if you see this Ms. Gerb");
        }
    }
}
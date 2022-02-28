import java.util.*;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class Profile {
    private String profileName;
    private int threshold, image;
    private boolean order = false;
    private boolean allQuestions = true;
    private LinkedHashMap<Integer, int[]> questions = new LinkedHashMap<Integer, int[]>();
    private ArrayList<Domain> domains = new ArrayList<Domain>();
    Profile(String profileName, int imageIndex) {
        this.profileName = profileName;
        image = imageIndex;
    }
    Profile(File xml, Quizit quizit) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);
            doc.getDocumentElement().normalize();
            Node profile = doc.getElementsByTagName("profile").item(0);
            Element pf = (Element) profile;
            NodeList qs = doc.getElementsByTagName("question");
            for(int i = 0; i < qs.getLength(); i++) {
                Node question = qs.item(i);
                Element q = (Element) question;
                questions.put(Integer.parseInt(q.getElementsByTagName("id").item(0).getTextContent()),
                new int[] {Integer.parseInt(q.getElementsByTagName("numRight").item(0).getTextContent()),
                Integer.parseInt(q.getElementsByTagName("numAsked").item(0).getTextContent())});
            }
            NodeList ds = doc.getElementsByTagName("domainPath");
            for(int i = 0; i < ds.getLength(); i++) {
                String domain = ds.item(i).getTextContent();
                domains.add(new Domain(new File(domain), quizit));
            }
            profileName = doc.getElementsByTagName("profileName").item(0).getTextContent();
            threshold = Integer.parseInt(doc.getElementsByTagName("threshold").item(0).getTextContent());
            image = Integer.parseInt(doc.getElementsByTagName("image").item(0).getTextContent());
        } catch (Exception e) {}
    }
    public String getName() {
        return profileName;
    }
    public ArrayList<Domain> getDomains() {
        return domains;
    }
    public LinkedHashMap<Integer, int[]> getHashMap() {return questions;}
    public void detachDomain(Domain domain) {
        boolean notRemoved = true;
        int i = 0;
        while(notRemoved) {
            if(domain == domains.get(i)) {
                notRemoved = false;
                domains.remove(i);
            }
            i++;
        }
    }
    public void changeImage(int imageIndex) {
        image = imageIndex;
    }
    public void answeredCorrectly(int questionID) {
        questions.get(questionID)[0] += 1;
    }
    public void asked(int questionID) {
        questions.get(questionID)[1] += 1;
    }
    public int getAnsweredRight(int questionID) {
        return questions.get(questionID)[0];
    }
    public int getTimesAsked(int questionID) {
        return questions.get(questionID)[1];
    }
    public void setNumCorrect(int questionID, int numberRight) {
        questions.get(questionID)[0] = numberRight;
    }
    public void setNumAsked(int questionID, int numberAsked) {
        questions.get(questionID)[1] = numberAsked;
    }
    public void setPossQuestions(boolean allQ) {
        allQuestions = allQ;
    }
    public boolean getPossible() {
        return allQuestions;
    }
    public void setOrderQuestions(boolean rand) {
        order = rand;
    }
    public boolean getOrder() {
        return order;
    }
    public void setThreshold(int thresh) {
        threshold = thresh;
    }
    public int getThreshold() {
        return threshold;
    }
    public void addDomain(Domain domain) {
        domains.add(domain);
    }
}

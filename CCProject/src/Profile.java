import java.util.*;
public class Profile {
    private String profileName;
    private int threshold, image;
    private boolean order = false;
    private boolean allQuestions = true;
    private HashMap<Integer, int[]> questions = new HashMap<Integer, int[]>();
    private ArrayList<Domain> domains = new ArrayList<Domain>();
    Profile(String profileName, int imageIndex) {
        this.profileName = profileName;
        image = imageIndex;
    }

    public String getName() {
        return profileName;
    }
    public ArrayList<Domain> getDomains() {
        return domains;
    }
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

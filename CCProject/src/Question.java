import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Question {
    private String questionString;
    private String answerString;
    private String graphicString;
    private BufferedImage graphic;
    private int ID,tempID ;

    // FOR TESTING PURPOSES ONLY |||||
    // VVVVV
    //
    // Question(String question, String answer) {
    // questionString = question;
    // // answerString = answer;
    // graphicString=null;
    // int tempID = (int) (Math.random() * 1000000000);
    // ID= tempID;
    // }

    // Question(String question, String answer, String imagePath) {
    // questionString = question;
    // answerString = answer;
    // this.setImage(imagePath);
    // int tempID = (int) (Math.random() * 1000000000);
    // ID= tempID;
    // }

    // ^^^^^^
    // FOR TESTING PURPOSES ONLY ||||||

    Question() {
        questionString = "";
        answerString = "";
        graphicString = "";
        ID = -1;
    }

    Question(String question, String answer, Quizit quiz) {
        questionString = question;
        answerString = answer;
        graphicString = "";
        tempID = (int) (Math.random() * 1000000000);
        while (quiz.getProfile().getHashMap().containsKey(tempID)) {
            tempID = (int) (Math.random() * 1000000000);
        }
        ID = tempID;
        quiz.getProfile().addQuestion(ID, new int[] {0,0});
        quiz.getDomain().addQuestion(this);
    }

    Question(String question, String answer, String imagePath, int questID, Quizit quiz) {
        questionString = question;
        answerString = answer;
        graphicString = imagePath;
        ID=questID;
        
    }
    
    Question(String question, String answer, String imagePath, Quizit quiz) {
        questionString = question;
        answerString = answer;
        graphicString=imagePath;
        this.setImage(imagePath);
        tempID = (int) (Math.random() * 1000000000);
        while (quiz.getProfile().getHashMap().containsKey(tempID)) {
            tempID = (int) (Math.random() * 1000000000);
        }
        ID = tempID;
        quiz.getProfile().addQuestion(ID, new int[] {0,0});
        quiz.getDomain().addQuestion(this);
    }

    public boolean setImage(String imagePath) {
        try {
            graphicString = imagePath;
            graphic = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public void detachImage() {
    	graphicString=null;
        graphic = null;
    }

    public BufferedImage getImage() {
        return graphic;
    }

    public String getGraphicPath() {
        return graphicString;
    }

    public String getQuestion() {
        return questionString;
    }

    public String getAnswer() {
        return answerString;
    }

    public int getID() {
        return ID;
    }

    public void setQuestion(String question) {
        questionString = question;
    }

    public void setAnswer(String answer) {
        answerString = answer;
    }

}

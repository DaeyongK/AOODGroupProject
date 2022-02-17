import java.io.*;
import java.util.*;

public class Domain {
	ArrayList<Question> questions=new ArrayList<Question>();
	String domainName;
	
	Domain(String name, ArrayList<Question> quest){
		domainName=name;
	}
	
	Domain(File file){
		//import questions from xml file into each element of the array list questions
	}
	
	public void deleteQuestion(int questionID) {
		questions.remove(questionID);
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	public void setDomainName(String newName) {
		domainName=newName;
	}
	
	public String getDomainName() {
		return domainName;
	}
	
	public File export() {
		
	}
}

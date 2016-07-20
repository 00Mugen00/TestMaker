package TestMakerGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMaker {
	private Connection dataBaseConnection;
	private ResultSet questionsAnswers;
	private boolean hasNext;
	public TestMaker(){
		hasNext=false;
		try {
			dataBaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?autoReconnect=true&useSSL=false","student","student");
			Statement statement = dataBaseConnection.createStatement();
			questionsAnswers = statement.executeQuery("SELECT * FROM questionsanswers");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean nextQuestionAnswers(){
		try {
			hasNext=questionsAnswers.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hasNext;
	}
	public String nextQuestion() throws SQLException{
		if(!hasNext){
			throw new RuntimeException("ERROR. No more questions");
		}
		return questionsAnswers.getString("Question");
	}
	
	public String nextAnswer1() throws SQLException{
		if(!hasNext){
			throw new RuntimeException("ERROR. No more answer1");
		}
		return questionsAnswers.getString("Answer1");
	}
	public String nextAnswer2() throws SQLException{
		if(!hasNext){
			throw new RuntimeException("ERROR. No more answer2");
		}
		return questionsAnswers.getString("Answer2");
	}
	public String nextAnswer3() throws SQLException{
		if(!hasNext){
			throw new RuntimeException("ERROR. No more answer3");
		}
		return questionsAnswers.getString("Answer3");
	}
	public String nextAnswer4() throws SQLException{
		if(!hasNext){
			throw new RuntimeException("ERROR. No more answer4");
		}
		return questionsAnswers.getString("Answer4");
	}
	
}

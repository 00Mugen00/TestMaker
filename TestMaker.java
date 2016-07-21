package TestMakerGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMaker {
	private Connection dataBaseConnection;
	private ResultSet questionsAnswers;
	private boolean hasQuestion;
	public TestMaker(){
		hasQuestion=false;
		try {
			dataBaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false","student","student");
			Statement statement = dataBaseConnection.createStatement();
			questionsAnswers = statement.executeQuery("SELECT * FROM mydb.Question");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean nextQuestionAnswers(){
		try {
			if(questionsAnswers.isLast()){
				hasQuestion=false;
			}else{
				hasQuestion=questionsAnswers.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			hasQuestion=false;
		}
		return hasQuestion;
	}
	public boolean previousQuestionAnswers(){
		try{
			if(questionsAnswers.isFirst()){
				hasQuestion=false;
			}else{
				hasQuestion=questionsAnswers.previous();
			}
		}catch (SQLException e) {
			e.printStackTrace();
			hasQuestion=false;
		}
		return hasQuestion;
	}
	public String getQuestion() throws SQLException{
		if(!hasQuestion){
			throw new RuntimeException("ERROR. No more questions");
		}
		return questionsAnswers.getString("Question");
	}
	
	public String getAnswer1() throws SQLException{
		if(!hasQuestion){
			throw new RuntimeException("ERROR. No more answer1");
		}
		return questionsAnswers.getString("Answer1");
	}
	public String getAnswer2() throws SQLException{
		if(!hasQuestion){
			throw new RuntimeException("ERROR. No more answer2");
		}
		return questionsAnswers.getString("Answer2");
	}
	public String getAnswer3() throws SQLException{
		if(!hasQuestion){
			throw new RuntimeException("ERROR. No more answer3");
		}
		return questionsAnswers.getString("Answer3");
	}
	public String getAnswer4() throws SQLException{
		if(!hasQuestion){
			throw new RuntimeException("ERROR. No more answer4");
		}
		return questionsAnswers.getString("Answer4");
	}
	
	public int getCorrectAnswer() throws SQLException{
		if(!hasQuestion){
			throw new RuntimeException("ERROR. No more answer4");
		}
		return questionsAnswers.getInt("CorrectAnswer");
	}
	
}

package TestMakerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by johncarlo on 7/11/2016.
 */
public class TestMakerCtr implements ActionListener{
    private TestMakerView testMakerView;
    private TestMaker testMaker;
    private int correctAnswer;
    public TestMakerCtr(TestMakerView testMakerView,TestMaker testMaker){
        this.testMakerView= testMakerView;
        this.testMaker=testMaker;
        this.correctAnswer=0;
        boolean hasNext=testMaker.nextQuestionAnswers();
        if(hasNext){
    		try {
    			correctAnswer=testMaker.getCorrectAnswer();
				testMakerView.changeQuestion(testMaker.getQuestion(), testMaker.getAnswer1(), testMaker.getAnswer2(), testMaker.getAnswer3(), testMaker.getAnswer4());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    	}else{
    		correctAnswer=0;
    		testMakerView.changeQuestion("Question","Answer1","Answer2","Answer3","Answer4");
    		System.out.println("No more tests");
    	}
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "NEXT":
            	nextQuestion();
                break;
            case "PREVIOUS":
            	previousQuestion();
                break;
            case "CHECK":
                testMakerView.check(correctAnswer);
                break;
            default:
                break;
        }
    }
    
    private void nextQuestion(){
    	testMakerView.setMessage("Test in Progress");
    	boolean hasNext=testMaker.nextQuestionAnswers();
    	if(hasNext){
    		try {
    			correctAnswer=testMaker.getCorrectAnswer();
				testMakerView.changeQuestion(testMaker.getQuestion(), testMaker.getAnswer1(), testMaker.getAnswer2(), testMaker.getAnswer3(), testMaker.getAnswer4());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    	}
    }
    
    private void previousQuestion(){
    	testMakerView.setMessage("Test in Progress");
    	boolean hasPrevious=testMaker.previousQuestionAnswers();
    	if(hasPrevious){
    		try {
    			correctAnswer=testMaker.getCorrectAnswer();
				testMakerView.changeQuestion(testMaker.getQuestion(), testMaker.getAnswer1(), testMaker.getAnswer2(), testMaker.getAnswer3(), testMaker.getAnswer4());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    	}
    }
}

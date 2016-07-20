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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "NEXT":
            	boolean hasNext=testMaker.nextQuestionAnswers();
            	if(hasNext){
            		try {
            			correctAnswer=testMaker.getRealAnswer();
            			testMakerView.check(testMaker.getRealAnswer());
						testMakerView.changeQuestion(testMaker.nextQuestion(), testMaker.nextAnswer1(), testMaker.nextAnswer2(), testMaker.nextAnswer3(), testMaker.nextAnswer4());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
            	}else{
            		correctAnswer=0;
            		testMakerView.changeQuestion("Question","Answer1","Answer2","Answer3","Answer4");
            		System.out.println("No more tests");
            	}
                break;
            case "PREVIOUS":
                break;
            case "CHECK":
                testMakerView.check(correctAnswer);
                break;
            default:
                break;
        }
    }
}

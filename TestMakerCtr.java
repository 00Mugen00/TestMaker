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
    public TestMakerCtr(TestMakerView testMakerView,TestMaker testMaker){
        this.testMakerView= testMakerView;
        this.testMaker=testMaker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "NEXT":
            	boolean hasNext=testMaker.nextQuestionAnswers();
            	if(hasNext){
            		try {
						testMakerView.changeQuestion(testMaker.nextQuestion(), testMaker.nextAnswer1(), testMaker.nextAnswer2(), testMaker.nextAnswer3(), testMaker.nextAnswer4());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
            	}else{
            		testMakerView.changeQuestion("Question","Answer1","Answer2","Answer3","Answer4");
            		System.out.println("No more tests");
            	}
                break;
            case "PREVIOUS":
                break;
            case "CHECK":
                testMakerView.check(1);
                break;
            default:
                break;
        }
    }
}

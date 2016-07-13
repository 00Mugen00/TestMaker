package TestMakerGUI;

import java.awt.event.ActionListener;

/**
 * Created by johncarlo on 7/11/2016.
 */
public interface TestMakerView {
    String PREVIOUS= "PREVIOUS";
    String NEXT= "NEXT";
    String CHECK= "CHECK";
    //String ANSWER1 = "ANSWER1";
    //String ANSWER2 = "ANSWER2";
    //String ANSWER3 = "ANSWER3";
    //String ANSWER4 = "ANSWER4";
    void setQuestion(String question);
    void setAnswer1(String answer1);
    void setAnswer2(String answer2);
    void setAnswer3(String answer3);
    void setAnswer4(String answer4);
    void check(int correctAnswer);
    void controller(ActionListener ctr);
    void enableButtons(Boolean state);
    void changeQuestion(String question,String answer1,String answer2,String answer3,String answer4);
}

package TestMakerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by johncarlo on 7/11/2016.
 */
public class TestMakerPanel1 extends JPanel implements TestMakerView{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton answer1;
    private JRadioButton answer2;
    private JRadioButton answer3;
    private JRadioButton answer4;
    private ButtonGroup radioButtons;
    private JTextField question;
    private JLabel message;
    private JButton previous;
    private JButton next;
    private JButton check;
    public TestMakerPanel1(){
        //Initialize all variables
        answer1 = new JRadioButton("Question",false);
        answer2 = new JRadioButton("Answer1",false);
        answer3 = new JRadioButton("Answer2",false);
        answer4 = new JRadioButton("Answer3",false);
        for(int i=1; i<5; i++){
            changeColor(i,Color.white);
        }
        radioButtons= new ButtonGroup();
        radioButtons.add(answer1);
        radioButtons.add(answer2);
        radioButtons.add(answer3);
        radioButtons.add(answer4);
        question = new JTextField("Llegaremos al final?");
        question.setEditable(false);
        previous = new JButton("PREVIOUS");
        check = new JButton("CHECK");
        next = new JButton("NEXT");
        message=new JLabel("Test In Progress");
        //Set layout of the GUI
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(new JLabel("Question"));
        northPanel.add(question);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,1));
        centerPanel.add(answer1);
        centerPanel.add(answer2);
        centerPanel.add(answer3);
        centerPanel.add(answer4);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));
        southPanel.add(buttonPanel,BorderLayout.CENTER);
        JPanel messagePanel = new JPanel();
        southPanel.add(messagePanel,BorderLayout.SOUTH);
        buttonPanel.add(previous);
        buttonPanel.add(check);
        buttonPanel.add(next);
        messagePanel.add(message);

        add(northPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
        add(southPanel,BorderLayout.SOUTH);
    }

    public void controller(ActionListener ctr){
        previous.addActionListener(ctr);
        previous.setActionCommand(PREVIOUS);
        check.addActionListener(ctr);
        check.setActionCommand(CHECK);
        next.addActionListener(ctr);
        next.setActionCommand(NEXT);
    }

    public void setQuestion(String question) {
        this.question.setText(question);
    }

    public void setAnswer1(String answer1) {
        this.answer1.setText(answer1);
    }

    public void setAnswer2(String answer2) {
        this.answer2.setText(answer2);
    }

    public void setAnswer3(String answer3) {
        this.answer3.setText(answer3);
    }

    public void setAnswer4(String answer4) {
        this.answer4.setText(answer4);
    }

    public int getAnswer(){
        if(radioButtons.getSelection().equals(answer1.getModel())){
            return 1;
        }else if(radioButtons.getSelection().equals(answer2.getModel())){
            return 2;
        }else if(radioButtons.getSelection().equals(answer3.getModel())){
            return 3;
        }else if(radioButtons.getSelection().equals(answer4.getModel())){
            return 4;
        }
        return 0;
    }

    public void check(int correctAnswer){
        try{
            if(correctAnswer==getAnswer()){
                changeColor(correctAnswer,Color.green);
            }else{
                changeColor(correctAnswer,Color.green);
                changeColor(getAnswer(),Color.red);
            }
            enableButtons(false);
        }catch(NullPointerException e){
            message.setText("ERROR. Please Input Answer");
        }
    }

    public void enableButtons(Boolean state){
        answer1.setEnabled(state);
        answer2.setEnabled(state);
        answer3.setEnabled(state);
        answer4.setEnabled(state);
    }

    public void changeColor(int answer,Color color){
        switch(answer){
            case 1:
                answer1.setBackground(color);
                break;
            case 2:
                answer2.setBackground(color);
                break;
            case 3:
                answer3.setBackground(color);
                break;
            case 4:
                answer4.setBackground(color);
                break;
        }
    }

    public void changeQuestion(String question,String answer1,String answer2,String answer3,String answer4){
        setQuestion(question);
        setAnswer1(answer1);
        setAnswer2(answer2);
        setAnswer3(answer3);
        setAnswer4(answer4);
        enableButtons(true);
        for(int i=1; i<5; i++){
            changeColor(i,Color.white);
        }
    }
}

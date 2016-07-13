package TestMakerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by johncarlo on 7/11/2016.
 */
public class TestMakerCtr implements ActionListener{
    private TestMakerView testMakerView;
    public TestMakerCtr(TestMakerView testMakerView){
        this.testMakerView= testMakerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "NEXT":
                testMakerView.changeQuestion("Pregunta","respuesta 1","respuesta 2","respuesta 3","respuesta 4");
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

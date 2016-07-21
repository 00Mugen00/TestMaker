package TestMakerPackage;

import TestMakerGUI.TestMaker;
import TestMakerGUI.TestMakerCtr;
import TestMakerGUI.TestMakerPanel1;
import TestMakerGUI.TestMakerView;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by johncarlo on 7/11/2016.
 */
public class TestMakerDemo {
    public static void main(String[] agrs){
    	TestMaker testMaker = new TestMaker();
        TestMakerView testMakerView = new TestMakerPanel1();
        TestMakerCtr testMakerCtr = new TestMakerCtr(testMakerView,testMaker);
        testMakerView.controller(testMakerCtr);
        JFrame window = new JFrame("TestMaker");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane((JPanel) testMakerView);
        window.pack();
        window.setMinimumSize(new Dimension(300,300));
        window.setVisible(true);
    }
}

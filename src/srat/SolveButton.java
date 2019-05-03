package srat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class SolveButton extends JButton implements ActionListener{
    public String [] answersFromProlog;
    private final ArrayList<Question> questions;

    public SolveButton(String[] answersFromProlog, ArrayList<Question> questions) {
        super("Solve");
        addActionListener(this);
        this.answersFromProlog = answersFromProlog;
        this.questions = questions;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        int index = 0;
        for(String answer : answersFromProlog)
        {
            switch(answer)
            {
                case "A":
                    questions.get(index).optionA.setSelected(true);
                    break;
                case "B":
                    questions.get(index).optionB.setSelected(true);
                    break;
                case "C":
                    questions.get(index).optionC.setSelected(true);
                    break;
                case "D":
                    questions.get(index).optionD.setSelected(true);
                    break;    
                case "E":
                    questions.get(index).optionE.setSelected(true);
                    break;
            }
            index++;
        }     
 
    }
}

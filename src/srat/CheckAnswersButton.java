package srat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.UIManager;

public class CheckAnswersButton extends JButton implements ActionListener {

    private final String[] answers = {"C", "A", "B", "B", "A", "B", "E", "B", "E", "D"};
    private final ArrayList<Question> questions;

    public CheckAnswersButton(ArrayList<Question> questions) {
        super("Check answers");
        addActionListener(this);
        this.questions = questions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = 0;
        for (String answer : answers) {
            questions.get(index).optionA.setBackground(UIManager.getColor ( "Panel.background" ));
            questions.get(index).optionB.setBackground(UIManager.getColor ( "Panel.background" ));
            questions.get(index).optionC.setBackground(UIManager.getColor ( "Panel.background" ));
            questions.get(index).optionD.setBackground(UIManager.getColor ( "Panel.background" ));
            questions.get(index).optionE.setBackground(UIManager.getColor ( "Panel.background" ));
            switch (answer) {
                case "A":
                    if (questions.get(index).optionA.isSelected()) {
                        questions.get(index).optionA.setBackground(Color.green);
                    } else {
                        selectTheError(questions.get(index));
                    }
                    break;
                case "B":
                    if (questions.get(index).optionB.isSelected()) {
                        questions.get(index).optionB.setBackground(Color.green);
                    } else {
                        selectTheError(questions.get(index));
                    }
                    break;
                case "C":
                    if (questions.get(index).optionC.isSelected()) {
                        questions.get(index).optionC.setBackground(Color.green);
                    } else {
                        selectTheError(questions.get(index));
                    }
                    break;
                case "D":
                    if (questions.get(index).optionD.isSelected()) {
                        questions.get(index).optionD.setBackground(Color.green);
                    } else {
                        selectTheError(questions.get(index));
                    }
                    break;
                case "E":
                    if (questions.get(index).optionE.isSelected()) {
                        questions.get(index).optionE.setBackground(Color.green);
                    } else {
                        selectTheError(questions.get(index));
                    }
                    break;
            }
            index++;
        }
        this.setSelected(false);
    }

    private void selectTheError(Question q) {
        if (q.optionA.isSelected()) {
            q.optionA.setBackground(Color.red);
        }
        if (q.optionB.isSelected()) {
            q.optionB.setBackground(Color.red);
        }
        if (q.optionC.isSelected()) {
            q.optionC.setBackground(Color.red);
        }
        if (q.optionD.isSelected()) {
            q.optionD.setBackground(Color.red);
        }
        if (q.optionE.isSelected()) {
            q.optionE.setBackground(Color.red);
        }
    }
}

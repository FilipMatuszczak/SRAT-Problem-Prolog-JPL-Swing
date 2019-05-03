package srat;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Question {

    public JLabel questionContent;
    public JRadioButton optionA;
    public JRadioButton optionB;
    public JRadioButton optionC;
    public JRadioButton optionD;
    public JRadioButton optionE;

    public Question(
            String question,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            String optionE) {
        this.questionContent = new JLabel(question);
        this.optionA = new JRadioButton(optionA);
        this.optionB = new JRadioButton(optionB);
        this.optionC = new JRadioButton(optionC);
        this.optionD = new JRadioButton(optionD);
        this.optionE = new JRadioButton(optionE);
        ButtonGroup bg = new ButtonGroup();
        bg.add(this.optionA);
        bg.add(this.optionB);
        bg.add(this.optionC);
        bg.add(this.optionD);
        bg.add(this.optionE);
    }

    
}

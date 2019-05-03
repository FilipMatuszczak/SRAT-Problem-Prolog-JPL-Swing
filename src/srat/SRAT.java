package srat;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class SRAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JFrame frame = new JFrame("SRAT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        QuestionsProvider qp = new QuestionsProvider();
        ArrayList<Question> questions = qp.getQuestions();
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JScrollPane scroll = new JScrollPane(jpanel);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        AnswersProvider ap = new AnswersProvider();
        SolveButton sb = new SolveButton(ap.getAnswers(), questions);
        CheckAnswersButton cab = new CheckAnswersButton(questions);
        for (Question q : questions) {
            jpanel.add(q.questionContent);
            jpanel.add(q.optionA);
            jpanel.add(q.optionB);
            jpanel.add(q.optionC);
            jpanel.add(q.optionD);
            jpanel.add(q.optionE);
            jpanel.add(new JToolBar.Separator());
        }
        sb.setText("Solve!");
        jpanel.add(sb);
        jpanel.add(cab);
        frame.add(scroll);
        frame.setVisible(true);

    }

}

package srat;

import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

public class AnswersProvider {

    public String[] getAnswers() {
        String[] answers = new String[10];

        Variable Q1 = new Variable("Q1");
        Variable Q2 = new Variable("Q2");
        Variable Q3 = new Variable("Q3");
        Variable Q4 = new Variable("Q4");
        Variable Q5 = new Variable("Q5");
        Variable Q6 = new Variable("Q6");
        Variable Q7 = new Variable("Q7");
        Variable Q8 = new Variable("Q8");
        Variable Q9 = new Variable("Q9");
        Variable Q10 = new Variable("Q10");
        
        String projectDir = System.getProperty("user.dir");
        projectDir = projectDir.replace("\\", "/");
        Query q1 = new Query("consult('" + projectDir + "/src/srat/start.pl')");
        System.out.println("consult " + (q1.hasSolution() ? "succeeded" : "failed"));

        Query q2
                = new Query(
                        "f",
                        new Term[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10}
                );

        Map<String, Term> solution;

        while (q2.hasMoreSolutions()) {
            solution = q2.nextSolution();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < 11; i++) {
                sb.append("Q");
                sb.append(i);
                String answer = solution.get(sb.toString()).toString();
                String formated = formatTerm(answer);
                try {
                    answers[i - 1] = interpretZeroOnes(formated);
                } catch (Exception ex) {
                    System.err.println("Invalid answer " + formated);
                }
                sb.setLength(0);
            }
        }

        return answers;
    }

    private String formatTerm(String term) {
        String[] output = term.split("'\\[\\|\\]'\\(|\\, \\'\\[\\]\\'\\)\\)\\)\\)\\)");
        StringBuilder sb = new StringBuilder();
        for (String x : output) {
            if (!x.equals("")) {
                sb.append(x);
            }

        }

        return sb.toString();
    }

    private String interpretZeroOnes(String unformatted) throws Exception {
        switch (unformatted) {
            case "1, 0, 0, 0, 0": {
                return "A";
            }
            case "0, 1, 0, 0, 0": {
                return "B";
            }
            case "0, 0, 1, 0, 0": {
                return "C";
            }
            case "0, 0, 0, 1, 0": {
                return "D";
            }
            case "0, 0, 0, 0, 1": {
                return "E";
            }
            default:
                throw new Exception();
        }
    }
}

package srat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionsProvider {

    public QuestionsProvider() {
    }

    public ArrayList<Question> getQuestions() {
        ArrayList<Question> arr = new ArrayList<>();
        fillQuestionList(arr);
        return arr;
    }

    private void fillQuestionList(ArrayList<Question> list) {
        String fileName = "questions.txt";
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean even = true;
            while ((line = br.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                if (even) {
                    questions.add(line);
                    even = false;
                } else {
                    answers.add(line);
                    even = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < questions.size(); i++) {
            String[] output = answers.get(i).split("\\(");
            ArrayList<String> currAnswers = new ArrayList<>();
            for (String x : output) {
                if (!x.equals("")) {
                    currAnswers.add(x);
                }
            }
            list.add(new Question(questions.get(i), currAnswers.get(0), currAnswers.get(1), currAnswers.get(2), currAnswers.get(3), currAnswers.get(4)));
        }
    }
}

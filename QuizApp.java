import java.util.*;

public class QuizApp {

    // Inner class to represent a quiz question
    static class Question {
        String question;
        String[] options;
        char correctAnswer;

        public Question(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public void display() {
            System.out.println(question);
            char optionLabel = 'A';
            for (String option : options) {
                System.out.println(optionLabel + ". " + option);
                optionLabel++;
            }
        }

        public boolean checkAnswer(char answer) {
            return Character.toUpperCase(answer) == Character.toUpperCase(correctAnswer);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Add quiz questions
        questions.add(new Question("What is the capital of France?",
                new String[]{"Paris", "Rome", "Berlin", "Madrid"}, 'A'));
        questions.add(new Question("Which language is used for Android development?",
                new String[]{"Python", "Java", "C#", "Swift"}, 'B'));
        questions.add(new Question("What does JVM stand for?",
                new String[]{"Java Very Machine", "Java Virtual Machine", "Just Virtual Machine", "Java Verified Mode"}, 'B'));

        int score = 0;

        System.out.println("===== Welcome to the Quiz App =====\n");

        // Loop through all questions
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1));
            questions.get(i).display();

            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = scanner.next().charAt(0);

            if (questions.get(i).checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! The correct answer was: " + questions.get(i).correctAnswer + "\n");
            }
        }

        // Show final result
        System.out.println("===== Quiz Over! =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println(" Excellent!");
        } else if (score >= questions.size() / 2) {
            System.out.println(" Good Job!");
        } else {
            System.out.println("� Keep Practicing!");
        }
    }
}

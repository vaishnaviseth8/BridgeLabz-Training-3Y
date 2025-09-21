package ScenarioBasedQues;

import java.util.*;

public class EduMentorPlatform {
    public static void main(String[] args) {
        Instructor inst = new Instructor("Dr. Smith", "smith@edumentor.com", "I100");

        List<String> questions = Arrays.asList(
                "What is 2+2?",
                "What color is the sky?",
                "Capital of France?"
        );
        List<String> answers = Arrays.asList("4", "blue", "Paris");

        Quiz quiz = new Quiz(questions, answers, 1);

        Learner learner = new Learner("Alice", "alice@learner.com", "L200", false);

        List<String> aliceAnswers = Arrays.asList("4", "Blue", "paris");
        quiz.evaluate(aliceAnswers);

        learner.completeQuiz(quiz);

        System.out.println("Quiz Score: " + quiz.getScore() + "%");
        System.out.println("Average Score: " + learner.calculateAverageScore() + "%");
        System.out.println(learner.generateCertificate());
    }
}

interface ICertifiable {
    String generateCertificate();
}

abstract class User {
    private String name;
    private String email;
    private String userId;

    public User(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }
}

class Learner extends User implements ICertifiable {
    private List<Quiz> completedQuizzes;
    private boolean fullTime;

    public Learner(String name, String email, String userId, boolean fullTime) {
        super(name, email, userId);
        this.completedQuizzes = new ArrayList<>();
        this.fullTime = fullTime;
    }

    public void completeQuiz(Quiz quiz) {
        completedQuizzes.add(quiz);
    }

    public double calculateAverageScore() {
        if (completedQuizzes.isEmpty()) return 0.0;
        double total = 0;
        for (Quiz q : completedQuizzes) {
            total += q.getScore();
        }
        return total / completedQuizzes.size();
    }

    @Override
    public String generateCertificate() {
        if (fullTime) {
            return "Full-Time Certificate for " + getName();
        } else {
            return "Short Course Certificate for " + getName();
        }
    }
}

class Instructor extends User {
    public Instructor(String name, String email, String userId) {
        super(name, email, userId);
    }
}

class Quiz {
    private List<String> questions;
    private List<String> answers;
    private double score; // score out of 100
    private final boolean answersLocked;

    public Quiz(List<String> questions, List<String> answers, int difficulty) {
        if (questions.size() != answers.size()) {
            throw new IllegalArgumentException("Questions and answers count mismatch");
        }
        this.questions = new ArrayList<>(questions);
        this.answers = Collections.unmodifiableList(new ArrayList<>(answers));
        this.score = 0.0;
        this.answersLocked = true;
    }

    public List<String> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public List<String> getAnswers() {
        return answers;
    }

    public double getScore() {
        return score;
    }

    public void evaluate(List<String> userAnswers) {
        if (userAnswers.size() != answers.size()) {
            throw new IllegalArgumentException("User answers count mismatch");
        }
        int correct = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equalsIgnoreCase(userAnswers.get(i))) {
                correct++;
            }
        }
        score = ((double) correct / answers.size()) * 100.0;
    }
}


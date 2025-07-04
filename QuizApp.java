import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class QuizApp {
    private static class Question {
        String questionText;
        String[] originalOptions;
        int correctAnswerIndex;
        private static Random rand = new Random();

        Question(String questionText, String[] originalOptions, int correctAnswerIndex) {
            this.questionText = questionText;
            this.originalOptions = originalOptions.clone();
            this.correctAnswerIndex = correctAnswerIndex;
        }

        String[] getShuffledOptions() {
            int newCorrectIndex = rand.nextInt(4);
            String[] shuffledOptions = new String[4];
            ArrayList<Integer> usedIndices = new ArrayList<>();
            usedIndices.add(newCorrectIndex);

            shuffledOptions[newCorrectIndex] = originalOptions[correctAnswerIndex];

            int index = 0;
            while (usedIndices.size() < 4) {
                int randomIndex = rand.nextInt(4);
                if (!usedIndices.contains(randomIndex)) {
                    while (index == correctAnswerIndex) index++;
                    shuffledOptions[randomIndex] = originalOptions[index++];
                    if (index == correctAnswerIndex) index++;
                    usedIndices.add(randomIndex);
                }
            }
            return shuffledOptions;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("What is a variable in Java?", new String[]{"A constant", "A storage location", "A method", "A class"}, 1));
        questions.add(new Question("How do you declare a method in Java?", new String[]{"void method()", "method void()", "declare method()", "method() void"}, 0));
        questions.add(new Question("What is the difference between `int` and `double`?", new String[]{"`int` is decimal, `double` is integer", "`int` is 32-bit, `double` is 64-bit float", "`int` is string, `double` is number", "`int` is object, `double` is primitive"}, 1));
        questions.add(new Question("What is an operator in Java?", new String[]{"A variable", "A symbol for operation", "A class", "A method"}, 1));
        questions.add(new Question("How do you handle user input in Java?", new String[]{"`Scanner` class", "`Input` class", "`UserInput` class", "`Read` class"}, 0));
        questions.add(new Question("What is an array in Java?", new String[]{"A single variable", "A collection of elements", "A method", "A loop"}, 1));
        questions.add(new Question("How do you iterate over an array?", new String[]{"Using for loop", "Using if statement", "Using switch", "Using class"}, 0));
        questions.add(new Question("What is the difference between `length` and `length()`?", new String[]{"`length` for arrays, `length()` for strings", "`length()` for arrays, `length` for strings", "Both same", "No difference"}, 0));
        questions.add(new Question("How do you sort an array in Java?", new String[]{"`Arrays.sort()`", "`sortArray()`", "`Array.sort()`", "`sort()`"}, 0));
        questions.add(new Question("What is a loop in Java?", new String[]{"A decision structure", "A repetition structure", "A variable", "A method"}, 1));
        questions.add(new Question("What is inheritance in Java?", new String[]{"Hiding data", "Parent-child relationship", "Method duplication", "Variable sharing"}, 1));
        questions.add(new Question("Why use the `this` keyword?", new String[]{"To call superclass", "To refer to current object", "To declare variable", "To define method"}, 1));
        questions.add(new Question("What is method overriding vs overloading?", new String[]{"Overriding changes, overloading adds", "Both same", "Overloading changes, overriding adds", "No difference"}, 0));
        questions.add(new Question("What is object instantiation?", new String[]{"Creating object", "Declaring class", "Defining method", "Initializing array"}, 0));
        questions.add(new Question("Explain single vs multiple inheritance.", new String[]{"One parent vs many parents", "One child vs many children", "One method vs many methods", "One class vs many classes"}, 0));
        questions.add(new Question("Difference between `FileReader` and `BufferedReader`?", new String[]{"`FileReader` buffers, `BufferedReader` reads", "`FileReader` reads, `BufferedReader` buffers", "Both same", "No difference"}, 1));
        questions.add(new Question("What is try-with-resources?", new String[]{"Auto resource management", "Manual resource management", "Exception handling", "Loop structure"}, 0));
        questions.add(new Question("How to handle `IOException`?", new String[]{"try-catch", "if-else", "switch", "for loop"}, 0));
        questions.add(new Question("What are checked and unchecked exceptions?", new String[]{"Compile-time vs runtime", "Runtime vs compile-time", "Both same", "No difference"}, 0));
        questions.add(new Question("How does file writing work in Java?", new String[]{"Using `FileWriter` or `BufferedWriter`", "Using `Scanner`", "Using `ArrayList`", "Using `JFrame`"}, 0));
        questions.add(new Question("What is Swing?", new String[]{"A GUI toolkit", "A database library", "A file I/O class", "A loop structure"}, 0));
        questions.add(new Question("Difference between AWT and Swing?", new String[]{"Swing is lightweight, AWT is heavyweight", "AWT is lightweight, Swing is heavyweight", "Both same", "No difference"}, 0));
        questions.add(new Question("What is `ActionListener`?", new String[]{"Handles GUI events", "Reads files", "Manages databases", "Sorts arrays"}, 0));
        questions.add(new Question("How to manage layouts in Java?", new String[]{"Using `LayoutManager`", "Using `Scanner`", "Using `ArrayList`", "Using `JDBC`"}, 0));
        questions.add(new Question("What is the Event Dispatch Thread?", new String[]{"Handles GUI events", "Manages database", "Reads files", "Sorts data"}, 0));
        questions.add(new Question("What is JDBC?", new String[]{"Java Database Connectivity", "Java GUI Connectivity", "Java File Connectivity", "Java Web Connectivity"}, 0));
        questions.add(new Question("What is `PreparedStatement`?", new String[]{"Precompiled SQL statement", "GUI component", "File reader", "Array sorter"}, 0));
        questions.add(new Question("Difference between `Statement` and `PreparedStatement`?", new String[]{"`PreparedStatement` is precompiled, `Statement` is not", "Both same", "`Statement` is precompiled, `PreparedStatement` is not", "No difference"}, 0));
        questions.add(new Question("How do you handle SQL exceptions?", new String[]{"try-catch", "if-else", "switch", "for loop"}, 0));
        questions.add(new Question("How to prevent SQL injection?", new String[]{"Use `PreparedStatement`", "Use `Statement`", "Use `ResultSet`", "Use `Connection`"}, 0));
        questions.add(new Question("What are Java loops?", new String[]{"Repetition structures", "Decision structures", "Variable declarations", "Method definitions"}, 0));
        questions.add(new Question("What is enhanced-for-loop?", new String[]{"Iterates collections", "Handles exceptions", "Manages GUI", "Reads files"}, 0));
        questions.add(new Question("How do you handle multiple user inputs?", new String[]{"Using `Scanner`", "Using `JFrame`", "Using `JDBC`", "Using `ArrayList`"}, 0));
        questions.add(new Question("How is a switch-case different from if-else?", new String[]{"Switch for multiple conditions, if-else for single", "Both same", "If-else for multiple, switch for single", "No difference"}, 0));
        questions.add(new Question("What are collections in Java?", new String[]{"Data structure interfaces", "GUI components", "Database objects", "File readers"}, 0));
        questions.add(new Question("What is `ArrayList`?", new String[]{"Dynamic array", "Static array", "GUI component", "Database table"}, 0));
        questions.add(new Question("How to iterate using iterators?", new String[]{"Using `Iterator` interface", "Using `Scanner`", "Using `JFrame`", "Using `JDBC`"}, 0));
        questions.add(new Question("What is a `Map`?", new String[]{"Key-value pairs", "Array list", "GUI layout", "Database query"}, 0));
        questions.add(new Question("How to sort a list?", new String[]{"`Collections.sort()`", "`Array.sort()`", "`List.sort()`", "`Sort.list()`"}, 0));
        questions.add(new Question("How to shuffle elements?", new String[]{"`Collections.shuffle()`", "`Array.shuffle()`", "`List.shuffle()`", "`Shuffle.list()`"}, 0));

        Collections.shuffle(questions);
        int totalQuestions = Math.min(15, questions.size());
        int score = 0;

        System.out.println("Welcome to the Advanced Quiz App!");
        System.out.println("You will be asked " + totalQuestions + " questions.\n");

        for (int i = 0; i < totalQuestions; i++) {
            Question q = questions.get(i);
            String[] shuffledOptions = q.getShuffledOptions();
            System.out.println("Question " + (i + 1) + ": " + q.questionText);
            for (int j = 0; j < shuffledOptions.length; j++) {
                System.out.println((j + 1) + ". " + shuffledOptions[j]);
            }
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt() - 1;

            int correctPosition = -1;
            for (int j = 0; j < shuffledOptions.length; j++) {
                if (shuffledOptions[j].equals(q.originalOptions[q.correctAnswerIndex])) {
                    correctPosition = j;
                    break;
                }
            }

            if (userAnswer >= 0 && userAnswer < 4 && userAnswer == correctPosition) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.originalOptions[q.correctAnswerIndex] + "\n");
            }
        }

        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + " out of " + totalQuestions);
        double percentage = (score * 100.0) / totalQuestions;
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println(percentage >= 60 ? "Passed!" : "Failed!");

        scanner.close();
    }
}
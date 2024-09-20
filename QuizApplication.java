import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class QuizApplication {
    private JFrame frame;
    private JPanel panel;
    private JTextArea questionArea;
    private JRadioButton[] options;
    private ButtonGroup optionGroup;
    private JButton submitButton;
    private JLabel timerLabel;
    private Timer timer;
    private int timeLeft = 10; // Time limit per question (in seconds)

    private String[] questions = {
        "What is the capital of France?",
        "What is 2 + 2?",
        "What is the Fulform of DBMS"
    };
    private String[][] optionsList = {
        {"Paris", "London", "Berlin", "Madrid"},
        {"3", "4", "5", "6"},
        {"Database Management System","Data Border Management System","Database Merge System","Data Backup Management System"}
    };
    private int[] answers = {0, 1,0}; // Index of the correct answer

    private int currentQuestionIndex = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizApplication().createAndShowGUI());
        
    }

    private void createAndShowGUI() {
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        questionArea = new JTextArea();
        questionArea.setEditable(false);
        panel.add(questionArea);

        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            optionGroup.add(options[i]);
            panel.add(options[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        panel.add(submitButton);

        timerLabel = new JLabel("Time left: " + timeLeft + "s");
        panel.add(timerLabel);

        frame.add(panel, BorderLayout.CENTER);

        showQuestion(currentQuestionIndex);

        frame.setVisible(true);
    }

    private void showQuestion(int index) {
        if (index >= questions.length) {
            JOptionPane.showMessageDialog(frame, "Quiz Finished!");
            System.exit(0);
        }

        questionArea.setText(questions[index]);
        for (int i = 0; i < options.length; i++) {
            options[i].setText(optionsList[index][i]);
        }

        timeLeft = 10;
        timerLabel.setText("Time left: " + timeLeft + "s");
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(1000, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft + "s");
            if (timeLeft <= 0) {
                timer.stop();
                submitAnswer();
            }
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            submitAnswer();
        }
    }

    private void submitAnswer() {
        int selectedOption = -1;
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }

        if (selectedOption == answers[currentQuestionIndex]) {
            JOptionPane.showMessageDialog(frame, "Correct!");
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect. The correct answer was: " +
                optionsList[currentQuestionIndex][answers[currentQuestionIndex]]);
        }

        currentQuestionIndex++;
        showQuestion(currentQuestionIndex);
    }
}

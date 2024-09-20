import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {
    private JTextField amountField;
    private JTextArea displayArea;
    private double balance = 0.0;

    public ATMInterface() {
        // Frame properties
        setTitle("ATM Interface"); 
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel balanceLabel = new JLabel("Balance:");
        JLabel amountLabel = new JLabel("Amount:");

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        amountField = new JTextField();

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        // Add components to panel
        panel.add(balanceLabel);
        panel.add(displayArea);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        // Action listeners
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("Current balance: $" + balance);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0) {
                        balance += amount;
                        displayArea.setText("Deposited: $" + amount + "\nNew balance: $" + balance);
                    } else {
                        displayArea.setText("Invalid deposit amount.");
                    }
                } catch (NumberFormatException ex) {
                    displayArea.setText("Invalid input. Please enter a number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        displayArea.setText("Withdrew: $" + amount + "\nNew balance: $" + balance);
                    } else if (amount > balance) {
                        displayArea.setText("Insufficient funds.");
                    } else {
                        displayArea.setText("Invalid withdrawal amount.");
                    }
                } catch (NumberFormatException ex) {
                    displayArea.setText("Invalid input. Please enter a number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create and display the ATM interface
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATMInterface().setVisible(true);
            }
        });
    }
}


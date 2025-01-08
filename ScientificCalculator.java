import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
    private final JTextField inputField;
    private final JButton[] numberButtons = new JButton[10];
    private final JButton[] functionButtons = new JButton[9];
    private final String[] functionNames = {"+", "-", "*", "/", "sin", "cos", "tan", "sqrt", "log"};
    private final JButton equalsButton, clearButton;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        inputField = new JTextField();
        inputField.setBounds(50, 25, 300, 50);
        inputField.setFont(new Font("Arial", Font.BOLD, 20));
        inputField.setEditable(false);
        add(inputField);

        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        // Add function buttons
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i] = new JButton(functionNames[i]);
            functionButtons[i].addActionListener(this);
        }

        // Add number buttons
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Layout setup
        int x = 50, y = 100;
        for (int i = 1; i < numberButtons.length; i++) {
            numberButtons[i].setBounds(x, y, 60, 60);
            add(numberButtons[i]);
            x += 70;
            if (i % 3 == 0) {
                x = 50;
                y += 70;
            }
        }

        numberButtons[0].setBounds(50, y, 60, 60);
        add(numberButtons[0]);

        equalsButton.setBounds(190, y, 60, 60);
        clearButton.setBounds(260, y, 60, 60);
        add(equalsButton);
        add(clearButton);

        x = 50;
        y += 70;
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].setBounds(x, y, 80, 60);
            add(functionButtons[i]);
            x += 90;
            if (x > 320) {
                x = 50;
                y += 70;
            }
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                inputField.setText(inputField.getText() + i);
            }
        }

        for (int i = 0; i < functionButtons.length; i++) {
            if (e.getSource() == functionButtons[i]) {
                num1 = Double.parseDouble(inputField.getText());
                operator = functionNames[i].charAt(0);
                inputField.setText("");
            }
        }

        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                case 's' -> result = Math.sin(Math.toRadians(num1));
                case 'c' -> result = Math.cos(Math.toRadians(num1));
                case 't' -> result = Math.tan(Math.toRadians(num1));
                case 'l' -> result = Math.log10(num1);
                case 'q' -> result = Math.sqrt(num1);
            }
            inputField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) {
            inputField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}

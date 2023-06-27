import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp implements ActionListener {

    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton buttonClear;
    private JButton buttonEquals;
    private JPanel panel;

    private double num1, num2, result;
    private String operator;

    public CalculatorApp() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 30, 240, 40);
        textField.setEditable(false);
        frame.add(textField);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            operatorButtons[i].addActionListener(this);
        }

        buttonClear = new JButton("C");
        buttonClear.addActionListener(this);

        buttonEquals = new JButton("=");
        buttonEquals.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(30, 90, 240, 250);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(operatorButtons[0]);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(operatorButtons[1]);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(operatorButtons[2]);

        panel.add(numberButtons[0]);
        panel.add(buttonClear);
        panel.add(buttonEquals);
        panel.add(operatorButtons[3]);

        frame.add(panel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == operatorButtons[0]) {
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }

        if (e.getSource() == operatorButtons[1]) {
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }

        if (e.getSource() == operatorButtons[2]) {
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }

        if (e.getSource() == operatorButtons[3]) {
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }

        if (e.getSource() == buttonClear) {
            textField.setText("");
        }

        if (e.getSource() == buttonEquals) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        textField.setText("Error: Divide by zero");
                    break;
            }

            textField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}

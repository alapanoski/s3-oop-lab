import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JPanel buttonJPanel;
    JTextField textField;

    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button0 = new JButton("0");

    JButton buttonAdd = new JButton("+");
    JButton buttonSub = new JButton("-");
    JButton buttonMul = new JButton("*");
    JButton buttonDiv = new JButton("/");
    JButton buttonEqual = new JButton("=");
    JButton buttonClear = new JButton("C");

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setResizable(false);

        textField = new JTextField("");
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        frame.add(textField);

        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(4, 4, 1, 1));
        buttonJPanel.add(button7);
        buttonJPanel.add(button8);
        buttonJPanel.add(button9);
        buttonJPanel.add(buttonDiv);
        buttonJPanel.add(button4);
        buttonJPanel.add(button5);
        buttonJPanel.add(button6);
        buttonJPanel.add(buttonMul);
        buttonJPanel.add(button1);
        buttonJPanel.add(button2);
        buttonJPanel.add(button3);
        buttonJPanel.add(buttonSub);
        buttonJPanel.add(button0);
        buttonJPanel.add(buttonClear);
        buttonJPanel.add(buttonAdd);
        buttonJPanel.add(buttonEqual);
        buttonJPanel.setBounds(50, 100, 300, 300);
        frame.add(buttonJPanel);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button0.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSub.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonClear.addActionListener(this);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            textField.setText(textField.getText().concat("1"));
        }
        if (e.getSource() == button2) {
            textField.setText(textField.getText().concat("2"));
        }
        if (e.getSource() == button3) {
            textField.setText(textField.getText().concat("3"));
        }
        if (e.getSource() == button4) {
            textField.setText(textField.getText().concat("4"));
        }
        if (e.getSource() == button5) {
            textField.setText(textField.getText().concat("5"));
        }
        if (e.getSource() == button6) {
            textField.setText(textField.getText().concat("6"));
        }
        if (e.getSource() == button7) {
            textField.setText(textField.getText().concat("7"));
        }
        if (e.getSource() == button8) {
            textField.setText(textField.getText().concat("8"));
        }
        if (e.getSource() == button9) {
            textField.setText(textField.getText().concat("9"));
        }
        if (e.getSource() == button0) {
            textField.setText(textField.getText().concat("0"));
        }
        if (e.getSource() == buttonAdd) {
            if (!(textField.getText().equals("")
                    || textField.getText().endsWith("+ ")
                    || textField.getText().endsWith("- ")
                    || textField.getText().endsWith("* ")
                    || textField.getText().endsWith("/ ")))
                textField.setText(textField.getText().concat(" ").concat("+").concat(" "));
        }
        if (e.getSource() == buttonSub) {
            if (!(textField.getText().equals("")
                    || textField.getText().endsWith("+ ")
                    || textField.getText().endsWith("- ")
                    || textField.getText().endsWith("* ")
                    || textField.getText().endsWith("/ ")))
                textField.setText(textField.getText().concat(" ").concat("-").concat(" "));
        }
        if (e.getSource() == buttonMul) {
            if (!(textField.getText().equals("")
                    || textField.getText().endsWith("+ ")
                    || textField.getText().endsWith("- ")
                    || textField.getText().endsWith("* ")
                    || textField.getText().endsWith("/ ")))
                textField.setText(textField.getText().concat(" ").concat("*").concat(" "));
        }
        if (e.getSource() == buttonDiv) {
            if (!(textField.getText().equals("")
                    || textField.getText().endsWith("+ ")
                    || textField.getText().endsWith("- ")
                    || textField.getText().endsWith("* ")
                    || textField.getText().endsWith("/ ")))
                textField.setText(textField.getText().concat(" ").concat("/").concat(" "));
        }
        if (e.getSource() == buttonClear) {
            textField.setText("");
        }
        if (e.getSource() == buttonEqual) {

            try {
                StringTokenizer expression = new StringTokenizer(textField.getText(), " ");
                boolean isFirstToken = true;
                double result = 0;

                while (expression.hasMoreTokens()) {
                    if (isFirstToken) {
                        Double x = Double.parseDouble(expression.nextToken());
                        String operator = expression.nextToken();
                        Double y = Double.parseDouble(expression.nextToken());
                        switch (operator) {
                            case "+":
                                result = x + y;
                                break;
                            case "-":
                                result = x - y;
                                break;
                            case "*":
                                result = x * y;
                                break;
                            case "/":
                                if (y == 0)
                                    throw new ArithmeticException("Divide by zero");
                                result = x / y;
                                break;
                        }
                        isFirstToken = false;
                    } else {
                        String operator = expression.nextToken();
                        Double y = Double.parseDouble(expression.nextToken());
                        switch (operator) {
                            case "+":
                                result += y;
                                break;
                            case "-":
                                result -= y;
                                break;
                            case "*":
                                result *= y;
                                break;
                            case "/":
                                if (y == 0)
                                    throw new ArithmeticException("Divide by zero");
                                result /= y;
                                break;
                        }
                    }
                }

                textField.setText(Double.toString(result));
            } catch (Exception exception) {
                textField.setText("Error: " + exception.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

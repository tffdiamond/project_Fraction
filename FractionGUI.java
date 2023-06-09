package project.project_Fraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.IllegalFormatException;
import java.util.Objects;

public class FractionGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField whole1Field, numerator1Field, denominator1Field, whole2Field, numerator2Field,
            denominator2Field, wholeAnswer, numeratorAnswer, denominatorAnswer;
    private String selectedOperator;
    private final String[] operators;

    public FractionGUI() {
        // Create the input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());

        // Create the panel for the first fraction input
        JPanel firstFractionPanel = new JPanel();
        firstFractionPanel.setLayout(new BoxLayout(firstFractionPanel, BoxLayout.Y_AXIS));

        // Create the text fields for the mixed number, numerator and denominator inputs
        whole1Field = new JTextField(2);
        numerator1Field = new JTextField(2);
        denominator1Field = new JTextField(2);

        // Add the mixed number, numerator and denominator fields to the first fraction panel
        JPanel firstFractionInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        firstFractionInputPanel.add(whole1Field);

        // Spacer
        firstFractionInputPanel.add(new JLabel(" "));
        firstFractionInputPanel.add(new JSeparator(SwingConstants.VERTICAL));
        firstFractionInputPanel.add(new JLabel(" "));

        firstFractionInputPanel.add(numerator1Field);
        firstFractionInputPanel.add(new JLabel("/"));
        firstFractionInputPanel.add(denominator1Field);
        firstFractionPanel.add(firstFractionInputPanel);

        // Add the first fraction panel to the input panel
        inputPanel.add(firstFractionPanel);

        // Create the panel for the second fraction input
        JPanel secondFractionPanel = new JPanel();
        secondFractionPanel.setLayout(new BoxLayout(secondFractionPanel, BoxLayout.Y_AXIS));

        // Create the text fields for the mixed number, numerator and denominator inputs
        whole2Field = new JTextField(2);
        numerator2Field = new JTextField(2);
        denominator2Field = new JTextField(2);

        // Add the mixed number, numerator and denominator fields to the second fraction panel
        JPanel secondFractionInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        secondFractionInputPanel.add(whole2Field);

        // Spacer
        secondFractionInputPanel.add(new JLabel(" "));
        secondFractionInputPanel.add(new JSeparator(SwingConstants.VERTICAL));
        secondFractionInputPanel.add(new JLabel(" "));

        secondFractionInputPanel.add(numerator2Field);
        secondFractionInputPanel.add(new JLabel("/"));
        secondFractionInputPanel.add(denominator2Field);
        secondFractionPanel.add(secondFractionInputPanel);

        // Create the drop-down menu for the operator
        operators = new String[]{"+", "-", "*", "/"};
        JComboBox<String> operatorComboBox = new JComboBox<>(operators);
        JPanel operatorPanel = new JPanel();
        operatorPanel.add(operatorComboBox);

        // Add the drop-down menu and second fraction panel to the input panel
        inputPanel.add(operatorPanel);
        inputPanel.add(Box.createVerticalStrut(20)); // Add a vertical strut for spacing
        inputPanel.add(secondFractionPanel);
        // add action listener to the operator combo box
        operatorComboBox.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Typecast into a string
                selectedOperator = (String) operatorComboBox.getSelectedItem();

                Fraction answer = solveFraction(whole1Field, numerator1Field, denominator1Field,
                        whole2Field, numerator2Field, denominator2Field);

                verifyInstance(answer);
            }
        });

        // solve and simplify buttons
        JPanel computationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton solveButton = new JButton("Solve");
        JButton simplifyButton = new JButton("Simplify");
        computationPanel.add(solveButton);
        computationPanel.add(simplifyButton);

        // add action event handler on solve and simplify button
        solveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Typecast into a string
                selectedOperator = (String) operatorComboBox.getSelectedItem();

                Fraction answer = null;
                try {
                    answer = solveFraction(whole1Field, numerator1Field, denominator1Field,
                            whole2Field, numerator2Field, denominator2Field);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Input data is not a whole number, please input an " +
                            "appropriate " +
                            "data");
                }
                verifyInstance(answer);
            }
        });

        simplifyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Fraction answer = null;
                try {
                    answer = simplifyFraction(wholeAnswer, numeratorAnswer, denominatorAnswer);
                } catch (IllegalFormatException illegalFormatException) {
                    JOptionPane.showMessageDialog(null, "Input data is not a whole number, please input an " +
                            "appropriate " +
                            "data");
                }
                verifyInstance(answer);
            }
        });

        // Create the answer panel
        JPanel answerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wholeAnswer = new JTextField(2);
        numeratorAnswer = new JTextField(2);
        denominatorAnswer = new JTextField(2);
        answerPanel.add(wholeAnswer);
        wholeAnswer.setText("0");
        numeratorAnswer.setText("0");
        denominatorAnswer.setText("0");

        // Spacer
        answerPanel.add(new JLabel(" "));
        answerPanel.add(new JSeparator(SwingConstants.VERTICAL));
        answerPanel.add(new JLabel(" "));

        answerPanel.add(numeratorAnswer);
        answerPanel.add(new JLabel("/"));
        answerPanel.add(denominatorAnswer);

        // Add the input panel, button panel, and answer panel to the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(20)); //Adds spacing below the input fields
        mainPanel.add(computationPanel);
        mainPanel.add(answerPanel);

        // Add the main panel to the frame and set other frame properties
        //Also shows the window on runtime
        add(mainPanel);
        setResizable(false);
        setBackground(new Color(255, 255, 255));
        setTitle("Fraction Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Fraction simplifyFraction(JTextField wholeAnswer, JTextField numeratorAnswer, JTextField denominatorAnswer)
    {
        if (wholeAnswer.getText().isEmpty())
        {
            return new Fraction().reduceFraction(new Fraction(Integer.parseInt(numeratorAnswer.getText()),
                    Integer.parseInt(denominatorAnswer.getText())));
        }
        else
        {
            return new MixedFraction().reduceFraction(new MixedFraction(Integer.parseInt(wholeAnswer.getText()),
                    Integer.parseInt(numeratorAnswer.getText()), Integer.parseInt(denominatorAnswer.getText())));
        }
    }

    private void verifyInstance(Fraction answer) {
        if (answer instanceof MixedFraction)
        {
            wholeAnswer.setText(String.valueOf(((MixedFraction) answer).getWhole()));
            numeratorAnswer.setText(String.valueOf(answer.getNumerator()));
            denominatorAnswer.setText(String.valueOf(answer.getDenominator()));
        }
        else if (answer != null){
            wholeAnswer.setText("");
            numeratorAnswer.setText(String.valueOf(answer.getNumerator()));
            denominatorAnswer.setText(String.valueOf(answer.getDenominator()));
        }
    }

    // solveFraction tendency to cause an unchecked exception
    private Fraction solveFraction(JTextField whole1Field, JTextField numerator1Field, JTextField denominator1Field,
                                   JTextField whole2Field, JTextField numerator2Field, JTextField denominator2Field) {

        checkFraction();

        // add arithmetic
        if (Objects.equals(selectedOperator, operators[0])) {
            if (whole1Field.getText().isEmpty() && whole2Field.getText().isEmpty()) {
                return new Fraction(Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).add(new Fraction(Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText().isEmpty() && whole2Field.getText() != null) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()), Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).add(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText() != null && whole2Field.getText().isEmpty()) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()), Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).add(new MixedFraction(0,
                        Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()),
                        Integer.parseInt(numerator1Field.getText()), Integer.parseInt(denominator1Field.getText())).add(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            }
        }

        // sub arithmetic
        else if (Objects.equals(selectedOperator, operators[1])) {
            if (whole1Field.getText().isEmpty() && whole2Field.getText().isEmpty()) {
                return new Fraction(Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).sub(new Fraction(Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText().isEmpty() && whole2Field.getText() != null) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()), Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).sub(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText() != null && whole2Field.getText().isEmpty()) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()), Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).sub(new MixedFraction(0,
                        Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()),
                        Integer.parseInt(numerator1Field.getText()), Integer.parseInt(denominator1Field.getText())).sub(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            }
        }

        // multiply arithmetic
        else if (Objects.equals(selectedOperator, operators[2])) {
            if (whole1Field.getText().isEmpty() && whole2Field.getText().isEmpty()) {
                return new Fraction(Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).multiply(new Fraction(Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText().isEmpty() && whole2Field.getText() != null) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()),
                        Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).multiply(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText() != null && whole2Field.getText().isEmpty()) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()), Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).multiply(new MixedFraction(0,
                        Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()),
                        Integer.parseInt(numerator1Field.getText()), Integer.parseInt(denominator1Field.getText())).multiply(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            }
        }

        // divide arithmetic
        else {
            if (whole1Field.getText().isEmpty() && whole2Field.getText().isEmpty()) {
                return new Fraction(Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).divide(new Fraction(Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText().isEmpty() && whole2Field.getText() != null) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()), Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).divide(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else if (whole1Field.getText() != null && whole2Field.getText().isEmpty()) {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()), Integer.parseInt(numerator1Field.getText()),
                        Integer.parseInt(denominator1Field.getText())).divide(new MixedFraction(0,
                        Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            } else {
                return new MixedFraction(Integer.parseInt(whole1Field.getText()),
                        Integer.parseInt(numerator1Field.getText()), Integer.parseInt(denominator1Field.getText())).divide(new MixedFraction(Integer.parseInt(whole2Field.getText()), Integer.parseInt(numerator2Field.getText()), Integer.parseInt(denominator2Field.getText())));
            }
        }
    }

    private void checkFraction() {
        if (Integer.parseInt(denominator1Field.getText()) == 0 || Integer.parseInt(denominator2Field.getText()) == 0)
        {
            JOptionPane.showMessageDialog(null, "A fraction with a 0 denominator is undefined");
        }
    }

    public static void main(String[] args) {
        new FractionGUI();
    }
}

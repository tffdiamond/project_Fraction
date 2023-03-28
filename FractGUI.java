package projectFractionGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractGUI extends JFrame {
    private JTextField whole1Field, numerator1Field, denominator1Field, whole2Field, numerator2Field, denominator2Field;
    private JLabel resultLabel;

    public FractGUI() {
        // Create the input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());

        // Create boundaries for the first fraction panel
        GridBagConstraints gbcFirst = new GridBagConstraints();
        gbcFirst.gridx = 0;
        gbcFirst.gridy = 0;
        gbcFirst.anchor = GridBagConstraints.WEST;

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
        inputPanel.add(firstFractionPanel, gbcFirst);

        // Create the boundaries for the second fraction panel
        GridBagConstraints gbcSecond = new GridBagConstraints();
        gbcSecond.gridx = 1;
        gbcSecond.gridy = 0;
        gbcSecond.anchor = GridBagConstraints.WEST;

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
        secondFractionInputPanel.add(new JLabel(" "));
        secondFractionInputPanel.add(new JSeparator(SwingConstants.VERTICAL));
        secondFractionInputPanel.add(new JLabel(" "));
        secondFractionInputPanel.add(numerator2Field);
        secondFractionInputPanel.add(new JLabel("/"));
        secondFractionInputPanel.add(denominator2Field);
        secondFractionPanel.add(secondFractionInputPanel);

        // Add the second fraction panel to the input panel
        inputPanel.add(secondFractionPanel, gbcSecond);

        // Create the drop-down menu for the operator
        String[] operators = {"+", "-", "*", "/"};
        JComboBox<String> operatorComboBox = new JComboBox<>(operators);
        JPanel operatorPanel = new JPanel();
        operatorPanel.add(operatorComboBox);

        // Add the drop-down menu and second fraction panel to the input panel
        inputPanel.add(operatorPanel);
        inputPanel.add(Box.createVerticalStrut(20)); // Add a vertical strut for spacing
        inputPanel.add(secondFractionPanel);

        // The action listener to the operator combo box
        operatorComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOperator = (String) operatorComboBox.getSelectedItem();

                switch(selectedOperator) {
                    case "+":
                        // Add the two fractions
                        break;
                    case "-":
                        // Subtract the two fractions
                        break;
                    case "*":
                        // Multiply the two fractions
                        break;
                    case "/":
                        // Divide the two fractions
                        break;
                }
            }
        });

        // Create the equals button and add an ActionListener
        JButton equalsButton = new JButton("=");
        //equalsButton.addActionListener(e -> computeResult());
        JPanel equalsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        equalsPanel.add(equalsButton);
        resultLabel = new JLabel("Result:");

        // Add the input panel, button panel, and result label to the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(20)); //Adds spacing below the input fields
        mainPanel.add(equalsPanel);
        mainPanel.add(resultLabel);

        // Add the main panel to the frame and set other frame properties
        //Also shows the window on runtime
        add(mainPanel);
        setTitle("Fraction Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        FractGUI calculator = new FractGUI();
    }
}
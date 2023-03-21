package project;

import java.util.Scanner;

public class FractionArithmetic {
    int choice = 0;
    Fraction fraction1;
    Fraction fraction2;
    Fraction tempFraction;
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        FractionArithmetic fractionArithmetic = new FractionArithmetic();
        showIntroduction();
        fractionArithmetic.mainMenuOption();

        // Display the output of the resulted fraction corresponding to the user desired option
        fractionArithmetic.printFraction();

        // Terminated if choice < 5
        if (fractionArithmetic.optionalMenu(fractionArithmetic.choice))
        {
            fractionArithmetic.printFraction();
        }

        System.exit(0);
    }

    private void printFraction()
    {
        System.out.println(tempFraction + "\n" + tempFraction.toDouble());
    }

    private boolean optionalMenu(int choice)
    {
        char letter;
        try {
            if (choice <= 4)
            {
                System.out.println("Would you like to reduce the fraction? (y/n)");
                letter = keyboard.next().charAt(0);
                optionalMenuVerification(letter);
                return true;
            }
        } catch (ArithmeticException e){
            System.out.println("You can't reduce an undefined fraction");
        }
        return false;
    }

    private void optionalMenuVerification(char character) {
        Fraction temp = new Fraction();
        if (character == 'y')
        {
            tempFraction = temp.reduceFraction(fraction1);
        }
        else if (character == 'n')
        {
            System.out.println("Thank you for using our program!");
        }
        else
        {
            System.out.println("Your input is incorrect, closing the application now....");
        }
    }

    private void mainMenuOption() {
        do {
            // Show the mainMenu
            choice = showMainMenu();
            switch (choice) {
                // arithmetic options
                case 1 -> tempFraction = addFractions();
                case 2 -> tempFraction = subtractFractions();
                case 3 -> tempFraction = multiplyFractions();
                case 4 -> tempFraction = divideFraction();
                case 5 -> tempFraction = simplifyFraction();
            }
            if (choice > 6)
            {
                System.out.println("Please input a valid value!");
            }
        } while (choice > 6);
    }

    private Fraction simplifyFraction()
    {
        tempFraction = readAFraction();
        return tempFraction.reduceFraction(tempFraction);
    }

    private Fraction addFractions()
    {
        fraction1 = readAFraction();
        fraction2 = readAFraction();
        return fraction1.add(fraction2);
    }

    private Fraction subtractFractions()
    {
        fraction1 = readAFraction();
        fraction2 = readAFraction();
        return fraction1.sub(fraction2);
    }

    private Fraction multiplyFractions()
    {
        fraction1 = readAFraction();
        fraction2 = readAFraction();
        return fraction1.multiply(fraction2);
    }

    private  Fraction divideFraction()
    {
        fraction1 = readAFraction();
        fraction2 = readAFraction();
        return fraction1.divide(fraction2);
    }

    private static int showMainMenu()
    {
        System.out.println("1. Add Fractions");
        System.out.println("2. Subtraction Fractions");
        System.out.println("3. Multiply Fractions");
        System.out.println("4. Divide Fractions");
        System.out.println("5. Reduce a Fraction");
        System.out.println("Please input an appropriate option for computing a fraction: ");
        return keyboard.nextInt();
    }

    public static Fraction readAFraction()  {
        String input_string_fraction;
        keyboard.nextLine();
        System.out.println("Input the fraction: ");
        input_string_fraction = keyboard.nextLine();

        return new Fraction(input_string_fraction);

    }

    private static void showIntroduction()
    {
        // Introduction
        System.out.println("This application allows the application of arithmetic operations(addition, subtraction, multiplication,\n" +
                "division) with fractions.");
        System.out.println("The fractions to which operations will be performed should be entered by the user at runtime.");
        System.out.println("Provide a menu facility for the user of your application.");
    }

}
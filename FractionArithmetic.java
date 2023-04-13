package project.project_Fraction;

import projectV2.Fraction;
import projectV2.MixedFraction;

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
        if (fractionArithmetic.optionalMenu(fractionArithmetic.choice)) {
            fractionArithmetic.printFraction();
        }

        System.exit(0);
    }

    private void printFraction() {
        System.out.println(tempFraction + "\n" + tempFraction.toDouble());
    }

    private boolean optionalMenu(int choice) {
        char letter;
        try {
            if (choice <= 4) {
                System.out.println("Would you like to reduce the fraction? (y/n)");
                letter = keyboard.next().charAt(0);
                optionalMenuVerification(letter);
                return true;
            }
        } catch (ArithmeticException e) {
            System.out.println("You can't reduce an undefined fraction");
        }
        return false;
    }

    private void optionalMenuVerification(char character) {
        Fraction temp = new Fraction();
        if (character == 'y') {
            tempFraction = temp.reduceFraction(tempFraction);
        } else if (character == 'n') {
            System.out.println("Thank you for using our program!");
        } else {
            System.out.println("Your input is incorrect, closing the application now....");
        }
    }

    private void mainMenuOption() {
        do {
            // Show the mainMenu
            choice = Integer.parseInt(showMainMenu());
            switch (choice) {
                // arithmetic options
                case 1 -> tempFraction = addFractions();
                case 2 -> tempFraction = subtractFractions();
                case 3 -> tempFraction = multiplyFractions();
                case 4 -> tempFraction = divideFraction();
                case 5 -> tempFraction = simplifyFraction();
            }
            if (choice > 6) {
                System.out.println("Please input a valid value!");
            }
        } while (choice > 6);
    }

    private Fraction simplifyFraction() {
        tempFraction = readAFraction();
        return tempFraction.reduceFraction(tempFraction);
    }

    private Fraction addFractions() {
        fraction1 = readAFraction();
        fraction2 = readAFraction();

        return verify_instance();
    }


    private Fraction subtractFractions()
    {
        fraction1 = readAFraction();
        fraction2 = readAFraction();

        return verify_instance();
    }

    private Fraction multiplyFractions()
    {
        fraction1 = readAFraction();
        fraction2 = readAFraction();

        return verify_instance();
    }

    private  Fraction divideFraction()
    {
        fraction1 = readAFraction();
        fraction2 = readAFraction();

        return verify_instance();
    }

    private static String showMainMenu()
    {
        System.out.println("1. Add Fractions");
        System.out.println("2. Subtraction Fractions");
        System.out.println("3. Multiply Fractions");
        System.out.println("4. Divide Fractions");
        System.out.println("5. Reduce a Fraction");
        System.out.println("Please input an appropriate option for computing a fraction: ");
        return keyboard.nextLine();
    }

    public Fraction readAFraction()  {
        String input_string_fraction;
        Fraction temp;
        System.out.println("Input the fraction: ");
        input_string_fraction = keyboard.nextLine();

        temp = checkAFraction(input_string_fraction);

        return temp;
    }

    private Fraction checkAFraction(String input_string_fraction) {
        String[] fraction_parts, numerator_denominator;
        String fraction;
        int whole;

        if (input_string_fraction.contains(" "))
        {
            fraction_parts = input_string_fraction.split(" ");
            whole = Integer.parseInt(fraction_parts[0]);
            fraction = fraction_parts[1];
            numerator_denominator = fraction.split("/");
            return new MixedFraction(whole, Integer.parseInt(numerator_denominator[0]), Integer.parseInt(numerator_denominator[1]));
        }
        else
        {
            numerator_denominator = input_string_fraction.split("/");
            return new Fraction(Integer.parseInt(numerator_denominator[0]), Integer.parseInt(numerator_denominator[1]));
        }
    }

    private static void showIntroduction()
    {
        // Introduction
        System.out.println("This application allows the application of arithmetic operations(addition, subtraction, multiplication,\n" +
                "division) with fractions.");
        System.out.println("The fractions to which operations will be performed should be entered by the user at runtime.");
        System.out.println("Provide a menu facility for the user of your application.");
    }

    private Fraction verify_instance()
    {

        switch (choice) {
            case 1:
                if (fraction1 instanceof MixedFraction && fraction2 instanceof MixedFraction)
                {
                    return ((MixedFraction) fraction1).add((MixedFraction) fraction2);
                }
                else if (fraction1 != null && fraction2 instanceof MixedFraction)
                {
                    return fraction1.add(fraction2);
                }
                else if (fraction1 instanceof MixedFraction && fraction2 != null)
                {
                    return fraction1.add(fraction2);
                }
                else
                {
                    assert fraction1 != null;
                    assert fraction2 != null;
                    return fraction1.add(fraction2);
                }
            case 2:
                if (fraction1 instanceof MixedFraction && fraction2 instanceof MixedFraction)
                {
                    return ((MixedFraction) fraction1).sub((MixedFraction) fraction2);
                }
                else if (fraction1 != null && fraction2 instanceof MixedFraction)
                {
                    return new MixedFraction(0,fraction1).sub((MixedFraction) fraction2);
                }
                else if (fraction1 instanceof MixedFraction && fraction2 != null)
                {
                    return fraction1.sub(fraction2);
                }
                else
                {
                    assert fraction1 != null;
                    assert fraction2 != null;
                    return fraction1.sub(fraction2);
                }
            case 3:
                if (fraction1 instanceof MixedFraction && fraction2 instanceof MixedFraction)
                {
                    return ((MixedFraction) fraction1).multiply((MixedFraction) fraction2);
                }
                else if (fraction1 != null && fraction2 instanceof MixedFraction)
                {
                    return fraction1.multiply(fraction2);
                }
                else if (fraction1 instanceof MixedFraction && fraction2 != null)
                {
                    return fraction2.multiply(fraction1);
                }
                else
                {
                    assert fraction1 != null;
                    assert fraction2 != null;
                    return fraction1.multiply(fraction2);
                }
            case 4:
                if (fraction1 instanceof MixedFraction && fraction2 instanceof MixedFraction)
                {
                    return ((MixedFraction) fraction1).divide((MixedFraction) fraction2);
                }
                else if (fraction1 != null && fraction2 instanceof MixedFraction)
                {
                    MixedFraction temp = new MixedFraction(0,fraction1);
                    return temp.divide((MixedFraction) fraction2);
                }
                else if (fraction1 instanceof MixedFraction && fraction2 != null)
                {
                    MixedFraction temp = new MixedFraction(0,fraction2);
                    return ((MixedFraction) fraction1).divide(temp);
                }
                else
                {
                    assert fraction1 != null;
                    assert fraction2 != null;
                    return fraction1.divide(fraction2);
                }
        }
        return tempFraction;
    }
}
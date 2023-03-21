package project;

import java.util.Objects;

class Fraction
{
    private int numerator;
    private int denominator;

    public Fraction()
    {
        numerator = 0;
        denominator = 1;
    }

    Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Fraction(Fraction fraction) {
        numerator = fraction.getNumerator();
        denominator = fraction.getDenominator();
    }

    Fraction(String input_string_fraction) {
        String[] fraction_parts, numerator_denominator;
        String fraction;
        int whole;

        if (Objects.equals(input_string_fraction, input_string_fraction.strip()))
        {
            fraction_parts = input_string_fraction.split(" ");
            whole = Integer.parseInt(fraction_parts[0]);
            fraction = fraction_parts[1];
            numerator_denominator = fraction.split("/");
        }
        else
        {
            numerator_denominator = input_string_fraction.split("/");
        }


        this.numerator = Integer.parseInt(numerator_denominator[0]);
        this.denominator = Integer.parseInt(numerator_denominator[1]);
    }

    public void setDenominator(int denominator){
        this.denominator = denominator;
    }

    public int getDenominator(){
        return denominator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public int getNumerator(){
        return numerator;
    }

    public String toString(){

        if (denominator == numerator) return "1";
        else if (denominator == 1) return numerator + "";
        else if (numerator == 0) return "0";
        else if (denominator == 0) return "Undefined";
        return numerator + "/" + denominator;
    }

    public double toDouble(){
        return (double) numerator/denominator;
    }

    public Fraction add(Fraction another)
    {
        if (denominator == another.getDenominator())
        {
            numerator = numerator + another.getNumerator();
        }
        else if (denominator != another.getDenominator())
        {
            numerator = (numerator * another.getDenominator()) + (another.getNumerator() * denominator);
            denominator = denominator * another.getDenominator();
        }
        return this;
    }

    public Fraction sub(Fraction another)
    {
        if (denominator == another.getDenominator())
        {
            numerator = numerator - another.getNumerator();
        }
        else if (denominator != another.getDenominator())
        {
            numerator = (numerator * another.getDenominator()) - (another.getNumerator() * denominator);
            denominator = denominator * another.getDenominator();
        }
        return this;
    }

    public Fraction multiply(Fraction another)
    {
        numerator = numerator * another.getNumerator();
        denominator = denominator * another.getDenominator();
        return this;
    }

    public Fraction divide(Fraction another)
    {
        numerator = numerator * another.getDenominator();
        denominator = denominator * another.getNumerator();
        return this;
    }

    private int computeGCD(int value1, int value2) //recursion
    {
        try {
            if (value1 == 0) return value2;
            else if (value1 == value2) return 1;
            else if (value1 < value2) {
                return computeGCD(value2 % value1, value1);
            } else {
                return computeGCD(value1 % value2, value2);
            }
        } catch (ArithmeticException e) {
            System.out.println("The fraction is undefined");
        }
        return 0;
    }

    public Fraction reduceFraction(Fraction fraction)
    {
    /*
     GCD -> defined as greatest common denominator
     #NOTE: GCD AND GCF ARE EXACTLY THE SAME
    */
        int GCD;
        int numerator1 = 0;
        int denominator1 = 0;
        try {
            GCD = computeGCD(fraction.getNumerator(), fraction.getDenominator());
            numerator1 = fraction.getNumerator() / GCD;
            denominator1 = fraction.getDenominator() / GCD;

        } catch (ArithmeticException e) {
            System.out.println("Division by zero is undefined");
        }
        return new Fraction(numerator1, denominator1);
    }
}
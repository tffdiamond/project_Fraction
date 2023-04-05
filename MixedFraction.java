package project;

class MixedFraction extends Fraction {
    private int whole;

    MixedFraction() {
    }

    MixedFraction(int whole, Fraction fraction) {
        super(fraction);
    }

    MixedFraction(int whole, int numerator, int denominator) {
        super(numerator, denominator);
        this.whole = whole;
    }

    MixedFraction(Fraction fraction) {
        super(fraction);
    }

    public void setWholePart(int whole) {
        this.whole = whole;
    }

    public void setFractionPart(Fraction fraction) {
    }

    public int getWhole() {
        return whole;
    }

    public Fraction getFractionPart() {
        return this;
    }

    public Fraction toFraction(){
        return this;
    }

    public MixedFraction add(MixedFraction other){

        whole = getWhole() + other.getWhole();

        int newNumerator = 0;
        int newDenominator = getDenominator(); // or int newDenominator = other.getDenominator()

        if (getDenominator() == other.getDenominator())
        {
            newNumerator = getNumerator() + other.getNumerator();
        }
        else if (getDenominator() != other.getDenominator())
        {
            newNumerator = (getNumerator() * other.getDenominator()) + (other.getNumerator() * getDenominator());
            newDenominator = getDenominator() * other.getDenominator();
        }
        return new MixedFraction(whole, newNumerator, newDenominator);
    }

    public MixedFraction sub(MixedFraction other){

        whole = getWhole() - other.getWhole();

        int newNumerator = 0;
        int newDenominator = getDenominator(); // or int newDenominator = other.getDenominator()

        if (getDenominator() == other.getDenominator())
        {
            newNumerator = getNumerator() - other.getNumerator();
        }
        else if (getDenominator() != other.getDenominator())
        {
            newNumerator = (getNumerator() * other.getDenominator()) - (other.getNumerator() * getDenominator());
            newDenominator = getDenominator() * other.getDenominator();
        }
        return new MixedFraction(whole, newNumerator, newDenominator);

    }

    public MixedFraction multiply(MixedFraction other){

        int newNumerator = (getDenominator() * getWhole()) + getNumerator();
        int newDenominator;

        newNumerator = newNumerator * other.getNumerator();
        newDenominator = (getDenominator() * other.getDenominator());


        return new MixedFraction(other.whole, newNumerator, newDenominator);

    }

    public MixedFraction divide(MixedFraction other){
        int newNumerator;
        int newDenominator;

        if (other.getWhole() == 0 && getWhole() != 0)
        {
            // Converting mixed fraction into fraction
            newNumerator = (getDenominator() * getWhole()) + getNumerator();

            newNumerator = newNumerator * other.getDenominator();
            newDenominator = (getDenominator() * other.getNumerator());

            return new MixedFraction(other.whole, newNumerator, newDenominator);
        }

        else
        {
            int tempNumerator;

            // Converting mixed fraction into fraction
            tempNumerator = (other.getDenominator() * other.getWhole()) + other.getNumerator();

            newNumerator = getNumerator() * other.getDenominator();
            newDenominator = getDenominator() * tempNumerator;

            return new MixedFraction(getWhole(), newNumerator, newDenominator);
        }
    }

    @Override
    public String toString() {
        if (whole == 0) return getNumerator() + "/" + getDenominator();
        else if (getDenominator() == getNumerator()) return whole + 1 + "";
        else if (getDenominator() == 1) return whole + getNumerator() + "";
        else if (getNumerator() == 0) return whole + "";
        else if (getDenominator() == 0) return "Undefined";
        return whole + " " + getNumerator() + "/" + getDenominator();
    }

    @Override
    public double toDouble(){
        if (whole == 0) return (double) getNumerator()/getDenominator();
        else if (getDenominator() == getNumerator()) return whole + 1;
        else if (getDenominator() == 1) return whole + getNumerator();
        else if (getNumerator() == 0) return whole;
        else if (getDenominator() == 0) return -1;
        return whole + (getNumerator()/ (double) getDenominator());
    }
}
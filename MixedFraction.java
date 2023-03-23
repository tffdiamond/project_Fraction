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
//
//    public MixedFraction multiply(MixedFraction other){
//
//    }
//
//    public MixedFraction divide(MixedFraction other){
//
//    }

    @Override
    public String toString() {
        return whole + " " + getNumerator() + "/" + getDenominator();
    }

    @Override
    public double toDouble(){
        if (getDenominator() == getNumerator()) return whole + 1;
        else if (getDenominator() == 1) return whole + getNumerator();
        else if (getNumerator() == 0) return whole;
        else if (getDenominator() == 0) System.out.println("Undefined");
        return whole + (double) (getNumerator()/getDenominator());
    }

    //    public String toString() {
//        return whole + " " + getNumerator() + "/" + getDenominator();
//    }
}
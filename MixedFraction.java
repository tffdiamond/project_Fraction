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

        // Formula for changing an improper fraction to mixed fraction
        if (numerator > denominator) {
            numerator = numerator % denominator;
            whole = numerator / denominator;
            setWholePart(whole);
        }

        new Fraction(numerator, denominator);
    }

    MixedFraction(Fraction fraction) {

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

//    public MixedFraction add(MixedFraction other){
//
//    }
//
//    public MixedFraction sub(MixedFraction other){
//
//    }
//
//    public MixedFraction multiply(MixedFraction other){
//
//    }
//
//    public MixedFraction divide(MixedFraction other){
//
//    }

    public String toString() {
        return "";
    }
}
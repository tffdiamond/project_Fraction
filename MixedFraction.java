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

        int newNumerator = 0;
        int newDenominator = getDenominator(); // or int newDenominator = other.getDenominator()

        if (getDenominator() == other.getDenominator())
        {
            if (getWhole() != 0 && other.getWhole() != 0)
            {
                newNumerator =
                        (((getWhole() * getDenominator())) + getNumerator()) - (((other.getWhole() * other.getDenominator()) + other.getNumerator()));
            }
            else if (getWhole() == 0 && other.getWhole() != 0)
            {
                newNumerator = getNumerator() - ((other.getWhole() * other.getDenominator()) + other.getNumerator());
            }
            else if (getWhole() != 0 && other.getWhole() == 0)
            {
                newNumerator = ((getWhole() * getDenominator()) + getNumerator()) - other.getNumerator();
            }
        }
        else if (getDenominator() != other.getDenominator())
        {
            if (getWhole() != 0 && other.getWhole() != 0)
            {
                newNumerator =
                        ((((getWhole() * getDenominator())) + getNumerator()) * other.getDenominator()) - ((((other.getWhole() * other.getDenominator())) + other.getNumerator()) * getDenominator());
            }
            else if (getWhole() == 0 && other.getWhole() != 0)
            {
                newNumerator =
                        (getNumerator() * other.getDenominator()) - (((other.getWhole() * other.getDenominator()) + other.getNumerator()) * getDenominator());
            }
            else if (getWhole() != 0 && other.getWhole() == 0)
            {
                newNumerator =
                        (((getWhole() * getDenominator()) + getNumerator()) * other.getDenominator()) - (other.getNumerator() * getDenominator());
            }
            newDenominator = getDenominator() * other.getDenominator();
        }

        return new MixedFraction(0, newNumerator, newDenominator);
    }

    public MixedFraction multiply(MixedFraction other)
    {
        int newNumerator = 0;
        int newDenominator;

        if (getWhole() != 0 && other.getWhole() != 0)
        {
            newNumerator =
                    (((getWhole() * getDenominator())) + getNumerator())  * other.getDenominator();
        }
        else if (getWhole() == 0 && other.getWhole() != 0)
        {
            newNumerator =
                    getNumerator() * ((other.getWhole() * other.getDenominator()) + other.getNumerator());
        }
        else if (getWhole() != 0 && other.getWhole() == 0)
        {
            newNumerator =
                    ((getWhole() * getDenominator()) + getNumerator())  * other.getNumerator();
        }
        newDenominator = getDenominator() * other.getDenominator();

        return new MixedFraction(0, newNumerator, newDenominator);
    }

    public MixedFraction divide(MixedFraction other){
        int newNumerator = 0;
        int newDenominator;

        if (getWhole() != 0 && other.getWhole() != 0)
        {
            newNumerator =
                    (((getWhole() * getDenominator())) + getNumerator())  * other.getDenominator();
        }
        else if (getWhole() == 0 && other.getWhole() != 0)
        {
            newNumerator =
                    getNumerator() * ((other.getWhole() * other.getDenominator()) + other.getNumerator());
        }
        else if (getWhole() != 0 && other.getWhole() == 0)
        {
            newNumerator =
                    ((getWhole() * getDenominator()) + getNumerator())  * other.getNumerator();
        }
        newDenominator = getDenominator() * (((other.getWhole() * other.getDenominator())) + other.getNumerator());

        return new MixedFraction(0, newNumerator, newDenominator);
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
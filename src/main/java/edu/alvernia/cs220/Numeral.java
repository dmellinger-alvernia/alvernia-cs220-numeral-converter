package edu.alvernia.cs220;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Numeral
 * Contains the numeral, and the Numeral System which it is representing.
 */
public class Numeral {

    // The Numeral being worked with. Rather than work with a datatype like
    // int or double, which are numeric, a String is used since non-numeric
    // characters are used to represent some values of the numeral.
    public String numeral;

    // The system which the numeral is actually representing.
    public NumeralSystem numeralSystem;

    /**
     * The Constructor for instantiating the numeral.
     */
    public Numeral(String numeral, NumeralSystem numeralSystem) {
        this.numeral = numeral;
        this.numeralSystem = numeralSystem;
    }

    /**
     * Creates a new Numeral object, converted to the specified system.
     * @return The new numeral
     */
    public Numeral convert(NumeralSystem targetNumeralSystem) {
        String output = "";
        // First convert the current number to a decimal
        long decimal = convertToDecimal();
        if (targetNumeralSystem == NumeralSystem.Decimal) {
            // The Numeral target is Decimal, which has already been converted to.
            // No further conversion is needed.
            return new Numeral(roundAsDecimal(decimal), targetNumeralSystem);
        }
        // The core algorithm for encoding a number from Decimal, to the target
        // system.
        while (decimal > 0) {
            // Divide the decimal version by the base being converted to.
            long quotient = (decimal / targetNumeralSystem.getBase());
            // The remainder from the division (modulus) operation,
            // which will end up being the value of the current
            // digit.
            int remainder = (int) (decimal % targetNumeralSystem.getBase());
            // The remainder will be used to this digits actual character.
            // For example, if Hexadecimal, a remainder of 11 will check
            // the Alphabet, and get the index at 11 which should be B.
            char value = targetNumeralSystem.getAlphabet().charAt(remainder);
            // Prepend the found digit to the numeral. In the conversion
            // algorithm, a reverse is called after the end of the loop.
            // This step effectively negates that need.
            output = value + output;
            // The result of the division operation becomes the next value
            // to divide.
            decimal = quotient;
        }
        Numeral convertedNumeral = new Numeral(output, targetNumeralSystem);
        return convertedNumeral;
    }

    /**
     * Converts the Numeral to a different system, and produces a new
     * Numeral object. We can not modify the Numeral Object once created
     * making it immutable.
     * @return
     */
    private long convertToDecimal() {
        long total = 0;
        for (int i = 0; i < this.numeral.length(); i++) {
            // The current digit to look at.
            char digit = this.numeral.charAt(i);
            // Checks the Alphabet of the current number system, and finds
            // the index in the String. The index will correspond to that
            // digits Decimal value.
            int digitValue = this.numeralSystem.getAlphabet().indexOf(digit);
            // Finds the exponent needed for the current digits value
            int power = this.numeral.length() - 1 - i;
            // Does the power of the current place, and multiplies it be the value
            // of the digit.
            total += Math.pow(this.numeralSystem.getBase(), power) * digitValue;
        }
        return total;
    }

    /**
     * Takes in a variable of tpye 'double', and converts it to a String
     * removing and decimal places that exist to keep it as a round
     * number.
     * @param value
     * @return
     */
    static private String roundAsDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.FLOOR);
        String formattedDouble = df.format(value);
        return formattedDouble;
    }

    /**
     * Overrides the toString method to print information on
     * the numeral.
     * @return
     */
    @Override
    public String toString() {
        return this.numeralSystem.getName() + "[" + this.numeral + "]";
    }
}

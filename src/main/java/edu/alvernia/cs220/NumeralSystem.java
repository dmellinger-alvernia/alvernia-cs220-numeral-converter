package edu.alvernia.cs220;

/**
 * Definition of the different numbering (numeral) systems that we can convert to
 * and from, defining the base they are in.
 */
public enum NumeralSystem {
    Binary(2, "Binary", "01"),
    Decimal(10, "Decimal", "0123456789"),
    Hexadecimal(16, "Hexadecimal", "0123456789ABCDEF"),
    Base64(16, "Hexadecimal", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-");

    private final int base;
    private final String name;
    private final String alphabet;

    NumeralSystem(int base, String name, String alphabet) {
        this.base = base;
        this.name = name;
        this.alphabet = alphabet;
    }

    public int getBase() {
        return this.base;
    }

    public String getName() {
        return name;
    }

    public String getAlphabet() {
        return alphabet;
    }
}

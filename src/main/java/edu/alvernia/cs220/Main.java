package edu.alvernia.cs220;

import java.util.Scanner;

public class Main {

    /**
     * Main starting point for the program
     * @param args
     */
    public static void main(String[] args) {

        // Scanner for taking input from the prompt
        Scanner scanner = new Scanner(System.in);
        String continueLoop = "Y";
        do {
            // Create a title for this program
            System.out.println("Numeral Number Converter");
            System.out.println("------------------------");

            // Display a menu to select the base of the number
            System.out.println("Select a Numeral System to convert from: ");
            System.out.println("1. Binary  2. Decimal  3. Hexadecimal 4. Base64");
            System.out.print("Option: ");
            int numeralType = scanner.nextInt();

            System.out.print("Enter the number to convert: ");
            String inputtedNumeral = scanner.next();

            Numeral numeral = null;
            NumeralSystem numeralSystem = null;
            switch (numeralType) {
                case 1:
                    // Construct our Binary numeral type
                    numeralSystem = NumeralSystem.Binary;
                    break;
                case 2:
                    // construct our Decimal Type
                    numeralSystem = NumeralSystem.Decimal;
                    break;
                case 3:
                    // construct our Hexadecimal Type
                    numeralSystem = NumeralSystem.Hexadecimal;
                    break;
                case 4:
                    // construct our Base64 Type
                    numeralSystem = NumeralSystem.Base64;
                    break;
                default:
                    // What do we do when we get an error?
                    break;
            }
            numeral = new Numeral(inputtedNumeral, numeralSystem);

            // Prompt the user to input the number they want to convert
            //
            System.out.println("Select a Numeral System to convert from: ");
            System.out.println("1. Binary  2. Decimal  3. Hexadecimal 4. Base64");
            System.out.print("Option: ");
            int convertingType = scanner.nextInt();
            switch (convertingType) {
                case 1:
                    System.out.println("In Binary it is: " + numeral.convert(NumeralSystem.Binary).numeral);
                    break;
                case 2:
                    System.out.println("In Decimal it is: " + numeral.convert(NumeralSystem.Decimal).numeral);
                    break;
                case 3:
                    System.out.println("In Hexadecimal it is: " + numeral.convert(NumeralSystem.Hexadecimal).numeral);
                    break;
                case 4:
                    System.out.println("In Base64 it is: " + numeral.convert(NumeralSystem.Base64).numeral);
                    break;
                default:
                    System.out.println("The value you entered is not correct.");
                    break;
            }
            System.out.println("Enter 'Y' to continue, or 'N' to exit: ");
            continueLoop = scanner.next();
        } while (continueLoop.equalsIgnoreCase("Y"));
    }
}


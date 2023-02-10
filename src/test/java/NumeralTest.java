import edu.alvernia.cs220.Numeral;
import edu.alvernia.cs220.NumeralSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumeralTest {

    @Test
    void testConvertBinary() {
        // Convert to Decimal
        Numeral numeral = new Numeral(Integer.toBinaryString(15), NumeralSystem.Binary);
        assertEquals("15", numeral.convert(NumeralSystem.Decimal).numeral);
        numeral = new Numeral(Integer.toBinaryString(128), NumeralSystem.Binary);
        assertEquals("128", numeral.convert(NumeralSystem.Decimal).numeral);
        numeral = new Numeral(Integer.toBinaryString(643567), NumeralSystem.Binary);
        assertEquals("643567", numeral.convert(NumeralSystem.Decimal).numeral);

        // Convert to Hexadecimal
        numeral = new Numeral(Integer.toBinaryString(15), NumeralSystem.Binary);
        assertEquals(Integer.toHexString(15).toUpperCase(), numeral.convert(NumeralSystem.Hexadecimal).numeral);
        numeral = new Numeral(Integer.toBinaryString(45), NumeralSystem.Binary);
        assertEquals(Integer.toHexString(45).toUpperCase(), numeral.convert(NumeralSystem.Hexadecimal).numeral);
        numeral = new Numeral(Integer.toBinaryString(643567), NumeralSystem.Binary);
        assertEquals(Integer.toHexString(643567).toUpperCase(), numeral.convert(NumeralSystem.Hexadecimal).numeral);
    }

    @Test
    void testConvertDecimal() {
        // Convert to Binary
        Numeral numeral = new Numeral("15", NumeralSystem.Decimal);
        assertEquals(Integer.toBinaryString(15), numeral.convert(NumeralSystem.Binary).numeral);
        numeral = new Numeral("987", NumeralSystem.Decimal);
        assertEquals(Integer.toBinaryString(987), numeral.convert(NumeralSystem.Binary).numeral);
        numeral = new Numeral("4964", NumeralSystem.Decimal);
        assertEquals(Integer.toBinaryString(4964), numeral.convert(NumeralSystem.Binary).numeral);

        // Convert to Hexadecimal
        numeral = new Numeral("15", NumeralSystem.Decimal);
        assertEquals(Integer.toHexString(15).toUpperCase(), numeral.convert(NumeralSystem.Hexadecimal).numeral);
        numeral = new Numeral("1023", NumeralSystem.Decimal);
        assertEquals(Integer.toHexString(1023).toUpperCase(), numeral.convert(NumeralSystem.Hexadecimal).numeral);
        numeral = new Numeral("54345", NumeralSystem.Decimal);
        assertEquals(Integer.toHexString(54345).toUpperCase(), numeral.convert(NumeralSystem.Hexadecimal).numeral);
    }

    @Test
    void testConvertHexadecimal() {
        // Convert to Binary
        Numeral numeral = new Numeral(Integer.toHexString(15).toUpperCase(), NumeralSystem.Hexadecimal);
        assertEquals(Integer.toBinaryString(15).toUpperCase(), numeral.convert(NumeralSystem.Binary).numeral);
        numeral = new Numeral(Integer.toHexString(987).toUpperCase(), NumeralSystem.Hexadecimal);
        assertEquals(Integer.toBinaryString(987), numeral.convert(NumeralSystem.Binary).numeral);
        numeral = new Numeral(Integer.toHexString(4964).toUpperCase(), NumeralSystem.Hexadecimal);
        assertEquals(Integer.toBinaryString(4964), numeral.convert(NumeralSystem.Binary).numeral);

        // Convert to Decimal
        numeral = new Numeral(Integer.toHexString(15).toUpperCase(), NumeralSystem.Hexadecimal);
        assertEquals("15", numeral.convert(NumeralSystem.Decimal).numeral);
        numeral = new Numeral(Integer.toHexString(1023).toUpperCase(), NumeralSystem.Hexadecimal);
        assertEquals("1023", numeral.convert(NumeralSystem.Decimal).numeral);
        numeral = new Numeral(Integer.toHexString(54345).toUpperCase(), NumeralSystem.Hexadecimal);
        assertEquals("54345", numeral.convert(NumeralSystem.Decimal).numeral);

    }

    @Test
    void testConvertToMethod() {
        Numeral numeral = new Numeral("F", NumeralSystem.Hexadecimal);
        assertEquals("15", numeral.convert(NumeralSystem.Decimal).numeral);
        Numeral binary = new Numeral("10000", NumeralSystem.Binary);
        assertEquals("10", binary.convert(NumeralSystem.Hexadecimal).numeral);
        Numeral decimal = new Numeral("35", NumeralSystem.Decimal);
        assertEquals("23", decimal.convert(NumeralSystem.Hexadecimal).numeral);
        decimal = new Numeral("36", NumeralSystem.Decimal);
        assertEquals("24", decimal.convert(NumeralSystem.Hexadecimal).numeral);
        decimal = new Numeral("37", NumeralSystem.Decimal);
        assertEquals("25", decimal.convert(NumeralSystem.Hexadecimal).numeral);
        decimal = new Numeral("38", NumeralSystem.Decimal);
        assertEquals("26", decimal.convert(NumeralSystem.Hexadecimal).numeral);
        decimal = new Numeral("39", NumeralSystem.Decimal);
        assertEquals("27", decimal.convert(NumeralSystem.Hexadecimal).numeral);
        decimal = new Numeral("40", NumeralSystem.Decimal);
        assertEquals("28", decimal.convert(NumeralSystem.Hexadecimal).numeral);
    }

    @Test
    void testUsingBase64() {
        Numeral numeral = new Numeral("765433456765", NumeralSystem.Decimal);
        assertEquals("LI3Y6h9", numeral.convert(NumeralSystem.Base64).numeral);
        numeral = new Numeral("LI3Y6h9", NumeralSystem.Base64);
        assertEquals("765433456765", numeral.convert(NumeralSystem.Decimal).numeral);
    }

}

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RomanNumberTest {

    public void testRomanNumberValue(String romanNumber, Integer decimalNumber) {
        RomanNumber test = new RomanNumber(decimalNumber);
        assertEquals(romanNumber, test.value());
    }
    @Test
    public void romanNumberValueShouldGetRomanNumberLessThan10() {
        RomanNumber one = new RomanNumber(1);
        assertEquals("I", one.value());

        RomanNumber two = new RomanNumber(2);
        assertEquals("II", two.value());

        RomanNumber three = new RomanNumber(3);
        assertEquals("III", three.value());

        RomanNumber four = new RomanNumber(4);
        assertEquals("IV", four.value());

        RomanNumber five = new RomanNumber(5);
        assertEquals("V", five.value());

        RomanNumber six = new RomanNumber(6);
        assertEquals("VI", six.value());

        RomanNumber seven = new RomanNumber(7);
        assertEquals("VII", seven.value());

        RomanNumber eight = new RomanNumber(8);
        assertEquals("VIII", eight.value());

        RomanNumber nine = new RomanNumber(9);
        assertEquals("IX", nine.value());

        RomanNumber ten = new RomanNumber(10);
        assertEquals("X", ten.value());
    }

    @Test
    public void romanNumberValueShouldGetRomanNumberLessThan50() {
       RomanNumber twentyTwo = new RomanNumber(22);
       assertEquals("XXII", twentyTwo.value());

       RomanNumber forty = new RomanNumber(40);
       assertEquals("XL", forty.value());
    }

    @Test
    public void romanNumberValueShouldGetRomanNumberLessThan100() {
        testRomanNumberValue("LXVII", 67);
        testRomanNumberValue("XC", 90);
    }

    @Test
    public void romanNumberValueShouldGetRomanNumberLessThan3000() {
        testRomanNumberValue("LXVII", 67);
        testRomanNumberValue("XC", 90);
    }

    @Test
    public void romanNumberValueShouldGetRomanNumberLessThan1() {
        testRomanNumberValue("LXVII", 67);
        testRomanNumberValue("XC", 90);
    }

    @Test
    public void romanNumberValueShouldGetRomanNumberMoreThan3000() {
        assertThrows(IllegalArgumentException.class, ()-> testRomanNumberValue("ERROR", 4903));
    }

    @Test
    public void romanNumberValueCanBeAdd() {
        RomanNumber romanNumber1 = new RomanNumber(10);
        RomanNumber romanNumber2 = new RomanNumber(25);

        assertEquals("XXXV", romanNumber1.plus(romanNumber2).value());
    }
}

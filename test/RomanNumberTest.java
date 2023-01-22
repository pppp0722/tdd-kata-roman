import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import romannumber.RomanNumber;
import org.junit.Test;

public class RomanNumberTest {

    @Test
    public void 십보다_작은_숫자_로마_숫자_변환_테스트() {
        testRomanNumber("I", 1);
        testRomanNumber("II", 2);
        testRomanNumber("III", 3);
        testRomanNumber("IV", 4);
        testRomanNumber("V", 5);
        testRomanNumber("VI", 6);
        testRomanNumber("VII", 7);
        testRomanNumber("VIII", 8);
        testRomanNumber("IX", 9);
    }

    @Test
    public void 오십보다_작은_숫자_로마_숫자_변환_테스트() {
        testRomanNumber("X", 10);
        testRomanNumber("XXII", 22);
        testRomanNumber("XL", 40);
    }

    @Test
    public void 백보다_작은_숫자_로마_숫자_변환_테스트() {
        testRomanNumber("L", 50);
        testRomanNumber("LXVII", 67);
        testRomanNumber("XC", 90);
    }

    @Test
    public void 사천보다_작은_숫자_로마_숫자_변환_테스트() {
        testRomanNumber("LXVII", 67);
        testRomanNumber("XC", 90);
    }

    @Test
    public void 일보다_작은_숫자_로마_숫자_변환_예외_테스트() {
        assertThrows(IllegalArgumentException.class,
            () -> new RomanNumber(0));
    }

    @Test
    public void 사천보다_크거나_같은_숫자_로마_숫자_변환_예외_테스트() {
        assertThrows(IllegalArgumentException.class,
            () -> new RomanNumber(4000));
    }

    @Test
    public void 로마_숫자_덧셈_테스트() {
        RomanNumber romanNumber10 = new RomanNumber(10);
        RomanNumber romanNumber25 = new RomanNumber(25);
        RomanNumber romanNumber35 = romanNumber10.plus(romanNumber25);
        testRomanNumber(romanNumber35.getValue(), 35);
    }

    @Test
    public void 로마_숫자_뺄셈_테스트() {
        RomanNumber romanNumber10 = new RomanNumber(10);
        RomanNumber romanNumber25 = new RomanNumber(25);
        RomanNumber romanNumber15 = romanNumber25.minus(romanNumber10);
        testRomanNumber(romanNumber15.getValue(), 15);
    }

    @Test
    public void 로마_숫자_곱셈_테스트() {
        RomanNumber romanNumber10 = new RomanNumber(10);
        RomanNumber romanNumber25 = new RomanNumber(25);
        RomanNumber romanNumber250 = romanNumber10.multiply(romanNumber25);
        testRomanNumber(romanNumber250.getValue(), 250);
    }

    @Test
    public void 로마_숫자_나눗셈_테스트() {
        RomanNumber romanNumber2 = new RomanNumber(2);
        RomanNumber romanNumber10 = new RomanNumber(10);
        RomanNumber romanNumber5 = romanNumber10.divide(romanNumber2);
        testRomanNumber(romanNumber5.getValue(), 5);
    }

    public void testRomanNumber(String expected, Integer decimalNumber) {
        RomanNumber romanNumber = new RomanNumber(decimalNumber);
        assertEquals(expected, romanNumber.getValue());
    }
}

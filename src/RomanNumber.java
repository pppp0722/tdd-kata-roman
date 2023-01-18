import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

    // 1 : I, 4 : IV, 5 : V, 9 : IX, 10 : X, 40 : XL, 50 : L, 90 : XC, 100 : C, 400 : CD, 500 : D, 900 : CM, 1000 : M
    private final int decimalNumber;
    private final String romanNumber;
    private static final int[] ROMAN_NUMS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final Map<Integer, String> ROMAN_MAP = new HashMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public RomanNumber(int decimalNumber) {
        this.romanNumber = toRomanNumber(decimalNumber);
        this.decimalNumber = decimalNumber;
    }

    private String toRomanNumber(int decimalNumber) {
        // 입력값 범위 체크
        checkValue(decimalNumber);

        StringBuilder sb = new StringBuilder();

        for (int romanNum : ROMAN_NUMS) {
            while (decimalNumber >= romanNum) {
                sb.append(ROMAN_MAP.get(romanNum));
                decimalNumber -= romanNum;
            }
        }
        return sb.toString();
    }

    public RomanNumber plus(RomanNumber romanNumber) {
        return new RomanNumber(this.decimalNumber + romanNumber.getDecimalNumber());
    }

    private void checkValue(int decimalNumber) {
        if (decimalNumber < 1 || decimalNumber >= 4000) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }

    public String value() {
        return this.romanNumber;
    }

    public int getDecimalNumber() {
        return this.decimalNumber;
    }

}

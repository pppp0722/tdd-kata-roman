package romannumber;

public class RomanNumber {

    public static final int MIN = 1;
    public static final int MAX = 4_000 - 1;
    private final String value;
    private final int decimalNumber;

    public RomanNumber(int decimalNumber) {
        validateRange(decimalNumber);
        value = toRomanNumber(decimalNumber);
        this.decimalNumber = decimalNumber;
    }

    private String toRomanNumber(int decimalNumber) {
        StringBuilder value = new StringBuilder();
        for (RomanNumberEnum romanNumberEnum : RomanNumberEnum.values()) {
            while (decimalNumber >= romanNumberEnum.getDecimalNumber()) {
                value.append(romanNumberEnum.name());
                decimalNumber -= romanNumberEnum.getDecimalNumber();
            }
        }
        return value.toString();
    }

    public RomanNumber plus(RomanNumber romanNumber) {
        return new RomanNumber(decimalNumber + romanNumber.getDecimalNumber());
    }

    public RomanNumber minus(RomanNumber romanNumber) {
        return new RomanNumber(decimalNumber - romanNumber.getDecimalNumber());
    }

    public RomanNumber multiply(RomanNumber romanNumber) {
        return new RomanNumber(decimalNumber * romanNumber.getDecimalNumber());
    }

    public RomanNumber divide(RomanNumber romanNumber) {
        // 로마 숫자는 0이 없으므로 division by zero exception 발생 X
        return new RomanNumber(decimalNumber / romanNumber.getDecimalNumber());
    }

    private void validateRange(int decimalNumber) {
        if (decimalNumber < MIN || decimalNumber > MAX) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }

    public String getValue() {
        return value;
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }
}

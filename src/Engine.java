import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    public Engine() {
    }

    public void start() {
        String line;
        int decimalNumber;
        RomanNumber romanNumber;
        // try-catch-resources(java.lang.AutoCloseable)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("1 이상, 4000 미만 십진수 숫자를 입력하세요. (종료 -> q) : ");
                line = br.readLine();
                if (isQuit(line)) {
                    System.out.println("종료합니다.");
                    break;
                }
                if (!isValidNumber(line)) {
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
                decimalNumber = Integer.parseInt(line);
                romanNumber = new RomanNumber(decimalNumber);
                System.out.println(decimalNumber + " -> " + romanNumber.getValue());
            }
        } catch (IOException e) {
            System.out.println("예기치 못한 오류 발생!");
        }
    }

    private boolean isQuit(String line) {
        return "q".equalsIgnoreCase(line);
    }

    private boolean isValidNumber(String line) {
        if (line.equals("") || !line.chars().allMatch(Character::isDigit)) {
            return false;
        }
        int number = Integer.parseInt(line);
        return number >= RomanNumber.MIN && number <= RomanNumber.MAX;
    }
}

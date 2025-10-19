package calculator.domain;

public class Numbers {
    private static final String MESSAGE_NOT_NUMBER = "숫자가 아닌 값이 포함되어 있습니다.";
    private static final String MESSAGE_NEGATIVE = "음수는 포함될 수 없습니다.";

    private final int[] values;

    public Numbers(Tokens tokens) {
        this.values = toInts(tokens);
        validateNegativeNumbers();
    }

    private int[] toInts(Tokens tokens) {
        String[] stringTokens = tokens.getValues();
        int length = tokens.length();

        int[] numbers = new int[length];
        try {
            fillNumbers(numbers, stringTokens);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_NOT_NUMBER);
        }

        return numbers;
    }

    private void fillNumbers(int[] numbers, String[] stringTokens) {
        for (int i = 0; i < stringTokens.length; i++) {
            numbers[i] = Integer.parseInt(stringTokens[i]);
        }
    }

    private void validateNegativeNumbers() {
        for (int number : this.values) {
            validateSingleNumberPositive(number);
        }
    }

    private void validateSingleNumberPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(MESSAGE_NEGATIVE);
        }
    }

    public int sum() {
        int result = 0;
        for (int number : this.values) {
            result += number;
        }
        return result;
    }
}

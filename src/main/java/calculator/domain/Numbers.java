package calculator.domain;

public class Numbers {
    private final int[] values;

    public Numbers(Tokens tokens) {
        this.values = toInts(tokens);
    }

    public int[] toInts(Tokens tokens) {
        int length = tokens.length();
        String[] stringTokens = tokens.stream().toArray(String[]::new);

        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(stringTokens[i]);
        }
        return numbers;
    }

    public int sum() {
        int result = 0;
        for (int number : this.values) {
            result += number;
        }
        return result;
    }
}

package calculator.domain;

public class Tokens {
    private final String[] values;

    public Tokens(String[] values) {
        this.values = values;
    }

    public String[] getValues() {
        return values.clone();
    }

    public int length() {
        return this.values.length;
    }
}


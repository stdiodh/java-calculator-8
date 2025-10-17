package calculator.domain;

public class Expression {
    private final String value;

    public Expression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

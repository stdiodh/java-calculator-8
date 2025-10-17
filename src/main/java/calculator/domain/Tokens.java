package calculator.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public class Tokens {
    private final String[] values;

    public Tokens(String[] values) {
        this.values = values;
    }

    public Stream<String> stream() {
        return Arrays.stream(values);
    }

    public int length() {
        return this.values.length;
    }
}


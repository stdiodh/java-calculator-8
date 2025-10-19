package calculator.service;

import calculator.domain.Expression;
import calculator.domain.Numbers;
import calculator.domain.Tokenizer;
import calculator.domain.Tokens;

public class CalculatorService {
    private final Tokenizer tokenizer;

    public CalculatorService(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public int calculate(Expression userInput) {
        Tokens parseInput = tokenizer.parse(userInput);
        Numbers numbers = new Numbers(parseInput);

        return numbers.sum();
    }
}

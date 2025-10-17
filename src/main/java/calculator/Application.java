package calculator;

import calculator.domain.Expression;
import calculator.domain.Numbers;
import calculator.domain.StringCalculator;
import calculator.domain.Tokens;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputPrompt();
        Expression userInput = new Expression(inputView.getUserInput());

        StringCalculator calculator = new StringCalculator();
        Tokens parseInput = calculator.parse(userInput);

        //TODO: 입력 검증 (예외 처리)

        Numbers numbers = new Numbers(parseInput);
        int result = numbers.sum();

        outputView.printOutputPrompt(result);
    }
}

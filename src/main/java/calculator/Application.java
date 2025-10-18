package calculator;

import calculator.domain.Expression;
import calculator.domain.Numbers;
import calculator.domain.StringCalculator;
import calculator.domain.Tokens;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        try {
            processCalculator();
        } catch (IllegalArgumentException e) {
            handleError(e);
        }
    }

    private void processCalculator() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        StringCalculator calculator = new StringCalculator();

        outputView.printInputPrompt();
        Expression userInput = new Expression(inputView.getUserInput());
        Tokens parseInput = calculator.parse(userInput);
        Numbers numbers = new Numbers(parseInput);

        int result = numbers.sum();
        outputView.printOutputPrompt(result);
    }

    private void handleError(IllegalArgumentException e) {
        OutputView outputView = new OutputView();
        outputView.printError(e);
    }
}

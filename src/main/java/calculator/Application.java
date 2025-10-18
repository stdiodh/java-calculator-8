package calculator;

import calculator.domain.Expression;
import calculator.domain.Numbers;
import calculator.domain.Tokenizer;
import calculator.domain.Tokens;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Tokenizer tokenizer = new Tokenizer();

        try {
            outputView.printInputPrompt();
            Expression userInput = new Expression(inputView.getUserInput());

            int result = processCalculator(userInput, tokenizer);

            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            handleError(e, outputView);
        }
    }

    private int processCalculator(Expression userInput, Tokenizer tokenizer) {
        Tokens parseInput = tokenizer.parse(userInput);
        Numbers numbers = new Numbers(parseInput);

        return numbers.sum();
    }

    private void handleError(IllegalArgumentException e, OutputView outputView) {
        outputView.printError(e);
    }
}

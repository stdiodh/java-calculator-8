package calculator;

import calculator.domain.Expression;
import calculator.domain.Tokenizer;
import calculator.service.CalculatorService;
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
        CalculatorService calculatorService = new CalculatorService(tokenizer);

        outputView.printInputPrompt();
        Expression userInput = new Expression(inputView.getUserInput());

        int result = calculatorService.calculate(userInput);

        outputView.printResult(result);
    }
}

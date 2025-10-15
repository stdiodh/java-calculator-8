package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputPrompt();
        String userInput = inputView.getUserInput();

        StringCalculator calculator = new StringCalculator();
        String[] parseInput = calculator.parse(userInput);

        //TODO: 입력 검증 (예외 처리)
    }
}

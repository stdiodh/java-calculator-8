package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printInputPrompt();
        String userInput = inputView.getUserInput();

        System.out.println(userInput);
        //TODO: 문자열 분리 및 파싱
    }
}

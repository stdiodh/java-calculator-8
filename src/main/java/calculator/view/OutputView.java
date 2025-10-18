package calculator.view;

public class OutputView {
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_PROMPT_MESSAGE = "결과 : ";

    public void printInputPrompt() {
        System.out.println(INPUT_PROMPT_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(OUTPUT_PROMPT_MESSAGE + result);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

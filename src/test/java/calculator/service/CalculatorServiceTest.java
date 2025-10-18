package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.Expression;
import calculator.domain.Tokenizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        Tokenizer tokenizer = new Tokenizer();
        calculatorService = new CalculatorService(tokenizer);
    }

    @Test
    @DisplayName("빈 문자열은 0을 반환한다")
    void testEmptyStringReturnsZero() {
        Expression expression = new Expression("");

        int result = calculatorService.calculate(expression);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열의 합을 반환한다")
    void testDefaultCommaSeparator() {
        Expression expression = new Expression("1,2,3");

        int result = calculatorService.calculate(expression);

        assertEquals(6, result);
    }

    @Test
    @DisplayName("콜론으로 구분된 문자열의 합을 반환한다")
    void testDefaultColonSeparator() {
        Expression expression = new Expression("1:2:3");

        int result = calculatorService.calculate(expression);

        assertEquals(6, result);
    }

    @Test
    @DisplayName("콤마와 콜론으로 구분된 문자열의 합을 반환한다")
    void testDefaultSeparator() {
        Expression expression = new Expression("1,2:3");

        int result = calculatorService.calculate(expression);

        assertEquals(6, result);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 문자열의 합을 반환한다")
    void testCustomSeparator() {
        Expression expression = new Expression("//;\\n1;2;3");

        int result = calculatorService.calculate(expression);

        assertEquals(6, result);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함된 경우 IllegalArgumentException을 던진다")
    void test_not_a_number_exception() {
        Expression expression = new Expression("1,a,3");
        String expectedMessage = "숫자가 아닌 값이 포함되어 있습니다.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                calculatorService.calculate(expression));

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("음수가 포함된 경우 IllegalArgumentException을 던진다")
    void test_negative_number_exception() {
        Expression expression = new Expression("-1:2,3");
        String expectedMessage = "음수는 포함될 수 없습니다.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                calculatorService.calculate(expression));

        assertEquals(expectedMessage, exception.getMessage());
    }
}

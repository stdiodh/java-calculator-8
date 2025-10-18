package calculator.domain;

public class StringCalculator {
    public Tokens parse(Expression expression) {
        String text = expression.getValue();
        if (text == null || text.isEmpty()) {
            return new Tokens(new String[0]);
        }

        if (text.startsWith("//") && text.contains("\n")) {
            return new Tokens(splitByCustomSeparator(text));
        }

        return new Tokens(splitByDefaultSeparator(text));
    }

    private String[] splitByDefaultSeparator(String text) {
        return text.split("[,:]]");
    }

    private String[] splitByCustomSeparator(String text) {
        final String CUSTOM_SEPARATOR_START = "//";
        final String CUSTOM_SEPARATOR_END = "\n";

        int startIndex = CUSTOM_SEPARATOR_START.length();
        int endIndex = text.indexOf(CUSTOM_SEPARATOR_END);

        String customSeparator = text.substring(startIndex, endIndex);

        String textToSplit = text.substring(endIndex + 1);

        return textToSplit.split(customSeparator);
    }
}
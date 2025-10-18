package calculator.domain;

import java.util.regex.Pattern;

public class Tokenizer {
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\\n";

    public Tokens parse(Expression expression) {
        String text = expression.getValue();
        if (text == null || text.isEmpty()) {
            return new Tokens(new String[0]);
        }

        if (text.startsWith(CUSTOM_SEPARATOR_START) && text.contains(CUSTOM_SEPARATOR_END)) {
            return new Tokens(splitByCustomSeparator(text));
        }

        return new Tokens(splitByDefaultSeparator(text));
    }

    private String[] splitByDefaultSeparator(String text) {
        return text.split("[,:]");
    }

    private String[] splitByCustomSeparator(String text) {
        int startIndex = CUSTOM_SEPARATOR_START.length();
        int endIndex = text.indexOf(CUSTOM_SEPARATOR_END);

        String customSeparator = text.substring(startIndex, endIndex);

        String textToSplit = text.substring(endIndex + CUSTOM_SEPARATOR_END.length());

        return textToSplit.split(Pattern.quote(customSeparator));
    }
}
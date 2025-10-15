package calculator.domain;

public class StringCalculator {
    public String[] split(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        if (text.startsWith("//") && text.contains("\n")) {
            return splitByCustomSeparator(text);
        }

        return splitByDefaultSeparator(text);
    }

    public String[] splitByDefaultSeparator(String text) {
        return text.split(",|:");
    }

    public String[] splitByCustomSeparator(String text) {
        final String CUSTOM_SEPARATOR_START = "//";
        final String CUSTOM_SEPARATOR_END = "\n";

        int startIndex = CUSTOM_SEPARATOR_START.length();
        int endIndex = text.indexOf(CUSTOM_SEPARATOR_END);

        String customSeparator = text.substring(startIndex, endIndex);

        String textToSplit = text.substring(endIndex + 1);

        return textToSplit.split(customSeparator);
    }
}

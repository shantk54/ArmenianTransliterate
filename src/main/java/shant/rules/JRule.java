package shant.rules;

import shant.Transliterate;
import shant.TransliterationRule;

public class JRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        char current = Character.toLowerCase(chars[i]);
        boolean isUpperCase = Character.isUpperCase(chars[i]);

        if (current == 'ջ' && Transliterate.isStartOfWord(chars, i)) {
            return new RuleResult(formatOutput("j", isUpperCase), 0);
        }

        return null;
    }

    private String formatOutput(String output, boolean isUpperCase) {
        return isUpperCase ? capitalize(output) : output;
    }

    private String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}

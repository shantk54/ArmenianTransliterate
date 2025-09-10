package shant.rules;

import shant.Transliterate;
import shant.TransliterationRule;

public class YRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        char current = Character.toLowerCase(chars[i]);
        boolean isUpperCase = Character.isUpperCase(chars[i]);

        if (current == 'ե' && i + 1 < chars.length && Character.toLowerCase(chars[i + 1]) == 'ա') {
            return new RuleResult(formatOutput("ya", isUpperCase), 1);
        }

        if (current == 'ե' && Transliterate.isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && Character.toLowerCase(chars[i + 1]) == 'ն' && Transliterate.isEndOfWord(chars, i + 1)) {
                return new RuleResult(formatOutput("en", isUpperCase), 1);
            }
            if (i + 2 < chars.length && Character.toLowerCase(chars[i + 1]) == 'ն' && Character.toLowerCase(chars[i + 2]) == 'ք' && Transliterate.isEndOfWord(chars, i + 2)) {
                return new RuleResult(formatOutput("enk", isUpperCase), 2);
            }
            if (i + 1 < chars.length && Character.toLowerCase(chars[i + 1]) == 'մ' && Transliterate.isEndOfWord(chars, i + 1)) {
                return new RuleResult(formatOutput("em", isUpperCase), 1);
            }
            if (i + 1 < chars.length && Character.toLowerCase(chars[i + 1]) == 'ս' && Transliterate.isEndOfWord(chars, i + 1)) {
                return new RuleResult(formatOutput("es", isUpperCase), 1);
            }
            return new RuleResult(formatOutput("ye", isUpperCase), 0);
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

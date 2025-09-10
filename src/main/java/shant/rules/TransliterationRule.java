package shant.rules;

import shant.utils.Utils;

public abstract class TransliterationRule {
    public abstract RuleResult apply(char[] chars, int i);

    public record RuleResult(String output, int skip) {}

    protected CharInfo getCharInfo(char[] chars, int i) {
        char current = Character.toLowerCase(chars[i]);
        boolean isUpperCase = Character.isUpperCase(chars[i]);
        return new CharInfo(current, isUpperCase);
    }

    protected String formatOutput(String output, boolean isUpperCase) {
        return isUpperCase ? Utils.capitalize(output) : output;
    }

    protected record CharInfo(char current, boolean isUpperCase) {
    }
}

package shant.rules;

import shant.utils.Utils;

public abstract class TransliterationRule {
    public abstract RuleResult apply(char[] chars, int i);

    public record RuleResult(String output, int skip) {}

    protected String formatOutput(String output, boolean isUpperCase) {
        return isUpperCase ? Utils.capitalize(output) : output;
    }
}



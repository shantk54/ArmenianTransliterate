package shant.rules;

import shant.TransliterationRule;

public class OoyRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'ո' && i + 2 < chars.length && chars[i + 1] == 'յ') {
            if (chars[i + 2] == 'ր') {
                return new RuleResult("ooyr", 2);
            }
            if (chars[i + 2] == 'ս') {
                return new RuleResult("ooys", 2);
            }
        }
        return null;
    }
}

package shant.rules;

import shant.TransliterationRule;

public class IvRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'ի' && i + 1 < chars.length && chars[i + 1] == 'ւ') {
            return new RuleResult("eev", 1);
        }
        return null;
    }
}


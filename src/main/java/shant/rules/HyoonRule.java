package shant.rules;

import shant.utils.Utils;

public class HyoonRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'ի' && i + 1 < chars.length && chars[i + 1] == 'ւ') {
            if (!Utils.isEndOfWord(chars, i + 1)) {
                return new RuleResult("yoo", 1);
            }
            return new RuleResult("eev", 1);
        }
        return null;
    }
}

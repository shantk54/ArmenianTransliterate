package shant.rules;

import shant.utils.Utils;

public class YevRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'և') {
            if (Utils.isStartOfWord(chars, i) && Utils.isEndOfWord(chars, i)) {
                return new RuleResult("yev", 0);
            }
            return new RuleResult("ev", 0);
        }
        return null;
    }
}

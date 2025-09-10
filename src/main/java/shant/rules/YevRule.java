package shant.rules;

import shant.utils.Utils;

public class YevRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (charInfo.current() == 'և') {
            if (Utils.isStartOfWord(chars, i) && Utils.isEndOfWord(chars, i)) {
                return new RuleResult(formatOutput("yev", charInfo.isUpperCase()), 0);
            }
            return new RuleResult(formatOutput("ev", charInfo.isUpperCase()), 0);
        }
        return null;
    }
}

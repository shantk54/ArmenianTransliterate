package shant.rules;

import shant.utils.Utils;

public class EeRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (charInfo.current() == 'ի' &&
                (Utils.isStartOfWord(chars, i) || Utils.isEndOfWord(chars, i))) {
            return new RuleResult(formatOutput("ee", charInfo.isUpperCase()), 0);
        }
        return null;
    }
}

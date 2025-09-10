package shant.rules;

import shant.utils.Utils;

public class EhRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (charInfo.current() == 'է' && (Utils.isEndOfWord(chars, i) || Utils.isStartOfWord(chars, i))) {
            return new RuleResult(formatOutput("eh", charInfo.isUpperCase()), 0);
        }
        return null;
    }
}

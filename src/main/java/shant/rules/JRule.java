package shant.rules;

import shant.utils.Utils;

public class JRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (Character.toLowerCase(charInfo.current()) == 'ջ' && Utils.isStartOfWord(chars, i)) {
            return new RuleResult(formatOutput("dj", charInfo.isUpperCase()), 0);
        }

        return null;
    }
}

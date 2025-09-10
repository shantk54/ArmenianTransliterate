package shant.rules;

import shant.utils.Utils;

public class HyoonRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (charInfo.current() == 'ի' && i + 1 < chars.length && chars[i + 1] == 'ւ') {
            if (!Utils.isEndOfWord(chars, i + 1)) {
                return new RuleResult(formatOutput("yoo", charInfo.isUpperCase()), 1);
            }
            return new RuleResult(formatOutput("eev", charInfo.isUpperCase()), 1);
        }
        return null;
    }
}

package shant.rules;

import shant.utils.Utils;

public class HiRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (Character.toLowerCase(charInfo.current()) == 'յ') {
            if (Utils.isEndOfWord(chars, i) && Utils.getWordLength(chars, i) > 5) {
                return new RuleResult(formatOutput("h", charInfo.isUpperCase()), 0);
            }
            if (Utils.isStartOfWord(chars, i)) {
                return new RuleResult(formatOutput("h", charInfo.isUpperCase()), 0);
            }
        }
        return null;
    }
}

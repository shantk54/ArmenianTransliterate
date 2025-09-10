package shant.rules;

import shant.utils.Utils;

public class HiRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        char current = Character.toLowerCase(chars[i]);
        boolean isUpperCase = Character.isUpperCase(chars[i]);

        if (current == 'յ') {
            if (Utils.isEndOfWord(chars, i) && Utils.getWordLength(chars, i) > 5) {
                return new RuleResult(formatOutput("h", isUpperCase), 0);
            }
            if (Utils.isStartOfWord(chars, i)) {
                return new RuleResult(formatOutput("h", isUpperCase), 0);
            }
        }
        return null;
    }

}

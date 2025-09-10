package shant.rules;

import shant.utils.Utils;

public class JRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        char current = Character.toLowerCase(chars[i]);
        boolean isUpperCase = Character.isUpperCase(chars[i]);

        if (current == 'ջ' && Utils.isStartOfWord(chars, i)) {
            return new RuleResult(formatOutput("j", isUpperCase), 0);
        }

        return null;
    }
}

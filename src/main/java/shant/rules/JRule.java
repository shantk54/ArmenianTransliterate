package shant.rules;

import shant.Transliterate;
import shant.TransliterationRule;

public class JRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'ջ' && Transliterate.isStartOfWord(chars, i)) {
            return new RuleResult("j", 0);
        }
        if (chars[i] == 'Ջ' && Transliterate.isStartOfWord(chars, i)) {
            return new RuleResult("J", 0);
        }
        return null;
    }
}

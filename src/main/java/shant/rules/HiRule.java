package shant.rules;

import shant.Transliterate;
import shant.TransliterationRule;

public class HiRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'յ') {
            if (Transliterate.isEndOfWord(chars, i) && Transliterate.getWordLength(chars, i) > 5) {
                return new RuleResult("h", 0);
            }
            if (Transliterate.isStartOfWord(chars, i)) {
                return new RuleResult("h", 0);
            }
        }
        return null;
    }
}

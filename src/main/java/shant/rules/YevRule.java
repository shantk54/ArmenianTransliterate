package shant.rules;

import shant.Transliterate;
import shant.TransliterationRule;

public class YevRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'և') {
            if (Transliterate.isStartOfWord(chars, i) && Transliterate.isEndOfWord(chars, i)) {
                return new RuleResult("yev", 0);
            }
            return new RuleResult("ev", 0);
        }
        return null;
    }
}

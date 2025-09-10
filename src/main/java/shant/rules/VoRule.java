package shant.rules;

import shant.Transliterate;
import shant.TransliterationRule;

public class VoRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        if (chars[i] == 'Ո' && Transliterate.isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && chars[i + 1] == 'ւ') {
                return new RuleResult("Oo", 1);
            }
            return new RuleResult("Vo", 0);
        }

        if (chars[i] == 'ո' && Transliterate.isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && chars[i + 1] == 'ւ') {
                return new RuleResult("oo", 1);
            }
            return new RuleResult("vo", 0);
        }

        if (chars[i] == 'ո' && i + 1 < chars.length && chars[i + 1] == 'ւ') {
            if (i + 2 < chars.length) {
                char next = chars[i + 2];
                if (next == 'ո') return new RuleResult("vo", 2);
                if (next == 'ա') return new RuleResult("va", 2);
                if (next == 'ե') return new RuleResult("ve", 2);
            }
            return new RuleResult("oo", 1);
        }

        if (chars[i] == 'Ո' && i + 1 < chars.length && chars[i + 1] == 'ւ') {
            if (i + 2 < chars.length) {
                char next = chars[i + 2];
                if (next == 'ո') return new RuleResult("Vo", 2);
                if (next == 'ա') return new RuleResult("Va", 2);
                if (next == 'ե') return new RuleResult("Ve", 2);
            }
            return new RuleResult("Oo", 1);
        }

        return null;
    }
}

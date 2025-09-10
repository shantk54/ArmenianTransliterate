package shant.rules;

import shant.Transliterate;
import shant.TransliterationRule;

public class YRule implements TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        // Case: ե + ա → "ya"
        if (chars[i] == 'ե' && i + 1 < chars.length && chars[i + 1] == 'ա') {
            return new RuleResult("ya", 1);
        }
        if (chars[i] == 'Ե' && i + 1 < chars.length && chars[i + 1] == 'ա') {
            return new RuleResult("Ya", 1);
        }

        if ((chars[i] == 'ե' || chars[i] == 'Ե') && Transliterate.isStartOfWord(chars, i)) {
            boolean isUpper = chars[i] == 'Ե';
            if (i + 1 < chars.length && chars[i + 1] == 'ն' && Transliterate.isEndOfWord(chars, i + 1)) {
                return new RuleResult(isUpper ? "En" : "en", 1);
            }
            if (i + 2 < chars.length && chars[i + 1] == 'ն' && chars[i + 2] == 'ք' && Transliterate.isEndOfWord(chars, i + 2)) {
                return new RuleResult(isUpper ? "Enk" : "enk", 2);
            }
            if (i + 1 < chars.length && chars[i + 1] == 'մ' && Transliterate.isEndOfWord(chars, i + 1)) {
                return new RuleResult(isUpper ? "Em" : "em", 1);
            }
            if (i + 1 < chars.length && chars[i + 1] == 'ս' && Transliterate.isEndOfWord(chars, i + 1)) {
                return new RuleResult(isUpper ? "Es" : "es", 1);
            }
            return new RuleResult(isUpper ? "Ye" : "ye", 0);
        }

        return null;
    }
}

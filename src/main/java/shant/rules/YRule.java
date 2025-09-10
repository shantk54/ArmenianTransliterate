package shant.rules;

import shant.utils.Utils;

public class YRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (charInfo.current() == 'ե' && i + 1 < chars.length && getCharInfo(chars, i + 1).current() == 'ա') {
            return new RuleResult(formatOutput("ya", charInfo.isUpperCase()), 1);
        }

        if (charInfo.current() == 'ե' && Utils.isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && getCharInfo(chars, i + 1).current() == 'ն' && Utils.isEndOfWord(chars, i + 1)) {
                return new RuleResult(formatOutput("en", charInfo.isUpperCase()), 1);
            }
            if (i + 2 < chars.length && getCharInfo(chars, i + 1).current() == 'ն' && getCharInfo(chars, i + 2).current() == 'ք' && Utils.isEndOfWord(chars, i + 2)) {
                return new RuleResult(formatOutput("enk", charInfo.isUpperCase()), 2);
            }
            if (i + 1 < chars.length && getCharInfo(chars, i + 1).current() == 'մ' && Utils.isEndOfWord(chars, i + 1)) {
                return new RuleResult(formatOutput("em", charInfo.isUpperCase()), 1);
            }
            if (i + 1 < chars.length && getCharInfo(chars, i + 1).current() == 'ս' && Utils.isEndOfWord(chars, i + 1)) {
                return new RuleResult(formatOutput("es", charInfo.isUpperCase()), 1);
            }
            return new RuleResult(formatOutput("ye", charInfo.isUpperCase()), 0);
        }

        return null;
    }
}

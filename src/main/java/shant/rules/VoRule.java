package shant.rules;

import shant.utils.Utils;

public class VoRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (charInfo.current() == 'ո' && Utils.isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && getCharInfo(chars, i + 1).current() == 'ւ') {
                return new RuleResult(formatOutput("oo", charInfo.isUpperCase()), 1);
            }
            return new RuleResult(formatOutput("vo", charInfo.isUpperCase()), 0);
        }

        if (charInfo.current() == 'ո' && i + 1 < chars.length && getCharInfo(chars, i + 1).current() == 'ւ') {
            if (i + 2 < chars.length) {
                CharInfo nextCharInfo = getCharInfo(chars, i + 2);
                if (nextCharInfo.current() == 'ո') return new RuleResult(formatOutput("vo", charInfo.isUpperCase()), 2);
                if (nextCharInfo.current() == 'ա') return new RuleResult(formatOutput("va", charInfo.isUpperCase()), 2);
                if (nextCharInfo.current() == 'ե') return new RuleResult(formatOutput("ve", charInfo.isUpperCase()), 2);
                if (nextCharInfo.current() == 'ի') return new RuleResult(formatOutput("vi", charInfo.isUpperCase()), 2);
            }
            return new RuleResult(formatOutput("oo", charInfo.isUpperCase()), 1);
        }

        return null;
    }
}

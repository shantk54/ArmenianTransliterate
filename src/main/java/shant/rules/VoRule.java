package shant.rules;

import shant.utils.Utils;

public class VoRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        char current = Character.toLowerCase(chars[i]);
        boolean isUpperCase = Character.isUpperCase(chars[i]);

        if (current == 'ո' && Utils.isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && Character.toLowerCase(chars[i + 1]) == 'ւ') {
                return new RuleResult(formatOutput("oo", isUpperCase), 1);
            }
            return new RuleResult(formatOutput("vo", isUpperCase), 0);
        }

        if (current == 'ո' && i + 1 < chars.length && Character.toLowerCase(chars[i + 1]) == 'ւ') {
            if (i + 2 < chars.length) {
                char next = Character.toLowerCase(chars[i + 2]);
                if (next == 'ո') return new RuleResult(formatOutput("vo", isUpperCase), 2);
                if (next == 'ա') return new RuleResult(formatOutput("va", isUpperCase), 2);
                if (next == 'ե') return new RuleResult(formatOutput("ve", isUpperCase), 2);
            }
            return new RuleResult(formatOutput("oo", isUpperCase), 1);
        }

        return null;
    }
}

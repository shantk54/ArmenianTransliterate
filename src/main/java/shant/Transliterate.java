package shant;

import shant.rules.HiRule;
import shant.rules.IvRule;
import shant.rules.JRule;
import shant.rules.OoyRule;
import shant.rules.VoRule;
import shant.rules.YRule;

import java.util.List;

public class Transliterate {

    private final List<TransliterationRule> rules = List.of(
            new YRule(),
            new VoRule(),
            new IvRule(),
            new HiRule(),
            new OoyRule(),
            new JRule()
    );

    public String transliterate(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            TransliterationRule.RuleResult applied = null;
            for (TransliterationRule rule : rules) {
                applied = rule.apply(chars, i);
                if (applied != null) break;
            }

            if (applied != null) {
                result.append(applied.output());
                i += applied.skip();
                continue;
            }

            String mapped = TransliterationMap.BASE_MAP.get(c);
            if (mapped != null) {
                result.append(mapped);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static boolean isStartOfWord(char[] chars, int i) {
        return (i == 0 || Character.isWhitespace(chars[i - 1]));
    }

    public static boolean isEndOfWord(char[] chars, int i) {
        return (i >= chars.length - 1 || Character.isWhitespace(chars[i + 1]));
    }

    public static int getWordLength(char[] chars, int i) {
        int start = i;
        while (start > 0 && !Character.isWhitespace(chars[start - 1])) start--;
        int end = i;
        while (end < chars.length && !Character.isWhitespace(chars[end])) end++;
        return end - start;
    }
}

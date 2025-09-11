package shant.transliteration;

import shant.rules.DooRule;
import shant.rules.EeRule;
import shant.rules.EhRule;
import shant.rules.HiRule;
import shant.rules.HyoonRule;
import shant.rules.JRule;
import shant.rules.NdjRule;
import shant.rules.OoyRule;
import shant.rules.TransliterationRule;
import shant.rules.VoRule;
import shant.rules.YRule;
import shant.rules.YevRule;
import shant.utils.Utils;

import java.util.List;

public class Transliteration {

    private final List<TransliterationRule> rules = List.of(
            new DooRule(),
            new EeRule(),
            new EhRule(),
            new HiRule(),
            new HyoonRule(),
            new JRule(),
            new NdjRule(),
            new OoyRule(),
            new VoRule(),
            new YevRule(),
            new YRule()
    );

    public String transliterate(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            TransliterationRule.RuleResult applied = applyRules(chars, i);
            if (applied != null) {
                result.append(applied.output());
                i += applied.skip();
                continue;
            }

            result.append(handleUnmappedCharacter(c));
        }

        return result.toString();
    }

    private TransliterationRule.RuleResult applyRules(char[] chars, int index) {
        for (TransliterationRule rule : rules) {
            TransliterationRule.RuleResult result = rule.apply(chars, index);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private String handleUnmappedCharacter(char c) {
        if (Character.isUpperCase(c)) {
            char lowerCase = Character.toLowerCase(c);
            String mapped = TransliterationMap.BASE_MAP.get(lowerCase);
            return mapped != null ? Utils.capitalize(mapped) : String.valueOf(c);
        } else {
            String mapped = TransliterationMap.BASE_MAP.get(c);
            return mapped != null ? mapped : String.valueOf(c);
        }
    }

}

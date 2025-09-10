package shant.rules;

public class DooRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (i + 2 < chars.length && charInfo.current() == 'դ' && chars[i + 1] == 'ո' && chars[i + 2] == 'ւ') {
            return new RuleResult(formatOutput("doo", charInfo.isUpperCase()), 2);
        }
        return null;
    }
}

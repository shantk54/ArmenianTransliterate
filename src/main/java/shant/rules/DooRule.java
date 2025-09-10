package shant.rules;

public class DooRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (i == 0 && chars.length == 3 && charInfo.current() == 'դ' && chars[1] == 'ո' && chars[2] == 'ւ') {
            return new RuleResult(formatOutput("doo", charInfo.isUpperCase()), 2);
        }
        return null;
    }
}

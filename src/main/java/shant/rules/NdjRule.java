package shant.rules;

public class NdjRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (i < chars.length - 1 && charInfo.current() == 'ն' && chars[i + 1] == 'ճ') {
            return new RuleResult(formatOutput("nj", charInfo.isUpperCase()), 1);
        }
        return null;
    }
}

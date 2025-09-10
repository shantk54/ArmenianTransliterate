package shant.rules;

public class OoyRule extends TransliterationRule {
    @Override
    public RuleResult apply(char[] chars, int i) {
        CharInfo charInfo = getCharInfo(chars, i);

        if (charInfo.current() == 'ո' && i + 2 < chars.length) {
            CharInfo nextCharInfo = getCharInfo(chars, i + 1);
            CharInfo thirdCharInfo = getCharInfo(chars, i + 2);

            if (nextCharInfo.current() == 'յ') {
                if (thirdCharInfo.current() == 'ր') {
                    return new RuleResult(formatOutput("ooyr", charInfo.isUpperCase()), 2);
                }
                if (thirdCharInfo.current() == 'ս') {
                    return new RuleResult(formatOutput("ooys", charInfo.isUpperCase()), 2);
                }
            }
        }
        return null;
    }
}

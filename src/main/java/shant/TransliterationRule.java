package shant;

public interface TransliterationRule {
    RuleResult apply(char[] chars, int index);

    record RuleResult(String output, int skip) {}
}

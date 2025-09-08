package shant;

public class Transliterate {
    public String transliterate(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean isStartOfWord = (i == 0 || chars[i - 1] == ' ');

            if (c == ' ') {
                result.append(' ');
            } else if (c == '՜') {
                // Ignore this character
            } else {
                String customResult = applyCustomLogic(c, isStartOfWord, i, chars);
                if (customResult != null) {
                    result.append(customResult);
                    if (shouldSkipNextCharacter(c, i, chars)) {
                        i++;
                    }
                } else if (TransliterationMap.BASE_MAP.containsKey(c)) {
                    result.append(TransliterationMap.BASE_MAP.get(c));
                } else {
                    System.err.println("Unmapped character: " + c);
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    private String applyCustomLogic(char c, boolean isStartOfWord, int i, char[] chars) {
        if (c == 'ե' && isStartOfWord) {
            return "ye";
        } else if (c == 'Ո' && isStartOfWord) {
            return "Vo";
        } else if (c == 'ի' && i > 0 && chars[i + 1] == 'ւ') {
            return "oo";
        } else if (c == 'ո' && i > 0 && chars[i + 1] == 'ւ') {
            return "oo";
        }
        return null;
    }

    private boolean shouldSkipNextCharacter(char c, int i, char[] chars) {
        return (c == 'ո' && i > 0 && i + 1 < chars.length && chars[i + 1] == 'ւ') ||
                (c == 'ի' && i > 0 && i + 1 < chars.length && chars[i + 1] == 'ւ');
    }
}

package shant;

public class Transliterate {
    public String transliterate(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean isStartOfWord = (i == 0 || chars[i - 1] == ' ');

            String customResult = applyCustomLogic(c, isStartOfWord, i, chars);
            if (customResult != null) {
                result.append(customResult);
                int skip = shouldSkipNextCharacter(c, i, chars);
                i += skip;
            } else if (TransliterationMap.BASE_MAP.containsKey(c)) {
                result.append(TransliterationMap.BASE_MAP.get(c));
            } else {
                int start = i;
                while (start > 0 && chars[start - 1] != ' ') {
                    start--;
                }
                int end = i;
                while (end < chars.length && chars[end] != ' ') {
                    end++;
                }
                String word = input.substring(start, end);
                System.err.println("Unmapped word: " + word);
                result.append(c);
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
        }
        else if (c == 'ո' && i > 0 && chars[i + 1] == 'ւ') {
            if (chars[i + 2] == 'ո') {
                return "vo";
            }
            return "oo";
        }
        return null;
    }

    private int shouldSkipNextCharacter(char c, int i, char[] chars) {
        if (c == 'ո' && i > 0 && i + 2 < chars.length && chars[i + 1] == 'ւ' && chars[i + 2] == 'ո') {
            return 2;
        }

        if ((c == 'ո' && i > 0 && i + 1 < chars.length && chars[i + 1] == 'ւ') ||
                (c == 'ի' && i > 0 && i + 1 < chars.length && chars[i + 1] == 'ւ')) {
            return 1;
        }

        return 0;
    }
}

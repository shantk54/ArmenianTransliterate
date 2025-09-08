package shant;

public class Transliterate {
    public String transliterate(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            String customResult = applyCustomLogic(c, i, chars);
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

    private String applyCustomLogic(char c, int i, char[] chars) {
        if (c == 'ե' && isStartOfWord(chars, i)) {
            if (chars[i + 1] == 'ն' && isEndOfWord(chars, i + 1)) {
                return "en";
            }
            return "ye";
        } else if (c == 'Ո' && isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && chars[i + 1] == 'ւ') {
                return "Oo";
            }
            return "Vo";
        } else if (c == 'ի' && i > 0 && chars[i + 1] == 'ւ') {
            return "oo";
        } else if (c == 'ո' && i > 0 && chars[i + 1] == 'ւ') {
            if (chars[i + 2] == 'ո') {
                return "vo";
            }
            return "oo";
        } else if (c == 'յ' && isEndOfWord(chars, i)) {
            return "h";
        }
        return null;
    }

    private static boolean isStartOfWord(char[] chars, int i) {
        return (i == 0 || chars[i - 1] == ' ');
    }

    private static boolean isEndOfWord(char[] chars, int i) {
        return (i == chars.length - 1 || !Character.isLetter(chars[i + 1]));
    }


    private int shouldSkipNextCharacter(char c, int i, char[] chars) {
        if (c == 'ո' && i + 2 < chars.length && chars[i + 1] == 'ւ' && chars[i + 2] == 'ո') {
            return 2;
        }

        if (((c == 'ո' || c == 'Ո') && i + 1 < chars.length && chars[i + 1] == 'ւ') ||
                ((c == 'ի' || c == 'Ի') && i > 0 && i + 1 < chars.length && chars[i + 1] == 'ւ') ||
                ((c == 'ե' || c == 'Ե') && isStartOfWord(chars,i) && chars[i + 1] == 'ն' && isEndOfWord(chars,i + 1))) {
            return 1;
        }

        return 0;
    }
}

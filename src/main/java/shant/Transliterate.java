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
            if (chars[i + 1] == 'ն') {
                if (isEndOfWord(chars, i + 1)) {
                    return "en";
                }
                if (chars[i + 2] == 'ք' && isEndOfWord(chars, i + 2)) {
                    return "enk";
                }
            }
            return "ye";
        } else if (c == 'Ո' && isStartOfWord(chars, i)) {
            if (i + 1 < chars.length && chars[i + 1] == 'ւ') {
                return "Oo";
            }
            return "Vo";
        } else if (c == 'ի' && i > 0 && chars[i + 1] == 'ւ') {
            return "yoo";
        } else if (c == 'ո' && i > 0 && chars[i + 1] == 'ւ') {
            if (chars[i + 2] == 'ո') {
                return "vo";
            }
            if (chars[i + 2] == 'ա') {
                return "va";
            }
            return "oo";
        } else if (c == 'ո' && isStartOfWord(chars, i)) {
            return "vo";
        }
        else if (c == 'յ') {
            if (isEndOfWord(chars, i) && getWordLength(chars, i) > 5) {
                return "h";
            }
            if (isStartOfWord(chars, i)) {
                return "h";
            }
        } else if (c == 'ո' && i + 2 < chars.length && chars[i + 1] == 'յ' && chars[i + 2] == 'ր') {
            return "ooyr";
        } else if (c == 'ո' && i + 2 < chars.length && chars[i + 1] == 'յ' && chars[i + 2] == 'ս') {
            return "ooys";
        }else if (c == 'ջ' && isStartOfWord(chars, i)) {
            return "j";
        } else if (c == 'Ջ' && isStartOfWord(chars, i)) {
            return "J";
        } else if (c == 'ե' && chars[i + 1] == 'ա') {
            return "ya";
        }
        return null;
    }

    private static boolean isStartOfWord(char[] chars, int i) {
        return (i == 0 || Character.isWhitespace(chars[i - 1]));
    }


    private static boolean isEndOfWord(char[] chars, int i) {
        if (i >= chars.length - 1) {
            return true;
        }
        return Character.isWhitespace(chars[i + 1]);
    }


    private static int getWordLength(char[] chars, int i) {
        int start = i;
        // move back to the start of the word
        while (start > 0 && chars[start - 1] != ' ') {
            start--;
        }

        int end = i;
        // move forward to the end of the word
        while (end < chars.length && chars[end] != ' ') {
            end++;
        }

        return end - start; // length of the word
    }



    private int shouldSkipNextCharacter(char c, int i, char[] chars) {
        if ((c == 'ո' && i + 2 < chars.length && chars[i + 1] == 'ւ' && chars[i + 2] == 'ո') || (c == 'ո' && i + 2 < chars.length && chars[i + 1] == 'ւ' && chars[i + 2] == 'ա') || (c == 'ո' && i + 2 < chars.length && chars[i + 1] == 'յ' && chars[i + 2] == 'ր') || (c == 'ո' && i + 2 < chars.length && chars[i + 1] == 'յ' && chars[i + 2] == 'ս') || (c == 'ե' && i + 2 > 0 && i + 1 < chars.length && chars[i + 1] == 'ն' && chars[i + 2] == 'ք')) {
            return 2;
        }

        if (((c == 'ո' || c == 'Ո') && i + 1 < chars.length && chars[i + 1] == 'ւ') ||
                ((c == 'ի' || c == 'Ի') && i > 0 && i + 1 < chars.length && chars[i + 1] == 'ւ') ||
                ((c == 'ե' || c == 'Ե') && isStartOfWord(chars,i) && chars[i + 1] == 'ն' && isEndOfWord(chars,i + 1)) ||
                (c == 'ե' && chars[i + 1] == 'ա')) {
            return 1;
        }

        return 0;
    }
}

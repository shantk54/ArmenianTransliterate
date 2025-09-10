package shant.utils;

public class Utils {

    public static boolean isStartOfWord(char[] chars, int i) {
        return (i == 0 || Character.isWhitespace(chars[i - 1]));
    }

    public static boolean isEndOfWord(char[] chars, int i) {
        return (i >= chars.length - 1 || Character.isWhitespace(chars[i + 1]));
    }

    public static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static int getWordLength(char[] chars, int i) {
        int start = i;
        while (start > 0 && !Character.isWhitespace(chars[start - 1])) start--;
        int end = i;
        while (end < chars.length && !Character.isWhitespace(chars[end])) end++;
        return end - start;
    }
}

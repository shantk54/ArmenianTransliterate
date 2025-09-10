package shant;

import java.util.Map;

public class TransliterationMap {
    public static final Map<Character, String> BASE_MAP;

    static {
        BASE_MAP = Map.<Character, String>ofEntries(
                Map.entry('ա', "a"), Map.entry('բ', "p"),
                Map.entry('գ', "k"), Map.entry('դ', "t"),
                Map.entry('ե', "e"), Map.entry('և', "ev"),
                Map.entry('զ', "z"), Map.entry('է', "e"),
                Map.entry('ը', "uh"), Map.entry('թ', "t"),
                Map.entry('ժ', "j"), Map.entry('ի', "i"),
                Map.entry('լ', "l"), Map.entry('խ', "kh"),
                Map.entry('ծ', "dz"), Map.entry('կ', "g"),
                Map.entry('հ', "h"), Map.entry('ձ', "ts"),
                Map.entry('ղ', "gh"), Map.entry('ճ', "dj"),
                Map.entry('մ', "m"), Map.entry('յ', "y"),
                Map.entry('ն', "n"), Map.entry('շ', "sh"),
                Map.entry('ո', "o"), Map.entry('չ', "ch"),
                Map.entry('պ', "b"), Map.entry('ջ', "ch"),
                Map.entry('ռ', "r"), Map.entry('ս', "s"),
                Map.entry('վ', "v"), Map.entry('տ', "d"),
                Map.entry('ր', "r"), Map.entry('ց', "ts"),
                Map.entry('ւ', "v"), Map.entry('փ', "p"),
                Map.entry('ք', "k"), Map.entry('օ', "o"),
                Map.entry('ֆ', "f"),

                Map.entry('։', "."), Map.entry(',', ","),
                Map.entry(':', "."), Map.entry('՞', ""),
                Map.entry('`', ""), Map.entry('՛', ""),
                Map.entry('‘', "'"), Map.entry('’', "'"),
                Map.entry('՜', ""), Map.entry(' ', " "),
                Map.entry('՝', " "), Map.entry('.', ";"),
                Map.entry('-', " "),
                Map.entry('\n', "\n"), Map.entry('\r', "")
        );
    }
}

package shant;

import java.util.Map;
import java.util.Set;

public class TransliterationMap {
    public static final Map<Character, String> BASE_MAP;
    public static final Set<Character> CAPITALS;

    static {
        BASE_MAP = Map.<Character, String>ofEntries(
                Map.entry('Ա', "A"), Map.entry('ա', "a"),
                Map.entry('Բ', "P"), Map.entry('բ', "p"),
                Map.entry('Գ', "K"), Map.entry('գ', "k"),
                Map.entry('Դ', "T"), Map.entry('դ', "t"),
                Map.entry('Ե', "Ye"), Map.entry('ե', "e"), Map.entry('և', "ev"),
                Map.entry('Զ', "Z"), Map.entry('զ', "z"),
                Map.entry('Է', "E"), Map.entry('է', "e"),
                Map.entry('Ը', "Uh"), Map.entry('ը', "uh"),
                Map.entry('Թ', "T"), Map.entry('թ', "t"),
                Map.entry('Ժ', "J"), Map.entry('ժ', "j"),
                Map.entry('Ի', "I"), Map.entry('ի', "i"),
                Map.entry('Լ', "L"), Map.entry('լ', "l"),
                Map.entry('Խ', "Kh"), Map.entry('խ', "kh"),
                Map.entry('Ծ', "Dz"), Map.entry('ծ', "dz"),
                Map.entry('Կ', "G"), Map.entry('կ', "g"),
                Map.entry('Հ', "H"), Map.entry('հ', "h"),
                Map.entry('Ձ', "Ts"), Map.entry('ձ', "ts"),
                Map.entry('Ղ', "Gh"), Map.entry('ղ', "gh"),
                Map.entry('Ճ', "Dj"), Map.entry('ճ', "dj"),
                Map.entry('Մ', "M"), Map.entry('մ', "m"),
                Map.entry('Յ', "H"), Map.entry('յ', "y"),
                Map.entry('Ն', "N"), Map.entry('ն', "n"),
                Map.entry('Շ', "Sh"), Map.entry('շ', "sh"),
                Map.entry('Ո', "O"), Map.entry('ո', "o"),
                Map.entry('Չ', "Ch"), Map.entry('չ', "ch"),
                Map.entry('Պ', "B"), Map.entry('պ', "b"),
                Map.entry('Ջ', "Ch"), Map.entry('ջ', "ch"),
                Map.entry('Ռ', "R"), Map.entry('ռ', "r"),
                Map.entry('Ս', "S"), Map.entry('ս', "s"),
                Map.entry('Վ', "V"), Map.entry('վ', "v"),
                Map.entry('Տ', "D"), Map.entry('տ', "d"),
                Map.entry('Ր', "R"), Map.entry('ր', "r"),
                Map.entry('Ց', "Ts"), Map.entry('ց', "ts"),
                Map.entry('Ւ', "V"), Map.entry('ւ', "v"),
                Map.entry('Փ', "Pʿ"), Map.entry('փ', "pʿ"),
                Map.entry('Ք', "Kʿ"), Map.entry('ք', "k"),
                Map.entry('Օ', "O"), Map.entry('օ', "o"),
                Map.entry('Ֆ', "F"), Map.entry('ֆ', "f"),

                Map.entry('։', "."), Map.entry(',', ","),
                Map.entry(':', "."), Map.entry('՞', ""),
                Map.entry('`', ""), Map.entry('՛', ""),
                Map.entry('‘', "'"), Map.entry('’', "'"),
                Map.entry('՜', ""), Map.entry(' ', " "),
                Map.entry('՝', " "), Map.entry('\n', "\n"),
                Map.entry('\r', "")

        );

        CAPITALS = Set.of(
                'Ա', 'Բ', 'Գ', 'Դ', 'Ե', 'Զ', 'Է', 'Ը', 'Թ', 'Ժ', 'Ի', 'Լ', 'Խ', 'Ծ', 'Կ', 'Հ', 'Ձ', 'Ղ', 'Ճ', 'Մ', 'Յ', 'Ն', 'Շ', 'Ո', 'Չ', 'Պ', 'Ջ', 'Ռ', 'Ս', 'Վ', 'Տ', 'Ր', 'Ց', 'Ւ', 'Փ', 'Ք', 'Օ', 'Ֆ'
        );
    }
}

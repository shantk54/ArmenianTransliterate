package shant;

public class Main {
    public static void main(String[] args) {
        Transliterate t = new Transliterate();

        String sentence = "Երևան Ոսկի Հայաստան Ձիւն Առիւծ";
        String sentence2 = "Երբ չի մնում ելք ու ճար, Խենթերն են գտնում հնար։ Այսպէս ծագեց, արեգակեց Սարտարապատի մարտը մեծ։ Զանգե՜ր, ղօղանջէք, Սրբազան քաջերին կանչէք Այս արդար պատից։ Սերունդնե՜ր, դուք ձեզ ճանաչէք։ Սարդարապատից։";

        System.out.println(sentence + " → " + t.transliterate(sentence));
        System.out.println(sentence2 + " → " + t.transliterate(sentence2));
    }
}

package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictionaryWithMap {

    public static void main(String[] args) {

        String text = "абвгдеёжзийклмнопрстуфхцчшщъыьэюялмнопрфхцчшщъыьэмнопрстуфхцчшщъыьэю";
        //buildDictionaryWithMap(text);
        buildDictionary(text);
    }

    /**
     * Будем перебирать все символы в строке, и
     * если это символ алфавита русского языка,
     * обновляем значение в Map.
     * <p>
     * Потом возьмём все Map.Entry<Character, Integer>,
     * и отсортируем по ключу (Character)
     *
     * @param text - текст
     */

    public static void buildDictionaryWithMap(String text) {
        text = text.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // ё идёт отдельно от а-я
            if ((ch >= 'а' && ch <= 'я') || ch == 'ё') {
                map.compute(ch, (character, integer)
                        -> integer == null ? 1 : integer + 1);
            }
        }

        ArrayList<Map.Entry<Character, Integer>> entries =
                new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * Вариант без Map.
     * Создадим массив нужной длины, и будем хранить
     * в соответствующих позициях количество вхождений
     * символов
     *
     * @param text
     */
    public static void buildDictionary(String text) {
        text = text.toLowerCase();

        int[] result = new int['я' - 'а' + 1];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'а' && ch <= 'я') {
                result[ch - 'а']++;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println((char) (i + 'а') + " = " + result[i]);
        }
    }
}

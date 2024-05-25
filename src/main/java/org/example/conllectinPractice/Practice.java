package org.example.conllectinPractice;


import java.util.*;

public class Practice {

    /*
     * Написать метод, который принимает целочисленный список и возвращает
     * целочисленный список только с нечётными значениями.
     * */
    public List<Integer> Task1(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer value : list) {
            if (value % 2 == 0) result.add(value);
        }
        return result;
    }

    /*
     * Написать метод countUnique, который принимает целочисленный
     * список в качестве параметра и возвращает кол-во уникальных
     * целых чисел в этом списке.
     * При получение пустого списка метод должен возвращать 0.
     * */
    public int countUnique(List<Integer> list) {
        int count = 0;
//        Для проверки уникальности используем HashSet который хранит униклаьные значения
        return new HashSet<>(list).size();
    }

    /*
     * Написать метод isUnique, который принимает Map<String, String>;
     * и возвращает true
     * если каждому ключу соответствуют своё уникальное значение.
     * */
    public boolean isUnique(Map<String, String> map) {
        /*
         * С помощью HashSet создаём уникальный Map
         * и далее проверяем размер двух map`ов
         * */
        return map.size() == new HashSet<>(map.values()).size();
    }

    /*
     * Сложить два многочлена заданной степени, если коэффициенты
     * многочлена хранятся в объекте HashMap в виде:
     * Ключ: номер степени
     * Значение: значение множителя
     * Вывести результирующий многочлен в виде строки: ax^6 + bx^4 + cx^3 + dx + 8
     * */
    public Map<Integer, Integer> sum(Map<Integer, Integer> polynomail1, Map<Integer, Integer> polynomail2) {
        Map<Integer, Integer> polynomailResult = new HashMap<>(polynomail1);

        for (Map.Entry<Integer, Integer> entry : polynomail2.entrySet()) {
            polynomailResult.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return polynomailResult;
    }

    public String convertToString(Map<Integer, Integer> map) {
        Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());
        result.putAll(map);
        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            String value = entry.getKey() == 0
                    ? String.valueOf(entry.getValue())
                    : entry.getValue() + "x^" + entry.getKey();
            list.add(value);
        }
        return String.join("+", list);
    }

}

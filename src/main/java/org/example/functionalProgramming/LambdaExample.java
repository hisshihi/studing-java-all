package org.example.functionalProgramming;

import java.util.Comparator;

public class LambdaExample {

    public void getLambda() {
        /*
         * Таким образом мы получаем lambda выражение
         *
         * Integer::compare в лябмда выражении означает использование метода как объект
         * То есть мы пишем класс (Integer) и ссылаемся на метод этого класса через двоеточие
         * */
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(25, 200));
    }

//    private static class IntegerComparator implements Comparator<Integer> {
//        @Override
//        [модификаторы] возврат название([параметры])
        /*
        * Модификаторы доступа мы можем опустить
        * возвращаемый тип тоже, так как он основывается на return
        * и так как мы используем функциональный интерфейс
        * то навзание можем опустить, так как метод реализации всего 1 не считая дефолтные
        * */
//        (Integer o1, Integer o2) {
//            return Integer.compare(o1, o2);
//        }

//    }

}

package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestCollection {

    public List<Integer> getCollectionArrayList() {
        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        return integers;
    }

    /*
     * LinkedList - это реализация двусвязного списка,
     * который входит в коллекции из стандартной библиотеки Java (Java Collections Framework).
     * В отличие от массивов и списков, основанных на массивах (например, ArrayList), LinkedList состоит из узлов,
     * где каждый узел содержит ссылку на предыдущий и следующий элементы списка, а также данные.
     *
     * Основные характеристики LinkedList:
     * 1. Динамическая структура данных: LinkedList может динамически изменять свой размер, добавляя или удаляя элементы.
     * 2. Эффективность операций вставки и удаления: Вставка и удаление элементов в середину или начало списка более эффективны по сравнению с ArrayList,
     * так как не требуется сдвиг элементов.
     * 3. Доступ к элементам: Доступ к элементам по индексу менее эффективен, чем у ArrayList,
     * так как для этого требуется пройти по ссылкам от начала списка до нужного элемента.
     * */
    public void getCollectionLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();

//        Пример использования
        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");

        // Добавляем элемент в начало
        linkedList.addFirst("New one");
        // Добавляем элемент в конец
        linkedList.addLast("New three");

        // Получаем первый и последний элемент
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());

//        Удаляем элементы
        linkedList.removeFirst();
        linkedList.removeLast();

        for (String item : linkedList) {
            System.out.println(item);
        }
        System.out.println();

        // Пример реализации стека (первый пришёл - последниё ушёл)
        LinkedList<String> stack = new LinkedList<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        System.out.println("LIFO: " + stack.pop());
        System.out.println("LIFO: " + stack.pop());
        System.out.println("LIFO: " + stack.pop());

        System.out.println();

//        Пример реализации очереди (первый пришёл - первый ушёл)
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");

        System.out.println("FIFO: " + queue.poll());
        System.out.println("FIFO: " + queue.poll());
        System.out.println("FIFO: " + queue.poll());

    }

    /*
    * Iterator в Java — это интерфейс, который используется для последовательного перебора элементов коллекций,
    * таких как ArrayList, LinkedList, HashSet и другие.
    * Он предоставляет методы для обхода коллекции и удаления элементов во время итерации.
    *
    * * boolean hasNext(): Проверяет, есть ли следующий элемент в коллекции. Возвращает true, если есть еще элементы для итерации, иначе — false.
    * * E next(): Возвращает следующий элемент в коллекции. Если элементов больше нет, бросает исключение NoSuchElementException
    * * void remove(): Удаляет последний элемент, возвращенный методом next(), из коллекции.
    * Этот метод может быть вызван только после вызова метода next() и до вызова следующего метода next().
    * Если вызвать его до next() или дважды подряд, бросает исключение IllegalStateException.
    * */
    public void getIterator() {
        List<Integer> sourseList = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> list = new ArrayList<>(sourseList);

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if (next == 3 || next == 4) {
                iterator.remove();
            }
        }
        System.out.println(list);

    }

}

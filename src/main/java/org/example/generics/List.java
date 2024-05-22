package org.example.generics;

// Дженерик нужен для того, чтобы определять тип который будет содержать класс или что-то другое
public class List<T> {

//    Object указываем так как не знаем, что будет помещено в массив
    private T[] objects;
    private int size;

//    Инициализация длинны массива
    public List(int initialSize) {
//        Делаем приведение типов для того, чтобы определять какой тип будет в массиве
        this.objects = (T[]) new Object[initialSize];
    }

//    Добавление нового объекта
    public void add(T element) {
        objects[size++] = element;
    }

//    Получаем элемент
    public T get(int index) {
        return objects[index];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

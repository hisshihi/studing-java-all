package org.example.generics;

// ƒженерик нужен дл€ того, чтобы определ€ть тип который будет содержать класс или что-то другое
public class List<T> {

//    Object указываем так как не знаем, что будет помещено в массив
    private T[] objects;
    private int size;

//    »нициализаци€ длинны массива
    public List(int initialSize) {
//        ƒелаем приведение типов дл€ того, чтобы определ€ть какой тип будет в массиве
        this.objects = (T[]) new Object[initialSize];
    }

//    ƒобавление нового объекта
    public void add(T element) {
        objects[size++] = element;
    }

//    ѕолучаем элемент
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

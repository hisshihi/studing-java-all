package org.example.generics;

// �������� ����� ��� ����, ����� ���������� ��� ������� ����� ��������� ����� ��� ���-�� ������
public class List<T> {

//    Object ��������� ��� ��� �� �����, ��� ����� �������� � ������
    private T[] objects;
    private int size;

//    ������������� ������ �������
    public List(int initialSize) {
//        ������ ���������� ����� ��� ����, ����� ���������� ����� ��� ����� � �������
        this.objects = (T[]) new Object[initialSize];
    }

//    ���������� ������ �������
    public void add(T element) {
        objects[size++] = element;
    }

//    �������� �������
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

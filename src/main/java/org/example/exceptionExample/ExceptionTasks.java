package org.example.exceptionExample;

public class ExceptionTasks {

    /*
    * Объявите переменную со значением null. Вызовите метод у этой переменной.
    * Отловите возникшее исключение.
    * */
    public void getExceptionNull() {
        String value = null;
        try {
            value.length();
        } catch (NullPointerException exception) {
            System.err.println("Catch");
            exception.printStackTrace();
        }
    }

    /*
    * Написать код, который создаст, а затем отловит
    * ArrayIndexOutOfBoundsException.
    * */
    public void getArrayException() {
        int[] values = {1, 4, 6, 5, 3};
        try {
            for (int i = 0; i < values.length + 1; i++) {
                System.out.println(values[i]);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }
    }

    /*
    * Создать собственный класс-исключение - наследник класса Exception.
    * Создать метод, выбрасыващий это исключение.
    * Вызвать этот метод и отловить исключение. Вывести stack trace в консоль.
    * */
    public void unsafe() {
        try {
            throw new CustomException(new RuntimeException("runtime exception"));
        } catch (CustomException e) {
//            System.err.println(e.getMessage());
//            System.err.println(e.getCause());
            e.printStackTrace();
        }
    }
}

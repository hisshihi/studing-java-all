package org.example.tasks;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task1 {

    /*
     * Заменить все грустные смайлики на весёлые
     * */
    private String value = "hello it`s I`m :( smile :( here :) ha-ha-ha :) not :(";

    public String replace() {
        return this.value.replace(":(", ":)");
    }

    //    task 2
    public boolean beginsAndEnds(String string, String word) {
        string = string.toLowerCase();
        return string.startsWith(word) && string.endsWith(word);
    }

    //    task 3
    public String fio(String firstName, String lastName, String patronymicName) {
        char firstNameChar = Character.toUpperCase(firstName.charAt(0));
        char lastNameChar = Character.toUpperCase(lastName.charAt(0));
        char patronymicNameChar = Character.toUpperCase(patronymicName.charAt(0));

        return String.format("%s.%s.%s", firstNameChar, lastNameChar, patronymicNameChar);
    }

    //    task 4
    public int сountingСommasAndExclamationMarksInALine(String word) {
        String result = word.replace(".", "").replace(",", "").replace("!", "");
        return word.length() - result.length();
    }

    /*
     * 5. Написать функцию, разбивающую строку на равные части по п символов и
     * сохраняющую отдельные части в массив. Вывести этот массив.
     * */
    public String split(String word, int n) {
        // 1. determining the size of the array
        int arraySize = (int) Math.ceil(word.length() / (double) n);

        // 2. create an array of strings to store parts
        String[] result = new String[arraySize];

        // 3. initialize the counter to fill the array
        int counter = 0;

        // 4. loop to split a string into pieces
        for (int i = 0; i < word.length(); i += n) {
            // 5. determining the ending index of the substring
            int endIndex = Math.min(word.length(), i + n);

            // 6. extract the substring from i to endindex
            String substring = word.substring(i, endIndex);

            // 7. saving the substring to an array
            result[counter] = substring;

            // 8. increase the counter
            counter++;
        }

        // 9. returning a string representation of the array
        return Arrays.toString(result);
    }

    //    Изучение StringBuffer and StringBuilder
    public long test() {
        long startTime = System.currentTimeMillis();
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            value.append(i);

        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

//    Из строки с одинковыми символами имеющая пробелы найти все символы в единственном экземпляре,
//    записать их все в одну строку и в формате upperCase
    public String taskHome1(String word) {
        Set<Character> uniqueChars = new LinkedHashSet<>();
        String processedInput = word.replaceAll(" ", "").toUpperCase();

        for (char c : processedInput.toCharArray()) {
            uniqueChars.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : uniqueChars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }



}

package org.example.regularExpressionsTasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsTasks {

    /*
    * Написать программу, проверяющую, является ли введённая строка адресом почтового ящика
    * В названии почтового ящика разрешить использование только
    * букв, цифр и нижних подчёркиваний, при этом оно должно
    * начинаться с буквы.
    * Возможные домены верхнего уровня: .org, .com
    * */
    public void task1() {
        String regex = "[a-zA-z]\\w*@\\w{3,}\\.(org|com)";
        String input = "hiss@gmail.com";
        System.out.println(Pattern.matches(regex, input));
    }

    /*
    * Написать программу, выполняющую поиск в строе
    * шестнадцатеричных чисел, записанных по правилам Java,
    * с помощью регулярных выражений и выводяющую их на страницу.
    * */
    public void task2() {
        String regex = "0[Xx][0-9a-fA-F]+";
        String input = "0Xff asdfwefdsafsdf 0x12 asdfasswg 0XAB a;sdf";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) System.out.println(matcher.group());
    }

    /*
    * Записать программу, выполняющую поиск в строке всех тегов
    * абзацев, в т.ч. тех, у которых есть параметры, например <p id="p1">,
    * и заменить их на простые теги абзацев <p>.
    * */
    public void task3() {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p>asdfasdfasdfsdf</p>, <b> fdsfsdf </b> asdfasdf <p id=\"p1\">asdfasdfsdf</p>" +
                "asdfasd <p>asdfasdf asdf <p id=\"p2\">asdfsd</p>";
        System.out.println(input.replaceAll(regex, "<p>$2"));
    }

}

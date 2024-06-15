package patternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {

    private final String phoneNumber = "asdfas dffasdf asdfa +7 (901) 154-36-25 asdf asdf asdfasdf" +
            "+7 (913) 987-32-89 fasdf sdfasdfas fasdfasd +7 (908) 323-34-22 " +
            "dfgh dfghd fghdfghfgh +7 (364) 233-31-25 fsdaa";

    private final String startLinePhoneNumber = "+7 (901) 154-36-25 asdf asdf asdfasdf" +
            "+7 (913) 987-32-89 fasdf sdfasdfas fasdfasd +7 (908) 323-34-22 " +
            "dfgh dfghd fghdfghfgh +7 (364) 233-31-25 fsdaa";

    private final String nameGroupAndLinkPhoneNumber = "+7 (901) 154-36-25 asdf asdf asdfasdf" +
            "+7 (913) 987-32-89 fasdf sdfasdfas fasdfasd +7 (908) 323-34-22 " +
            "dfgh dfghd fghdfghfgh +7 (364) 233-31-31 fsdaa";

    private final String removeGroupPhoneNumber = "+7 (901) 154-36-25 asdf asdf asdfasdf" +
            "+7 (913) 987-32-89 fasdf sdfasdfas fasdfasd +7 (908) 323-34-22 " +
            "dfgh dfghd fghdfghfgh +7 (364) 233-31-31 fsdaa";

    private final String regex = "(\\+7) ?\\((\\d{3})\\) ?\\d{3}-\\d{2}-\\d{2}";
    private final String startRegex = "^\\+7 ?\\(\\d{3}\\) ?\\d{3}-\\d{2}-\\d{2}";
    // С помощью code задаём имя группе, а (\2) обозначает, что мы ищем совпадение между ним и другими группами
    private final String nameGroupAndLinkRegex = "\\+7 ?\\((?<code>\\d{3})\\) ?\\d{3}-(\\d{2})-(\\2)";
    private final String removeGroupRegex = "(?:\\+7) ?\\((?<code>\\d{3})\\) ?\\d{3}-(\\d{2})-(\\2)";
    // Используем регулярку
    private final Pattern pattern = Pattern.compile(regex);
    private final Pattern startPattern = Pattern.compile(startRegex);

    private final Pattern nameGroupAndLinkPattern = Pattern.compile(nameGroupAndLinkRegex);
    private final Pattern removeGroupPattern = Pattern.compile(removeGroupRegex);

    public void patternFind() {
        // Передаём строку и сопоставляем их с регуляркой
        Matcher matcher = pattern.matcher(phoneNumber);
        // Пока все номера не будут найдены цикл не остановится
        while (matcher.find()) {
            // Возвращаем группу подстрок, если задать число, тогда вернётся определённая подгруппа
            // Группой обозначается какой-то блок в регулярке находящееся в скобках
            System.out.println("Код страны: " + matcher.group(1) + ", " + "код оператора: " + matcher.group(2));
        }
    }

    // Находим только первый номер в строке
    public void patternFindInStartLines() {
        Matcher matcher = startPattern.matcher(startLinePhoneNumber);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public void patternFindByNameGroupAndLink() {
        Matcher matcher = nameGroupAndLinkPattern.matcher(nameGroupAndLinkPhoneNumber);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group("code"));
        }
    }

//    Удаление группы
    public void removeGroupMethod() {
        Matcher matcher = removeGroupPattern.matcher(removeGroupPhoneNumber);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}

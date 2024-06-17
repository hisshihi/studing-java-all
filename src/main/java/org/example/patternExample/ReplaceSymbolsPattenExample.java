package patternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceSymbolsPattenExample {

    private final String phoneNumber = "asdfas dffasdf asdfa +7 (901) 154-36-25 asdf asdf asdfasdf " +
            "+7 (913) 987-32-89 fasdf sdfasdfas fasdfasd +7 (908) 323-34-22 " +
            "dfgh dfghd fghdfghfgh +7 (364) 233-31-25 fsdaa";

    private final String regex = "(\\+7) ?\\((\\d{3})\\) ?(\\d{3})-(\\d{2})-(\\d{2})";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNumber);

    public void replaceSymbol() {
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "XXX");
        }

        // Чтобы не терять хвост строки
        matcher.appendTail(stringBuilder);

        System.out.println(stringBuilder.toString());
    }

    public void replaceCityAndCode() {

        StringBuilder stringBuilder = new StringBuilder();

        // С помощью stringBuilder и спец. символа заменяем удаляем лишние группы и изменяем заданные
        while (matcher.find()) {
            String gr3 = matcher.group(3);
            String gr4 = matcher.group(4);
            String gr5 = matcher.group(5);
            matcher.appendReplacement(stringBuilder, "$3 - $4 - $5");
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder);

        // Также можно использовать replace all, чтобы не использовать цикл
        System.out.println(phoneNumber.replaceAll(regex, "$3 - $4 - $5"));
    }

}

package patternExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {

    public void pattern1() {
        String phoneNumber = "+7 (908) 323-34-22";
        String regex = "\\+7 ?\\(\\d{3}\\) ?\\d{3}-\\d{2}-\\d{2}";

        // Старый вариант использования
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        System.out.println(matcher.matches());

        // Новый
        System.out.println(Pattern.matches(regex, phoneNumber));

        // Ещё более новый
        System.out.println(phoneNumber.matches(regex));
    }

}

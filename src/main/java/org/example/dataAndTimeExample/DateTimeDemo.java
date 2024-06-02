package org.example.dataAndTimeExample;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {

    public void getDateTimeDemo() {
        ZonedDateTime now = ZonedDateTime.now();
//        Показывает текущее время в формате - 2024-06-02T19:16:53.035302600+03:00[Europe/Moscow]
        System.out.println(now);

//        Получить кол-во миллисекунд начиная с 1 янв 1970 года
        long epochMilli = now.toInstant().toEpochMilli();
        System.out.println(epochMilli);

//        Прибавить сколько-то к текущему времени
        ZonedDateTime plus = now.plus(1L, ChronoUnit.DAYS);
        System.out.println(plus);

//        Обнулить все данные кроме дня
        ZonedDateTime zonedDateTime = now.truncatedTo(ChronoUnit.DAYS);
        System.out.println(zonedDateTime);

        // Получение времени на нулевом мередиане
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println(localDateTime);

//        Получение текущего времени
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

    }

}

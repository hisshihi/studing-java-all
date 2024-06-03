package org.example.dataAndTimeExample;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataAndTimeTasks {

    /*
    * Создать объект LocalDateTime, представляющий собой
    * дату 25.06.2020 19:47. Используя объект, создать другой объект LocalDateTime,
    * представляющий собой дату через 3 месяца после сегдняшей.
    * Вывести на консоль содержащиеся в нём объекты LocalDate and LocalTime
    * */
    public void task1() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 3, 17, 23, 55);
        LocalDateTime newLocalDateTime = localDateTime.plusMonths(3L);
        System.out.println("Дата - " + newLocalDateTime.toLocalDate() + " " + " время - " + newLocalDateTime.toLocalTime());
    }

    /*
    * Создать объект LocalDate, представляющий собой сегодняшнюю дату.
    * Преобразовать дату в строку вида "05.05.2017". Вывести эту строку на консоль.
    * P.S. Также вывел часы и минуты
    * */
    public void task2() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String timeFormatter = time.format(formatter);
        System.out.println(timeFormatter);
    }

    /*
    * Дата строка вида "26-03-1968T09:12". Получить объект LocalDateTime, представляющий
    * собой дату, полученную из этой строки.
    * */
    public void task3() {
        String formattedDate = "26-03-1968T09:12";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime parse = LocalDateTime.parse(formattedDate, formatter);
        System.out.println(parse);
    }

    /*
    * Использовать LocalDateTIme из предыдущего задания, преобразовав его
    * в объект типа Instant, указав тайм зону "America/Chicago". Вывести кол-во
    * прошедших миллисекунд.
    * */
    public void task4() {
        String formattedDate = "26-03-1968T09:12";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime parse = LocalDateTime.parse(formattedDate, formatter);
        System.out.println(parse);

//        Задаём таймзону
        Instant instant = parse.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(parse));
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());
    }

    /*
    * Создать объект LocalDate, представляющий собой сегодняшнюю дату.
    * Создать объект LocalDate, представляющий собой дату 07.07.2018. Используя созданные объекты, найти кол-во дней между
    *  этими двумя датами.
    * */
    public void task5() {
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

        Period period = Period.between(prevDate, now);
        System.out.println(period.getYears());
        System.out.println(period.getYears());
        System.out.println(period.getDays());
        long days = ChronoUnit.DAYS.between(prevDate, now);
        System.out.println(days);
    }

    /*
    * Даны два объекта LocalDate из предыдущего задания. Подсчитать кол-во
    *  секунд между полуночью первой даты и полуночью второй даты.
    * */
    public void task6() {
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

        LocalDateTime localDateTimeNow = now.atStartOfDay();
        LocalDateTime localDateTimePrev = prevDate.atStartOfDay();

        Duration duration = Duration.between(localDateTimePrev, localDateTimeNow);
        System.out.println(duration.getSeconds());
    }

    /*
    * Создать объект Instant. Вывести его на консоль.
    * Затем создать объект ZonedDateTime на основании предыдущего объекта с там зоной "Africa/Cairo".
    * */
    public void task7() {
        Instant instant = Instant.now();
        System.out.println(instant);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zonedDateTime);
    }

    /*
    * Написать свою реализацию интерфейса TemporalAdjuster, которая бы
    * прибавляла к дате 42 дня.
    * */
    public void task8() {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(localDateTime);
    }

}

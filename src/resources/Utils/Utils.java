package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Utils {

    public static <T> T getRandom(List<T> list)
    {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static LocalDate getRandomBirthday() {
        return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
    }

    public static int calculateUserAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }
}

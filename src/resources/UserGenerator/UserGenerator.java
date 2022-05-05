package UserGenerator;

import User.User;
import org.apache.commons.lang3.RandomStringUtils;

import static Utils.Utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class UserGenerator {
    private static List<String> genders = Arrays.asList("МУЖ", "ЖЕН");
    private static List<String> femaleFirstNames = Arrays.asList("Эдита", "Нина", "Екатерина", "Инесса", "Жанна", "Чечилия", "Клара", "Валентина",
            "Яся", "Эрика","Люся", "Октябрина", "Шанетта", "Шарлота", "Мальвина", "Раиса", "Эльза", "Христина", "Виктория",
            "Ульяна", "Йосифа", "Федосья", "Клементина", "Харита", "Фаина");
    private static List<String> maleFirstNames = Arrays.asList("Эрик", "Гарри", "Харитон", "Станислав", "Филипп", "Кристиан", "Леон", "Мирослав",
            "Вячеслав", "Павел", "Динар", "Зигмунд", "Елисей", "Остап", "Эдуард", "Ким", "Ждан", "Иван", "Доминик", "Пётр",
            "Жерар", "Орландо", "Оскар", "Спартак", "Любомир", "Яромир");
    private static List<String> femaleLastNames = Arrays.asList("Носкова", "Евдокимова", "Лапина", "Кириллова", "Хижняк", "Корнейчук", "Матвеева",
            "Шилова", "Цушко", "Кобзар", "Коцюбинска", "Палий", "Стрелкова", "Самойлова", "Турова", "Хитрук", "Лыткина",
            "Ефимова", "Брагина", "Мухина", "Виноградова", "Белозёрова", "Соколова", "Щукина", "Романова", "Самойлова",
            "Андреева", "Шашкова", "Мартынова", "Филатова");
    private static List<String> maleLastNames = Arrays.asList("Молчанов", "Фомичёв", "Дорофеев", "Горбачёв", "Рымар", "Лобанов", "Семёнов", "Юдин",
            "Капустин", "Медяник", "Шумило", "Лукин", "Петрик", "Кириллов", "Гущин", "Филиппов", "Фадеев", "Савельев",
            "Бородай", "Плаксий", "Коломоец", "Зиновьев", "Суворов", "Панов", "Якушев", "Стегайло", "Белов", "Карпов", "Павлик", "Беляев");
    private static List<String> femalePatronymics = Arrays.asList("Владимировна", "Ярославовна", "Платоновна", "Леонидовна", "Ярославовна",
            "Станиславовна", "Юхимовна", "Васильевна", "Вадимовна", "Виталиевна", "Борисовна", "Андреевна",
            "Артёмовна", "Львовна", "Борисовна", "Алексеевна", "Сергеевна", "Петровна", "Богдановна", "Валериевна");
    private static List<String> malePatronymics = Arrays.asList("Виталиевич", "Григорьевич", "Дмитриевич", "Васильевич", "Леонидович", "Фёдорович",
            "Вадимович", "Иванович", "Данилович", "Сергеевич", "Ярославович", "Григорьевич", "Артёмович", "Борисович", "Романович",
            "Иванович", "Петрович", "Евгеньевич", "Юхимович", "Львович");
    private static List<String> citiesList = Arrays.asList("Жигулёвск", "Кириши", "Лесной", "Черемхово", "Кизляр", "Назарово", "Солнечногорск",
            "Узловая", "Боровичи", "Можга", "Шелехов", "Рославль", "Курганинск", "Москва", "Балахна", "Екатеринбург", "Карабулак", "Кингисепп");
    private static List<String> regionsList = Arrays.asList("Самарская", "Ленинградская", "Тульская", "Московская", "Новгородская",
            "Смоленская", "Иркутская", "Ростовская", "Орловская", "Кемеровская", "Тверская", "Новосибирская", "Тамбовская");
    private static List<String> streetsList = Arrays.asList("Центральная", "Молодежная", "Школьная", "Лесная", "Советская", "Новая",
            "Садовая", "Набережная","Заречная", "Зеленая", "Мира", "Ленина", "Гагарина", "Южная", "Восточная");

    public static User generateUser() throws ParseException {
        String firstName, lastName, patronymic;
        String gender = getRandom(genders);
        if (gender == "ЖЕН") {
            firstName = getRandom(femaleFirstNames);
            lastName = getRandom(femaleLastNames);
            patronymic = getRandom(femalePatronymics);
        } else {
            firstName = getRandom(maleFirstNames);
            lastName = getRandom(maleLastNames);
            patronymic = getRandom(malePatronymics);
        }
        LocalDate dateOfBirth = getRandomBirthday();
        String formattedDateOfBirth = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(dateOfBirth);
        int userAge = calculateUserAge(dateOfBirth, LocalDate.now());
        String placeOfBirth = getRandom(citiesList);
        String cityOfResiding = getRandom(citiesList);
        String regionOfResiding = getRandom(regionsList);
        String streetOfResiding = getRandom(streetsList);
        String postalCode = RandomStringUtils.randomNumeric(6);

        int max = 300;
        int min = 1;
        Random rand = new Random();
        int flatNumber = rand.nextInt((max - min) + 1) + min;
        int houseNumber = rand.nextInt((max - min) + 1) + min;
        String country = "Россия";

        User newUser = new User(firstName, lastName, patronymic, userAge, gender, formattedDateOfBirth, placeOfBirth,
                postalCode, country, regionOfResiding, cityOfResiding, streetOfResiding, houseNumber, flatNumber);
        return newUser;
    }
}

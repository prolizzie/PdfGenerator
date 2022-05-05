package User;

import java.time.LocalDate;

public class User{
    public String userFirstName;
    public String userLastName;
    public String userPatronymic;
    public int userAge;
    public String userGender;
    public String userDateOfBirth;
    public String userPlaceOfBirth;
    public String userPostcode;
    public String userCountry;
    public String userRegion;
    public String userCity;
    public String userStreet;
    public int userHouseNumber;
    public int userFlatNumber;

    public User(String name, String lastname, String patronymic, int age, String gender, String birthDate,
                String birthPlace, String postcode, String country, String region, String city,
                String street, int houseNumber, int flatNumber) {
        userFirstName = name;
        userLastName = lastname;
        userPatronymic = patronymic;
        userAge = age;
        userGender = gender;
        userDateOfBirth = birthDate;
        userPlaceOfBirth = birthPlace;
        userPostcode = postcode;
        userCountry = country;
        userRegion = region;
        userCity = city;
        userStreet = street;
        userHouseNumber = houseNumber;
        userFlatNumber = flatNumber;
    }
}

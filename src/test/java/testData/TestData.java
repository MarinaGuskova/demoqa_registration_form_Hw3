package testData;


import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;


public class TestData {
    static Faker faker = new Faker(new Locale("de"));
    public static String
            userName = faker.cat().breed(),
            userLastName = faker.animal().name(),
            userEmail = faker.internet().emailAddress(),
            userGender = genderRandom(),
            userPhone = faker.phoneNumber().subscriberNumber(10),
            dayBirth = String.valueOf(faker.number().numberBetween(10, 28)),
            monthBirth = monthRandom(),
            yearBirth = String.valueOf(faker.number().numberBetween(1900, 2000)),
            userSubjects = subjectsRandom(),
            userHobbies = hobbiesRandom(),
            pictureDirectory = "dog.jfif",
            userCurrentAddres = faker.shakespeare().romeoAndJulietQuote(),
            userState = "Rajasthan",
            userCity = "Jaiselmer";

    public static int randomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String genderRandom() {
        String[] gender = {"Male", "Female", "Other"};
        int index = randomInt(0, gender.length - 1);
        return gender[index];
    }

    public static String subjectsRandom() {
        String[] month = {"Math", "Physics", "Computer science", "Accounting", "Arts", "Biology"};
        int index = randomInt(0, month.length - 1);
        return month[index];
    }

    public static String monthRandom() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int index = randomInt(0, month.length - 1);
        return month[index];
    }

    public static String hobbiesRandom() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int index = randomInt(0, hobbies.length - 1);
        return hobbies[index];
    }
}


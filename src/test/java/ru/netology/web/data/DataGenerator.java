package ru.netology.web.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {

    //Валидные значения
    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getApprovedMonth() {
        return "08";
    }

    public static String getApprovedYear() {
        return "23";
    }

    public static String getApprovedOwner() {
        return "IVAN PETROV";
    }

    public static String getApprovedCVV() {
        return "345";
    }

    //Невалидные значения
    // Пустые значения
    public static String getEmptyCardNumber() {
        return "";
    }

    public static String getEmptyMonth() {
        return "";
    }

    public static String getEmptyYear() {
        return "";
    }

    public static String getEmptyOwner() {
        return "";
    }

    public static String getEmptyCVV() {
        return "";
    }

    //Значения, состоящие из нулей
    public static String getCardNumberWithAllZeros() {
        return "0000 0000 0000 0000";
    }

    public static String getMonthWith00() {
        return "00";
    }

    public static String getYearWith00() {
        return "00";
    }

    public static String getCVVWith00() {
        return "000";
    }

    //Значения из букв и спецсимволов
    public static String getCardNumberWithLettersAndSymbols() {
        return "fhhb $*)@ jkjs уолц";
    }

    public static String getMonthWithLettersAndSymbols() {
        return "h*";
    }

    public static String getYearWithLettersAndSymbols() {
        return "Р?";
    }

    public static String getOwnerWithCyrillicLetters() {
        return "ИВАН ПЕТРОВ";
    }

    public static String getOwnerWithSymbols() {
        return "23%$### *^^";
    }

    public static String getCVVWithLettersAndSymbols() {
        return "*Ц?";
    }

    //Другие невалидные значения
    public static String getCardNumberNotFromRange() {
        return "4444 4444 4444 4443";
    }

    public static String getCardNumberWithLessNumbers() {
        return "4444 4444 4444 444";
    }

    public static String getMonthWithMoreThan12() {
        return "13";
    }

    public static String getMonthWith1Symbol() {
        return "1";
    }

    public static String getYearLessThanCurrent() {
        return "22";
    }

    public static String getYearWith1Symbol() {
        return "2";
    }

    public static String getCVVWith2Symbols() {
        return "34";
    }
}

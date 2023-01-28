package ru.netology.web.data;

import lombok.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataGenerator {

    //Валидные значения
    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
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

    @Value
    public static class PaymentData {
        String id;
        String status;
    }

    public static PaymentData getLastPaymentData(String tableName) throws SQLException {
        String paymentSQL = "SELECT id, status FROM " + tableName + " ORDER BY created DESC LIMIT 1";
        String id = null;
        String status = null;
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
                Statement paymentStmt = conn.createStatement()
        ) {
            try (var rs = paymentStmt.executeQuery(paymentSQL)) {
                if (rs.next()) {
                    id = rs.getString("id");
                    status = rs.getString("status");
                }
            }
        }
        return new PaymentData(id, status);
    }
}

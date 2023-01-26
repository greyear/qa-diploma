package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.web.page.DebitPage;
import ru.netology.web.page.MainPage;

public class DebitCardTest {

    private MainPage mainPage;
    private DebitPage debitPage;

    @BeforeEach
    void setUpMainPage() {
        mainPage = new MainPage();
    }

    @Test
    //Вручную проходит
    @DisplayName("1. Покупка с оплатой дебетовой картой со статусом APPROVED: отправка формы в введенными во все поля валидными данными")
    void shouldPassWithApprovedDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 4444 4444 4441", "08", "23", "IVAN PETROV", "345");
        debitPage.checkIfSuccess();
    }

    @Test
    //Вручную не проходит, уведомление об успешной операции
    @DisplayName("2. Покупка по карте со статусом DECLINED")
    void shouldFailWithDeclinedDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 4444 4444 4442", "08", "23", "IVAN PETROV", "345");
        debitPage.checkIfFail();
    }

    @Test
    //Вручную не проходит, тексты уведомлений должны быть иными
    @DisplayName("3. Отправка пустой формы")
    void shouldThrowAllVerificationErrorsDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("", "", "", "", "");
        debitPage.emptyCardNumberError();
        debitPage.emptyMonthError();
        debitPage.emptyYearError();
        debitPage.emptyOwnerError();
        debitPage.emptyCVVError();
    }

    @Test
    //Вручную проходит
    @DisplayName("4. Номер карты из 16 цифр, отличный от 4444 4444 4444 4441 или 4444 4444 4444 4442")
    void shouldFailWithDebitCardNotFromList() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 4444 4444 4443", "08", "23", "IVAN PETROV", "345");
        debitPage.checkIfFail();
    }

    @Test
    //Вручную проходит
    @DisplayName("5. Номер карты из 16 нулей")
    void shouldFailWithDebitCardWithAllZeros() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("0000 0000 0000 0000", "08", "23", "IVAN PETROV", "345");
        debitPage.checkIfFail();
    }

    @Test
    //Вручную проходит
    @DisplayName("6. Номер карты, состоящий из менее чем 16 цифр")
    void shouldThrowWrongFormatCardNumberVerificationErrorDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 4444 4444 444", "08", "23", "IVAN PETROV", "345");
        debitPage.wrongFormatCardNumberError();
    }

    @Test
    //Вручную не проходит, текст уведомления должен быть иной
    @DisplayName("7. Пустой номер карты")
    void shouldThrowEmptyCardNumberVerificationErrorDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("", "08", "23", "IVAN PETROV", "345");
        debitPage.emptyCardNumberError();
    }

    @Test
    //Вручную проходит
    @DisplayName("8. В поле 'Номер карты' введены буквы и специальные символы")
    void shouldNotEnterLettersAndSymbolsInCardNumberDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardNumber("fhhb $*)@ jkjs уолц");
        debitPage.emptyCardNumberInField();
    }

    @Test
    //Вручную проходит
    @DisplayName("9. Месяц, больше 12")
    void shouldThrowInvalidExpDateMonthVerificationErrorWithMoreThan12DebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 44444 4444 4441", "13", "23", "IVAN PETROV", "345");
        debitPage.invalidExpDateMonthError();
    }

    @Test
    //Вручную проходит
    @DisplayName("10. Месяц из 1 цифры")
    void shouldThrowWrongFormatMonthVerificationErrorDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 4444 4444 4441", "1", "23", "IVAN PETROV", "345");
        debitPage.wrongFormatMonthError();
    }

    @Test
    //Вручную не проходит, текст уведомления должен быть иной
    @DisplayName("11. Пустое поле 'Месяц'")
    void shouldThrowEmptyMonthVerificationErrorDebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 4444 4444 4441", "", "23", "IVAN PETROV", "345");
        debitPage.emptyMonthError();
    }

    @Test
    //Вручную проходит
    @DisplayName("12. Месяц из двух нулей")
    void shouldThrowInvalidExpDateMonthVerificationErrorWith00DebitCard() {
        debitPage = mainPage.goToDebitPage();
        debitPage.fillInCardInfo("4444 44444 4444 4441", "00", "23", "IVAN PETROV", "345");
        debitPage.invalidExpDateMonthError();
    }


}
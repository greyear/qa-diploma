package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.web.page.CreditPage;
import ru.netology.web.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class CreditCardTest {
    private MainPage mainPage;
    private CreditPage creditPage;

    @BeforeEach
    void setUpMainPage() {
        mainPage = new MainPage();
    }

    @Test
    //Вручную проходит
    @DisplayName("26. Покупка с оплатой в кредит по карте со статусом APPROVED: отправка формы с введенными во всем поля валидными данными")
    void shouldPassWithApprovedCardInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 4444 4444 4441", "08", "23", "IVAN PETROV", "345");
        creditPage.checkIfSuccess();
    }

    @Test
    //Вручную не проходит, уведомление об успешной операции
    @DisplayName("27. Покупка по карте со статусом DECLINED")
    void shouldFailWithDeclinedCardInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 4444 4444 4442", "08", "23", "IVAN PETROV", "345");
        creditPage.checkIfFail();
    }

    @Test
    //Вручную не проходит, тексты уведомлений должны быть иными
    @DisplayName("28. Отправка пустой формы")
    void shouldThrowAllVerificationErrorsInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("", "", "", "", "");
        creditPage.emptyCardNumberError();
        creditPage.emptyMonthError();
        creditPage.emptyYearError();
        creditPage.emptyOwnerError();
        creditPage.emptyCVVError();
    }

    @Test
    //Вручную проходит
    @DisplayName("29. Номер карты из 16 цифр, отличный от 4444 4444 4444 4441 или 4444 4444 4444 4442")
    void shouldFailWithCardNotFromListInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 4444 4444 4443", "08", "23", "IVAN PETROV", "345");
        creditPage.checkIfFail();
    }

    @Test
    //Вручную проходит
    @DisplayName("30. Номер карты из 16 нулей")
    void shouldFailWithCardWithAllZerosInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("0000 0000 0000 0000", "08", "23", "IVAN PETROV", "345");
        creditPage.checkIfFail();
    }

    @Test
    //Вручную проходит
    @DisplayName("31. Номер карты, состоящий из менее чем 16 цифр")
    void shouldThrowWrongFormatCardNumberVerificationErrorInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 4444 4444 444", "08", "23", "IVAN PETROV", "345");
        creditPage.wrongFormatCardNumberError();
    }

    @Test
    //Вручную не проходит, текст уведомления должен быть иной
    @DisplayName("32. Пустой номер карты")
    void shouldThrowEmptyCardNumberVerificationErrorInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("", "08", "23", "IVAN PETROV", "345");
        creditPage.emptyCardNumberError();
    }

    @Test
    //Вручную проходит
    @DisplayName("33. В поле 'Номер карты' введены буквы и специальные символы")
    void shouldNotEnterLettersAndSymbolsInCardNumberInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardNumber("fhhb $*)@ jkjs уолц");
        creditPage.emptyCardNumberInField();
    }

    @Test
    //Вручную проходит
    @DisplayName("34. Месяц, больше 12")
    void shouldThrowInvalidExpDateMonthVerificationErrorWithMoreThan12InCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 44444 4444 4441", "13", "23", "IVAN PETROV", "345");
        creditPage.invalidExpDateMonthError();
    }

    @Test
    //Вручную проходит
    @DisplayName("35. Месяц из 1 цифры")
    void shouldThrowWrongFormatMonthVerificationErrorInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 4444 4444 4441", "1", "23", "IVAN PETROV", "345");
        creditPage.wrongFormatMonthError();
    }

    @Test
    //Вручную не проходит, текст уведомления должен быть иной
    @DisplayName("36. Пустое поле 'Месяц'")
    void shouldThrowEmptyMonthVerificationErrorInCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 4444 4444 4441", "", "23", "IVAN PETROV", "345");
        creditPage.emptyMonthError();
    }

    @Test
    //Вручную проходит
    @DisplayName("37. Месяц из двух нулей")
    void shouldThrowInvalidExpDateMonthVerificationErrorWith00InCredit() {
        creditPage = mainPage.goToCreditPage();
        creditPage.fillInCardInfo("4444 44444 4444 4441", "00", "23", "IVAN PETROV", "345");
        creditPage.invalidExpDateMonthError();
    }


}
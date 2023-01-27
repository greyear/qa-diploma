package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class CardPage {
    // Поля
    private SelenideElement cardNumberField = $$(".input__inner").findBy(text("Номер карты")).$("input");
    private SelenideElement monthField = $$(".input__inner").findBy(text("Месяц")).$("input");
    private SelenideElement yearField = $$(".input__inner").findBy(text("Год")).$("input");
    private SelenideElement cardOwnerField = $$(".input__inner").findBy(text("Владелец")).$("input");
    private SelenideElement cvvField = $$(".input__inner").findBy(text("CVC/CVV")).$("input");
    private SelenideElement sendRequestButton = $$("button").findBy(text("Продолжить"));

    //Уведомления об итоге отправки формы
    private SelenideElement successOperationNotification = $$(".notification__content").findBy(text("Операция одобрена Банком."));
    private SelenideElement failOperationNotification = $$(".notification__content").findBy(text("Ошибка! Банк отказал в проведении операции."));

    //Ошибки верификации
    private SelenideElement verificationErrorNumber = $$(".input__inner").findBy(text("Номер карты")).$(".input__sub");
    private SelenideElement verificationErrorMonth = $$(".input__inner").findBy(text("Месяц")).$(".input__sub");
    private SelenideElement verificationErrorYear = $$(".input__inner").findBy(text("Год")).$(".input__sub");
    private SelenideElement verificationErrorOwner = $$(".input__inner").findBy(text("Владелец")).$(".input__sub");
    private SelenideElement verificationErrorCVV = $$(".input__inner").findBy(text("CVC/CVV")).$(".input__sub");

    //Заполнение формы
    public void fillInCardInfo(String cardNumber, String month, String year, String cardOwner, String cvv) {
        cardNumberField.sendKeys(cardNumber);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
        cardOwnerField.sendKeys(cardOwner);
        cvvField.sendKeys(cvv);
        sendRequestButton.click();
    }

    public void fillInCardNumber(String cardNumber) {
        cardNumberField.sendKeys(cardNumber);
    }

    public void fillInMonth(String month) {
        monthField.sendKeys(month);
    }

    public void fillInYear(String year) {
        yearField.sendKeys(year);
    }

    public void fillInOwner(String owner) {
        cardOwnerField.sendKeys(owner);
    }

    public void fillInCVV(String CVV) {
        cvvField.sendKeys(CVV);
    }

    public void checkIfSuccess() {
        successOperationNotification.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void checkIfFail() {
        failOperationNotification.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void wrongFormatCardNumberError() {
        verificationErrorNumber.shouldHave(text("Неверный формат"), Duration.ofSeconds(3));
    }

    public void wrongFormatMonthError() {
        verificationErrorMonth.shouldHave(text("Неверный формат"), Duration.ofSeconds(3));
    }

    public void wrongFormatYearError() {
        verificationErrorYear.shouldHave(text("Неверный формат"), Duration.ofSeconds(3));
    }

    public void wrongFormatOwnerError() {
        verificationErrorOwner.shouldHave(text("Неверный формат"), Duration.ofSeconds(3));
    }

    public void wrongFormatCVVError() {
        verificationErrorCVV.shouldHave(text("Неверный формат"), Duration.ofSeconds(3));
    }

    public void emptyCardNumberError() {
        verificationErrorNumber.shouldHave(text("Поле обязательно для заполнения"), Duration.ofSeconds(3));
    }

    public void emptyMonthError() {
        verificationErrorMonth.shouldHave(text("Поле обязательно для заполнения"), Duration.ofSeconds(3));
    }

    public void emptyYearError() {
        verificationErrorYear.shouldHave(text("Поле обязательно для заполнения"), Duration.ofSeconds(3));
    }

    public void emptyOwnerError() {
        verificationErrorOwner.shouldHave(text("Поле обязательно для заполнения"), Duration.ofSeconds(3));
    }

    public void emptyCVVError() {
        verificationErrorCVV.shouldHave(text("Поле обязательно для заполнения"), Duration.ofSeconds(3));
    }

    public void invalidExpDateMonthError() {
        verificationErrorMonth.shouldHave(text("Неверно указан срок действия карты"), Duration.ofSeconds(3));
    }

    public void invalidExpDateYearError() {
        verificationErrorYear.shouldHave(text("Истёк срок действия карты"), Duration.ofSeconds(3));
    }

    public void invalidCVVError() {
        verificationErrorCVV.shouldHave(text("Неверное значение"), Duration.ofSeconds(3));
    }

    public void emptyCardNumberInField() {
        cardNumberField.shouldBe(empty);
    }

    public void emptyMonthInField() {
        monthField.shouldBe(empty);
    }

    public void emptyYearInField() {
        yearField.shouldBe(empty);
    }

    public void emptyCardOwnerInField() {
        cardOwnerField.shouldBe(empty);
    }

    public void emptyCVVInField() {
        cvvField.shouldBe(empty);
    }
}

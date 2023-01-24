package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement heading = $(".heading_size_1");
    private SelenideElement buyButton = $(byText("Купить"));
    private SelenideElement buyInCreditButton = $(byText("Купить в кредит"));

    private SelenideElement howToPayChoiceHeading = $(".heading").find(exactText("карт");

    public MainPage() {
        heading.shouldBe(visible);
    }

    public DebitPage goToDebitPage() {
        buyButton.click();
        howToPayChoiceHeading.shouldHave(exactText("Оплата по карте"));
        return new DebitPage();
    }

    public CreditPage goToCreditPage() {
        buyInCreditButton.click();
        howToPayChoiceHeading.shouldHave(exactText("Кредит по данным карты"));
        return new CreditPage();
    }
}
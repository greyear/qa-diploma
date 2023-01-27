package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private String host = "http://localhost:8080";
    private SelenideElement heading = $(".heading_size_l");
    private SelenideElement buyButton = $(byText("Купить")).parent().parent();
    private SelenideElement buyInCreditButton = $(byText("Купить в кредит"));

    private SelenideElement howToPayChoiceHeading = $$("h3").find(text("карт"));

    public MainPage() {
        open(host);
        heading.shouldBe(visible);
    }

    public CardPage goToDebitPage() {
        buyButton.click();
        howToPayChoiceHeading.shouldHave(exactText("Оплата по карте"));
        return new CardPage();
    }

    public CardPage goToCreditPage() {
        buyInCreditButton.click();
        howToPayChoiceHeading.shouldHave(exactText("Кредит по данным карты"));
        return new CardPage();
    }
}
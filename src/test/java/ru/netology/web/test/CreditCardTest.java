package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.web.page.CreditPage;
import ru.netology.web.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class CreditCardTest {
    private String host = "http://localhost:8080";
    private MainPage mainPage;
    private CreditPage creditPage;

    @BeforeEach
    void openBrowser() {
        open(host);
    }



}
package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.page.DebitPage;
import ru.netology.web.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class DebitCardTest {
    private String host = "http://localhost:8080";
    private MainPage mainPage;
    private DebitPage debitPage;

    @BeforeEach
    void openBrowser() {
        open(host);
    }

    @Test
    void

}
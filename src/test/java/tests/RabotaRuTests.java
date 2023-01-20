package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RabotaRuTests extends TestBase {

    @Test
    @Tag("rabotaru")
    @DisplayName("Работа поиска на главной странице")
    void searchMainPageTest() {
        step("Вводим в строке поисковый запрос", () -> {
            SelenideElement searchInput = $x("//input[@placeholder='Должность, компания']");
            searchInput.click();
            searchInput.sendKeys("сварщик");
        });
        step("Нажимаем на кнопку Найти", () -> {
            $x("//button[@aria-label='Найти']").click();
        });
        step("Проверяем что произошел переход на страницу с результатами", () -> {
            $x("//h1[contains(text(),'Вакансии сварщика')]").shouldBe(visible);
        });
    }

    @Test
    @Tag("rabotaru")
    @DisplayName("Проверка фильтров поиска")
    void checkboxesInFilterTest() {
        step("Нажимаем на кнопку Фильтры", () -> {
        $x("//button[@aria-label='Фильтры']").click();
        });
        step("Проверяем отображение фильтров", () -> {
        $(byAttribute("class", "card__text dialog-card__inner")).$$("label")
                .shouldHave(textsInAnyOrder("Для людей с инвалидностью",
                        "Пенсионерам",
                        "Студентам",
                        "Без переезда",
                        "С телефоном",
                        "Скрыть вакансии от агентств"));
        });
    }

    @Test
    @Tag("rabotaru")
    @DisplayName("Проверка отображение модального окна регистрации/входа")
    void loginTest() {
        step("Нажимаем на кнопку Войти", () -> {
        $x("//button[@aria-label='Войти' and @data-ripple='true']").click();
        });
        step("Проверяем отображение модального окна регистрации и его элементов", () -> {
        $(byAttribute("mode", "REGISTRATION")).shouldBe(visible);
        $x("//div[contains(text(),'Вход и регистрация')]").shouldBe(visible);
        });
    }

    @Test
    @Tag("rabotaru")
    @DisplayName("Проверка перехода через сторис")
    void storyRemoteTest() {
        step("Нажимаем на сторис Сбер", () -> {
        $$x("//li[@class='stories-inline-item__wrapper' and @data-visible='true']").get(0).click();
        });
        step("Проверяем отображение заголовка СБЕР", () -> {
        $x("//h1[contains(text(),'СБЕР')]").shouldBe(visible);
        });
    }

    @Test
    @Tag("rabotaru")
    @DisplayName("Проверка перехода к созданию резюме")
    void createResumeTest() {
        step("Нажимаем на кнопку Создать резюме", () -> {
        $x("//button[@aria-label='Создать резюме' and @data-ripple='true']").click();
        });
        step("Проверяем отображение страницы регистрации и его элементов", () -> {
        $x("//span[contains(text(),'Регистрация')]").shouldBe(visible);
        $x("//form[@aria-label='Регистрация' and @novalidate='novalidate']").shouldBe(visible);
        });
    }
}
package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RabotaRuTests extends TestBase {

    @Test
    @Tag("rabotaru")
    @Tag("smoke")
    @DisplayName("Поиск с главной страницы")
    void searchMainPageTest() {
        step("Вводим в строке поисковый запрос", () -> {
            SelenideElement searchInput = $x("//input[@placeholder='Должность, компания']");
            searchInput.click();
            searchInput.sendKeys("сварщик");
        });
        step("Нажимаем на кнопку Найти", () -> {
            $x("//button[@aria-label='Найти']").click();
            sleep(5000);
        });
        step("Проверяем что произошел переход на страницу с результатами", () -> {
            $x("//h1[contains(text(),'Вакансии сварщика')]").shouldBe(visible);
        });
    }

    @Test
    @Tag("rabotaru")
    @Tag("smoke")
    @DisplayName("Проверяем чекбоксы в фильтрах поиска")
    void checkboxesInFilterTest() {
        $x("//button[@aria-label='Фильтры']").click();
        $(byAttribute("class", "card__text dialog-card__inner")).$$("label")
                .shouldHave(textsInAnyOrder("Для людей с инвалидностью",
                        "Пенсионерам",
                        "Студентам",
                        "Без переезда",
                        "С телефоном",
                        "Скрыть вакансии от агентств"));
    }

    @Test
    @Tag("rabotaru")
    @Tag("regression")
    @DisplayName("Проверяем отображение модального окна регистрации/входа по нажатию на Войти")
    void loginTest() {
        $x("//button[@aria-label='Войти' and @data-ripple='true']").click();
        $(byAttribute("mode", "REGISTRATION")).shouldBe(visible);
        $x("//div[contains(text(),'Вход и регистрация')]").shouldBe(visible);
    }

    @Test
    @Tag("rabotaru")
    @Tag("smoke")
    @DisplayName("Проверяем переход на сторис про Сбер")
    void storyRemoteTest() {
        $$x("//li[@class='stories-inline-item__wrapper' and @data-visible='true']").get(0).click();
        $x("//h1[contains(text(),'СБЕР')]").shouldBe(visible);
    }

    @Test
    @Tag("rabotaru")
    @Tag("regression")
    @DisplayName("Нажимаем Создать резюме и проверяем что произошел переход к форме регистрации")
    void createResumeTest() {
        $x("//button[@aria-label='Создать резюме' and @data-ripple='true']").click();
        $x("//span[contains(text(),'Регистрация')]").shouldBe(visible);
        $x("//form[@aria-label='Регистрация' and @novalidate='novalidate']").shouldBe(visible);
    }
}
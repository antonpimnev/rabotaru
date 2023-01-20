# Проект по автоматизации тестирования сервиса для поиска работы и подбора сотрудников Rabota.ru

## 	Содержание

> ➠ [Покрытый функционал](#покрытый-функционал)
>
> ➠ [Технологический стек](#технологический-стек)
>
> ➠ [Запуск тестов из терминала](#запуск-тестов-из-терминала)
>
> ➠ [Запуск тестов в Jenkins](#-удаленный-запуск-тестов-в-Jenkins)
>
> ➠ [Отчет о результатах тестирования в Allure Report](#-главная-страница-allure-отчета)
>
> ➠ [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
>
> ➠ [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)

##  Покрытый функционал
> Разработаны автотесты на <code>UI</code>.
### UI

- [x] Работа поиска на главной странице
- [x] Проверка фильтров поиска
- [x] Проверка отображение модального окна регистрации/входа
- [x] Проверка перехода через сторис
- [x] Проверка перехода к созданию резюме

## Технологический стек

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="/readme_attach/design/Intelij_IDEA.png" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="/readme_attach/design/Java.png" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="/readme_attach/design/GitHub-Mark.png" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="/readme_attach/design/JUnit5.png" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="/readme_attach/design/Gradle.png" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="/readme_attach/design/Selenide.png" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="/readme_attach/design/Selenoid.png" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="/readme_attach/design/Allure_Report.png" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="/readme_attach/design/Jenkins.png" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://telegram.org/"><img src="/readme_attach/design/Telegram.png" width="50" height="50"  alt="Telegram"/></a>
</p>

### Проект написан на <code>Java</code> с использованием <code>Selenide</code> для UI-тестов.
>
> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>.
>
> <code>Allure Report</code> формирует отчет о запуске тестов.
>
> Для автоматизированной сборки проекта используется <code>Gradle</code>.
>
> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.
>
> <code>Jenkins</code> выполняет запуск тестов.
>
> После завершения тестов отправляются уведомления с помощью бота в <code>Telegram</code>.

## Запуск тестов из терминала

### Локальный запуск тестов

```
gradle clean test 
```

## <img  width="30" height="30" title="Jenkins" src="/readme_attach/design/Jenkins.svg"> Удаленный запуск тестов в Jenkins

> Для запуска тестов используется параметризированная сборка
<p align="center">
<img title="Jenkins" src="readme_attach/settings.png">
</p>

## <img width="30" height="30" title="Allure_Report" src="readme_attach/design/Allure_Report.svg"> Главная страница allure отчета

<p align="center">
<img title="Allure_main" src="readme_attach/allure.png">
</p>

### <img width="30" height="30" title="Allure_Report" src="readme_attach/design/Allure_Report.svg"> Тест кейсы в отчете allure

<p align="center">
<img title="Allure_suits" src="readme_attach/allure_suits.png">
</p>

### <img width="30" height="30" title="Allure_Report" src="readme_attach/design/Allure_Report.svg"> Основной дашборд

<p align="center">
<img title="Allure_dashboard" src="readme_attach/graphs.png">
</p>

## <img width="30" height="30" title="Telegram" src="readme_attach/design/Telegram.svg"> Уведомления в Telegram с использованием бота

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о проведенных тестах.
>
> Информация по настройке и использованию бота <code>https://github.com/qa-guru/allure-notifications</code>

<p align="center">
<img title="Telegram_notifications" src="readme_attach/telegram_allure.png">
</p>

## <img width="30" height="30" title="Selenoid" src="readme_attach/design/Selenoid.svg"> Пример запуска теста в Selenoid

> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.

<p align="center">
<img title="Selenoid" src="readme_attach/selenoid.gif">
</p>
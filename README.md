# Зависимости проекта

| Технология | Версия  |
|------------|:-------:|
| Java	      |   11    | 
| Maven      |  3.9.0  |
| JUnit | 4.13.2  |
|Rest-Assured|  5.5.6  |
|Allure| 2.29.1  |
|Lombok| 1.18.38 |
|JavaFaker|  1.0.2  |
|AspectJ|  1.9.7  |
|Selenium|4.35.0|
|WebDriverManager|6.3.1|
____
# Запуск проекта
### Для запуска всех тестов выполните команду:
```shell
./mvnw clean:test
```
### Для генерации отчетов Allure выполните:
```shell
./mvnw allure:serve
```
Отчеты генерируются в директорию target/allure-results
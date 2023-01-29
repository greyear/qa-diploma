# Дипломный проект по профессии «Тестировщик»
## Процедура запуска автотестов
##### Установленное ПО: 
1. IntelliJ IDEA
2. Docker Desktop
3. Браузер, например, Google Chrome
4. Node.js v18.13.0

##### Описание процедуры: 
1. Склонируйте репозиторий по [ссылке](https://github.com/netology-code/qa-diploma).
2. Откройте проект в IntelliJ IDEA
3. Запустите БД командами:
- Для БД MySQL:
`docker-compose up -d mysqldb`
- Для БД PostgreSQL:
`docker-compose up -d postgresqldb`
4. Запустите SUT в терминале:
- Для БД MySQL:
`java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar ./aqa-shop.jar`
- Для БД PostgreSQL:
`java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar ./aqa-shop.jar`

  Приложение запустится по [ссылке](http://localhost:8080/)
5. Запустите симулятор банковских сервисов в отдельном терминале:
- `cd ./gate-simulator`
- `npm start`
6. Запустите тесты в отдельном терминале:
- Для БД MySQL:
`./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`
- Для БД PostgreSQL:
`./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`
7. Сформируйте отчеты Allure:
`./gradlew allureReport`
8. Откройте отчеты в браузере:
`./gradlew allureServe`
9. Остановите приложение, завершите работу allureServe в терминале:
Ctrl+C
10. Остановите контейнеры командой
`docker-compose down`
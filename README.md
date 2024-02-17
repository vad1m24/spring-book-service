___05/02___
1. Сдать скриншот страницы /eureka/apps с зарегистрированными приложениями.
На скрине должно быть видно оба сервиса (book-service, issuer-service)

2. Добавить третий сервис: сервис читателей.

   ![1](https://github.com/vad1m24/spring-book-service/assets/88346237/cc7629de-89de-46a5-9b02-742f4faba2da)


___01/02___
1. Создать аннотацию замера времени исполнения метода (Timer). Она может ставиться над методами или классами.
   Аннотация работает так: после исполнения метода (метода класса) с такой аннотацией, необходимо в лог записать следующее:
   className - methodName #(количество секунд выполнения)

___29/01___
* 1   Для ресурсов, возвращающих HTML-страницы, реализовать авторизацию через login-форму. 
      Остальные /api ресурсы, возвращающие JSON, закрывать не нужно!
* 2.1 * Реализовать таблицы User(id, name, password) и Role(id, name), связанные многие ко многим
* 2.2 * Реализовать UserDetailsService, который предоставляет данные из БД (таблицы User и Role)
* 3.3 * Ресурсы выдачей (issue) доступны обладателям роли admin
* 3.4 * Ресурсы читателей (reader) доступны всем обладателям роли reader
* 3.5 * Ресурсы книг (books) доступны всем авторизованным пользователям

___25/01___
1. Подключить OpenAPI 3 и swagger к проекту с библиотекой
2. Описать все контроллеры, эндпоинты и возвращаемые тела с помощью аннотаций OpenAPI 3
3. В качестве результата, необходимо прислать скриншот(ы) страницы swagger (с ручками)

___22/01___
* 1 Подключить базу данных к проекту "библиотека", который разрабатывали на прошлых уроках.
* 1.1 Подключить spring-boot-starter-data-jpa (и необходимый драйвер) и указать параметры соединения в application.yml
* 1.2 Для книги, читателя и факта выдачи описать JPA-сущности
* 1.3 Заменить самописные репозитории на JPA-репозитории

___17/01___
* 1 В предыдущий проект (где была библиотека с книгами, выдачами и читателями) добавить следующие ресурсы,
* которые возвращают готовые HTML-страницы (т.е. это просто Controller'ы):
* 1.1 /ui/books - на странице должен отобразиться список всех доступных книг в системе
* 1.2 /ui/reader - аналогично 1.1
* 1.3 /ui/issues - на странице отображается таблица, в которой есть столбцы (книга, читатель, когда взял, когда вернул (если не вернул — пустая ячейка)).


___15/01___
* 1 Доделать сервис управления книгами:
* 1.1 Реализовать контроллер по управлению книгами с ручками: GET /book/{id} - получить описание книги, DELETE /book/{id} - удалить книгу, POST /book - создать книгу
* 1.2 Реализовать контроллер по управлению читателями (аналогично контроллеру с книгами из 1.1)
* 1.3 В контроллере IssueController добавить ресурс GET /issue/{id} - получить описание факта выдачи
*
* 2.1 В сервис IssueService добавить проверку, что у пользователя на руках нет книг. Если есть — не выдавать книгу (статус ответа - 409 Conflict)
* 2.2 В сервис читателя добавить ручку GET /reader/{id}/issue - вернуть список всех выдачей для данного читателя

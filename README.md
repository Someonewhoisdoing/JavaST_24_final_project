# JavaST_24_final_project
CoffeeShop project (Проект CoffeeShop)

Приложение написано на языке программирования Java c использованием шаблона MVC и следующих технологий:
- JDBC
- Servlet (Controller запросов и ответов)
- JSP

Шаблоны проектирования, используемые в приложении:
- DAO
- Factory method

При проектировании JSP страниц используется:
- JSTL
- Bootstrap 4
- собственные теги

Функциональность приложения (CRUD операции):
- аунтентификация пользователя (логин, пароль)
- просмотр, редактирование, удаление информации
- выход из системы

Юзер:
- login: user или user1
- password: 1234
- просмотр личной информации
- редактирование личной информации
- добавление пунктов меню в корзину
- удаление пунктов меню из корзины
- совершение заказа

Администратор:
- login: admin 
- password: 1234
- просмотр пунктов меню
//- добавление новых пунктов меню
- редактирование существующих пунктов меню
- просмотр всех пользователей

В приложении реализованы:
- пагинация
- cмена языка RU/EN
- собственные теги (footer.tag, menu.tag)
- потокобезопасный пул
- cессия
- валидация данных для пользователя (LoginValidator.java, UserDataValidator.java, login.jsp, edit_personal_information.jsp)
- алгоритм SHA-256 для хэширования паролей (util package, UserPersonalInformationEditorCommand.java)
- защита от sql injection 
- фильтры











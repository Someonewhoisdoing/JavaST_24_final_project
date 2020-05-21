# JavaST_24_final_project
CoffeeShop project (Проект CoffeeShop)

Приложение написано на языке программирования Java c использованием шаблонов Layered architecture и MVC и следующих технологий:
- JDBC
- Servlet
- JSP

Шаблоны проектирования, используемые в приложении:
- DAO
- Factory method
- Singleton

При проектировании JSP страниц используется:
- JSTL
- Bootstrap 4
- собственные теги

Функциональность приложения (CRUD операции):
- аунтентификация пользователя
- просмотр, редактирование, удаление информации
- выход из системы

Юзер:
- login: savage 
- password: $2a$12$6PUFlB9UwKHKGEZ795YEaObjOGdJU47dRpleQBrgN6smQBJluyn.6
- просмотр личной информации
- редактирование личной информации
- добавление пунктов меню в корзину
- удаление пунктов меню из корзины
- совершение заказа

Администратор:
- login: admin 
- password: 666666
- просмотр пунктов меню
- добавление новых пунктов меню
- редактирование существующих пунктов меню
- просмотр всех пользователей

В приложении реализованы:
- пагинация на страницах menu.jsp и menu_items_list_page.jsp
- cмена языка RU/EN на странице меню
- собственный тег (footer.tag)
- потокобезопасный пул
- cессия
- валидация входных данных для пользователя (LoginValidator.java, UserDataValidator.java, login.jsp, edit_personal_information.jsp)
- bcrypt для хэширования паролей (util package, UserPersonalInformationEditorCommand.java)
- защита от sql injection 
- фильтры











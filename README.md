 Java_Web_Applications

 1) Добавить в проект локальный сервер (например: Apache Tomcat).
 2) Добавить базу данных (например: PostgreSQL).
 3) В конфигурационном бине поменять данные Driver Manager Data Source на свои данные подключения к базе данных.
 4) Ваша БД должна иметь такие таблицы с колонками как:  Worksafety(id, currentdate, total, heavy, deadly),
                                                          Wagoms(id, currentdate, defectioncars), 
                                                          Trucking(id, currentDate, cargoweight),
                                                          Passengers(id, currentdate, cargohumans).
 
 !!! Важно 
    В БД тип данных поля currentdate должно быть date 

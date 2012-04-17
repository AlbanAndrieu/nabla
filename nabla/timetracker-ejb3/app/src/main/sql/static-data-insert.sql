-- Password is 'cooldude' encoded using MD5
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, IS_ACTIVE, CREATION_DATE, COMMENT) values (1, 'testuser', '756slLjeNViurJBGI5JeqA==', 'testuser', 'testuser', 'test@test.com',            1, PARSEDATETIME('2011-01-01 09:00', 'yyyy-MM-dd hh:mm'), 'User for test purpose');
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, IS_ACTIVE, CREATION_DATE, COMMENT) values (2, 'admin',    '756slLjeNViurJBGI5JeqA==', 'Alban',    'Andrieu',  'alban.andrieu@free.fr',    1, PARSEDATETIME('2011-01-01 09:00', 'yyyy-MM-dd hh:mm'), 'Alban Andrieu as administrator');
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, IS_ACTIVE, CREATION_DATE, COMMENT) values (3, 'aandrieu', '756slLjeNViurJBGI5JeqA==', 'Alban',    'Andrieu',  'alban.andrieu@gmail.com',  1, PARSEDATETIME('2011-01-01 09:00', 'yyyy-MM-dd hh:mm'), 'Alban Andrieu as standard user');
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, IS_ACTIVE, CREATION_DATE, COMMENT) values (4, 'rbrooke',  '756slLjeNViurJBGI5JeqA==', 'Rachael',  'Brooke',   'rachael.brooke@yahoo.com', 1, PARSEDATETIME('2011-01-01 09:00', 'yyyy-MM-dd hh:mm'), 'Rachael Brooke');
commit;

insert into USER_ROLE (ID, ROLE, USER_FK) values (1, 'STANDARD_USER', 1);
insert into USER_ROLE (ID, ROLE, USER_FK) values (2, 'ADMINISTRATOR', 1);
insert into USER_ROLE (ID, ROLE, USER_FK) values (3, 'STANDARD_USER', 2);
insert into USER_ROLE (ID, ROLE, USER_FK) values (4, 'STANDARD_USER', 3);
insert into USER_ROLE (ID, ROLE, USER_FK) values (5, 'STANDARD_USER', 4);
commit;

insert into USER2ROLES (USER_ID_FK, ROLE_ID_FK) values (1, 1);
insert into USER2ROLES (USER_ID_FK, ROLE_ID_FK) values (2, 2);
insert into USER2ROLES (USER_ID_FK, ROLE_ID_FK) values (2, 3);
insert into USER2ROLES (USER_ID_FK, ROLE_ID_FK) values (3, 4);
insert into USER2ROLES (USER_ID_FK, ROLE_ID_FK) values (4, 5);
commit;

insert into TASK (ID, NAME) values (1, 'Research');
insert into TASK (ID, NAME) values (2, 'Development');
insert into TASK (ID, NAME) values (3, 'Testing');
insert into TASK (ID, NAME) values (4, 'Admin');
insert into TASK (ID, NAME) values (5, 'Meeting');
commit;
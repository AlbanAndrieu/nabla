-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'

-- Password is 'cooldude' encoded using MD5 give 756slLjeNViurJBGI5JeqA==
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME) values (1, 'testuser', 'cooldude', 'testuser', 'testuser');
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME) values (2, 'admin',    'cooldude', 'Alban',    'Andrieu');
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME) values (3, 'aandrieu', 'cooldude', 'Alban',    'Andrieu');
insert into USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME) values (4, 'rbrooke',  'cooldude', 'Rachael',  'Brooke');
commit;      

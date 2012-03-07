create table TASK (
        ID BIGINT not null auto_increment,
        NAME VARCHAR(255) BINARY not null unique,
        primary key (ID)
    ) ENGINE=InnoDB;
create table TIMECARD (
        ID BIGINT not null auto_increment,
        STATUS VARCHAR(255) BINARY not null,
        START_DATE DATETIME not null,
        COMMENTS VARCHAR(255) BINARY not null,
        APPROVER_FK BIGINT,
        SUBMITTER_FK BIGINT not null,
        primary key (ID)
    ) ENGINE=InnoDB;
create table TIME_ALLOCATION (
        ID BIGINT not null auto_increment,
        TIME_PERIOD_START_TIME DATETIME not null,
        TIME_PERIOD_END_TIME DATETIME not null,
        TASK_FK BIGINT not null,
        TIMECARD_FK BIGINT not null,
        primary key (ID)
    ) ENGINE=InnoDB;
create table USERS (
        ID BIGINT not null auto_increment,
        USERNAME VARCHAR(255) BINARY not null unique,
        PASSWORD VARCHAR(255) BINARY not null,
        FIRST_NAME VARCHAR(255) BINARY not null,
        LAST_NAME VARCHAR(255) BINARY not null,
        EMAIL VARCHAR(255) BINARY not null unique,
        IS_ACTIVE TINYINT not null,
        CREATION_DATE DATETIME not null,
        COMMENT VARCHAR(255) BINARY,
        primary key (ID)
    ) ENGINE=InnoDB;
create table USER_ROLE (
        ID BIGINT not null auto_increment,
        ROLE VARCHAR(255) BINARY not null,
        USER_FK BIGINT,
        primary key (ID)
    ) ENGINE=InnoDB;
alter table TIMECARD
        add index TIMECARD_SUBMITTER_FKC (SUBMITTER_FK),
        add constraint TIMECARD_SUBMITTER_FKC
        foreign key (SUBMITTER_FK)
        references USERS (ID);
alter table TIMECARD
        add index TIMECARD_APPROVER_FKC (APPROVER_FK),
        add constraint TIMECARD_APPROVER_FKC
        foreign key (APPROVER_FK)
        references USERS (ID);
alter table TIME_ALLOCATION
        add index TIME_ALLOCATION_TIMECARD_FKC (TIMECARD_FK),
        add constraint TIME_ALLOCATION_TIMECARD_FKC
        foreign key (TIMECARD_FK)
        references TIMECARD (ID);
alter table TIME_ALLOCATION
        add index TIME_ALLOCATION_TASK_FKC (TASK_FK),
        add constraint TIME_ALLOCATION_TASK_FKC
        foreign key (TASK_FK)
        references TASK (ID);
create index USERNAME_INDEX on USERS (USERNAME);
alter table USER_ROLE
        add index USER_ROLE_USER_FKC (USER_FK),
        add constraint USER_ROLE_USER_FKC
        foreign key (USER_FK)
        references USERS (ID);
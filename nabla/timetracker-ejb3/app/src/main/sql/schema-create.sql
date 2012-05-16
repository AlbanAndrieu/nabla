
    create table TASK (
        ID BIGINT generated by default as identity,
        NAME VARCHAR(256) not null unique,
        primary key (ID)
    );

    create table TIMECARD (
        ID BIGINT generated by default as identity,
        COMMENTS VARCHAR(256) not null,
        START_DATE DATETIME not null,
        STATUS VARCHAR(256) not null,
        APPROVER_FK BIGINT,
        SUBMITTER_FK BIGINT not null,
        primary key (ID)
    );

    create table TIME_ALLOCATION (
        ID BIGINT generated by default as identity,
        TIME_PERIOD_START_TIME DATETIME not null,
        TIME_PERIOD_END_TIME DATETIME not null,
        TASK_FK BIGINT not null,
        TIMECARD_FK BIGINT not null,
        primary key (ID)
    );

    create table USERS (
        ID BIGINT generated by default as identity,
        USERNAME VARCHAR(50) not null unique,
        PASSWORD VARCHAR(256) not null,
        FIRST_NAME VARCHAR(256) not null,
        LAST_NAME VARCHAR(256) not null,
        EMAIL VARCHAR(50) not null unique,
        IS_ACTIVE BIT not null,
        CREATION_DATE DATETIME not null,
        COMMENT VARCHAR(256),
        primary key (ID)
    );

    create table USER_ROLE (
        ID BIGINT generated by default as identity,
        ROLE VARCHAR(256) not null,
        USER_FK BIGINT,
        primary key (ID)
    );

    alter table TIMECARD 
        add constraint TIMECARD_SUBMITTER_FKC 
        foreign key (SUBMITTER_FK) 
        references USERS;

    alter table TIMECARD 
        add constraint TIMECARD_APPROVER_FKC 
        foreign key (APPROVER_FK) 
        references USERS;

    alter table TIME_ALLOCATION 
        add constraint TIME_ALLOCATION_TIMECARD_FKC 
        foreign key (TIMECARD_FK) 
        references TIMECARD;

    alter table TIME_ALLOCATION 
        add constraint TIME_ALLOCATION_TASK_FKC 
        foreign key (TASK_FK) 
        references TASK;

    create index USERNAME_INDEX on USERS (USERNAME);

    alter table USER_ROLE 
        add constraint USER_ROLE_USER_FKC 
        foreign key (USER_FK) 
        references USERS;

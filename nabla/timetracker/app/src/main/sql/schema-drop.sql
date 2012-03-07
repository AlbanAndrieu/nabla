
    alter table TIMECARD 
        drop constraint TIMECARD_SUBMITTER_FKC;

    alter table TIMECARD 
        drop constraint TIMECARD_APPROVER_FKC;

    alter table TIME_ALLOCATION 
        drop constraint TIME_ALLOCATION_TIMECARD_FKC;

    alter table TIME_ALLOCATION 
        drop constraint TIME_ALLOCATION_TASK_FKC;

    alter table USER_ROLE 
        drop constraint USER_ROLE_USER_FKC;

    drop table TASK if exists;

    drop table TIMECARD if exists;

    drop table TIME_ALLOCATION if exists;

    drop table USERS if exists;

    drop table USER_ROLE if exists;

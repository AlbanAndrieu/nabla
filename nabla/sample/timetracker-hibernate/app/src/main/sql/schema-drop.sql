
    alter table TIMECARD 
        drop constraint TIMECARD_SUBMITTERC;

    alter table TIMECARD 
        drop constraint TIMECARD_APPROVERC;

    alter table TIME_ALLOCATION 
        drop constraint TIME_ALLOCATION_TASKC;

    alter table TIME_ALLOCATION 
        drop constraint TIME_ALLOCATION_TIMECARDC;

    alter table USER_ROLE 
        drop constraint USER_ROLE_USERSC;

    drop table TASK if exists;

    drop table TIMECARD if exists;

    drop table TIME_ALLOCATION if exists;

    drop table USERS if exists;

    drop table USER_ROLE if exists;

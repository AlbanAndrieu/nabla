/* ------------- TimeAllocation foreign key contraints ------------------ */
ALTER TABLE TIME_ALLOCATION
    ADD  ( CONSTRAINT FKTASKTIMEALLOCATION
        FOREIGN KEY (TASK)
            REFERENCES TASK
                ) ;

ALTER TABLE TIME_ALLOCATION
    ADD  ( CONSTRAINT FKTIMECARDTIMEALLOCATION
        FOREIGN KEY (TIMECARD)
            REFERENCES TIMECARD
                ) ;

/* ------------- Timecard foreign key contraints ------------------ */
ALTER TABLE TIMECARD
    ADD  ( CONSTRAINT FKUSERTIMECARD
        FOREIGN KEY (APPROVER)
            REFERENCES USERS
                ) ;

ALTER TABLE TIMECARD
    ADD  ( CONSTRAINT FKUSERTIMECARD
        FOREIGN KEY (SUBMITTER)
            REFERENCES USERS
                ) ;

/* ------------- roles2users foreign key contraints ------------------ */
ALTER TABLE ROLES2USERS
    ADD  ( CONSTRAINT FKUSERROLEROLES2USERS
        FOREIGN KEY (ROLES)
            REFERENCES USER_ROLE
                 ON DELETE CASCADE ) ;

ALTER TABLE ROLES2USERS
    ADD  ( CONSTRAINT FKUSERROLES2USERS
        FOREIGN KEY (USERS)
            REFERENCES USERS
                 ON DELETE CASCADE ) ;

/* ------------- groups2roles foreign key contraints ------------------ */
ALTER TABLE GROUPS2ROLES
    ADD  ( CONSTRAINT FKUSERROLEGROUPS2ROLES
        FOREIGN KEY (ROLES)
            REFERENCES USER_ROLE
                 ON DELETE CASCADE ) ;

ALTER TABLE GROUPS2ROLES
    ADD  ( CONSTRAINT FKUSERROLEGROUPS2ROLES
        FOREIGN KEY (GROUPS)
            REFERENCES USER_ROLE
                 ON DELETE CASCADE ) ;



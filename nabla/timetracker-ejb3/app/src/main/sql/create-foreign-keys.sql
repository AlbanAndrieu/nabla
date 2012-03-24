/* ------------- TimeAllocation foreign key contraints ------------------ */
ALTER TABLE TIME_ALLOCATION
    ADD  ( CONSTRAINT FKTASKTIMEALLOCATION
        FOREIGN KEY (TASK_FK)
            REFERENCES TASK
                ) ;

ALTER TABLE TIME_ALLOCATION
    ADD  ( CONSTRAINT FKTIMECARDTIMEALLOCATION
        FOREIGN KEY (TIMECARD_FK)
            REFERENCES TIMECARD
                ) ;

/* ------------- Timecard foreign key contraints ------------------ */
ALTER TABLE TIMECARD
    ADD  ( CONSTRAINT FKUSERTIMECARD
        FOREIGN KEY (APPROVER_FK)
            REFERENCES USERS
                ) ;

ALTER TABLE TIMECARD
    ADD  ( CONSTRAINT FKUSERTIMECARD
        FOREIGN KEY (SUBMITTER_FK)
            REFERENCES USERS
                ) ;

/* ------------- UserRole foreign key contraints ------------------ */
ALTER TABLE USER_ROLE
    ADD  ( CONSTRAINT FKUSERUSERROLE
        FOREIGN KEY (USER_FK)
            REFERENCES USERS
                ) ;



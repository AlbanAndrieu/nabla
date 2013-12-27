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

/* ------------- UserRole foreign key contraints ------------------ */
ALTER TABLE USER_ROLE
    ADD  ( CONSTRAINT FKUSERUSERROLE
        FOREIGN KEY (USERS)
            REFERENCES USERS
                ) ;



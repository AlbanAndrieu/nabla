/* --------------- TimeAllocation table definition --------------------- */
CREATE TABLE TIME_ALLOCATION 
(
    ID BIGINT NOT NULL,
    TIME_PERIOD org::andromda::timetracker::domain::TimePeriod NOT NULL,
    TASK_FK BIGINT NOT NULL,
    TIMECARD_FK BIGINT NOT NULL
);

/* ------------- relation indexes ------------------ */
CREATE INDEX IDXTASKTIMEALLOCATION ON TIME_ALLOCATION
(
       TASK_FK
);

CREATE INDEX IDXTIMECARDTIMEALLOCATION ON TIME_ALLOCATION
(
       TIMECARD_FK
);


/* ------------ primary key contraints ---------------- */
ALTER TABLE TIME_ALLOCATION
   ADD  ( CONSTRAINT XPKTIMEALLOCATION PRIMARY KEY (ID) );

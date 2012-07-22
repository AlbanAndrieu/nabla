/* --------------- Timecard table definition --------------------- */
CREATE TABLE TIMECARD 
(
    ID BIGINT NOT NULL,
    COMMENTS VARCHAR(256) NOT NULL,
    START_DATE DATETIME NOT NULL,
    STATUS VARCHAR(256) NOT NULL,
    APPROVER_FK BIGINT NULL,
    SUBMITTER_FK BIGINT NOT NULL
);

/* ------------- relation indexes ------------------ */
CREATE INDEX IDXUSERTIMECARD ON TIMECARD
(
       APPROVER_FK
);

CREATE INDEX IDXUSERTIMECARD ON TIMECARD
(
       SUBMITTER_FK
);


/* ------------ primary key contraints ---------------- */
ALTER TABLE TIMECARD
   ADD  ( CONSTRAINT XPKTIMECARD PRIMARY KEY (ID) );

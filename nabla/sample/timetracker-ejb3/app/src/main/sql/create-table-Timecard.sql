/* --------------- Timecard table definition --------------------- */
CREATE TABLE TIMECARD 
(
    ID BIGINT NOT NULL,
    COMMENTS VARCHAR(256) NOT NULL,
    START_DATE DATETIME NOT NULL,
    STATUS VARCHAR(256) NOT NULL,
    APPROVER BIGINT NULL,
    SUBMITTER BIGINT NOT NULL
);

/* ------------- relation indexes ------------------ */
CREATE INDEX IDXUSERTIMECARD ON TIMECARD
(
       APPROVER
);

CREATE INDEX IDXUSERTIMECARD ON TIMECARD
(
       SUBMITTER
);


/* ------------ primary key contraints ---------------- */
ALTER TABLE TIMECARD
   ADD  ( CONSTRAINT XPKTIMECARD PRIMARY KEY (ID) );

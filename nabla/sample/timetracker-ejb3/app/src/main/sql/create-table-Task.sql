/* --------------- Task table definition --------------------- */
CREATE TABLE TASK 
(
    ID BIGINT NOT NULL,
    NAME VARCHAR(256) NOT NULL
);

/* ------------- relation indexes ------------------ */

/* ------------ primary key contraints ---------------- */
ALTER TABLE TASK
   ADD  ( CONSTRAINT XPKTASK PRIMARY KEY (ID) );

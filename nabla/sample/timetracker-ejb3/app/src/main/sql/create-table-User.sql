/* --------------- User table definition --------------------- */
CREATE TABLE USERS 
(
    ID BIGINT NOT NULL,
    USERNAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(256) NOT NULL,
    FIRST_NAME VARCHAR(256) NOT NULL,
    LAST_NAME VARCHAR(256) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    IS_ACTIVE SMALLINT NOT NULL,
    CREATION_DATE DATE NOT NULL,
    COMMENT VARCHAR(256) NULL
);

/* ------------- relation indexes ------------------ */

/* ------------ primary key contraints ---------------- */
ALTER TABLE USERS
   ADD  ( CONSTRAINT XPKUSER PRIMARY KEY (ID) );

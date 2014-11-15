/* --------------- UserRole table definition --------------------- */
CREATE TABLE USER_ROLE 
(
    ID BIGINT NOT NULL,
    ROLE VARCHAR(256) NOT NULL,
    CONDITIONAL BIT NULL
);

/* ------------- relation indexes ------------------ */

/* ------------ primary key contraints ---------------- */
ALTER TABLE USER_ROLE
   ADD  ( CONSTRAINT XPKUSERROLE PRIMARY KEY (ID) );

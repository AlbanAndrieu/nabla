/* --------------- UserRole table definition --------------------- */
CREATE TABLE USER_ROLE 
(
    ID BIGINT NOT NULL,
    ROLE VARCHAR(256) NOT NULL,
    USER BIGINT NOT NULL
);

/* ------------- relation indexes ------------------ */
CREATE INDEX IDXUSERUSERROLE ON USER_ROLE
(
       USER
);


/* ------------ primary key contraints ---------------- */
ALTER TABLE USER_ROLE
   ADD  ( CONSTRAINT XPKUSERROLE PRIMARY KEY (ID) );

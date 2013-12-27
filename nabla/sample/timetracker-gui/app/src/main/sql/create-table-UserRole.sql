/* --------------- UserRole table definition --------------------- */
CREATE TABLE USER_ROLE 
(
    ID BIGINT NOT NULL,
    ROLE VARCHAR(256) NOT NULL,
    USERS BIGINT NOT NULL
);

/* ------------- relation indexes ------------------ */
CREATE INDEX IDXUSERUSERROLE ON USER_ROLE
(
       USERS
);


/* ------------ primary key contraints ---------------- */
ALTER TABLE USER_ROLE
   ADD  ( CONSTRAINT XPKUSERROLE PRIMARY KEY (ID) );

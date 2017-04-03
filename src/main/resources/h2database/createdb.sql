CREATE TABLE IF NOT EXISTS UNIVERSITY
(
	ID INTEGER NOT NULL IDENTITY,
	TITLE            VARCHAR(50),
	OPT_LOCK_VERSION INTEGER,
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS STUDENT
(
	ID INTEGER NOT NULL IDENTITY,
	FIRST_NAME       VARCHAR(20) NOT NULL,
	LAST_NAME        VARCHAR(20),
	UNIVERSITY_ID    INTEGER,
	REGISTRATION_NO  VARCHAR(20),
	OPT_LOCK_VERSION INTEGER,
	PRIMARY KEY (ID),
	FOREIGN KEY (UNIVERSITY_ID) REFERENCES UNIVERSITY (ID)
);

CREATE TABLE IF NOT EXISTS COURSE
(
	ID INTEGER NOT NULL IDENTITY,
	NAME             VARCHAR(50),
	OPT_LOCK_VERSION INTEGER,
	PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS STUDENT_COURSE
(
	STUDENT_ID      INTEGER,
	COURSE_ID       INTEGER,
	PRIMARY KEY (STUDENT_ID, COURSE_ID),
	FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT (ID),
	FOREIGN KEY (COURSE_ID) REFERENCES COURSE (ID)
);

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 10000;


CREATE TABLE users
(
id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
name     VARCHAR NOT NULL,
login    VARCHAR NOT NULL,
password VARCHAR NOT NULL
);

CREATE UNIQUE INDEX users_unique_login_idx ON users(login);

CREATE TABLE user_roles
(
user_id INTEGER NOT NULL,
role VARCHAR NOT NULL,
CONSTRAINT user_roles_idx UNIQUE (user_id, role),
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE contacts
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER NOT NULL,
  lastName    TEXT NOT NULL,
  firstName   TEXT NOT NULL,
  middleName  TEXT NOT NULL,
  mobilePhone TEXT NOT NULL,
  homePhone   TEXT,
  address     TEXT,
  email       TEXT,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX contact_unique_idx ON contacts(user_id, id)
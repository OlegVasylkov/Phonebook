DELETE FROM user_roles;
DELETE FROM user;
ALTER SEQUENCE global_seq RESTART WITH 10000;

INSERT INTO users (name, login, password) VALUES
  ('Admin name', 'adminLogin', 'adminPassword'),
  ('User name', 'userLogin', 'userPassword');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 10000),
  ('ROLE_ADMIN', 10001);
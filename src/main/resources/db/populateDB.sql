DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM contacts;
ALTER SEQUENCE global_seq RESTART WITH 10000;

INSERT INTO users (name, login, password) VALUES
  ('Admin name', 'admin', 'root'),
  ('User name', 'user', 'password');

INSERT INTO contacts(user_id, lastname, firstname, middlename, mobilephone, homephone, address, email) VALUES
  (10001, 'Stivenson', 'Bob', 'Y', '+380987654321', '', '', ''),
  (10001, 'Bond', 'Mikle', 'L', '+380999999223', '', '', ''),
  (10000, 'Maas', 'Ryan', 'Z', '+380931234567', '', '', ''),
  (10000, 'Klim', 'Igor', 'V', '+380931299567', '', '', '');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 10000),
  ('ROLE_USER', 10001);
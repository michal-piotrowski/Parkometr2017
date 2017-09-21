DROP TABLE USERS;

CREATE TABLE USERS(
  id SERIAL,
  login VARCHAR(50) UNIQUE,
  password VARCHAR(64),
  role VARCHAR(10),
  area VARCHAR(64)
);


INSERT INTO USERS (login, password, role) VALUES ('main', 'DW5AeeNnA+vTfAByL1iR0osOKBHcEUsSkhUSOtzONgU=', 'Manager');
INSERT INTO USERS (login, password, role, area) VALUES ('WKeeper', 'DW5AeeNnA+vTfAByL1iR0osOKBHcEUsSkhUSOtzONgU=', 'User', 'GaleriaKrakowska');
INSERT INTO USERS (login, password, role, area) VALUES ('BKeeper', 'aIeH2P8UTFAsf1z/qv4sxYjYYHn53ogwTCawy5nOkcY=', 'User', 'AutoSave-Parking');

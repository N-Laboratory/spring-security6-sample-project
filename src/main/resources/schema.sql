DROP TABLE IF EXISTS role;

CREATE TABLE role(
    id INTEGER PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

DROP TABLE IF EXISTS login_user;

CREATE TABLE login_user(
    id INTEGER PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    role_id INTEGER NOT NULL,
    foreign key (role_id) references role(id)
);
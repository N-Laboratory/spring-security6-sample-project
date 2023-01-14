INSERT INTO role(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO role(id, name) VALUES(2, 'ROLE_GENERAL');

INSERT INTO login_user(id, name, email, password, role_id)
VALUES(1, 'admin', 'admin@admin.com', '$2a$10$3MvURFedOnkU6fQOKFRch.l3G7aLuyxpNlNAl7WhzVWOd5pRq39we', 1);

INSERT INTO login_user(id, name, email, password, role_id)
VALUES(2, 'general', 'general@general.com', '$2a$10$JrgiWw4wJ.3XXiwqcbCaDuIIDvAQOFHWhdgqRGYqGZf5UC9Ow3RaK', 2);
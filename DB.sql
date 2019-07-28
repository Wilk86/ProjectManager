create database taskmanager_db;

# utworzenie użytkownika

create user 'taskmanager'@'localhost' identified by 'sda';

# przypisanie uprawnień

grant SELECT, UPDATE, INSERT, DELETE, CREATE, ALTER on taskmanager_db.* to 'taskmanager'@'localhost';
# wielka litera
# Cyfra
# Specjalny

INSERT INTO taskmanager_db.role (role_id, role_name) VALUES ('1', 'ROLE_USER');
INSERT INTO taskmanager_db.role (role_id, role_name) VALUES ('2', 'ROLE_ADMIN');

CREATE TABLE users(
    id TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password TEXT NOT NULL,
    created_at DATE NOT NULL
);

CREATE TABLE authorities(
    id tinyint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    user_id TINYINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE projects(
    id TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    coordinator TINYINT NOT NULL,
    FOREIGN KEY (coordinator) REFERENCES users(id)
);

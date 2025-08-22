INSERT INTO users(username, password, created_at) VALUES ( 'Maria', '', '2024-10-30');
INSERT INTO users(username, password, created_at) VALUES ( 'Diana', '','2025-01-12');

INSERT INTO authorities(name, user_id) VALUES ( 'READ', 1);
INSERT INTO authorities(name, user_id) VALUES ('WRITE', 2);

INSERT INTO projects(name, coordinator) VALUES ('Germany',1);
INSERT INTO projects(name, coordinator) VALUES ('Spain',1);
INSERT INTO projects(name, coordinator) VALUES ('Norway',1);

INSERT INTO projects(name, coordinator) VALUES ('Netherlands',2);
INSERT INTO projects(name, coordinator) VALUES ('France',2);
INSERT INTO projects(name, coordinator) VALUES ('Hungary',2);




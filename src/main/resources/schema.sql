DROP TABLE IF EXISTS user;
	 
CREATE TABLE user (
id INT AUTO_INCREMENT  PRIMARY KEY,
first_name VARCHAR(250) NOT NULL,
last_name VARCHAR(250) NOT NULL,
user_name VARCHAR(250) NOT NULL,
password VARCHAR(250) NOT NULL,
role VARCHAR(250) NOT NULL
);
	 
INSERT INTO user (first_name, last_name, user_name, password, role ) VALUES
('Cristian', 'Jaldin', 'cjaldin','1234','ADMIN'),
('Juan', 'Perez', 'jperez','5678','BASIC'),
('Matias', 'Sanchez', 'msanchez','5378','BASIC'),
('Leo', 'Gonzales', 'lgonzales','6678','BASIC'),
('Maria', 'Cespedes', 'mcespedes','8678','ADMIN');
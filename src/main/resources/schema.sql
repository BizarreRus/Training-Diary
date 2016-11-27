DROP TABLE IF EXISTS training_exercise;
DROP TABLE IF EXISTS activity;
DROP TABLE IF EXISTS training;
DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS complex_exercise;
DROP TABLE IF EXISTS complex;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS muscle_group;

CREATE TABLE muscle_group (
  id           INT AUTO_INCREMENT PRIMARY KEY,
  muscle_group VARCHAR(20)
);

CREATE TABLE exercise (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  exercise VARCHAR(20) NOT NULL,
  group_id INT,
  FOREIGN KEY (group_id) REFERENCES muscle_group (id)
);

CREATE TABLE complex (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  complex VARCHAR(20) NOT NULL
);

CREATE TABLE complex_exercise (
  exercise_id INT,
  complex_id  INT,
  FOREIGN KEY (exercise_id) REFERENCES exercise (id),
  FOREIGN KEY (complex_id) REFERENCES complex (id)
);

CREATE TABLE user (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20),
  password VARCHAR(20)
);

CREATE TABLE training (
  id            INT PRIMARY KEY AUTO_INCREMENT,
  training_date DATE,
  user_id       INT,
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE training_exercise (
  training_id INT,
  exercise_id INT,
  FOREIGN KEY (training_id) REFERENCES training (id),
  FOREIGN KEY (exercise_id) REFERENCES exercise (id)
);

CREATE TABLE activity (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  exercise_id INT,
  training_id INT,
  reps        INT(2),
  weight      INT(3),
  FOREIGN KEY (exercise_id) REFERENCES exercise (id),
  FOREIGN KEY (training_id) REFERENCES training (id)
);
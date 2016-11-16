DROP TABLE IF EXISTS exercise_trainings;
DROP TABLE IF EXISTS trainings;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS muscle_groups;

CREATE TABLE muscle_groups (
  id      INT AUTO_INCREMENT PRIMARY KEY ,
  group_name VARCHAR(20)
);

CREATE TABLE exercises (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  exercise_name VARCHAR(20) NOT NULL,
  group_id INT,
  FOREIGN KEY (group_id) REFERENCES muscle_groups (id)
);

CREATE TABLE complexes (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  complex_name     VARCHAR(20) NOT NULL
);

CREATE TABLE complex_exercise (
  exercise_id INT,
  complex_id INT,
  FOREIGN KEY (exercise_id) REFERENCES exercises (id),
  FOREIGN KEY (complex_id) REFERENCES complexes (id)
);
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

CREATE TABLE trainings (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  training_name     VARCHAR(20) NOT NULL,
  sets         INT,
  reps         INT
);

CREATE TABLE exercise_trainings (
  exercise_id INT,
  training_id INT,
  FOREIGN KEY (exercise_id) REFERENCES exercises (id),
  FOREIGN KEY (training_id) REFERENCES trainings (id)
);
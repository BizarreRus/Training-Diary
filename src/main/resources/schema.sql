DROP TABLE IF EXISTS training_exercises;
DROP TABLE IF EXISTS trainings;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS muscle_groups;

CREATE TABLE muscle_groups (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  `group` VARCHAR(20)     DEFAULT 'Без группы'
);

CREATE TABLE exercises (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  exercise VARCHAR(20) NOT NULL,
  group_id INT,
  FOREIGN KEY (group_id) REFERENCES muscle_groups (group_id)
);

CREATE TABLE trainings (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  training     VARCHAR(20) NOT NULL,
#   training_day DATETIME    NOT NULL,
  sets         INT,
  reps         INT
);

CREATE TABLE exercise_trainings (
  exercise_id INT,
  training_id INT,
  FOREIGN KEY (exercise_id) REFERENCES exercises (id),
  FOREIGN KEY (training_id) REFERENCES trainings (id)
);
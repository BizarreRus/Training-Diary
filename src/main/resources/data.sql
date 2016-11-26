INSERT INTO
  muscle_group (muscle_group)
VALUES
  ('Default'),
  ('Chest'),
  ('Back'),
  ('Arms'),
  ('Legs');

INSERT INTO
  exercise (exercise, group_id)
VALUES
  ('Push Ups', 2),
  ('Pull Ups', 3),
  ('Squats', 5),
  ('Leg Curls', 5);

INSERT INTO
  complex (complex)
VALUES
  ('Block 1'),
  ('Block 2'),
  ('Block 3');

INSERT INTO
  complex_exercise (exercise_id, complex_id)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (1, 2),
  (2, 2);
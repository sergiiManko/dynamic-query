ALTER TABLE department
  ADD COLUMN unit VARCHAR(64);
UPDATE department
SET unit = 'default value'
WHERE id = 1;
UPDATE department
SET unit = 'not default value'
WHERE id = 2;
UPDATE department
SET unit = 'default value'
WHERE id = 3;
ALTER TABLE department
  ALTER COLUMN unit SET NOT NULL;

DROP TABLE IF EXISTS employee CASCADE;

CREATE TABLE employee
(
  id            BIGSERIAL,
  name          VARCHAR(64) NOT NULL,
  department_id BIGINT      NOT NULL,
  CONSTRAINT employee_pkey PRIMARY KEY (id)
);

INSERT INTO employee(name, department_id)
VALUES ('Ivan', (SELECT id FROM department WHERE department.code = 'DP001'));

INSERT INTO employee(name, department_id)
VALUES ('Ivan', (SELECT id FROM department WHERE department.code = 'DP002'));

INSERT INTO employee(name, department_id)
VALUES ('Ivan', (SELECT id FROM department WHERE department.code = 'DP001'));

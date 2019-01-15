DROP TABLE IF EXISTS department CASCADE;

CREATE TABLE department
(
  id   BIGSERIAL,
  code VARCHAR(64) NOT NULL,
  CONSTRAINT department_pkey PRIMARY KEY (id)
);

INSERT INTO department(code)
VALUES ('DP001');
INSERT INTO department(code)
VALUES ('DP002');
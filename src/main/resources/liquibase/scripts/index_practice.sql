-- liquibase formatted sql

-- changeset maxon4ik:1

CREATE INDEX student_name_index ON student (name);
CREATE INDEX faculty_nc_index ON faculty (name, color);


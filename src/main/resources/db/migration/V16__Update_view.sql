DROP VIEW `spm_assignment`.`detailed_grades_entry`;
CREATE VIEW `detailed_grades_entry` AS
SELECT * FROM `student` NATURAL JOIN `grades_entry` NATURAL JOIN `ccf_event`;
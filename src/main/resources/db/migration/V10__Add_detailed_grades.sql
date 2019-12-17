ALTER TABLE `spm_assignment`.`grades_entry`
    ADD COLUMN `grades_problem1` INT(11) NOT NULL DEFAULT 0 AFTER `is_approved`,
    ADD COLUMN `grades_problem2` INT(11) NOT NULL DEFAULT 0 AFTER `grades_problem1`,
    ADD COLUMN `grades_problem3` INT(11) NOT NULL DEFAULT 0 AFTER `grades_problem2`,
    ADD COLUMN `grades_problem4` INT(11) NOT NULL DEFAULT 0 AFTER `grades_problem3`,
    ADD COLUMN `grades_problem5` INT(11) NOT NULL DEFAULT 0 AFTER `grades_problem4`,
    CHANGE COLUMN `grades` `grades` INT(11) NOT NULL DEFAULT (grades_problem1 + grades_problem2 + grades_problem3 + grades_problem4 + grades_problem5) ;

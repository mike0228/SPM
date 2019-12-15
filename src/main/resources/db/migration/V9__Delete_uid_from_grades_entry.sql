ALTER TABLE `spm_assignment`.`grades_entry`
    DROP FOREIGN KEY `ge_uid`;
ALTER TABLE `spm_assignment`.`grades_entry`
    DROP COLUMN `uid`,
    DROP INDEX `ge_uid_idx` ;
;

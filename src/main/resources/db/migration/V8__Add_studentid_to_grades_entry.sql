ALTER TABLE `spm_assignment`.`grades_entry`
    DROP FOREIGN KEY `ge_eid`;
ALTER TABLE `spm_assignment`.`grades_entry`
    ADD COLUMN `student_id` VARCHAR(45) NOT NULL AFTER `uid`,
    DROP INDEX `ge_uid_idx` ,
    ADD INDEX `ge_uid_idx` (`uid` ASC) INVISIBLE,
    DROP INDEX  `UNIQUE`,
    ADD INDEX `UNIQUE` (`uid` ASC, `eid` ASC, `student_id` ASC) INVISIBLE,
    ADD INDEX `ge_eid_idx` (`eid` ASC) VISIBLE;
;
ALTER TABLE `spm_assignment`.`grades_entry`
    ADD CONSTRAINT `ge_eid`
        FOREIGN KEY (`eid`)
            REFERENCES `spm_assignment`.`ccf_event` (`eid`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

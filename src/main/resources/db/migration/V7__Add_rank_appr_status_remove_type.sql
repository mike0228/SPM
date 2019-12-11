CREATE TABLE `spm_assignment`.`select_rank_entry` (
          `reid` INT NOT NULL AUTO_INCREMENT,
          `uid` INT,
          `rank` INT NOT NULL,
          `eid` INT NOT NULL,
          PRIMARY KEY (`reid`),
          UNIQUE INDEX `UNIQUE` (`uid` ASC, `eid` ASC) VISIBLE,
          INDEX `re_eid_idx` (`eid` ASC) VISIBLE,
          CONSTRAINT `re_uid`
              FOREIGN KEY (`uid`)
                  REFERENCES `spm_assignment`.`user` (`uid`)
                  ON DELETE SET NULL
                  ON UPDATE CASCADE,
          CONSTRAINT `re_eid`
              FOREIGN KEY (`eid`)
                  REFERENCES `spm_assignment`.`ccf_event` (`eid`)
                  ON DELETE CASCADE
                  ON UPDATE CASCADE);
ALTER TABLE `spm_assignment`.`grades_entry`
    DROP COLUMN `type`,
    ADD COLUMN `is_approved` TINYINT NOT NULL DEFAULT 1 AFTER `max_grades`;

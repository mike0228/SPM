ALTER TABLE `spm_assignment`.`application`
    CHANGE COLUMN `app_time` `app_time` DATETIME NOT NULL ;
ALTER TABLE `spm_assignment`.`select_rank_entry`
    DROP FOREIGN KEY `re_uid`;
ALTER TABLE `spm_assignment`.`select_rank_entry`
    CHANGE COLUMN `uid` `uid` INT(11) NOT NULL ;
ALTER TABLE `spm_assignment`.`select_rank_entry`
    ADD CONSTRAINT `re_uid`
        FOREIGN KEY (`uid`)
            REFERENCES `spm_assignment`.`user` (`uid`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

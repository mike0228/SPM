ALTER TABLE `spm_assignment`.`grades_entry`
    CHANGE COLUMN `type` `type` ENUM('select', 'official', 'pending') NOT NULL ;
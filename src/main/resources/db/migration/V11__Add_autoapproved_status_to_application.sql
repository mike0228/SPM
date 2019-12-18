ALTER TABLE `spm_assignment`.`application`
    CHANGE COLUMN `app_status` `app_status` ENUM('not confirmed', 'pending', 'auto-approved', 'approved', 'manually-approved', 'failed') NOT NULL DEFAULT 'pending' ;
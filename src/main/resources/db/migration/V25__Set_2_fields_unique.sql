ALTER TABLE `spm_assignment`.`application`
    ADD UNIQUE INDEX `app_unique` (`uid` ASC, `eid` ASC) VISIBLE;
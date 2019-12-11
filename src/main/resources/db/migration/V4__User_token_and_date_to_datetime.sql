CREATE TABLE `spm_assignment`.`user_token` (
   `session_id` INT NOT NULL AUTO_INCREMENT,
   `token` VARCHAR(45) NOT NULL,
   `uid` INT NOT NULL,
   `expires` DATETIME NULL,
   PRIMARY KEY (`session_id`),
   INDEX `ut_uid_idx` (`uid` ASC) VISIBLE,
   CONSTRAINT `ut_uid`
       FOREIGN KEY (`uid`)
           REFERENCES `spm_assignment`.`user` (`uid`)
           ON DELETE CASCADE
           ON UPDATE CASCADE);

ALTER TABLE `spm_assignment`.`ccf_event`
    CHANGE COLUMN `exam_time` `exam_time` DATETIME NOT NULL ,
    CHANGE COLUMN `select_exam_time` `select_exam_time` DATETIME NOT NULL ,
    CHANGE COLUMN `appli_deadline` `appli_deadline` DATETIME NOT NULL ;

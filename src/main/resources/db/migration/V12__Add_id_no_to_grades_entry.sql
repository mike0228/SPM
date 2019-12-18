ALTER TABLE `grades_entry`
ADD COLUMN `id_no`  varchar(45) NULL AFTER `student_id`,
DROP INDEX `UNIQUE` ,
ADD INDEX `UNIQUE` (`eid`, `student_id`, `id_no`) USING BTREE ;
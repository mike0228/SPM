ALTER TABLE `spm_assignment`.`select_rank_entry`
    ADD COLUMN `id_no` VARCHAR(45) NOT NULL AFTER `eid`;

CREATE VIEW `detailed_select_rank` AS
SELECT
    `spm_assignment`.`select_rank_entry`.`eid` AS `eid`,
    `spm_assignment`.`student`.`student_id` AS `student_id`,
    (CASE
         WHEN (`spm_assignment`.`student`.`id_no` IS NOT NULL) THEN `spm_assignment`.`student`.`id_no`
         ELSE `spm_assignment`.`select_rank_entry`.`id_no`
        END) AS `id_no`,
    `spm_assignment`.`student`.`uid` AS `uid`,
    `spm_assignment`.`student`.`name` AS `name`,
    `spm_assignment`.`student`.`gender` AS `gender`,
    `spm_assignment`.`student`.`ethnic_group` AS `ethnic_group`,
    `spm_assignment`.`student`.`admission_year` AS `admission_year`,
    `spm_assignment`.`student`.`institute` AS `institute`,
    `spm_assignment`.`student`.`profession` AS `profession`,
    `spm_assignment`.`student`.`class_no` AS `class_no`,
    `spm_assignment`.`student`.`phone_no` AS `phone_no`,
    `spm_assignment`.`select_rank_entry`.`reid` AS `reid`,
    `spm_assignment`.`select_rank_entry`.`rank_no` AS `rank_no`,
    `spm_assignment`.`ccf_event`.`exam_no` AS `exam_no`,
    `spm_assignment`.`ccf_event`.`exam_time` AS `exam_time`
FROM
    ((`spm_assignment`.`select_rank_entry`
        LEFT JOIN `spm_assignment`.`student` ON (((`spm_assignment`.`select_rank_entry`.`id_no` = `spm_assignment`.`student`.`id_no`))))
        JOIN `spm_assignment`.`ccf_event` ON ((`spm_assignment`.`select_rank_entry`.`eid` = `spm_assignment`.`ccf_event`.`eid`)));
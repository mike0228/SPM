CREATE
    OR REPLACE
    VIEW `spm_assignment`.`detailed_grades_entry` AS
SELECT
    `spm_assignment`.`grades_entry`.`eid` AS `eid`,
    `spm_assignment`.`student`.`student_id` AS `student_id`,
    `spm_assignment`.`student`.`id_no` AS `id_no`,
    `spm_assignment`.`student`.`uid` AS `uid`,
    `spm_assignment`.`student`.`name` AS `name`,
    `spm_assignment`.`student`.`gender` AS `gender`,
    `spm_assignment`.`student`.`ethnic_group` AS `ethnic_group`,
    `spm_assignment`.`student`.`admission_year` AS `admission_year`,
    `spm_assignment`.`student`.`institute` AS `institute`,
    `spm_assignment`.`student`.`profession` AS `profession`,
    `spm_assignment`.`student`.`class_no` AS `class_no`,
    `spm_assignment`.`student`.`phone_no` AS `phone_no`,
    `spm_assignment`.`grades_entry`.`gid` AS `gid`,
    `spm_assignment`.`grades_entry`.`grades` AS `grades`,
    `spm_assignment`.`grades_entry`.`max_grades` AS `max_grades`,
    `spm_assignment`.`grades_entry`.`is_approved` AS `is_approved`,
    `spm_assignment`.`grades_entry`.`grades_problem1` AS `grades_problem1`,
    `spm_assignment`.`grades_entry`.`grades_problem2` AS `grades_problem2`,
    `spm_assignment`.`grades_entry`.`grades_problem3` AS `grades_problem3`,
    `spm_assignment`.`grades_entry`.`grades_problem4` AS `grades_problem4`,
    `spm_assignment`.`grades_entry`.`grades_problem5` AS `grades_problem5`,
    `spm_assignment`.`ccf_event`.`exam_no` AS `exam_no`,
    `spm_assignment`.`ccf_event`.`exam_time` AS `exam_time`
FROM
    ((`spm_assignment`.`student`
        JOIN `spm_assignment`.`grades_entry` ON (((`spm_assignment`.`student`.`student_id` = `spm_assignment`.`grades_entry`.`student_id`)
            OR (`spm_assignment`.`student`.`id_no` = `spm_assignment`.`grades_entry`.`id_no`))))
        JOIN `spm_assignment`.`ccf_event` ON ((`spm_assignment`.`grades_entry`.`eid` = `spm_assignment`.`ccf_event`.`eid`)));

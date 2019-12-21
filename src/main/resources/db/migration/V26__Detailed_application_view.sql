CREATE OR REPLACE
    VIEW `spm_assignment`.`detailed_application` AS
SELECT
    `spm_assignment`.`application`.`eid` AS `eid`,
    `spm_assignment`.`application`.`uid` AS `uid`,
    `spm_assignment`.`application`.`aid` AS `aid`,
    `spm_assignment`.`application`.`app_time` AS `app_time`,
    `spm_assignment`.`application`.`app_status` AS `app_status`,
    `spm_assignment`.`student`.`name` AS `name`,
    `spm_assignment`.`student`.`student_id` AS `student_id`,
    `spm_assignment`.`student`.`gender` AS `gender`,
    `spm_assignment`.`student`.`id_no` AS `id_no`,
    `spm_assignment`.`student`.`ethnic_group` AS `ethnic_group`,
    `spm_assignment`.`student`.`admission_year` AS `admission_year`,
    `spm_assignment`.`student`.`institute` AS `institute`,
    `spm_assignment`.`student`.`profession` AS `profession`,
    `spm_assignment`.`student`.`class_no` AS `class_no`,
    `spm_assignment`.`student`.`phone_no` AS `phone_no`,
    `spm_assignment`.`ccf_event`.`exam_no` AS `exam_no`,
    `spm_assignment`.`ccf_event`.`exam_time` AS `exam_time`,
    `spm_assignment`.`ccf_event`.`select_exam_time` AS `select_exam_time`,
    `spm_assignment`.`ccf_event`.`appli_deadline` AS `appli_deadline`,
    `spm_assignment`.`ccf_event`.`can_apply` AS `can_apply`,
    `spm_assignment`.`ccf_event`.`appli_starts_on` AS `appli_starts_on`
FROM
    ((`spm_assignment`.`application`
        JOIN `spm_assignment`.`student` ON ((`spm_assignment`.`application`.`uid` = `spm_assignment`.`student`.`uid`)))
        JOIN `spm_assignment`.`ccf_event` ON ((`spm_assignment`.`application`.`eid` = `spm_assignment`.`ccf_event`.`eid`)))
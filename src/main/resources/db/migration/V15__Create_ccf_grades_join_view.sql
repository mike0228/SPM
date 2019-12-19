CREATE
    VIEW `spm_assignment`.`detailed_grades_entry` AS
SELECT
    `spm_assignment`.`ccf_event`.`eid` AS `eid`,
    `spm_assignment`.`ccf_event`.`exam_no` AS `exam_no`,
    `spm_assignment`.`ccf_event`.`exam_time` AS `exam_time`,
    `spm_assignment`.`ccf_event`.`select_exam_time` AS `select_exam_time`,
    `spm_assignment`.`ccf_event`.`appli_deadline` AS `appli_deadline`,
    `spm_assignment`.`ccf_event`.`can_apply` AS `can_apply`,
    `spm_assignment`.`ccf_event`.`appli_starts_on` AS `appli_starts_on`,
    `spm_assignment`.`grades_entry`.`gid` AS `gid`,
    `spm_assignment`.`grades_entry`.`grades` AS `grades`,
    `spm_assignment`.`grades_entry`.`student_id` AS `student_id`,
    `spm_assignment`.`grades_entry`.`id_no` AS `id_no`,
    `spm_assignment`.`grades_entry`.`max_grades` AS `max_grades`,
    `spm_assignment`.`grades_entry`.`is_approved` AS `is_approved`,
    `spm_assignment`.`grades_entry`.`grades_problem1` AS `grades_problem1`,
    `spm_assignment`.`grades_entry`.`grades_problem2` AS `grades_problem2`,
    `spm_assignment`.`grades_entry`.`grades_problem3` AS `grades_problem3`,
    `spm_assignment`.`grades_entry`.`grades_problem4` AS `grades_problem4`,
    `spm_assignment`.`grades_entry`.`grades_problem5` AS `grades_problem5`
FROM
    (`spm_assignment`.`ccf_event`
        JOIN `spm_assignment`.`grades_entry` ON ((`spm_assignment`.`ccf_event`.`eid` = `spm_assignment`.`grades_entry`.`eid`)));
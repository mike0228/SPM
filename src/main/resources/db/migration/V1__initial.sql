-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 
-- サーバのバージョン： 8.0.15
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spm_assignment`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `application`
--

CREATE TABLE `application` (
  `aid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `app_time` date NOT NULL,
  `app_status` enum('not confirmed','pending','approved','failed') NOT NULL DEFAULT 'pending',
  `eid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- テーブルの構造 `ccf_event`
--

CREATE TABLE `ccf_event` (
  `eid` int(11) NOT NULL,
  `exam_no` int(11) NOT NULL,
  `exam_time` date NOT NULL,
  `select_exam_time` date NOT NULL,
  `appli_deadline` date NOT NULL,
  `can_apply` tinyint(4) NOT NULL DEFAULT '0',
  `appli_starts_on` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- テーブルの構造 `global_parameters`
--

CREATE TABLE `global_parameters` (
  `key` varchar(255) NOT NULL,
  `value` varchar(511) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- テーブルのデータのダンプ `global_parameters`
--

INSERT INTO `global_parameters` (`key`, `value`) VALUES
('max_sponsored_participants', '150'),
('midgrades_for_autoapprove', '300');

-- --------------------------------------------------------

--
-- テーブルの構造 `grades_entry`
--

CREATE TABLE `grades_entry` (
  `gid` int(11) NOT NULL,
  `type` enum('select','official') NOT NULL,
  `grades` int(11) NOT NULL,
  `eid` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `max_grades` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- テーブルの構造 `student`
--

CREATE TABLE `student` (
  `uid` int(11) DEFAULT NULL,
  `student_id` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `id_no` varchar(45) NOT NULL,
  `ethnic_group` varchar(45) DEFAULT NULL,
  `admission_year` int(11) NOT NULL,
  `institute` varchar(45) NOT NULL,
  `profession` varchar(45) NOT NULL,
  `class` varchar(45) NOT NULL,
  `phone_no` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- テーブルの構造 `teacher`
--

CREATE TABLE `teacher` (
  `uid` int(11) NOT NULL,
  `work_id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- テーブルの構造 `user`
--

CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` enum('student','teacher','associate') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`aid`),
  ADD KEY `a_uid_idx` (`uid`),
  ADD KEY `a_eid_idx` (`eid`);

--
-- Indexes for table `ccf_event`
--
ALTER TABLE `ccf_event`
  ADD PRIMARY KEY (`eid`),
  ADD UNIQUE KEY `ce_unique` (`exam_no`);

--
-- Indexes for table `global_parameters`
--
ALTER TABLE `global_parameters`
  ADD PRIMARY KEY (`key`);

--
-- Indexes for table `grades_entry`
--
ALTER TABLE `grades_entry`
  ADD PRIMARY KEY (`gid`),
  ADD UNIQUE KEY `UNIQUE` (`eid`,`uid`,`type`),
  ADD KEY `ge_uid_idx` (`uid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD UNIQUE KEY `student_id_UNIQUE` (`student_id`),
  ADD KEY `s_uid_idx` (`uid`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `account` (`account`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ccf_event`
--
ALTER TABLE `ccf_event`
  MODIFY `eid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grades_entry`
--
ALTER TABLE `grades_entry`
  MODIFY `gid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT;

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `a_eid` FOREIGN KEY (`eid`) REFERENCES `ccf_event` (`eid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `a_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- テーブルの制約 `grades_entry`
--
ALTER TABLE `grades_entry`
  ADD CONSTRAINT `ge_eid` FOREIGN KEY (`eid`) REFERENCES `ccf_event` (`eid`),
  ADD CONSTRAINT `ge_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- テーブルの制約 `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `s_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- テーブルの制約 `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `t_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2014 at 05:39 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `deteksi_anomali_knn`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_testing`
--

CREATE TABLE IF NOT EXISTS `data_testing` (
  `NIS` int(11) DEFAULT NULL,
  `rata2Raport` float DEFAULT NULL,
  `TestPsikologi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_testing`
--

INSERT INTO `data_testing` (`NIS`, `rata2Raport`, `TestPsikologi`) VALUES
(501, 79, 109),
(753, 79, 120),
(193, 138, 234),
(213, 86, 150),
(555, 150, 300),
(175, 75, 400),
(913, 98, 115),
(333, 76, 115),
(888, 89, 131),
(151, 70, 104),
(874, 87, 127),
(152, 87, 109),
(900, 76.9, 150),
(576, 86, 156),
(277, 125, 139),
(995, 88.2, 120),
(774, 89, 106),
(656, 72.9, 202),
(315, 110, 120),
(714, 89, 231),
(966, 102, 351),
(387, 99, 102),
(5656, 87, 130),
(444, 89, 112),
(877, 140, 260),
(746, 68, 98),
(412, 78, 123),
(821, 67, 83),
(831, 77, 111),
(988, 81, 125),
(661, 75, 300),
(664, 129, 130),
(772, 83, 132),
(881, 74, 300),
(474, 130, 97),
(1667, 101, 132),
(700, 83, 123);

-- --------------------------------------------------------

--
-- Table structure for table `data_training`
--

CREATE TABLE IF NOT EXISTS `data_training` (
  `NIS` int(10) NOT NULL,
  `rata2Raport` float NOT NULL,
  `TestPsikologi` int(3) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  PRIMARY KEY (`NIS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_training`
--

INSERT INTO `data_training` (`NIS`, `rata2Raport`, `TestPsikologi`, `kelas`) VALUES
(7275, 87.2, 234, 'IPA'),
(7346, 78.85, 111, 'IPS'),
(7351, 81.2, 125, 'IPS'),
(7355, 97.2, 29, 'IPS'),
(7367, 87.2, 232, 'IPA'),
(7370, 81, 127, 'IPS'),
(7375, 89.3, 241, 'IPA'),
(7376, 81.95, 128, 'IPS'),
(7385, 87.9, 212, 'IPA'),
(7398, 86.2, 210, 'IPA'),
(7399, 83, 125, 'IPA'),
(7400, 81.75, 130, 'IPS'),
(7402, 81.4, 131, 'IPS'),
(7419, 82.15, 132, 'IPA'),
(7423, 81.6, 143, 'IPS'),
(7424, 82.45, 132, 'IPA'),
(7430, 87.1, 123, 'IPA'),
(7443, 84.3, 143, 'IPA'),
(7446, 84.25, 127, 'IPA'),
(7450, 84.9, 128, 'IPA'),
(7451, 83.5, 129, 'IPA'),
(7453, 76.2, 43, 'IPS'),
(7460, 82.85, 130, 'IPA'),
(7462, 93.9, 221, 'IPA'),
(7470, 83.75, 131, 'IPA'),
(7480, 84.55, 134, 'IPA'),
(7492, 75.2, 243, 'IPA'),
(7498, 87.3, 190, 'IPA'),
(7519, 79.75, 95, 'IPS'),
(7531, 80.45, 134, 'IPS'),
(7534, 80.2, 135, 'IPS'),
(7541, 86.15, 136, 'IPA'),
(7552, 94.5, 200, 'IPA'),
(7555, 77.15, 110, 'IPS'),
(7558, 81.7, 145, 'IPS'),
(7562, 80.65, 140, 'IPS'),
(7577, 82.35, 141, 'IPA'),
(7585, 82.65, 142, 'IPA'),
(7586, 81.85, 143, 'IPS'),
(7592, 88.5, 213, 'IPA'),
(7594, 85.2, 241, 'IPA'),
(7600, 80.95, 143, 'IPS'),
(7606, 81.95, 144, 'IPS'),
(7607, 82.2, 145, 'IPA'),
(7614, 82.5, 146, 'IPA'),
(7628, 82.85, 150, 'IPA'),
(7634, 84.1, 15, 'IPS'),
(7638, 86.8, 151, 'IPA'),
(7643, 81.1, 152, 'IPS'),
(7662, 76.2, 270, 'IPA'),
(7831, 87.2, 254, 'IPA');

-- --------------------------------------------------------

--
-- Table structure for table `temporari`
--

CREATE TABLE IF NOT EXISTS `temporari` (
  `NIS` int(10) NOT NULL,
  `rata2Raport` float NOT NULL,
  `psikologi` int(11) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `jarak` float NOT NULL,
  `deteksi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temporari`
--

INSERT INTO `temporari` (`NIS`, `rata2Raport`, `psikologi`, `kelas`, `jarak`, `deteksi`) VALUES
(7275, 87.2, 234, 'IPA', 58.8544, 'Anomali'),
(7346, 78.85, 111, 'IPS', 161.06, 'Anomali'),
(7351, 81.2, 125, 'IPS', 147.25, 'Anomali'),
(7355, 97.2, 29, 'IPS', 234.932, 'Anomali'),
(7367, 87.2, 232, 'IPA', 59.7649, 'Anomali'),
(7370, 81, 127, 'IPS', 145.499, 'Anomali'),
(7375, 89.3, 241, 'IPA', 54.1432, 'Anomali'),
(7376, 81.95, 128, 'IPS', 144.201, 'Anomali'),
(7385, 87.9, 212, 'IPA', 70.8407, 'Anomali'),
(7398, 86.2, 210, 'IPA', 73.4469, 'Anomali'),
(7399, 83, 125, 'IPA', 146.54, 'Anomali'),
(7400, 81.75, 130, 'IPS', 142.454, 'Anomali'),
(7402, 81.4, 131, 'IPS', 141.686, 'Anomali'),
(7419, 82.15, 132, 'IPA', 140.466, 'Anomali'),
(7423, 81.6, 143, 'IPS', 130.765, 'Anomali'),
(7424, 82.45, 132, 'IPA', 140.342, 'Anomali'),
(7430, 87.1, 123, 'IPA', 146.858, 'Anomali'),
(7443, 84.3, 143, 'IPA', 129.582, 'Anomali'),
(7446, 84.25, 127, 'IPA', 144.212, 'Anomali'),
(7450, 84.9, 128, 'IPA', 143.038, 'Anomali'),
(7451, 83.5, 129, 'IPA', 142.665, 'Anomali'),
(7453, 76.2, 43, 'IPS', 226.185, 'Anomali'),
(7460, 82.85, 130, 'IPA', 142.007, 'Anomali'),
(7462, 93.9, 221, 'IPA', 60.3839, 'Anomali'),
(7470, 83.75, 131, 'IPA', 140.73, 'Anomali'),
(7480, 84.55, 134, 'IPA', 137.662, 'Anomali'),
(7492, 75.2, 243, 'IPA', 66.9928, 'Anomali'),
(7498, 87.3, 190, 'IPA', 87.6201, 'Anomali'),
(7519, 79.75, 95, 'IPS', 175.656, 'Anomali'),
(7531, 80.45, 134, 'IPS', 139.364, 'Anomali'),
(7534, 80.2, 135, 'IPS', 138.568, 'Anomali'),
(7541, 86.15, 136, 'IPA', 135.188, 'Anomali'),
(7552, 94.5, 200, 'IPA', 75.3011, 'Anomali'),
(7555, 77.15, 110, 'IPS', 162.635, 'Anomali'),
(7558, 81.7, 145, 'IPS', 128.934, 'Anomali'),
(7562, 80.65, 140, 'IPS', 133.875, 'Anomali'),
(7577, 82.35, 141, 'IPA', 132.229, 'Anomali'),
(7585, 82.65, 142, 'IPA', 131.198, 'Anomali'),
(7586, 81.85, 143, 'IPS', 130.654, 'Anomali'),
(7592, 88.5, 213, 'IPA', 69.7227, 'Anomali'),
(7594, 85.2, 241, 'IPA', 58.0003, 'Anomali'),
(7600, 80.95, 143, 'IPS', 131.057, 'Anomali'),
(7606, 81.95, 144, 'IPS', 129.714, 'Anomali'),
(7607, 82.2, 145, 'IPA', 128.708, 'Anomali'),
(7614, 82.5, 146, 'IPA', 127.68, 'Anomali'),
(7628, 82.85, 150, 'IPA', 123.96, 'Anomali'),
(7634, 84.1, 15, 'IPS', 251.296, 'Anomali'),
(7638, 86.8, 151, 'IPA', 121.29, 'Anomali'),
(7643, 81.1, 152, 'IPS', 123.017, 'Anomali'),
(7662, 76.2, 270, 'IPA', 64.5789, 'Anomali'),
(7831, 87.2, 254, 'IPA', 53.1398, 'Anomali');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2023 at 08:33 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vaccination`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(123) NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`) VALUES
(1, 'aditya@gmail.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

CREATE TABLE `animal` (
  `aid` int(11) NOT NULL,
  `cname` varchar(11) NOT NULL,
  `cnumber` int(11) NOT NULL,
  `caddress` varchar(11) NOT NULL,
  `aspecie` varchar(11) NOT NULL,
  `abreed` varchar(11) NOT NULL,
  `age` int(11) NOT NULL,
  `vtype` varchar(11) NOT NULL,
  `date` date NOT NULL,
  `hname` varchar(11) NOT NULL,
  `campname` varchar(11) NOT NULL,
  `status` varchar(123) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `animal`
--

INSERT INTO `animal` (`aid`, `cname`, `cnumber`, `caddress`, `aspecie`, `abreed`, `age`, `vtype`, `date`, `hname`, `campname`, `status`) VALUES
(4, 'aditya', 6776, 'parola', 'Baffalow', 'girbaffalow', 3, 'LSD', '2023-07-21', 'Sanjivani', 'camp4', 'Approved');

-- --------------------------------------------------------

--
-- Table structure for table `camp`
--

CREATE TABLE `camp` (
  `id` int(123) NOT NULL,
  `name` varchar(123) NOT NULL,
  `address` varchar(123) NOT NULL,
  `Status` varchar(123) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `camp`
--

INSERT INTO `camp` (`id`, `name`, `address`, `Status`) VALUES
(1, 'camp1', 'dhule', 'Pending'),
(4, 'camp4', 'nandurbar', 'Approved'),
(5, 'cap a1', 'shirpur', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hid` int(123) NOT NULL,
  `name` varchar(256) NOT NULL,
  `address` varchar(256) NOT NULL,
  `contact` varchar(123) NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(123) NOT NULL,
  `status` varchar(123) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`hid`, `name`, `address`, `contact`, `email`, `password`, `status`) VALUES
(5, 'sanjivani', 'Dhule', '2567', 'sanjivani@gmail.com', 'jio', 'Approved'),
(6, 'Devare ', 'shirpur', '2345', 'aditya2663@gmail.com', 'aditya', 'Approved'),
(7, 'Vishakha', 'Shahada', '7898567678', 'vishh@gmail.com', 'vishakha', 'Approved'),
(8, 'Patanjali', 'jalgaon', '2556', 'patanjali@gmail.com', 'patajali', 'Approved');

-- --------------------------------------------------------

--
-- Table structure for table `qna`
--

CREATE TABLE `qna` (
  `srno` int(123) NOT NULL,
  `question` varchar(1000) NOT NULL,
  `answer` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `qna`
--

INSERT INTO `qna` (`srno`, `question`, `answer`) VALUES
(1, 'Can we give vaccine to the dog? ', 'asd'),
(2, 'How many vaccines are available in  1 camp?', ''),
(3, 'How many Vaccines are available in one camp?', 'Here are two types of vaccines are available in camp.'),
(4, 'Could we feed Lsdv to dogs ?', 'No you cant give it to the dogs.'),
(5, 'how many types of vaccines are available for cow', 'two types are available.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uid` int(123) NOT NULL,
  `name` varchar(256) NOT NULL,
  `address` varchar(256) NOT NULL,
  `contact` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(123) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `name`, `address`, `contact`, `email`, `password`) VALUES
(1, 'lalit', 'dahivad', '9834651243', 'bhavesh@gmail.com', 'user'),
(2, 'adi', 'parola', '7654235432', 'aditya22@gmail.com', 'admin'),
(3, 'aditty', 'parola', '7654235432', 'aditya22@gmail.com', 'adm'),
(4, 'neha', 'pune', '9322733698', 'neha@gmail.com', 'neha'),
(5, 'Neha', 'pune', '9322743524', 'neha@gmail.com', 'neha');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `camp`
--
ALTER TABLE `camp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hid`);

--
-- Indexes for table `qna`
--
ALTER TABLE `qna`
  ADD PRIMARY KEY (`srno`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `camp`
--
ALTER TABLE `camp`
  MODIFY `id` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hid` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `qna`
--
ALTER TABLE `qna`
  MODIFY `srno` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(123) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

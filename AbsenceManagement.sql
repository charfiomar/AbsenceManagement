-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 23 Mai 2018 à 23:56
-- Version du serveur :  5.7.22-0ubuntu0.16.04.1
-- Version de PHP :  7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `AbsenceManagement`
--

-- --------------------------------------------------------

--
-- Structure de la table `Classroom`
--

CREATE TABLE `Classroom` (
  `crid` int(11) NOT NULL,
  `crname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Classroom`
--

INSERT INTO `Classroom` (`crid`, `crname`) VALUES
(1, 'SC1'),
(2, 'SC2');

-- --------------------------------------------------------

--
-- Structure de la table `CourseSession`
--

CREATE TABLE `CourseSession` (
  `pid` int(11) NOT NULL,
  `gid` int(11) NOT NULL,
  `crid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `subid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Groups`
--

CREATE TABLE `Groups` (
  `gid` int(11) NOT NULL,
  `gnumber` int(11) NOT NULL,
  `gyear` int(11) NOT NULL,
  `gmail` varchar(50) NOT NULL,
  `spid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Groups`
--

INSERT INTO `Groups` (`gid`, `gnumber`, `gyear`, `gmail`, `spid`) VALUES
(1, 1, 1, 'g-procedes-I-g1@institut.com', 2),
(2, 1, 2, 'g-informatique-II-g1@institut.com', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Professor`
--

CREATE TABLE `Professor` (
  `pid` int(11) NOT NULL,
  `pfname` varchar(30) NOT NULL,
  `plname` varchar(30) NOT NULL,
  `pmail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Professor`
--

INSERT INTO `Professor` (`pid`, `pfname`, `plname`, `pmail`) VALUES
(1, 'SAID', 'TAKTAK', 'said.taktak@institut.com'),
(2, 'MOHAMED', 'ALOUI', 'mohamed.aloui@institut.com');

-- --------------------------------------------------------

--
-- Structure de la table `Session`
--

CREATE TABLE `Session` (
  `sid` int(11) NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `day` varchar(10) NOT NULL DEFAULT 'Monday'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Session`
--

INSERT INTO `Session` (`sid`, `startTime`, `endTime`, `day`) VALUES
(1, '08:15:00', '09:45:00', 'Monday');

-- --------------------------------------------------------

--
-- Structure de la table `Speciality`
--

CREATE TABLE `Speciality` (
  `spid` int(11) NOT NULL,
  `spname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Speciality`
--

INSERT INTO `Speciality` (`spid`, `spname`) VALUES
(1, 'GENIE INFORMATIQUE'),
(2, 'GENIE DES PROCEDES');

-- --------------------------------------------------------

--
-- Structure de la table `Subject`
--

CREATE TABLE `Subject` (
  `subid` int(11) NOT NULL,
  `subname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Subject`
--

INSERT INTO `Subject` (`subid`, `subname`) VALUES
(1, 'PROGRAMMATION ORIENTEE OBJET'),
(2, 'MECANIQUE DES FLUIDES');

-- --------------------------------------------------------

--
-- Structure de la table `WeekDay`
--

CREATE TABLE `WeekDay` (
  `day` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `WeekDay`
--

INSERT INTO `WeekDay` (`day`) VALUES
('Friday'),
('Monday'),
('Saturday'),
('Thursday'),
('Tuesday'),
('Wednesday');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Classroom`
--
ALTER TABLE `Classroom`
  ADD PRIMARY KEY (`crid`);

--
-- Index pour la table `CourseSession`
--
ALTER TABLE `CourseSession`
  ADD PRIMARY KEY (`pid`,`gid`,`crid`,`sid`),
  ADD UNIQUE KEY `unq_course_session_ps` (`pid`,`sid`),
  ADD UNIQUE KEY `unq_course_session_gs` (`gid`,`sid`),
  ADD UNIQUE KEY `unq_course_session_cs` (`crid`,`sid`),
  ADD KEY `sid` (`sid`),
  ADD KEY `subid` (`subid`);

--
-- Index pour la table `Groups`
--
ALTER TABLE `Groups`
  ADD PRIMARY KEY (`gid`),
  ADD KEY `spid_index` (`spid`);

--
-- Index pour la table `Professor`
--
ALTER TABLE `Professor`
  ADD PRIMARY KEY (`pid`);

--
-- Index pour la table `Session`
--
ALTER TABLE `Session`
  ADD PRIMARY KEY (`sid`),
  ADD KEY `day` (`day`);

--
-- Index pour la table `Speciality`
--
ALTER TABLE `Speciality`
  ADD PRIMARY KEY (`spid`);

--
-- Index pour la table `Subject`
--
ALTER TABLE `Subject`
  ADD PRIMARY KEY (`subid`);

--
-- Index pour la table `WeekDay`
--
ALTER TABLE `WeekDay`
  ADD PRIMARY KEY (`day`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Classroom`
--
ALTER TABLE `Classroom`
  MODIFY `crid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Groups`
--
ALTER TABLE `Groups`
  MODIFY `gid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Professor`
--
ALTER TABLE `Professor`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Session`
--
ALTER TABLE `Session`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Speciality`
--
ALTER TABLE `Speciality`
  MODIFY `spid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Subject`
--
ALTER TABLE `Subject`
  MODIFY `subid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `CourseSession`
--
ALTER TABLE `CourseSession`
  ADD CONSTRAINT `CourseSession_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `Professor` (`pid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CourseSession_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `Groups` (`gid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CourseSession_ibfk_3` FOREIGN KEY (`crid`) REFERENCES `Classroom` (`crid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CourseSession_ibfk_4` FOREIGN KEY (`sid`) REFERENCES `Session` (`sid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CourseSession_ibfk_5` FOREIGN KEY (`subid`) REFERENCES `Subject` (`subid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Groups`
--
ALTER TABLE `Groups`
  ADD CONSTRAINT `Groups_ibfk_1` FOREIGN KEY (`spid`) REFERENCES `Speciality` (`spid`);

--
-- Contraintes pour la table `Session`
--
ALTER TABLE `Session`
  ADD CONSTRAINT `Session_ibfk_1` FOREIGN KEY (`day`) REFERENCES `WeekDay` (`day`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

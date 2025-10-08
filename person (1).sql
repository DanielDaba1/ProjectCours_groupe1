-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 08 oct. 2025 à 08:14
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_person`
--

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pk_person` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `person`
--

INSERT INTO `person` (`id`, `firstname`, `lastname`, `age`, `email`, `password`) VALUES
(1, 'daniel', 'daba', 24, 'danieldaba.cd@gmail.com', '$2a$10$CDgAf0Agd9t3uKyBWpXf7e6XF0LxQS1LYFgpSnmyf1FwpLc5lO.eG'),
(2, 'dan', 'dab', 20, 'dan@gmail.com', '$2a$10$c8pmAEIGvGo884Lhba7T9OSYqmq4LiqAJmfR8x81.m4HMbERcfl0K'),
(3, 'isamuna', 'nkembo', 34, 'josamuna@gmail.com', '$2a$10$nKqMgcrqG9DiiOCFiZetk.tbLWrvpusdK/bRE4Hs72tdhA.uHzL42'),
(4, 'Asimwe', 'Gloire', 30, 'Asimwe@gmail.com', '$2a$10$Fr/y5ATOUwLlbfZor6CvEe9DN4heDJ4F3tjQK5fXBwBIcqEdE/SJ2'),
(5, 'JOSEPH', 'AMANI', 44, 'joseph@gmail.com', '$2a$10$WdHkhCmozpKEDWdxpV7yjedyeHAFKCi0VaW54Qbx.wnHMDbyxPkMG');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

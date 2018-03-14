-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-03-2018 a las 00:42:45
-- Versión del servidor: 5.1.53
-- Versión de PHP: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `BDbodeguita`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE IF NOT EXISTS `trabajadores` (
  `nom_trab` varchar(20) DEFAULT NULL,
  `apellidos_trab` varchar(25) DEFAULT NULL,
  `sexo_trab` varchar(15) DEFAULT NULL,
  `telefono_trab` varchar(15) DEFAULT NULL,
  `turno_trab` varchar(15) DEFAULT NULL,
  `id_trab` int(10) NOT NULL AUTO_INCREMENT,
  `fNacim_trab` date DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id_trab`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `trabajadores`
--


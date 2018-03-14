-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-03-2018 a las 00:41:51
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
-- Estructura de tabla para la tabla `compraproductos`
--

CREATE TABLE IF NOT EXISTS `compraproductos` (
  `nom_comprod` varchar(20) NOT NULL,
  `canunit_comprod` double NOT NULL,
  `total_comprod` int(20) NOT NULL,
  `cantcomp_comprod` double NOT NULL,
  `preuni_comprod` double NOT NULL,
  `nom_prove` varchar(20) NOT NULL,
  `folio_comprod` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_comprod` date DEFAULT NULL,
  `nom_emp` varchar(20) NOT NULL,
  PRIMARY KEY (`folio_comprod`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `compraproductos`
--


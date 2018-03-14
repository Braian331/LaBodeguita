-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-03-2018 a las 00:43:05
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
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `descripcion_vent` varchar(20) DEFAULT NULL,
  `cantidad_vent` int(10) NOT NULL,
  `precio_vent` decimal(10,0) DEFAULT NULL,
  `preciot_vent` decimal(10,0) DEFAULT NULL,
  `codigo_vent` int(10) NOT NULL AUTO_INCREMENT,
  `fecha_vent` date DEFAULT NULL,
  PRIMARY KEY (`codigo_vent`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `ventas`
--


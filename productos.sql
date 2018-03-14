-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-03-2018 a las 00:42:19
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
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `cod_prod` int(11) NOT NULL AUTO_INCREMENT,
  `stock_prod` int(10) NOT NULL,
  `id_proveedor` int(25) NOT NULL,
  `aaa` int(11) NOT NULL,
  `nombre_prod` varchar(20) NOT NULL,
  `descripcion_prod` varchar(40) NOT NULL,
  `precio_prod` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`cod_prod`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `productos`
--


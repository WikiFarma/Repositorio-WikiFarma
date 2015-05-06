-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Abr-2015 às 15:56
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `farmaciadb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
`id_cli` int(10) NOT NULL,
  `cpf_cli` int(11) NOT NULL,
  `nome_cli` varchar(50) DEFAULT NULL,
  `endereco_cli` varchar(100) DEFAULT NULL,
  `telefone_cli` int(11) DEFAULT NULL,
  `data_cad_cli` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cli`, `cpf_cli`, `nome_cli`, `endereco_cli`, `telefone_cli`, `data_cad_cli`) VALUES
(2, 1, 'marco', 'rua do sol', 909090, '0000-00-00'),
(3, 321, 'andrielly', 'rua bezerros', 505050, '0000-00-00'),
(4, 171, 'mariane', 'rua frodo', 303030, '2015-04-25');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
`id_pro` int(10) NOT NULL,
  `desc_pro` varchar(100) NOT NULL,
  `cod_bar_pro` int(13) NOT NULL,
  `tipo_pro` int(1) NOT NULL COMMENT '0 - remedio 1 - outro',
  `custo_pro` float NOT NULL,
  `preco_venda_pro` float NOT NULL,
  `preco_venda_cli_pro` float NOT NULL,
  `qtde_pro` int(11) NOT NULL,
  `data_reg_pro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id_usu` int(11) NOT NULL,
  `nome_usu` varchar(20) NOT NULL,
  `senha_usu` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Tabela de usuário para logar no sistema';

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usu`, `nome_usu`, `senha_usu`) VALUES
(1, 'marco', 1),
(3, 'admin', 9090),
(4, 'root', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
`id_ven` int(10) NOT NULL,
  `tipo_ven` int(1) NOT NULL,
  `id_cli_ven` int(10) NOT NULL,
  `id_pro_ven` int(10) NOT NULL,
  `qtde_pro_ven` int(11) NOT NULL,
  `preco_venda_pro_ven` float NOT NULL,
  `qtde_ven` float NOT NULL COMMENT 'preco_ven * qtde_pro',
  `total_ven` float NOT NULL COMMENT 'soma qtde_vend',
  `data_ven` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela de venda';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`id_cli`), ADD UNIQUE KEY `cpf_cli` (`cpf_cli`), ADD FULLTEXT KEY `nome_cli` (`nome_cli`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
 ADD PRIMARY KEY (`id_pro`), ADD UNIQUE KEY `cod_bar_pro` (`cod_bar_pro`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`id_usu`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
 ADD PRIMARY KEY (`id_ven`), ADD KEY `id_cli_ven` (`id_cli_ven`), ADD KEY `id_pro_ven` (`id_pro_ven`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
MODIFY `id_cli` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
MODIFY `id_pro` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id_usu` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
MODIFY `id_ven` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
ADD CONSTRAINT `cons_id_cli_ven` FOREIGN KEY (`id_cli_ven`) REFERENCES `cliente` (`id_cli`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `cons_id_pro_ven` FOREIGN KEY (`id_pro_ven`) REFERENCES `produto` (`id_pro`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

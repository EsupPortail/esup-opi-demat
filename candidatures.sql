<!-- Piwik -->
<script type="text/javascript">
var pkBaseURL = (("https:" == document.location.protocol) ? "https://piwik.test.dauphine.fr/" :
"http://piwik.test.dauphine.fr/");
document.write(unescape("%3Cscript src='" + pkBaseURL + "piwik.js' type='text/javascript'%3E%3C/script%3E"));
</script><script type="text/javascript">
try {
var piwikTracker = Piwik.getTracker(pkBaseURL + "piwik.php", 1);
piwikTracker.trackPageView();
piwikTracker.enableLinkTracking();
} catch( err ) {}
</script><noscript><p><img src="http://piwik.test.dauphine.fr/piwik.php?idsite=1" style="border:0" alt="" /></p></noscript>
<!-- End Piwik Tracking Code -->

-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: 192.168.5.118:3306
-- GÃ©nÃ©rÃ© le : Mar 11 Mars 2014 Ã  09:53
-- Version du serveur: 5.1.71
-- Version de PHP: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de donnÃ©es: `candidatures`
--

-- --------------------------------------------------------

--
-- Structure de la table `UPD_CONSULTATION`
--

DROP TABLE IF EXISTS `UPD_CONSULTATION`;
CREATE TABLE IF NOT EXISTS `UPD_CONSULTATION` (
  `id_session` varchar(50) NOT NULL DEFAULT '',
  `login` varchar(50) NOT NULL DEFAULT '',
  `id_cmi` int(11) NOT NULL,
  `elements` varchar(255) NOT NULL,
  `dat_cre_session` datetime DEFAULT NULL,
  `dat_fin_session` datetime DEFAULT NULL,
  PRIMARY KEY (`id_session`,`login`,`id_cmi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Elements affiches pour session de consultation de comission ';

-- --------------------------------------------------------

--
-- Structure de la table `UPD_EXAMEN_DOSSIER`
--

DROP TABLE IF EXISTS `UPD_EXAMEN_DOSSIER`;
CREATE TABLE IF NOT EXISTS `UPD_EXAMEN_DOSSIER` (
  `id_usr_candidat` int(11) NOT NULL,
  `id_usr_membre` int(11) NOT NULL,
  `id_cmi` int(11) NOT NULL,
  `Observations` text NOT NULL,
  `Etat_traitement` varchar(70) NOT NULL,
  `Date_creation_traitement` date NOT NULL,
  `Date_modification_traitement` date NOT NULL,
  KEY `id_usr_candidat` (`id_usr_candidat`),
  KEY `id_cmi` (`id_cmi`),
  KEY `id_usr_membre` (`id_usr_membre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `UPD_FILTRE_ETAB`
--

DROP TABLE IF EXISTS `UPD_FILTRE_ETAB`;
CREATE TABLE IF NOT EXISTS `UPD_FILTRE_ETAB` (
  `id_session` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `id_cmi` int(11) NOT NULL,
  `filtre_cod_etab` varchar(255) NOT NULL,
  `dat_cre_session` datetime NOT NULL,
  `dat_fin_session` datetime NOT NULL,
  PRIMARY KEY (`id_session`,`login`,`id_cmi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `UPD_IND_FICHIER`
--

DROP TABLE IF EXISTS `UPD_IND_FICHIER`;
CREATE TABLE IF NOT EXISTS `UPD_IND_FICHIER` (
  `ID_FICHIER` int(11) NOT NULL AUTO_INCREMENT,
  `id_usr` int(11) NOT NULL COMMENT 'rÃ©fÃ©rence au candidat',
  `id_cmi` int(11) NOT NULL COMMENT 'rÃ©fÃ©rence Ã  la commission',
  `DATE_UPLOAD` datetime NOT NULL,
  `TYPE_PIECE_JUSTIF` int(11) NOT NULL,
  `Emplacement` varchar(255) NOT NULL COMMENT 'Emplacement du fichier sur le serveur',
  PRIMARY KEY (`ID_FICHIER`),
  KEY `id_cmi` (`id_cmi`),
  KEY `TYPE_PIECE_JUSTIF` (`TYPE_PIECE_JUSTIF`),
  KEY `id_usr` (`id_usr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13773 ;

-- --------------------------------------------------------

--
-- Structure de la table `UPD_IND_REFERENT`
--

DROP TABLE IF EXISTS `UPD_IND_REFERENT`;
CREATE TABLE IF NOT EXISTS `UPD_IND_REFERENT` (
  `id_usr` int(11) NOT NULL,
  `id_ref` int(11) NOT NULL,
  `nom_fichier_recommandation` varchar(255) DEFAULT NULL,
  `dat_depot_recommandation` date DEFAULT NULL,
  KEY `id_usr` (`id_usr`),
  KEY `id_ref` (`id_ref`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `UPD_REFERENT`
--

DROP TABLE IF EXISTS `UPD_REFERENT`;
CREATE TABLE IF NOT EXISTS `UPD_REFERENT` (
  `id_ref` int(11) NOT NULL AUTO_INCREMENT,
  `mail_ref` varchar(50) NOT NULL,
  `nom_ref` varchar(30) DEFAULT NULL,
  `prenom_ref` varchar(20) DEFAULT NULL,
  `mdp_ref` varchar(50) NOT NULL,
  `date_cre_ref` date NOT NULL,
  `dat_mod_ref` date NOT NULL,
  `titre_ref` varchar(150) NOT NULL,
  `organisme_ref` varchar(150) NOT NULL,
  `lien_mdp_ref` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ref`),
  UNIQUE KEY `mail_ref` (`mail_ref`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Personne rÃ©fÃ©rente pour la lettre de  recommandation' AUTO_INCREMENT=299 ;

--
-- Contraintes pour les tables exportÃ©es
--

--
-- Contraintes pour la table `UPD_EXAMEN_DOSSIER`
--
ALTER TABLE `UPD_EXAMEN_DOSSIER`
  ADD CONSTRAINT `UPD_EXAMEN_DOSSIER_ibfk_1` FOREIGN KEY (`id_usr_candidat`) REFERENCES `individu` (`id_usr`) ON DELETE CASCADE,
  ADD CONSTRAINT `UPD_EXAMEN_DOSSIER_ibfk_2` FOREIGN KEY (`id_usr_membre`) REFERENCES `opi_user` (`id_usr`) ON DELETE CASCADE,
  ADD CONSTRAINT `UPD_EXAMEN_DOSSIER_ibfk_3` FOREIGN KEY (`id_cmi`) REFERENCES `commission` (`id_cmi`) ON DELETE CASCADE;

--
-- Contraintes pour la table `UPD_IND_FICHIER`
--
ALTER TABLE `UPD_IND_FICHIER`
  ADD CONSTRAINT `UPD_IND_FICHIER_ibfk_5` FOREIGN KEY (`id_usr`) REFERENCES `individu` (`id_usr`) ON DELETE CASCADE,
  ADD CONSTRAINT `UPD_IND_FICHIER_ibfk_6` FOREIGN KEY (`id_cmi`) REFERENCES `commission` (`id_cmi`) ON DELETE CASCADE,
  ADD CONSTRAINT `UPD_IND_FICHIER_ibfk_7` FOREIGN KEY (`TYPE_PIECE_JUSTIF`) REFERENCES `nomenclature` (`id_nom`) ON DELETE CASCADE;

--
-- Contraintes pour la table `UPD_IND_REFERENT`
--
ALTER TABLE `UPD_IND_REFERENT`
  ADD CONSTRAINT `UPD_IND_REFERENT_ibfk_1` FOREIGN KEY (`id_usr`) REFERENCES `individu` (`id_usr`) ON DELETE CASCADE,
  ADD CONSTRAINT `UPD_IND_REFERENT_ibfk_2` FOREIGN KEY (`id_ref`) REFERENCES `UPD_REFERENT` (`id_ref`) ON DELETE CASCADE;

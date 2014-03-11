CREATE TABLE `UPD_CONSULTATION` (
  `id_session` varchar(50) NOT NULL DEFAULT '',
  `login` varchar(50) NOT NULL DEFAULT '',
  `id_cmi` int(11) NOT NULL,
  `elements` varchar(255) NOT NULL,
  `dat_cre_session` datetime DEFAULT NULL,
  `dat_fin_session` datetime DEFAULT NULL,
  PRIMARY KEY (`id_session`,`login`,`id_cmi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Elements affiches pour session de consultation de comission ';

CREATE TABLE `UPD_EXAMEN_DOSSIER` (
  `id_usr_candidat` int(11) NOT NULL,
  `id_usr_membre` int(11) NOT NULL,
  `id_cmi` int(11) NOT NULL,
  `Observations` text NOT NULL,
  `Etat_traitement` varchar(70) NOT NULL,
  `Date_creation_traitement` date NOT NULL,
  `Date_modification_traitement` date NOT NULL,
  KEY `id_usr_candidat` (`id_usr_candidat`),
  KEY `id_cmi` (`id_cmi`),
  KEY `id_usr_membre` (`id_usr_membre`),
  CONSTRAINT `UPD_EXAMEN_DOSSIER_ibfk_1` FOREIGN KEY (`id_usr_candidat`) REFERENCES `individu` (`id_usr`) ON DELETE CASCADE,
  CONSTRAINT `UPD_EXAMEN_DOSSIER_ibfk_2` FOREIGN KEY (`id_usr_membre`) REFERENCES `opi_user` (`id_usr`) ON DELETE CASCADE,
  CONSTRAINT `UPD_EXAMEN_DOSSIER_ibfk_3` FOREIGN KEY (`id_cmi`) REFERENCES `commission` (`id_cmi`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `UPD_FILTRE_ETAB` (
  `id_session` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `id_cmi` int(11) NOT NULL,
  `filtre_cod_etab` varchar(255) NOT NULL,
  `dat_cre_session` datetime NOT NULL,
  `dat_fin_session` datetime NOT NULL,
  PRIMARY KEY (`id_session`,`login`,`id_cmi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `UPD_IND_FICHIER` (
  `ID_FICHIER` int(11) NOT NULL AUTO_INCREMENT,
  `id_usr` int(11) NOT NULL COMMENT 'rÃ©fÃ©rence au candidat',
  `id_cmi` int(11) NOT NULL COMMENT 'rÃ©fÃ©rence Ã  la commission',
  `DATE_UPLOAD` datetime NOT NULL,
  `TYPE_PIECE_JUSTIF` int(11) NOT NULL,
  `Emplacement` varchar(255) NOT NULL COMMENT 'Emplacement du fichier sur le serveur',
  PRIMARY KEY (`ID_FICHIER`),
  KEY `id_cmi` (`id_cmi`),
  KEY `TYPE_PIECE_JUSTIF` (`TYPE_PIECE_JUSTIF`),
  KEY `id_usr` (`id_usr`),
  CONSTRAINT `UPD_IND_FICHIER_ibfk_5` FOREIGN KEY (`id_usr`) REFERENCES `individu` (`id_usr`) ON DELETE CASCADE,
  CONSTRAINT `UPD_IND_FICHIER_ibfk_6` FOREIGN KEY (`id_cmi`) REFERENCES `commission` (`id_cmi`) ON DELETE CASCADE,
  CONSTRAINT `UPD_IND_FICHIER_ibfk_7` FOREIGN KEY (`TYPE_PIECE_JUSTIF`) REFERENCES `nomenclature` (`id_nom`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10293 DEFAULT CHARSET=latin1;

CREATE TABLE `UPD_IND_REFERENT` (
  `id_usr` int(11) NOT NULL,
  `id_ref` int(11) NOT NULL,
  `nom_fichier_recommandation` varchar(255) DEFAULT NULL,
  `dat_depot_recommandation` date DEFAULT NULL,
  KEY `id_usr` (`id_usr`),
  KEY `id_ref` (`id_ref`),
  CONSTRAINT `UPD_IND_REFERENT_ibfk_1` FOREIGN KEY (`id_usr`) REFERENCES `individu` (`id_usr`) ON DELETE CASCADE,
  CONSTRAINT `UPD_IND_REFERENT_ibfk_2` FOREIGN KEY (`id_ref`) REFERENCES `UPD_REFERENT` (`id_ref`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `UPD_REFERENT` (
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
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=latin1 COMMENT='Personne rÃ©fÃ©rente pour la lettre de  recommandation';

CREATE TABLE `UPD_trt_cmi_vet_apo` (
  `id_trt_cmi` int(11) NOT NULL AUTO_INCREMENT,
  `cod_etp_trt_cmi` varchar(6) NOT NULL,
  `cod_vrs_vet_trt_cmi` int(11) NOT NULL,
  `cod_dip_trt_cmi` varchar(7) NOT NULL,
  `cod_vrs_vdi_trt_cmi` int(11) NOT NULL,
  `id_cmi` int(11) NOT NULL,
  `id_sel` int(11) DEFAULT NULL,
  `cod_etp_trt_cmi_apo` varchar(6) NOT NULL,
  `cod_vrs_vet_trt_cmi_apo` int(11) NOT NULL,
  PRIMARY KEY (`id_trt_cmi`),
  UNIQUE KEY `cod_etp_trt_cmi` (`cod_etp_trt_cmi`,`cod_vrs_vet_trt_cmi`),
  KEY `FK30E5131C86F9919` (`id_cmi`),
  KEY `FK30E5131C7C79B24F` (`id_sel`),
  CONSTRAINT `UPD_trt_cmi_vet_apo_ibfk_1` FOREIGN KEY (`id_sel`) REFERENCES `selection` (`id_sel`),
  CONSTRAINT `UPD_trt_cmi_vet_apo_ibfk_2` FOREIGN KEY (`id_cmi`) REFERENCES `commission` (`id_cmi`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=362 DEFAULT CHARSET=latin1;

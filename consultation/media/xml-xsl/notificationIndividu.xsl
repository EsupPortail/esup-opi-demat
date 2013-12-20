<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:variable name="para-font-size">
		11pt
	</xsl:variable>
	<xsl:variable name="para-font-size-small">
		8pt
	</xsl:variable>
	<xsl:variable name="para-font-size-title">
		13pt
	</xsl:variable>
	<xsl:variable name="padding-cell-tab-info">
		3pt
	</xsl:variable>
	<xsl:variable name="para-font-family">
		Arial Narrow,sans-serif
	</xsl:variable>
	<xsl:variable name="para-font-family-small">
		Trebuchet MS,sans-serif
	</xsl:variable>

	<xsl:variable name="grisClair">
		#e6e6e6
	</xsl:variable>


	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
			xmlns:fox="http://xml.apache.org/fop/extensions">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="all"
					page-height="29.699cm" page-width="20.999cm" margin-right="2cm"
					margin-left="2cm" margin-bottom="1cm" margin-top="1.10cm">
					<fo:region-body margin-top="0cm" margin-bottom="1cm" />
					<fo:region-before extent="0cm" />
					<fo:region-after extent="0.5cm" region-name="xsl-region-after" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="all">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:apply-templates select="array-list" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="array-list">
		<xsl:for-each select="notification-opinion">
			<xsl:if test="voeux-favorable != ''">
				<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}">
					<xsl:call-template name="voeuxFavorables" />
				</fo:block>
				<xsl:if test="voeux-defavorable != ''">
					<fo:block break-after='page'/>
				</xsl:if>
			</xsl:if>
			<xsl:if test="voeux-defavorable != ''">
				<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}">
					<xsl:call-template name="voeuxDefavorables" />
				</fo:block>
			</xsl:if>
			<xsl:if test="position() != last()">
				<fo:block break-after='page'/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template name="voeuxFavorables">
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="10cm" padding-top="2.5cm">
			<xsl:call-template name="dateDuJour" />
			<xsl:call-template name="adresse" />
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="40pt" text-align="justify">
			<xsl:if test="sexe = 'M'">
				Monsieur,
			</xsl:if>
			<xsl:if test="sexe = 'F'">
				Madame,
			</xsl:if>
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="15pt"
			text-align="justify" text-indent="1.25cm">
			Après examen de votre dossier par la Commission pédagogique, j'ai le plaisir de vous informer que vous êtes autorisé à vous inscrire à la (ou aux) formation(s) suivante(s) : 
		</fo:block>
		<xsl:for-each select="voeux-favorable">
			<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}">
				<xsl:call-template name="lesVoeux" />
			</fo:block>
		</xsl:for-each>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt"
			text-align="justify" text-indent="1.25cm">
			La vérification de vos diplômes sera effectuée, lors de votre inscription administrative, avant délivrance de votre carte étudiant.
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt"
			text-align="justify" text-indent="1.25cm">
			Vous devez impérativement vous reconnecter entre le 07/07/2009 et le 
			<xsl:text> </xsl:text>
			<xsl:value-of select="date-cloture" />
			 au serveur Candidatures Rennes1 (www.candidatures.univ-rennes1.fr) pour indiquer si vous acceptez d'intégrer cette (ou l'une de ces) formation(s) ou si vous y renoncez. 
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt" 
			text-align="justify" text-indent="1.25cm">
			L'absence de confirmation de votre part pendant la période indiquée sera considérée comme un désistement. 
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt"
			text-align="justify" text-indent="1.25cm">
			Si vous confirmez votre entrée à l'Université de Rennes 1, vous serez informé par mail des modalités de votre inscription administrative.
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt"
			text-align="justify" text-indent="1.25cm">
			Je vous rappelle que cette proposition d'inscription n'est valable que pour l'année universitaire 
			<xsl:value-of select="periode-scolaire" />
			. Si vous souhaitez différer votre entrée en formation, il conviendra de renouveler votre candidature.
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt"
			text-align="justify" text-indent="1.25cm">
			Pour toute information complémentaire, merci de contacter :
		</fo:block>
		
		<xsl:call-template name="contactCGE" />
		
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="5cm"
			padding-top="15pt" text-align="justify">
			Cordialement,
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="5cm"
			padding-top="10pt" text-align="justify">
			P./ Le Président de l'Université et par délégation,
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="5cm"
			padding-top="10pt" text-align="justify">
			Le Responsable du Service de la Scolarité 
		</fo:block>
		<xsl:call-template name="RappelNumDossier" />
	</xsl:template>

	<xsl:template name="voeuxDefavorables">
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="10cm" padding-top="2.5cm">
			<xsl:call-template name="dateDuJour" />
			<xsl:call-template name="adresse" />
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="40pt" text-align="justify">
			<xsl:if test="sexe = 'M'">
				Monsieur,
			</xsl:if>
			<xsl:if test="sexe = 'F'">
				Madame,
			</xsl:if>
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="15pt"
			text-align="justify" text-indent="1.25cm">
			J'ai le regret de vous informer, qu'après examen de votre dossier, la Commission pédagogique n'a pu retenir votre candidature pour les motifs suivants :
		</fo:block>
		<xsl:for-each select="voeux-defavorable">
			<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}">
				<xsl:call-template name="lesVoeux" />
			</fo:block>
		</xsl:for-each>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt" 
			text-align="justify" text-indent="1.25cm">
			Si vous souhaitez faire appel de cette décision, vous pouvez former un recours auprès du Président de l'université ou du tribunal administratif de Rennes (voies et délais de recours précisés au verso).
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="10pt" 
			text-align="justify" text-indent="1.25cm">
			Pour toute information complémentaire, je vous remercie de contacter :
		</fo:block>

		<xsl:call-template name="contactCGE" />

		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="15pt" 
			text-align="justify" text-indent="1.25cm">
			Je vous prie d'agréer, Madame, Monsieur, l'expression de ma considération distinguée. 
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="3cm"
			padding-top="35pt" text-align="justify">
			P./ Le Président de l'Université et par délégation,
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="3cm"
			padding-top="5pt" text-align="justify">
			Le Responsable du Service de la Scolarité 
		</fo:block>
		<xsl:call-template name="RappelNumDossier" />
		<fo:block break-after='page'/>

		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size-title}" margin-left="2cm"
			padding-top="6cm" text-align="justify" font-weight="bold">
			VISAS
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="3.5cm"
			padding-top="25pt" text-align="justify" text-indent="-1.5cm">
			Décret n°85-906 du 23 août 1985 fixant les conditions de validation des études, expériences professionnelles ou acquis personnels en vue de l'accès aux différents niveaux de l'enseignement supérieur,
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="3.5cm"
			padding-top="15pt" text-align="justify" text-indent="-1.5cm">
			Décret n°2002-481 du 8 avril 2002 relatif aux grades et titres universitaires et aux diplômes nationaux.
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size-title}" margin-left="2cm"
			padding-top="20pt" text-align="justify" font-weight="bold">
			DELAIS ET VOIES DE RECOURS
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="2cm"
			padding-top="15pt" text-align="justify" text-indent="1.5cm">
			Si vous souhaitez faire appel de cette décision, vous disposez d'un délai de deux mois pour :
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="2cm"
			padding-top="5pt" text-align="justify" text-indent="1.5cm">
			- soit former un recours gracieux auprès du Président de l'université de Rennes 1 ;
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="2cm"
			padding-top="5pt" text-align="justify" text-indent="1.5cm">
			- soit former un recours contentieux auprès du tribunal administratif de Rennes.
		</fo:block>
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" margin-left="2cm"
			padding-top="15pt" text-align="justify" text-indent="1.5cm">
			Dans le cas où vous choisissez de former un recours gracieux, vous disposez d'un nouveau délai de deux mois,
			soit à compter de la notification de la nouvelle décision,
			soit à compter de l'expiration du délai implicite de décision de deux mois, pour contester celle-ci devant le tribunal administratif.
		</fo:block>
		
	</xsl:template>

	<xsl:template name="RappelNumDossier">
		<fo:block font-family="{$para-font-family}" font-size="{$para-font-size}" padding-top="15pt"
			text-align="justify" text-indent="1.25cm" font-style="italic">
				<xsl:if test="num-dossier-opi">
				Rappel : votre numéro de dossier de candidature est le :  
						<xsl:value-of select="num-dossier-opi" />
				</xsl:if>
		</fo:block>
	</xsl:template>

	<xsl:template name="dateDuJour">
		Le 
		<xsl:value-of select="date-du-jour" />
	</xsl:template>

	<xsl:template name="contactCGE">
		<fo:block font-size="{$para-font-size}" padding-top="10pt" margin-left="3cm">
			<fo:block font-size="{$para-font-size}" padding-top="2pt" >
				<xsl:value-of select="nom-commission" />
			</fo:block>
			<fo:block font-size="{$para-font-size}" >
				<xsl:value-of select="coordonnees-contact/adresse/adr1" />
			</fo:block>
			<fo:block font-size="{$para-font-size}">
				<xsl:value-of select="coordonnees-contact/adresse/adr2" />
			</fo:block>
			<fo:block font-size="{$para-font-size}" >
				<xsl:value-of select="coordonnees-contact/adresse/adr3" />
			</fo:block>
			<fo:block font-size="{$para-font-size}" >
				<xsl:value-of select="coordonnees-contact/commune/cod-com" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="coordonnees-contact/commune/lib-commune" />
			</fo:block>
			<xsl:if test="coordonnees-contact/adresse/phone-number != ''">
				<fo:block font-size="{$para-font-size}" >
					Téléphone : 
					<xsl:value-of select="coordonnees-contact/adresse/phone-number" />
				</fo:block>
			</xsl:if>
			<xsl:if test="coordonnees-contact/adresse/fax-number != ''">
				<fo:block font-size="{$para-font-size}" >
					Fax : 
					<xsl:value-of select="coordonnees-contact/adresse/fax-number" />
				</fo:block>
			</xsl:if>
			<xsl:if test="coordonnees-contact/adresse/mail != ''">
				<fo:block font-size="{$para-font-size}" >
					Mail :
					<xsl:value-of select="coordonnees-contact/adresse/mail" />
				</fo:block>
			</xsl:if>
			<xsl:if test="coordonnees-contact/adresse/is-cedex = true">
				<xsl:text> </xsl:text>
				CEDEX
				<xsl:value-of select="coordonnees-contact/adresse/cedex" />
			</xsl:if>
		</fo:block>
	</xsl:template>
	
	<xsl:template name="lesVoeux">
			<fo:block font-size="{$para-font-size}" padding-top="10pt" margin-left="2cm">
				- <xsl:value-of select="vrs-etape/lib-web-vet" />
				<xsl:text> : </xsl:text>
				<xsl:value-of select="avis-en-service/motivation-avis/libelle" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="avis-en-service/commentaire" />
			</fo:block>
	</xsl:template>

	<xsl:template name="adresse">
			<fo:block font-size="11pt" padding-top="15pt" font-weight="bold">
				<xsl:if test="sexe = 'M'">
					Monsieur 
				</xsl:if>
				<xsl:if test="sexe = 'F'">
					Madame 
				</xsl:if>
				<xsl:value-of select="nom" /> 
				<xsl:text> </xsl:text>
				<xsl:value-of select="prenom" /> 
			</fo:block>
			<fo:block font-size="11pt" font-weight="bold">
				<xsl:value-of select="adresse-etu/adresse/adr1" />
			</fo:block>
			<fo:block font-size="11pt" font-weight="bold">
				<xsl:value-of select="adresse-etu/adresse/adr2" />
			</fo:block>
			<fo:block font-size="11pt" font-weight="bold">
				<xsl:value-of select="adresse-etu/adresse/adr3" />
			</fo:block>
			<fo:block font-size="11pt" font-weight="bold">
				<xsl:choose>
					<xsl:when test="adresse-etu/commune">
						<xsl:value-of select="adresse-etu/adresse/cod-bdi" />
						<xsl:text> </xsl:text>
						<xsl:value-of select="adresse-etu/commune/lib-commune" />
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="adresse-etu/adresse/lib-com-etr" />
					</xsl:otherwise>
				</xsl:choose>
			</fo:block>
			<fo:block font-size="11pt" font-weight="bold">
				<xsl:value-of select="adresse-etu/pays/lib-pay" />
			</fo:block>
			<xsl:if test="adresse-etu/adresse/adr2 = ''">
				<fo:block font-size="11pt">
					<xsl:text> </xsl:text>
				</fo:block>
			</xsl:if>
			<xsl:if test="adresse-etu/adresse/adr3 = ''">
				<fo:block font-size="11pt">
					<xsl:text> </xsl:text>
				</fo:block>
			</xsl:if>
	</xsl:template>
	
</xsl:stylesheet>

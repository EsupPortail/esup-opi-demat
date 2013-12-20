/**
 * EtablissementMetierServiceInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv;

public interface EtablissementMetierServiceInterface extends java.rmi.Remote {
    public gouv.education.apogee.commun.transverse.dto.etablissement.EtablissementCompletDTO.EtablissementCompletDTO[] recupererEtablissementWS(java.lang.String _typeEtb, java.lang.String _codeEtb, java.lang.String _libEtb, java.lang.String _deptEtb, java.lang.String _paysEtb, java.lang.String _temoinEtbSve, java.lang.String _temoinTpeSve) throws java.rmi.RemoteException, gouv.education.apogee.commun.transverse.exception.WebBaseException;
}

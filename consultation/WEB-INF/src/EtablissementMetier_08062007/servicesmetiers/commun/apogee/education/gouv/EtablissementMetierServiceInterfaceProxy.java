package EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv;

public class EtablissementMetierServiceInterfaceProxy implements EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterface {
  private String _endpoint = null;
  private EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterface etablissementMetierServiceInterface = null;
  
  public EtablissementMetierServiceInterfaceProxy() {
    _initEtablissementMetierServiceInterfaceProxy();
  }
  
  public EtablissementMetierServiceInterfaceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEtablissementMetierServiceInterfaceProxy();
  }
  
  private void _initEtablissementMetierServiceInterfaceProxy() {
    try {
      etablissementMetierServiceInterface = (new EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterfaceServiceLocator()).getEtablissementMetier();
      if (etablissementMetierServiceInterface != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)etablissementMetierServiceInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)etablissementMetierServiceInterface)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (etablissementMetierServiceInterface != null)
      ((javax.xml.rpc.Stub)etablissementMetierServiceInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterface getEtablissementMetierServiceInterface() {
    if (etablissementMetierServiceInterface == null)
      _initEtablissementMetierServiceInterfaceProxy();
    return etablissementMetierServiceInterface;
  }
  
  public gouv.education.apogee.commun.transverse.dto.etablissement.EtablissementCompletDTO.EtablissementCompletDTO[] recupererEtablissementWS(java.lang.String _typeEtb, java.lang.String _codeEtb, java.lang.String _libEtb, java.lang.String _deptEtb, java.lang.String _paysEtb, java.lang.String _temoinEtbSve, java.lang.String _temoinTpeSve) throws java.rmi.RemoteException, gouv.education.apogee.commun.transverse.exception.WebBaseException{
    if (etablissementMetierServiceInterface == null)
      _initEtablissementMetierServiceInterfaceProxy();
    return etablissementMetierServiceInterface.recupererEtablissementWS(_typeEtb, _codeEtb, _libEtb, _deptEtb, _paysEtb, _temoinEtbSve, _temoinTpeSve);
  }
  
  
}
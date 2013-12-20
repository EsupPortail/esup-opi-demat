package com.tg_mvc.IntroWebService;

import gouv.education.apogee.commun.transverse.dto.etablissement.EtablissementCompletDTO.EtablissementCompletDTO;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterfaceServiceLocator;
import EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierSoapBindingStub;

public class EtablissementApogee {
	
	protected EtablissementMetierSoapBindingStub stubET	=null;
	
	private	URL	makeURL(String service) throws Exception {
    	URL	result	=null;
    	try {
			result	=new URL("http://ws.exemple.fr/apohisto-webservices/services/EtablissementMetier");
		} catch (MalformedURLException ex) {
			System.err.println( "Error de configuration webservice : URL invalid");
			System.err.println( "Message : " + ex.getMessage());
			System.err.println( "Trace   :");
			StackTraceElement[] tab = ex.getStackTrace();
			for (int i = 0; i < tab.length; i++) {
				System.err.println("   > " + tab[i]);
			}
			throw new Exception("EtablissementApogee > invalid webservice url");
		}
    	return result;
    }
	
	public	EtablissementApogee(){
	}
	
	public	void	initConnexion() throws Exception{this.initStub();}
	
	public	boolean	isConnected(){
		return this.stubET!=null ;
	}
	
	public	void close() throws Exception{
		this.stubET	=null;
	}
	
	protected	void	initStub() throws Exception{
		// stub : EtablissementMetier
		try{
			EtablissementMetierServiceInterfaceServiceLocator 		locatorET = new EtablissementMetierServiceInterfaceServiceLocator();
			//if (this.getUrl()!=null)
				this.stubET= (EtablissementMetierSoapBindingStub)locatorET.getEtablissementMetier(this.makeURL("http://ws.exemple.fr/apohisto-webservices/wsdl/EtablissementMetier_08062007_Impl.wsdl/EtudiantMetier"));
			//else
				//this.stubET= (EtablissementMetierSoapBindingStub)locatorET.getEtablissementMetier();
				//this.stubET.setUsername("user");
				//this.stubET.setPassword("password");
			System.out.println("WS binding EtablissementMetier -> ok");
		}catch(javax.xml.rpc.ServiceException ex){
			System.err.println("can not initialize binding : EtablissementMetier");
			throw new Exception("ApogeeConfig > init webservice 'EtablissementMetier' failed");
		}
	}
	
	public	EtablissementCompletDTO[] getEtablissementtMetier(String _codeEtb)
	throws WebBaseException, RemoteException {
		return	this.stubET.recupererEtablissementWS("", _codeEtb, "", "", "", "", "");
	}
}

/**
 * EtablissementMetierServiceInterfaceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv;

public class EtablissementMetierServiceInterfaceServiceLocator extends org.apache.axis.client.Service implements EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterfaceService {

    public EtablissementMetierServiceInterfaceServiceLocator() {
    }


    public EtablissementMetierServiceInterfaceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EtablissementMetierServiceInterfaceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EtablissementMetier
    private java.lang.String EtablissementMetier_address = "http://ws.exemple.fr/apohisto-webservices/services/EtablissementMetier";

    public java.lang.String getEtablissementMetierAddress() {
        return EtablissementMetier_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EtablissementMetierWSDDServiceName = "EtablissementMetier";

    public java.lang.String getEtablissementMetierWSDDServiceName() {
        return EtablissementMetierWSDDServiceName;
    }

    public void setEtablissementMetierWSDDServiceName(java.lang.String name) {
        EtablissementMetierWSDDServiceName = name;
    }

    public EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterface getEtablissementMetier() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EtablissementMetier_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEtablissementMetier(endpoint);
    }

    public EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterface getEtablissementMetier(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierSoapBindingStub _stub = new EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierSoapBindingStub(portAddress, this);
            _stub.setPortName(getEtablissementMetierWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEtablissementMetierEndpointAddress(java.lang.String address) {
        EtablissementMetier_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (EtablissementMetier_08062007.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierServiceInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierSoapBindingStub _stub = new EtablissementMetier_08062007_impl.servicesmetiers.commun.apogee.education.gouv.EtablissementMetierSoapBindingStub(new java.net.URL(EtablissementMetier_address), this);
                _stub.setPortName(getEtablissementMetierWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EtablissementMetier".equals(inputPortName)) {
            return getEtablissementMetier();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("gouv.education.apogee.commun.servicesmetiers.EtablissementMetier_08062007-impl", "EtablissementMetierServiceInterfaceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("gouv.education.apogee.commun.servicesmetiers.EtablissementMetier_08062007-impl", "EtablissementMetier"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EtablissementMetier".equals(portName)) {
            setEtablissementMetierEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

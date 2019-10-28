/**
 * MailServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mail;

public class MailServiceLocator extends org.apache.axis.client.Service implements mail.MailService {

    public MailServiceLocator() {
    }


    public MailServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MailServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Mail
    private java.lang.String Mail_address = "http://localhost:8080/SA3Server/services/Mail";

    public java.lang.String getMailAddress() {
        return Mail_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MailWSDDServiceName = "Mail";

    public java.lang.String getMailWSDDServiceName() {
        return MailWSDDServiceName;
    }

    public void setMailWSDDServiceName(java.lang.String name) {
        MailWSDDServiceName = name;
    }

    public mail.Mail getMail() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Mail_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMail(endpoint);
    }

    public mail.Mail getMail(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mail.MailSoapBindingStub _stub = new mail.MailSoapBindingStub(portAddress, this);
            _stub.setPortName(getMailWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMailEndpointAddress(java.lang.String address) {
        Mail_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mail.Mail.class.isAssignableFrom(serviceEndpointInterface)) {
                mail.MailSoapBindingStub _stub = new mail.MailSoapBindingStub(new java.net.URL(Mail_address), this);
                _stub.setPortName(getMailWSDDServiceName());
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
        if ("Mail".equals(inputPortName)) {
            return getMail();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://mail", "MailService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://mail", "Mail"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Mail".equals(portName)) {
            setMailEndpointAddress(address);
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

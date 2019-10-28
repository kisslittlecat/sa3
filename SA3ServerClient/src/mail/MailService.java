/**
 * MailService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mail;

public interface MailService extends javax.xml.rpc.Service {
    public java.lang.String getMailAddress();

    public mail.Mail getMail() throws javax.xml.rpc.ServiceException;

    public mail.Mail getMail(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

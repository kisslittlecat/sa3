package mail;

public class MailProxy implements mail.Mail {
  private String _endpoint = null;
  private mail.Mail mail = null;
  
  public MailProxy() {
    _initMailProxy();
  }
  
  public MailProxy(String endpoint) {
    _endpoint = endpoint;
    _initMailProxy();
  }
  
  private void _initMailProxy() {
    try {
      mail = (new mail.MailServiceLocator()).getMail();
      if (mail != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mail)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mail)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mail != null)
      ((javax.xml.rpc.Stub)mail)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mail.Mail getMail() {
    if (mail == null)
      _initMailProxy();
    return mail;
  }
  
  public boolean validateEmailAddress(java.lang.String url) throws java.rmi.RemoteException{
    if (mail == null)
      _initMailProxy();
    return mail.validateEmailAddress(url);
  }
  
  public void sendEmail(java.lang.String url, java.lang.String payload) throws java.rmi.RemoteException{
    if (mail == null)
      _initMailProxy();
    mail.sendEmail(url, payload);
  }
  
  public void sendEmailBatch(java.lang.String[] urls, java.lang.String payload) throws java.rmi.RemoteException{
    if (mail == null)
      _initMailProxy();
    mail.sendEmailBatch(urls, payload);
  }
  
  
}
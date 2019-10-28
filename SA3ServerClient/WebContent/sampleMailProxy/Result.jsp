<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleMailProxyid" scope="session" class="mail.MailProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleMailProxyid.setEndpoint(request.getParameter("endpoint"));
%>
<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleMailProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleMailProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        mail.Mail getMail10mtemp = sampleMailProxyid.getMail();
if(getMail10mtemp == null){
%>
<%=getMail10mtemp %>
<%
}else{
        if(getMail10mtemp!= null){
        String tempreturnp11 = getMail10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String url_1id=  request.getParameter("url16");
            java.lang.String url_1idTemp = null;
        if(!url_1id.equals("")){
         url_1idTemp  = url_1id;
        }
        boolean validateEmailAddress13mtemp = sampleMailProxyid.validateEmailAddress(url_1idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validateEmailAddress13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 18:
        gotMethod = true;
        String url_2id=  request.getParameter("url21");
            java.lang.String url_2idTemp = null;
        if(!url_2id.equals("")){
         url_2idTemp  = url_2id;
        }
        String payload_3id=  request.getParameter("payload23");
            java.lang.String payload_3idTemp = null;
        if(!payload_3id.equals("")){
         payload_3idTemp  = payload_3id;
        }
        sampleMailProxyid.sendEmail(url_2idTemp,payload_3idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
alert("N");
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>
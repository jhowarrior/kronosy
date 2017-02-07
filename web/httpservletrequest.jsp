<%-- 
    Document   : httpservletrequest
    Created on : 16/01/2017, 23:01:48
    Author     : joao
--%>

<%!
    HttpServletRequest httpServletRequest;
    String requisita (String valor) {
        String temp = httpServletRequest.getParameter(valor);
        if(temp==null)
            temp="";
            return temp;
    
    }
%>
<%
  httpServletRequest = request;  
%>
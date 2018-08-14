<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    //首页跳转
    //response.sendRedirect(basePath+"user_index.action");
%>

<HTML>
<HEAD>
    <%--首页跳转--%>
    <%--<META http-equiv="refresh" content="0; URL=user_index.action">--%>
</HEAD>
<BOBY>
    <%--首页跳转--%>
    <s:action name="user_index" namespace="/" executeResult="true"/>
</BOBY>
</HTML>

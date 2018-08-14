<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>修改拜访</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css"
          type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css"
          type=text/css rel=stylesheet>


    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1
      action="${pageContext.request.contextPath }/visit_update.action"
      method=post enctype="multipart/form-data">

    <input type="hidden" name="visitId" value="${visit.visitId }"/>

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG
                    src="${pageContext.request.contextPath }/images/new_019.jpg"
                    border=0></TD>
            <TD width="100%"
                background="${pageContext.request.contextPath }/images/new_020.jpg"
                height=20></TD>
            <TD width=15><IMG
                    src="${pageContext.request.contextPath }/images/new_021.jpg"
                    border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15
                background="${pageContext.request.contextPath }
						/images/new_022.jpg"><IMG
                    src="${pageContext.request.contextPath }/images/new_022.jpg"
                    border=0></TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：拜访管理 &gt; 修改拜访</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>
                <TABLE cellSpacing=0 cellPadding=5 border=0>
                    <TR>
                        <TD>所属用户：</TD>
                        <TD><select name="visitUser.userId">
                            <c:forEach var="user" items="${users }">
                                <option value="${user.userId }">${user.userName }</option>
                            </c:forEach>
                        </select></TD>

                        <TD>所属客户</TD>
                        <TD><select name="visitCustomer.customerId">
                            <c:forEach var="customer" items="${customers }">
                                <option value="${customer.customerId }">${customer.customerName }</option>
                            </c:forEach>
                        </select></TD>
                    </TR>
                    <TR>
                        <TD>拜访地址：</TD>
                        <TD><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
                                   maxLength=50 name="visitAddress" value="${visit.visitAddress}"></TD>
                        <TD>拜访内容：</TD>
                        <TD><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
                                   maxLength=50 name="visitContent" value="${visit.visitContent}"></TD>
                    </TR>
                    <TR>

                    </TR>
                    <TR>
                        <TD rowspan=2><INPUT class=button id=sButton2 type=submit
                                             value="保存" name=sButton2></TD>
                    </TR>
                </TABLE>


            </TD>
            <TD width=15
                background="${pageContext.request.contextPath }/images/new_023.jpg">
                <IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
                     border=0>
            </TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG
                    src="${pageContext.request.contextPath }/images/new_024.jpg"
                    border=0></TD>
            <TD align=middle width="100%"
                background="${pageContext.request.contextPath }/images/new_025.jpg"
                height=15></TD>
            <TD width=15><IMG
                    src="${pageContext.request.contextPath }/images/new_026.jpg"
                    border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>

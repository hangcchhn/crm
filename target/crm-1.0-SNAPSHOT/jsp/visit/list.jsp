<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>列表拜访</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css"
          type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css"
          type=text/css rel=stylesheet>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <SCRIPT language=javascript>
        function to_page(page) {
            if (page) {
                $("#page").val(page);
            }
            document.customerForm.submit();

        }
    </SCRIPT>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id="customerForm" name="customerForm"
      action="${pageContext.request.contextPath }/visit_content.action"
      method=post>

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
                background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
                    src="${pageContext.request.contextPath }/images/new_022.jpg"
                    border=0></TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：拜访管理 &gt; 列表拜访</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>
                <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
                       width="100%" align=center border=0>
                    <TBODY>
                    <TR>
                        <TD height=25>
                            <TABLE cellSpacing=0 cellPadding=2 border=0>
                                <TBODY>
                                <TR>
                                    <TD>拜访内容：</TD>
                                    <TD><INPUT class=textbox id=sChannel2
                                               style="WIDTH: 80px" maxLength=50 name="visitContent"></TD>
                                    <TD><INPUT class=button id=sButton2 type=submit value=" 筛选 "
                                               name=sButton2></TD>
                                </TR>
                                </TBODY>
                            </TABLE>
                        </TD>
                    </TR>
                    <TR>
                        <TD>
                            <TABLE id=grid
                                   style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
                                   cellSpacing=1 cellPadding=2 rules=all border=0>
                                <TBODY>
                                <TR
                                        style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                    <TD>所属用户</TD>
                                    <TD>所属客户</TD>
                                    <TD>拜访地址</TD>
                                    <TD>拜访内容</TD>

                                    <TD>修改</TD>
                                    <TD>删除</TD>
                                </TR>
                                <c:forEach items="${visits }" var="visit">
                                    <TR
                                            style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

                                        <TD>${visit.visitUser.userName }</TD>
                                        <TD>${visit.visitCustomer.customerName }</TD>
                                        <TD>${visit.visitAddress }</TD>
                                        <TD>${visit.visitContent }</TD>


                                        <TD><a
                                                href="${pageContext.request.contextPath }/visit_edit.action?visitId=${visit.visitId}">修改</a>
                                        </TD>
                                        <TD><a
                                                href="${pageContext.request.contextPath }/visit_delete.action?visitId=${visit.visitId}">删除</a>
                                        </TD>
                                    </TR>

                                </c:forEach>

                                </TBODY>
                            </TABLE>
                        </TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
            <TD width=15
                background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
                    src="${pageContext.request.contextPath }/images/new_023.jpg"
                    border=0></TD>
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

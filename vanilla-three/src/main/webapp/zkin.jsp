<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="z" uri="http://www.zkoss.org/jsp/zul" %>
<%
    request.setAttribute(org.zkoss.zk.ui.sys.Attributes.NO_CACHE, Boolean.TRUE);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="-1"/>
    <title>ZK in JSP</title>
    <z:zkhead/>
    <style type="text/css">
        body {
            font-family: 'Segoe UI', Verdana, Arial, sans-serif;
        }

        #container {
            margin: 50px 20% 0;
        }
    </style>
</head>
<body>
<div id="container">
    <h2>ZK in JSP</h2>
    <p>This example demonstrate using ZK component inside JSP.</p>

    <hr/>
    <br/>

    <z:page>
        <z:grid apply="com.sankholin.vanilla.three.ui.RegistrationController" width="400px">
            <z:columns visible="false">
                <z:column/>
                <z:column/>
            </z:columns>
            <z:auxhead>
                <z:auxheader colspan="2" label="Registration Form" style="font-size:16px"/>
            </z:auxhead>
            <z:rows>
                <z:row>
                    Name
                    <z:textbox id="nameBox" hflex="1" constraint="no empty"/>
                </z:row>
                <z:row>
                    Gender:
                    <z:radiogroup id="genderRadio">
                        <z:radio label="Male" value="male" iconSclass="z-icon-male" checked="true"/>
                        <z:radio label="Female" value="female" iconSclass="z-icon-female"/>
                    </z:radiogroup>
                </z:row>
                <z:row>
                    Birthday
                    <z:datebox id="birthdayBox" hflex="1" constraint="no empty, no today, no future"/>
                </z:row>
                <z:row spans="2" align="center">
                    <z:hlayout>
                        <z:checkbox id="acceptTermBox"/>
                        Accept Term of Use
                    </z:hlayout>
                </z:row>
                <z:row spans="2" align="right">
                    <z:hlayout>
                        <z:button id="submitButton" label="Submit" disabled="true"/>
                    </z:hlayout>
                </z:row>
            </z:rows>
        </z:grid>
    </z:page>

    <div style="font-size: small; margin-top: 20px">
        <a href="members.zul">Go Members</a> | <a href="index.jsp">Go Home</a>
    </div>

</div>
</body>
</html>
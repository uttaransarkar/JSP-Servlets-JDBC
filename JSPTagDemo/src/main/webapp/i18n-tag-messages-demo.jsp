<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
scope="session" />
<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="com.jsp.tagdemo.i18n.resources.mylabels" />
 
<!DOCTYPE html>
<html>
<head>
<title>i18n Demo</title>
</head>
<body>

<h3>i18n Messages tag Demo</h3>
View this page in:

<a href="i18n-tag-messages-demo.jsp?theLocale=en_US">English (US)</a>

<a href="i18n-tag-messages-demo.jsp?theLocale=es_ES">Spanish (ES)</a>

<a href="i18n-tag-messages-demo.jsp?theLocale=de_DE">German (DE)</a>
<hr>

<!-- reference the labels from the resource(.properties) files with format <fmt> tag -->

<h3><fmt:message key="label.welcome" />!</h3>

<fmt:message key="label.firstName" />: <b>Sheldon</b> <br>

<fmt:message key="label.lastName" />: <b>Cooper</b><br>

<hr>
<fmt:message key="label.content" /> <br><br>

Current Locale: <b>${theLocale}</b>

</body>
</html>
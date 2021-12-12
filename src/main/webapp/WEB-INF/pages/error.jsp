<%@include file="include.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main-page>
<jsp:attribute name="body">

<h1> ${errorTitle} </h1>
<p> ${errorMessage} </p>

</jsp:attribute>
</t:main-page>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="administrator.materialSheets.list.label.title" path="title" width="60%"/>
	<acme:list-column code="administrator.materialSheets.list.label.providerName" path="providerName" width="40%"/>
</acme:list>
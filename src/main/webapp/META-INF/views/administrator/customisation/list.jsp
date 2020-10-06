

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.customisation.list.label.threshold" path="thresholdPercentage" width="25%"/>
	<acme:list-column code="administrator.customisation.list.label.spam" path="spam" width="75%"/>

</acme:list>



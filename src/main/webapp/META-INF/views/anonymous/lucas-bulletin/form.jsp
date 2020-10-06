<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form >
	<acme:form-textbox code="anonymous.lucas-bulletin.form.label.author" path="author"/>
	<acme:form-textarea code="anonymous.lucas-bulletin.form.label.text" path="text"/>
	
	<acme:form-submit code="anonymous.lucas-bulletin.form.button.create" action="/anonymous/lucas-bulletin/create"/>
	<acme:form-return code="anonymous.lucas-bulletin.form.button.return"/>
</acme:form>


<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	
	<acme:form-textbox code="authenticated.figment.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.figment.form.label.creationMoment" path="creationMoment"/>
	<acme:form-textbox code="authenticated.figment.form.label.inventorName" path="inventorName"/>
	<acme:form-textarea code="authenticated.figment.form.label.description" path="description"/>
	<acme:form-money code="authenticated.figment.form.label.minMoney" path="minMoney"/>
	<acme:form-money code="authenticated.figment.form.label.maxMoney" path="maxMoney"/>
	
	
	<acme:form-return code="authenticated.figment.form.button.return"/>
</acme:form>

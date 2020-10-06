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
	<acme:form-url code="authenticated.advertisement.form.label.picture" path="picture"/>
	<acme:form-textbox code="authenticated.advertisement.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.advertisement.form.label.creationMoment" path="creationMoment"/>
	<acme:form-moment code="authenticated.advertisement.form.label.initialTime" path="initialTime"/>
	<acme:form-moment code="authenticated.advertisement.form.label.deadline" path="deadline"/>
	<acme:form-money  code="authenticated.advertisement.form.label.smallDiscount" path="smallDiscount"/>
	<acme:form-money  code="authenticated.advertisement.form.label.averageDiscount" path="averageDiscount"/>
	<acme:form-money  code="authenticated.advertisement.form.label.largeDiscount" path="largeDiscount"/>
	<acme:form-textarea code="authenticated.advertisement.form.label.description" path="description"/>
	
	<acme:form-return code="authenticated.advertisement.form.button.return"/>
</acme:form>

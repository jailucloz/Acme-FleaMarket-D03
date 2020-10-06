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
	<acme:form-url code="authenticated.news.form.label.headerPicture" path="headerPicture"/>
	<acme:form-textbox code="authenticated.news.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.news.form.label.category" path="category"/>
	<acme:form-moment code="authenticated.news.form.label.deadline" path="deadline"/>
	<acme:form-url code="authenticated.news.form.label.relatedNews" path="relatedNews"/>
	<acme:form-textarea code="authenticated.news.form.label.body" path="body"/>
	
	<acme:form-return code="authenticated.news.form.button.return"/>
</acme:form>

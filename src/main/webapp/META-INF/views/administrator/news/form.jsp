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

<acme:form>
	<acme:form-url code="administrator.news.form.label.headerPicture" path="headerPicture"/>
	<acme:form-textbox code="administrator.news.form.label.title" path="title"/>
	<acme:form-textbox code="administrator.news.form.label.category" path="category"/>
	<acme:form-moment code="administrator.news.form.label.deadline" path="deadline"/>
	<acme:form-url code="administrator.news.form.label.relatedNews" path="relatedNews"/>
	<acme:form-textarea code="administrator.news.form.label.body" path="body"/>
	
	<jstl:if test="${command=='create' }">
	<acme:form-checkbox  code="administrator.news.form.label.accept" path="accept"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" code="administrator.news.form.button.create" 
						action="/administrator/news/create"/>
	
	<acme:form-return code="administrator.news.form.button.return"/>
</acme:form>

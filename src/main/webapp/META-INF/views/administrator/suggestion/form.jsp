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

<acme:form >
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="administrator.suggestion.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="administrator.suggestion.form.label.title" path="title"/>
	<acme:form-textarea code="administrator.suggestion.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.suggestion.form.label.email" path="email"/>
	
	
	

	<acme:form-submit test="${command == 'show'}" code="administrator.suggestion.form.button.update" 
						action="/administrator/suggestion/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.suggestion.form.button.delete" 
						action="/administrator/suggestion/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.suggestion.form.button.create" 
						action="/administrator/suggestion/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.suggestion.form.button.update" 
						action="/administrator/suggestion/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.suggestion.form.button.delete" 
						action="/administrator/suggestion/delete"/>
			
	<acme:form-return code="administrator.suggestion.form.button.return"/>
</acme:form>

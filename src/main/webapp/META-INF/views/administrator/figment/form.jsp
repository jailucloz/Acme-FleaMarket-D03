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
		<acme:form-moment code="administrator.figment.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="administrator.figment.form.label.title" path="title"/>
	<acme:form-textarea code="administrator.figment.form.label.description" path="description"/>
	<acme:form-textbox code="administrator.figment.form.label.inventorName" path="inventorName"/>
	<acme:form-textbox code="administrator.figment.form.label.minMoney" path="minMoney"/>
	<acme:form-textbox code="administrator.figment.form.label.maxMoney" path="maxMoney"/>

	<acme:form-submit test="${command == 'show'}" code = "administrator.figment.form.button.update"
		action = "/administrator/figment/update"/>
		
	<acme:form-submit test="${command == 'show'}" code = "administrator.figment.form.button.delete"
		action = "/administrator/figment/delete"/>
	
	<acme:form-submit test="${command == 'update'}" code = "administrator.figment.form.button.update"
		action = "/administrator/figment/update"/>
		
	<acme:form-submit test="${command == 'delete'}" code = "administrator.figment.form.button.delete"
		action = "/administrator/figment/delete"/>
	
	<acme:form-submit test="${command == 'create'}" code="administrator.figment.form.button.create" 
						action="/administrator/figment/create"/>
			
	<acme:form-return code="administrator.figment.form.button.return"/>
</acme:form>

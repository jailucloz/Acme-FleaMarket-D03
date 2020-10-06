<%--
- form.jsp
-
- Copyright (c) 2019 Aureliano Piqueras, based on Rafael Corchuelo's DP Starter project.
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
	<acme:form-double code="administrator.customisation.form.label.spamThreshold" path="thresholdPercentage" />
	<acme:form-textarea code="administrator.customisation.form.label.spamWords" path="spam" />
	<acme:form-textarea code="administrator.customisation.form.label.itemCategories" path="itemCategories" />
	<acme:form-textarea code="administrator.customisation.form.label.newsCategories" path="newsCategories" />
	
  	<acme:form-return code="administrator.customisation.form.button.return"/>
</acme:form>

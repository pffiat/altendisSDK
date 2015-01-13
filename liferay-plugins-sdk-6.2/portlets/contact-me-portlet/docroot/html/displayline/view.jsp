<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> 
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.kernel.template.TemplateHandler" %>
<%@ page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.altendis.contact.model.Form" %>
<%@ page import="com.altendis.contact.service.FormLocalServiceUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

Liste des formulaires envoyés:



<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= FormLocalServiceUtil.getForms(searchContainer.getStart(), searchContainer.getEnd()) %>"  
		total="<%= FormLocalServiceUtil.getFormsCount() %>"
	/>

	<liferay-ui:search-container-row className="com.altendis.contact.model.Form"	modelVar="aForm">

		<liferay-ui:search-container-column-text property="nom" name="Nom" />
	
		<liferay-ui:search-container-column-text property="entreprise" name="Entreprise" />
	
		<liferay-ui:search-container-column-text property="email" />
	
		<liferay-ui:search-container-column-text property="telephone" name="Telephone" />
	
		<liferay-ui:search-container-column-text property="comment" name="Commentaire" cssClass="lfr-textarea-container"/>
		
		<liferay-ui:search-container-column-date property="createDate" name="Date de création"/>
		
		<liferay-ui:search-container-column-text name="Suppression" >
			<portlet:actionURL var="deleteLineURL" name="deleteLine">
				<portlet:param name="formId" value="${aForm.formId}" />
			</portlet:actionURL>	
			<liferay-ui:icon-delete url="${deleteLineURL}" />
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


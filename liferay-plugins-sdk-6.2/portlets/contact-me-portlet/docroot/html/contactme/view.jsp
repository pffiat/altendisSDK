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

<portlet:defineObjects />
<liferay-theme:defineObjects />


<liferay-ui:success key="success" message="Votre message a été correctement envoyé!" />
<liferay-ui:error key="error" message="Votre message n'a pas pu être correctement envoyé. Merci de remplir le formulaire comme il se doit." />

Vous pouvez poser vos questions ou demander une inscription ici:

<portlet:actionURL name="addForm" var="addFormUrl">
	<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:actionURL>

<aui:form action="${addFormUrl}" name="fm_contactme">

	<aui:fieldset>
		<aui:input name="nom" label="Nom:" >
			<%-- <aui:validator name="required" errorMessage="merci de remplir ce champ"></aui:validator> --%>
			<aui:validator name="custom" errorMessage="simulation-name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\w\s]+$/.test(val);
				}
			</aui:validator>
		</aui:input>

		<aui:input name="entreprise" label="Entreprise:" >
 			<aui:validator name="required" errorMessage="merci de remplir ce champ"></aui:validator>
			<aui:validator name="custom" errorMessage="simulation-name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\w\s]+$/.test(val);
				}
			</aui:validator>
		</aui:input>

		<aui:input name="telephone" label="Numéro de téléphone:">
 			<aui:validator name="required" errorMessage="merci de remplir ce champ"></aui:validator>
			<aui:validator name="maxLength">16</aui:validator>
			<aui:validator name="custom" errorMessage="simulation-telephone-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\d\s]+$/.test(val);
				}
			</aui:validator>
		</aui:input>

		<aui:input name="email" label="Adresse email:">
 			<aui:validator name="required" errorMessage="Merci de remplir ce champ."></aui:validator>
 			<aui:validator name="email" errorMessage="Merci de remplir le champ avec une adresse mail correcte."/>		
		</aui:input>
		
		<aui:input style="width:400px; height:100px;" cssClass= "optional" label="commentaire" name="comment" type="textarea" wrap="soft" wrapperCssClass="lfr-textarea-container" >
 			<aui:validator name="required" errorMessage="merci de remplir ce champ"></aui:validator>			
		</aui:input>
       
		<aui:button onClick="" type="submit" value="send"></aui:button>
	</aui:fieldset>

</aui:form>





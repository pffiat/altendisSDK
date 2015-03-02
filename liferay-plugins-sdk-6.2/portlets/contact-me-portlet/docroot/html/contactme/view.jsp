<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> 
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%-- 
<liferay-ui:success key="success" message="Votre message a été correctement envoyé!" />
<liferay-ui:error key="error" message="Votre message n'a pas pu être correctement envoyé. Merci de remplir le formulaire comme il se doit." />  --%>

<c:set var="send"><liferay-ui:message key="send"></liferay-ui:message></c:set>
<c:set var="to_au"><liferay-ui:message key="to_au"></liferay-ui:message></c:set>
<c:set var="from"><liferay-ui:message key="from"></liferay-ui:message></c:set>
<c:set var="registration"><liferay-ui:message key="registration"></liferay-ui:message></c:set>
<c:set var="comment"><liferay-ui:message key="comment"></liferay-ui:message></c:set>
<c:set var="mail"><liferay-ui:message key="mail"></liferay-ui:message></c:set>
<c:set var="tel"><liferay-ui:message key="tel1"></liferay-ui:message></c:set>
<c:set var="surname"><liferay-ui:message key="surname"></liferay-ui:message></c:set>
<c:set var="name"><liferay-ui:message key="name"></liferay-ui:message></c:set>

<portlet:actionURL name="addForm" var="addFormUrl">
	<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:actionURL>

<aui:form action="${addFormUrl}" name="fm_contactme"> 

	<aui:fieldset>
		<aui:input name="nom" label="${name }:" >
			<aui:validator name="required"></aui:validator> 
			<aui:validator name="custom" errorMessage="name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\w\s]+$/.test(val);
				}
			</aui:validator>
		</aui:input>

		<aui:input name="prenom" label="${surname }:" >
 			<aui:validator name="required"></aui:validator>
			<aui:validator name="custom" errorMessage="name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\w\s]+$/.test(val);
				}
			</aui:validator>
		</aui:input>

		<aui:input name="telephone" label="${tel }:">
 			<aui:validator name="required"></aui:validator>
			<aui:validator name="maxLength">16</aui:validator>
			<aui:validator name="custom" errorMessage="telephone-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\d\s]+$/.test(val);
				}
			</aui:validator>
		</aui:input>

		<aui:input name="email" label="${mail }:">
 			<aui:validator name="required"></aui:validator>
 			<aui:validator name="email"/>		
		</aui:input>
		
		<%--prefill the message if registering to training --%>
		<c:if test="${not empty training}">
			<c:set var="inscription">${ registration} ${training }</c:set>
			
		</c:if>
		<aui:input style="width:400px; height:100px;" cssClass= "optional" label="${comment}" name="comment" type="textarea" wrap="soft" wrapperCssClass="lfr-textarea-container" value="${inscription }" >
 			<aui:validator name="required" ></aui:validator>			
		</aui:input>
       
		<aui:button type="submit" value="${send }"></aui:button>
	</aui:fieldset>

</aui:form>





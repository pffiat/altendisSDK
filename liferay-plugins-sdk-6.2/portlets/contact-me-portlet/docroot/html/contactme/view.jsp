<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> 
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

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
			<aui:validator name="required" errorMessage="merci de remplir ce champ"></aui:validator> 
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
		
		<%--prefill the message if registering to training --%>
		<c:if test="${not empty training && not empty startTraining && not empty endTraining }">
			<jsp:useBean id="start" class="java.util.Date" />
			<jsp:setProperty name="start" property="time" value="${startTraining}" />
			<jsp:useBean id="end" class="java.util.Date" />
			<jsp:setProperty name="end" property="time" value="${endTraining}" />	
			
			<c:set var="inscription">Je souhaite m'inscrire pour la formation "${training }"</c:set>
			
			<c:choose>
			<c:when test="${startTraining+25*60*60*1000 gt endTraining }">
			<c:set var="inscription">${inscription } du <fmt:formatDate value="${end }" dateStyle="long" /></c:set>
			</c:when>
			<c:otherwise>
			<c:set var="inscription">${inscription } du <fmt:formatDate value="${start}" pattern="d" /> au <fmt:formatDate value="${end }" dateStyle="long" /></c:set>
			</c:otherwise>
			</c:choose>
		</c:if>
		<aui:input style="width:400px; height:100px;" cssClass= "optional" label="commentaire" name="comment" type="textarea" wrap="soft" wrapperCssClass="lfr-textarea-container" value="${inscription }" >
 			<aui:validator name="required" errorMessage="merci de remplir ce champ"></aui:validator>			
		</aui:input>
       
		<aui:button onClick="" type="submit" value="send"></aui:button>
	</aui:fieldset>

</aui:form>





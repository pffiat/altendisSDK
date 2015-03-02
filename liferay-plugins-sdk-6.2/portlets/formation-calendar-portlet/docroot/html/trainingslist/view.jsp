<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
 

<c:if test="${empty requestScope.bookings }">
	<p class="text-center text-muted">Aucune prévue pour le moment!</p>
</c:if>
<ul id="training-list" class="list-next-training">
<c:forEach items="${requestScope.bookings}" var="booking">
	<jsp:useBean id="start" class="java.util.Date" />
	<jsp:setProperty name="start" property="time" value="${booking.startTime}" />
	<jsp:useBean id="end" class="java.util.Date" />
	<jsp:setProperty name="end" property="time" value="${booking.endTime}" />	
			
	<c:set var="title" ><liferay-ui:message key="${booking.titleCurrentValue}" /></c:set>
	<c:set var="form" ><liferay-ui:message key="form" /></c:set>
	<c:set var="from"><liferay-ui:message key="from_the"/></c:set>
	<c:set var="to_au"><liferay-ui:message key="jusquau" /></c:set>
	<c:set var="register"><liferay-ui:message key="register" /></c:set>
	
	<c:set var="monthNum"><fmt:formatDate value="${end }" pattern="M" /></c:set>
	<c:set var="month"><liferay-ui:message key="${monthNum}" /></c:set>
	
	<c:set var="date"></c:set>
	<c:choose>
	<c:when test="${booking.startTime+25*60*60*1000 gt booking.endTime }">
	<c:set var="date"><fmt:formatDate value="${end }" pattern="d" /> ${month } <fmt:formatDate value="${end }" pattern="y" /></c:set>
	</c:when>
	<c:otherwise>
	<c:set var="date"><fmt:formatDate value="${start }" pattern="d" /> ${to_au} <fmt:formatDate value="${end }" pattern="d" /> ${month } <fmt:formatDate value="${end }" pattern="y" /></c:set>
	</c:otherwise>
	</c:choose>
	<c:set var="training">${title } ${from } ${date }</c:set>
	<li>${date} : ${title} (Paris) <button class="btn btn-mini to-form" data-training="${training}" data-form="${form }" >${register}</button></li>
</c:forEach>

</ul>

<script type="text/javascript">
AUI().use('aui-base', 'liferay-portlet-url', function(A) {
    A.all(".to-form").each(function() {
        this.on('click', function(event) {
            event.preventDefault();
            
            var portletURL = Liferay.PortletURL.createRenderURL();
            portletURL.setPortletId("contactmeportlet_WAR_contactmeportlet"); 
            portletURL.setParameter("training", this.getData('training'));
            portletURL.setWindowState('pop_up');
        	Liferay.Util.openWindow({
             dialog : {
		                width: 500,
		                height: 700,
            	 		modal : true,
        	           	constrain : true,
        	           	destroyOnClose: true
        	        },
        	        uri : portletURL.toString(),
        	        title : this.getData('form')
            });
        });
    });
});
</script>
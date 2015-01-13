<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<portlet:defineObjects />
 


<c:if test="${empty requestScope.bookings }">
	<p class="text-center text-muted">Aucune prévue pour le moment !</p>
</c:if>
<ul id="training-list" class="list-next-training">
<c:forEach items="${requestScope.bookings}" var="booking">
	<jsp:useBean id="start" class="java.util.Date" />
	<jsp:setProperty name="start" property="time" value="${booking.startTime}" />
	<jsp:useBean id="end" class="java.util.Date" />
	<jsp:setProperty name="end" property="time" value="${booking.endTime}" />	
	
	<c:choose>
	<c:when test="${booking.startTime+25*60*60*1000 gt booking.endTime }">
	<c:set var="date"><fmt:formatDate value="${end }" dateStyle="long" /></c:set>
	</c:when>
	<c:otherwise>
	<c:set var="date"><fmt:formatDate value="${start }" pattern="d" /> au <fmt:formatDate value="${end }" dateStyle="long" /></c:set>
	</c:otherwise>
	</c:choose>
	<li>${date} : ${booking.titleCurrentValue} - Paris <button class="btn btn-mini to-form" data-training="${booking.titleCurrentValue}" data-start="${booking.startTime}" data-end="${booking.endTime}">s'inscrire</button></li>
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
            portletURL.setParameter("start", this.getData('start')); 
            portletURL.setParameter("end", this.getData('end'));
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
        	        title : 'Formulaire de contact'
            });
        });
    });
});
</script>
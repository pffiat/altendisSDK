<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<portlet:defineObjects />
 


<c:if test="${empty requestScope.bookings }">
	<p class="text-center text-muted">Aucune prévue pour le moment !</p>
</c:if>
<c:forEach items="${requestScope.bookings}" var="booking">
<ul class="list-next-training">
	<jsp:useBean id="start" class="java.util.Date" />
	<jsp:setProperty name="start" property="time" value="${booking.startTime}" />
	<jsp:useBean id="end" class="java.util.Date" />
	<jsp:setProperty name="end" property="time" value="${booking.endTime}" />	
	
	<c:choose>
	<c:when test="${booking.startTime+25*60*60*1000 gt booking.endTime }">
	<li><fmt:formatDate value="${end }" dateStyle="long" /> : ${booking.titleCurrentValue} (Paris)</li>
	</c:when>
	<c:otherwise>
	<li><fmt:formatDate value="${start }" pattern="d" /> au <fmt:formatDate value="${end }" dateStyle="long" /> : ${booking.titleCurrentValue} (Paris)</li>
	</c:otherwise>
	</c:choose>
</ul>
</c:forEach>

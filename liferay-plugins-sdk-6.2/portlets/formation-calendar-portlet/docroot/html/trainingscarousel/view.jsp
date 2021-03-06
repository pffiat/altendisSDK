<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<div class="next-formation">
	<div id="myCarousel" >
		<c:forEach items="${bookings}" var="booking" varStatus="status" >
			<jsp:useBean id="start" class="java.util.Date" />
			<jsp:setProperty name="start" property="time" value="${booking.startTime}" />
			<jsp:useBean id="end" class="java.util.Date" />
			<jsp:setProperty name="end" property="time" value="${booking.endTime}" />	
			
			<c:set var="title" ><liferay-ui:message key="${booking.titleCurrentValue}" /></c:set>
			<c:set var="to_au"><liferay-ui:message key="jusquau" /></c:set>
			
			<c:set var="monthNum"><fmt:formatDate value="${end }" pattern="M" /></c:set>
			<c:set var="month"><liferay-ui:message key="${monthNum}" /></c:set>
			
			<c:choose>
				<c:when test="${booking.startTime+25*60*60*1000 gt booking.endTime }">
				<a class="node-content animate-scroll" style="display:none;" href="#${fn:replace(title,' ', '')}">
					${title } (${status.count}/${bookings.size()})<br/><fmt:formatDate value="${end }" pattern="d" /> ${month } <fmt:formatDate value="${end }" pattern="y" /> (Paris)
				</a>
				</c:when>
				<c:otherwise>
				<a class="node-content animate-scroll" style="display:none;" href="#${fn:replace(title,' ', '')}">
					${title } (${status.count}/${bookings.size()})<br/><fmt:formatDate value="${start }" pattern="d" /> ${to_au} <fmt:formatDate value="${end }" pattern="d" /> ${month } <fmt:formatDate value="${end }" pattern="y" /> (Paris)
				</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
</div>

<script type="text/javascript">
AUI().use(
		'aui-base',
		'aui-timer',
		function(Y) {
			//Custom Carousel 
			var carousel = Y.one("#myCarousel");
			if(carousel !== null) {
				var carNodes = carousel.all(".node-content");
				//Hide all
				carNodes.hide();
				//Important data
				var indexCarousel = 0;
				var maxIndex = carNodes.size();
				//show the first node
				if(maxIndex>0) {
					carNodes.item(indexCarousel).show();
				
					if(maxIndex>1) {
						Y.setInterval(function() {
							carNodes.item(indexCarousel++).hide();
					
							if(indexCarousel>maxIndex-1)
								indexCarousel=0;
					
							carNodes.item(indexCarousel).show();
						},3000,null);
					}
				}
			}
		});
</script>
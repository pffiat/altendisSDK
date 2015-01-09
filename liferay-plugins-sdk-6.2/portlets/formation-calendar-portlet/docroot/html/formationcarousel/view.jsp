<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />

<div class="next-formation">
	<div id="myCarousel" >
		<c:forEach items="${bookings}" var="booking" varStatus="status" >
		<jsp:useBean id="start" class="java.util.Date" />
		<jsp:setProperty name="start" property="time" value="${booking.startTime}" />
		<jsp:useBean id="end" class="java.util.Date" />
		<jsp:setProperty name="end" property="time" value="${booking.endTime}" />	
		
		<c:choose>
		<c:when test="${booking.startTime+25*60*60*1000 gt booking.endTime }">
		<a class="node-content animate-scroll" style="display:none;" href="#${fn:replace(booking.titleCurrentValue,' ', '')}">
			${booking.titleCurrentValue } (${status.count}/${bookings.size()})<br/><fmt:formatDate value="${end }" dateStyle="long" /> (Paris)
		</a>
		</c:when>
		<c:otherwise>
		<a class="node-content animate-scroll" style="display:none;" href="#${fn:replace(booking.titleCurrentValue,' ', '')}">
			${booking.titleCurrentValue } (${status.count}/${bookings.size()})<br/><fmt:formatDate value="${start }" pattern="d" /> au <fmt:formatDate value="${end }" dateStyle="long" /> (Paris)
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
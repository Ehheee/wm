<%@include file="include.jsp" %>
<h3>Kanalid</h3>
<ul>
<c:forEach items="${channels}" var="channel" >
	<c:url value="/${channel.name}" var="channelRef" />
	<li><a href="${channelRef }" >${channel.name }</a></li>
</c:forEach>
</ul>
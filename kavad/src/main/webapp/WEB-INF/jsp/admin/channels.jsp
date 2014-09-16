<%@include file="include.jsp" %>
<a href="<c:url value='/admin/channels/0/edit' />" >Lisa uus kanal</a><br />
<c:forEach items="${channels}" var="channel">
	<c:url value="/admin/channels/${channel.id}/edit" var="ref" />
	<a href="${ref}" >${channel.name}</a>--
	<c:url value="/admin/channels/${channel.id}/delete" var="del" />
	<a href="${del}" >  Kustuta</a><br />
</c:forEach>
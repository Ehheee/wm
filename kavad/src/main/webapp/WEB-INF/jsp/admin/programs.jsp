<%@include file="include.jsp" %>
<a href="<c:url value='/admin/programs/0/edit' />" >Lisa uus programm</a><br />
<c:forEach items="${programs}" var="program">
	<c:url value="/admin/programs/${program.id}/edit" var="ref" />
	<a href="${ref}" >${program.name}</a>--
	<c:url value="/admin/programs/${program.id}/delete" var="del" />
	<a href="${del}" >  Kustuta</a><br />
</c:forEach>
<%@include file="include.jsp" %>
<h3>Programmid</h3>
<ul>
<c:forEach items="${programs}" var="program" >
	<c:url value="/programmid/${program.id}" var="programRef" />
	<li><a href="${programRef}" >${program.name}</a></li>
</c:forEach>
</ul>
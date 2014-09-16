<%@include file="include.jsp" %>
<h3>Märksõnad</h3>
<ul>
<c:forEach items="${tags}" var="tag">
	<c:url value="/tags/${tag.name }" var="tagRef" />
	<li><a href="${tagRef}" >${tag.name}</a></li>
</c:forEach>
</ul>
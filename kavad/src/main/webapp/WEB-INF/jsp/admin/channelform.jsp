<%@ include file="include.jsp"%>
<c:choose>
	<c:when test="${channel.id != null }">
		<c:url value="/admin/channels/${channel.id }/edit" var="action" />
	</c:when>
	<c:otherwise>
		<c:url value="/admin/channels/0/edit" var="action" />
	</c:otherwise>
</c:choose>
<c:set var="tagText" value=""></c:set>
<c:forEach items="${channel.tags }" var="tag">
	<c:set var="tagText" value="${tagText}, ${tag.name }" />

</c:forEach>
<form id="channelform" method="post" action="${action }">
	<input type="hidden" name="id" value="${channel.id}" /> 
	Kanali nimi:
	<input type="text" name="name" value="${channel.name }" /><br />
	Kanali kirjeldus:
	<textarea name="description">${channel.description}</textarea><br />
	Märksõnad:
	<input type="text" name="tags" value="${tagText }" /><br />
	<input type="submit" value="salvesta" />
	
</form>
<br />
<c:url value="/admin/programs/0/edit" var="addProgram" >
	<c:param name="channelId">${channel.id}</c:param>
</c:url>
<a href="${addProgram}" >Lisa programm</a>
<h5>Programmid:</h5>
<ul>
<c:forEach items="${channel.programs }" var="program">
	<c:url value="/admin/programs/${program.id}/edit" var="editProgram" />
	<li><a href="${editProgram }" >${program.name}</a>--
	<c:url value="/admin/programs/${program.id}/delete" var="del" />
	<a href="${del}" >  Kustuta</a></li>
</c:forEach>
</ul>
<%@ include file="include.jsp"%>
<c:choose>
	<c:when test="${channel.id != null }">
		<c:url value="/admin/programs/${program.id }/edit" var="action" />
	</c:when>
	<c:otherwise>
		<c:url value="/admin/programs/0/edit" var="action" />
	</c:otherwise>
</c:choose>
<c:set var="tagText" value="" />
<c:forEach items="${program.tags }" var="tag">
	<c:set var="tagText" value="${tagText}, ${tag.name }" />
</c:forEach>
<form method="post" >
<input type="hidden" name="id" value="${program.id}" />
Programmi nimi:<input type="text" name="name" value="${program.name }" /><br />
Märksõnad:<input type="text" name="tags" value="${tagText}" /><br />
Pikkus minutites:<input type="text" name="length" value="${program.length }" /><br />
Kanal:<select name="channel">
<option value="${program.channel.id}" selected="selected">${program.channel.name }</option>
<c:forEach items="${channels}" var="channel" >
<c:if test="${channel.id != program.channel.id }">
<option value="${channel.id}">${channel.name }</option>
</c:if>
</c:forEach>
</select><br />
Eetris:<c:choose>
	<c:when test="${program.enabled }" >
		<input type="checkbox" name="enabled" checked="checked" /> 
	</c:when>
	<c:otherwise>
		<input type="checkbox" name="enabled" /> 
	</c:otherwise>
</c:choose>
<br />
<input type="submit" value="salvesta" />
</form>
<br />
<c:if test="${program.channel.id != null }">
	<c:url value="/admin/channels/${program.channel.id}/edit" var="backToChannel" />
	<a href="${backToChannel }" >Kanali ${program.channel.name} juurde</a><br />
</c:if>
<h5>Algusajad:</h5>
<c:url value="/admin/programs/${program.id}/starttime/0" var="addStartTime" />
<a href="${addStartTime }" >Lisa algusaeg</a>
<ul>
<c:forEach items="${program.startTimes}" var="startTime">
	<c:url value="/admin/programs/${program.id}/starttime/${startTime.id}" var="startTimeRef" />
	<li><a href="${startTimeRef}" ><fmt:formatDate value='${startTime.time}' pattern='dd/MM/yyyy - HH:mm' /></a>
	<c:url value="/admin/programs/${program.id}/starttime/${startTime.id}/delete" var="startTimeDel" />
	<a href="${startTimeDel }" >  Kustuta</a></li>
</c:forEach>
</ul>
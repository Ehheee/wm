<%@include file="include.jsp" %>
<form method="post" >
<input type="hidden" name="id" value="${startTime.id}" />
Aeg:<input type="text" name="time" class="dateTimeInput" id="0${startTime.id }" value="<fmt:formatDate value='${startTime.time}' pattern='dd/MM/yyyy - HH:mm' />" /><br />
Eetris:
<c:choose>
	<c:when test="${startTime.enabled}">
		<input type="checkbox" checked="checked" name="enabled" /><br />
	</c:when>
	<c:otherwise>
		<input type="checkbox" name="enabled" /><br />
	</c:otherwise>
</c:choose>
<input type="hidden" name="program" value="${startTime.program.id }" />
<input type="submit" value="save" /><br />
</form>
<c:url value="/admin/programs/${startTime.program.id}/edit" var="backToProgram" />
<a href="${backToProgram}" >Tagasi programmi juurde</a>
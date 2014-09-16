<%@include file="include.jsp" %>
<h3>${program.name}</h3>

Programmi pikkus: ${program.length} minutit
<h4>Kanal:</h4>
<c:url value="/${program.channel.name}" var="channelRef" />
<a href="${channelRef }" >${program.channel.name}</a>
<h4>Vali ajavahemik:</h4>
<c:url var="action" value="/programmid/${program.id}" />
<form action="${action}" method="get" >
	Algus: <input type="text" id="min" name="start" class="dateTimeInput" />
	Lõpp: <input type="text" id="max" name="end" class="dateTimeInput" />
	<input type="submit" value="saada" />
</form>
<h4>Märksõnad:</h4>
<fmt:formatDate value="${start}" pattern='dd/MM/yyyy - HH:mm' var="start"/>
<fmt:formatDate value="${end}" pattern='dd/MM/yyyy - HH:mm' var="end"/>
<c:forEach items="${program.tags}" var="tag">
	<c:url value="/tags/${tag.name}" var="tagRef" >
		<c:param name="start" value="${start}" />
		<c:param name="end" value="${end}" />
	</c:url>
	<a href="${tagRef}" >${tag.name}</a>, 
</c:forEach>
<ul>
	<c:forEach items="${startTimes }" var="startTime">
		<li>
		<c:url value="/programmid/${startTime.program.id}" var="programRef" />
		<fmt:formatDate value='${startTime.time}' pattern='dd/MM - HH:mm'/> --  <a href="${programRef}" >${startTime.program.name}</a>
		</li>
	</c:forEach>
</ul>
<%@include file="include.jsp" %>
<h3>${tag.name }</h3>
<h4>Vali ajavahemik:</h4>
<c:url var="action" value="/tags/${tag.name}" />
<form action="${action}" method="get" >
	Algus: <input type="text" id="min" name="start" class="dateTimeInput" />
	Lõpp: <input type="text" id="max" name="end" class="dateTimeInput" />
	<input type="submit" value="saada" />
</form>
<h4>Kanalid:</h4>
<c:forEach items="${channels}" var="channel">
	<c:url value="/${channel.name}" var="channelRef" />
	<a href="${channelRef}" >${channel.name}</a>, 
</c:forEach>
<c:if test="${programs != null}">
	<h4>Programmid:</h4>
	<c:forEach items="${programs}" var="program" >
		<c:url value="/programmid/${program.id}" var="programRef" />
		<a href="${programRef}" >${program.name}</a>, 
	</c:forEach>
</c:if>
<ul>
	<c:forEach items="${startTimes }" var="startTime">
		<li>
		<c:url value="/programmid/${startTime.program.id}" var="programRef" />
		<fmt:formatDate value='${startTime.time}' pattern='dd/MM - HH:mm'/> --  <a href="${programRef}" >${startTime.program.name}</a>
		</li>
	</c:forEach>
</ul>
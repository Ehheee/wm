<%@include file="include.jsp" %>
<c:forEach items="${week}" var="day" >
	<fmt:formatDate value="${day.key}" pattern='dd/MM/yyyy - HH:mm' var="formattedDate"/>
	<c:url value="/${channel.name}" var="dayRef" >
		<c:param name="start" value="${formattedDate}"></c:param>
	</c:url>
	<a href="${dayRef}">${day.value}</a>
</c:forEach>
<c:url var="action" value="/${channel.name}" />
<h4>Vali ajavahemik:</h4>

<form action="${action}" method="get" >
	Algus: <input type="text" id="min" name="start" class="dateTimeInput" />
	Lõpp: <input type="text" id="max" name="end" class="dateTimeInput" />
	<input type="submit" value="saada" />
</form>
<h3>${channel.name}</h3>
<ul>
	<c:forEach items="${startTimes }" var="startTime">
		<li>
		<c:url value="/programmid/${startTime.program.id}" var="programRef" />
		<fmt:formatDate value='${startTime.time}' pattern='dd/MM - HH:mm'/> --  <a href="${programRef}" >${startTime.program.name}</a>
		(
		<c:forEach items="${startTime.program.tags}" var="tag" >
			<c:url value="/tags/${tag.name}" var="tagRef" />
			<a href="${tagRef}" >${tag.name}</a>; 
		</c:forEach>
		)
		</li>
	</c:forEach>
</ul>
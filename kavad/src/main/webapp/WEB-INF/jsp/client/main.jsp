<%@ include file="include.jsp" %>

<jsp:include page="header.jsp"></jsp:include>

<div id="container">
<div id="leftMenu">
<jsp:include page="leftmenu.jsp" ></jsp:include>
</div>
<div id="content">
<jsp:include page="${jspContent}" ></jsp:include>
</div>


<jsp:include page="footer.jsp"></jsp:include>
</div>

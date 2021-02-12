<jsp:include page="/WEB-INF/header.jsp" />
<%@ page import="fr.albapretiosa.dao.*"%>
<title>Vue Administrateur - AlbaPretiosa</title>
<!-- Alain : pas de référencement sur cette page bien entendu-->    

</head>
<body>
<jsp:include page="/WEB-INF/navbar.jsp" />
<div class="yellow_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="title">
					<h2>Vue administrateur ( Alain )</h2>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="notification-div">
	<form action="<%= request.getContextPath()%>/PublierNotif" method="post" class="form-example">
		<label for="objet">Objet : </label><br>
		<input type="text" id="objet" name="objet" required>
		<br>
		<label for="message">Message : </label><br>
		<textarea id="message" name="message" required></textarea>
		<button type="submit" class="btn btn-success">Publier</button>
	</form>
</div>
<form class="bannissement" action="<%=request.getContextPath()%>/bannissement" method="post">
	<%= Dao.selectAbo() %><br>
	<button type="submit" class="btn btn-warning">Bannir !</button>
</form>






<jsp:include page="/WEB-INF/footer.jsp"/>
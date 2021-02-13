<%@page import="fr.albapretiosa.metier.zak.Annonce"%>
<%@page import="fr.albapretiosa.dao.Dao"%>
<%@page import="fr.albapretiosa.util.*"%>
<jsp:include page="/WEB-INF/header.jsp" />
<title>Page erreur</title>
</head>

<body class="main-layout about_page">
<jsp:include page="/WEB-INF/navbar.jsp" />
		<div class="container">
			<div class="row errordiv">
				<img  alt="Error.jpg" width="500" height="500" src="<%=request.getContextPath()%>/assets/images/Error.jpg">
				<div class="col text-center textError">
					<% String message2 = (String)request.getAttribute("message");
					   if (message2 == null) message2 = "La page est introuvable";%>
					<h2 class="titreError">OOPS, Une erreur s'est produite</h2>
					<h3 class="titreError2"><%= message2 %></h3>
				</div>
			</div>
		</div>
<jsp:include page="/WEB-INF/footer.jsp"/>
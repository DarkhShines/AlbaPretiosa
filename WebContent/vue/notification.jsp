<jsp:include page="/WEB-INF/header.jsp" />
<%@ page import="fr.albapretiosa.dao.*"%>
<title>Notification - AlbaPretiosa</title>
 <!-- Alain : A l'avenir le titre de cette page sera dynamique,
 	  Le titre de l apage sera le titre de l'annonce -->
<!-- Alain : Référencement -->    
<meta name="keywords" content="notif, message, à lire d'urgence, viiiiiiite">
 <!-- Alain : A l'avenir la description de cette page sera dynamique,
 	  La description de la page sera la description de l'annonce -->
    <meta name="description" content="Bienvenue dans le centre de notification d'appel pretiosa, prenez un verre et delectez vous de ce que l'on vous propose.">
</head>
<body>
<jsp:include page="/WEB-INF/navbar.jsp" />
<div class="yellow_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title">
						<h2>Notification ( Alain )</h2>

					</div>
				</div>
			</div>
		</div>
	</div>

<%= Dao.listNotif() %>
<!-- <div class="notification-div">
	<span class="objetNotif">notification.getObjet()</span>
	<br>
	<p>De : administrateur.getAlias()<br><br>
	   Le : notification.getDate()</p><br><br>
	<p>notification.gettexteNotif()</p>
</div> -->






<jsp:include page="/WEB-INF/footer.jsp"/>
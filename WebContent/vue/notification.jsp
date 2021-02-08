<jsp:include page="/WEB-INF/header.jsp" />
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
<div class="notification-div">
	<h3>notification.getObjet()</h3>
	<p>De : administrateur.getAlias()<br>
	   Le : notification.getDate()</p>
	<p>notification.gettexteNotif()</p>
</div>






<jsp:include page="/WEB-INF/footer.jsp"/>
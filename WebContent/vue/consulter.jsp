<%@page import="fr.albapretiosa.metier.zak.Annonce"%>
<%@page import="fr.albapretiosa.metier.alain.Commentaire"%>
<%@page import="fr.albapretiosa.dao.Dao"%>
<%@page import="fr.albapretiosa.util.*"%>
<jsp:include page="/WEB-INF/header.jsp" />
<title>Consulter une annonce</title>
 <!-- Alain : A l'avenir le titre de cette page sera dynamique,
 	  Le titre de l apage sera le titre de l'annonce -->
<!-- Alain : Référencement -->    
<meta name="keywords" content="louer, vacances, extravagant, riche, penthouse, villa, piscine, magnifique">
 <!-- Alain : A l'avenir la description de cette page sera dynamique,
 	  La description de la page sera la description de l'annonce -->
    <meta name="description" content="Très beau chateau situé en Angleterre. 5000 chambres, inombrables salles de bain. Encore du blabla blabla">
</head>

<body class="main-layout about_page">
<%
	Annonce ann = new Annonce();
	String recup = request.getParameter("idAnnonce");
	int idAnnonce = Integer.parseInt(recup);
	for(Annonce annonce : Dao.getAllAnnonce()){
		System.out.println(annonce.getDescription());
		if(idAnnonce == annonce.getIdAnnonce()){
			ann = annonce;
		}
		
	}
	
%>
<jsp:include page="/WEB-INF/navbar.jsp" />
<script src="https://kit.fontawesome.com/746f19e510.js"></script>
	<div class="yellow_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title">
						<h2>Consulter une annonce ( Alain )</h2>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- form annonce -->
	<div id="container_form">
		<div class="container-fluid">
			<div class="row">
				<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 annonce">
					<div class="grid-form">
					<div class="imgpres">
						<img class="poudlard" alt="Poudlard" src="../assets/images/poudlard.jpg">
						<div class="pres">
							<!-- 
							Alain : Le titre de l'annonce, les images, la déscription, les petits plus 
							et l'intégralité de cette page sera généré automatiquement lorsqu'une annonce
							aura été selectionnée. Une page de codé, des milliers de générées. 
							 -->
							<h3 class="titreann"><%= ann.getTitre() %></h3>
							<p><%= ann.getDescription() %>
							<br><%= ann.getSurface() %>
							<br>Petits plus :<br></p>
							<p>Ce bien est disponnible du <%= UtilAlain.formatDateFr(ann.getCreneauDebut()) %> jusqu'au <%= UtilAlain.formatDateFr(ann.getCreneauFin()) %>, offrez vous des vacances !</p>
							<br>
							<p>Date de début du séjour : </p>
							<input type="date" name="datedebut" value="<%= ann.getCreneauDebut()%>">
							<br><br>
							<p>Date de fin du séjour : </p>
							<input type="date" name="datefin" value="<%= ann.getCreneauFin()%>"><br><br>
							<button type="button" class="btn btn-warning">Réserver</button>
						</div>
					</div>
					<!-- Alain : La section commentaire, permettant d'ajouter, de modifié, de supprimé
					mais également de listé bien entendu. Chaque utilisateur aura un controle total
					sur ces propres commentaires. Dans l'exemple ci-dessous on imagine que "DarkhShines"
					est connecté, lui permettant les actions sur ces commentaires ( les boutons
					n'apparraisse que sur ces commentaires. )
					Un administrateur, lui, pourra supprimé tout les commentaires, mais pas les modifiés
					pour des raisons évidentes.  -->
					<div class="col-xl-5 col-lg-5 col-md-5 col-sm-12 commEntier">
						<%= Dao.listCom() %>
					</div>
					<!-- L'envoi du commentaire sera géré par une servlet  -->
						<form method="POST" action="<%=request.getContextPath()%>/ajoutcomm">
							
								<p>Commentaire :</p>
							
							<div class="divcomm">
								<textarea name="commentaire" class="areacom" cols="50"></textarea>
								<!-- <button type="submit" class="btn btn-warning"><i class="far fa-paper-plane"></i></button> -->
								<a href="<%=request.getContextPath()%>/ajoutcomm?idAnnonce=<%= ann.getIdAnnonce()%>"><i class="far fa-paper-plane"></i></a>
								
							</div>
							
							

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



<jsp:include page="/WEB-INF/footer.jsp"/>
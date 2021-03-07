<%@page import="fr.albapretiosa.metier.zak.Annonce"%>
<%@page import="fr.albapretiosa.metier.alain.Commentaire"%>
<%@page import="fr.albapretiosa.dao.Dao"%>
<%@page import="fr.albapretiosa.servlet.zak.ModifierAnnonceExistante"%>
<%@page import="fr.albapretiosa.util.*"%>
<jsp:include page="/WEB-INF/header.jsp" />
<title>Modifier une annonce</title>
<!-- Alain : A l'avenir le titre de cette page sera dynamique,
 	  Le titre de l apage sera le titre de l'annonce -->
<!-- Alain : Référencement -->
<meta name="keywords"
	content="louer, vacances, extravagant, riche, penthouse, villa, piscine, magnifique">
<!-- Alain : A l'avenir la description de cette page sera dynamique,
 	  La description de la page sera la description de l'annonce -->
<meta name="description"
	content="Très beau chateau situé en Angleterre. 5000 chambres, inombrables salles de bain. Encore du blabla blabla">
</head>

<body class="main-layout about_page">
<% Annonce an = (Annonce) request.getAttribute("an"); %>
	<jsp:include page="/WEB-INF/navbar.jsp" />
	<script src="https://kit.fontawesome.com/746f19e510.js"></script>
	<div class="yellow_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title">
						<h2>Modifier vos Annnoces</h2>

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
							<img class="poudlard" alt="Poudlard"
								src="../assets/images/poudlard.jpg">
							<div class="pres">
								<!-- 
							Alain : Le titre de l'annonce, les images, la déscription, les petits plus 
							et l'intégralité de cette page sera généré automatiquement lorsqu'une annonce
							aura été selectionnée. Une page de codé, des milliers de générées. 
							 -->
								<form method="Post" action="<%=request.getContextPath()%>/ModifAnnonce?id=<%= an.getIdAnnonce()%>">
								
									<p>Titre</p>
									<input type="text" name="titre" value="<%= an.getTitre()%>"/> 
									<br><p>Surface</p>
									<input type="number" name="surface" value="<%= an.getSurface()%>"/>
									<br><p>Description</p>
									<input type="text" name="description" value="<%= an.getDescription()%>" /> 

									<br>
									<p>Date de début du séjour :</p>
									<input type="date" name="datedebut" value="<%= an.getCreneauDebut()%>"> <br>
									<br>
									<p>Date de fin du séjour :</p>
									<input type="date" name="datefin" value="<%= an.getCreneauFin()%>"><br>
									<br>
									<button type="submit" class="btn btn-warning" >Modifier</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<jsp:include page="/WEB-INF/footer.jsp" />
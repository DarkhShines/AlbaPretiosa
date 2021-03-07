<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="fr.albapretiosa.metier.nico.*"%>
<%@ page import="fr.albapretiosa.metier.zak.*"%>
<%@ page import="fr.albapretiosa.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- bootstrap css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/Zak_CSs.css">
<!-- style css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/style.css">
<!-- responsive-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/responsive.css">
<!-- awesome fontfamily -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>AlbaPretiosa/Liste de mes annonces</title>
</head>
<body>
	<jsp:include page="/WEB-INF/navbar.jsp"></jsp:include>

	<div class="yellow_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title">
						<h2>Liste de mes annonces</h2>
						<%
							Abonne abonne = (Abonne) session.getAttribute("Abonne");
							Annonces listeAn = (Annonces) request.getAttribute("liste");

						if (abonne != null) {
						%>
						<h3>
							<strong> Bonjour <br> <%=abonne.getPrenom()%> <%=abonne.getNom()%></strong>
						</h3>

					</div>
				</div>
			</div>
		</div>
	</div>

	<section class="resip_section">
		<div class="container">
			<div class="row">

				<div class="col-md-12">
					<div class="col-md-6 offset-md-3">

						<br>
						<div class="limiter">
							<div class="container-table100">
								<div class="wrap-table100">
									<div class="table100">
										<table>
											<thead>
												<tr>
													<th>ID Annonce</th>
													<th>Titre</th>
													<th>Date début</th>
													<th>Date fin</th>
													<th>Modifier</th>
													<th>Supprimer</th>
												</tr>
											</thead>

											<%
											// Je n'ai pas reussi à la faire passer par la Servlet
											// J'ai donc choisi d'utiliser la dao tout en sachant que ce n'est pas son role
												for (Annonce ann : Dao.getAllAnnonceById(abonne)) {
											%>
											<tr>
												<td class="column1"><%=ann.getIdAnnonce()%></td>
												<td class="column2"><%=ann.getTitre()%></td>
												<td class="column3"><%=ann.getCreneauDebut()%></td>
												<td class="column4"><%=ann.getCreneauFin()%></td>
												<td class="column5"><a
													href="<%=request.getContextPath() + "/ModifAnnonce?id=" + ann.getIdAnnonce()%>"><img
														src="<%=request.getContextPath()%>/assets/images/modifier.png" /></a></td>
												<td class="column5"><a
													href="<%=request.getContextPath() + "/SupprimerAnnonce?id=" + ann.getIdAnnonce()%>"><img
														src="<%=request.getContextPath()%>/assets/images/delete.png" /></a></td>
											</tr>
											<%
												}
											}
											%>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
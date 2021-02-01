<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>



<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<!-- header -->
<header>
	<!-- Sidebar  -->
	<!--/ Nav Star /-->
	<nav
		class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
		<div class="container">
			<div class="navbar-collapse collapse justify-content-end"
				id="navbarDefault">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">Accueil</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Consulter</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="page_Zak.html">Déposer Annonce</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Espace
							Abonné</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--/ Nav End /-->

</header>
<!-- end header -->

<div class="yellow_bg">
	<div class="title">
		<h2 id="titre_annonce">Consulter mes annonces</h2>
	</div>
</div>
<table class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
	<thead>
		<tr>
			<th>Img</th>
			<th>ID Annonce</th>
			<th>Titre</th>
			<th>Date mise en ligne</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
	</thead>
	<tr>
		<td><img src="<%=request.getContextPath()%>/img/poudlard.jpg" width= "100px" height="auto"></td>
		<td class="column1"><a
			href="<%=request.getContextPath()%>/*annonce.getIdAnnonce()*/"></a>#A15</td>
		<td class="column2">Villa Médicis</td>
		<td class="column3">12/11/2018</td>
		<td class="column4">
			<form method="post"
				action="<%=request.getContextPath()%>/vue/annonce_1.html"><!-- modifAnnonceServlet.java -->
				<button type="submit">
					<img src="../img/modifier.png" alt="modifier annonce">
				</button>
			</form>
		</td>
		<td class="column5">
			<form method="post"
				action="<%=request.getContextPath()%>/supprimerAnnonceServlet.java">
				<button type="submit">
					<img src="../img/delete.png" alt="supprimer annonce">
				</button>
			</form>
		</td>
	</tr>

</table>
<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
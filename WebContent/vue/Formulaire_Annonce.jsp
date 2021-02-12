<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>AlbaPretiosa/Déposer annonce</title>
<meta name="description"
	content="Louez une propriété haut de gamme, chateau, luxueuse villa, loft moderne">
<meta name="author" content="Zakarya D. Bahou">
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
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->

<body class="main-layout about_page">


	<div class="wrapper">

		<div class="sidebar">
			<!-- Sidebar  -->
			<jsp:include page="/WEB-INF/navbar.jsp"></jsp:include>
			<div id="content">
				<!-- header -->
				<header>
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-3">
								<div class="full">
									<a class="logo" href="index.html"><img src=""
										alt="Logo AlbaPretiosa"></a>
								</div>
							</div>
							<div class="col-md-9">
								<div class="full">
									<div class="right_header_info">
										<ul>
											<li><img style="margin-right: 15px;"
												src="<%=request.getContextPath()%>/assets/images/search_icon.png"
												alt="#"></li>
											<li>
												<button type="button" id="sidebarCollapse">
													<img src="<%=request.getContextPath()%>/assets/"
														alt="Logo AlbaPretiosa">
												</button>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</header>
				<!-- end header -->
				<!-- about -->
				<div class="about">
					<div class="row">
						<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
							<div class="about_img">
								<figure>
									<img
										src="<%=request.getContextPath()%>/assets/images/image_deco.jpg"
										alt="Image de décoration">
								</figure>
							</div>
						</div>
						<div
							class="col-xl-5 col-lg-5 col-md-10 col-sm-12 about_img_boxpdnt">
							<div class="about_box">
								<h3>Le Formulaire</h3>
								<p>
									L'annonce doit comporter les informations suivantes: <br>
									Le titre de votre annonce <br> La surface en m² <br>
									La date de début de disponibilité <br> La date de fin de
									disponibilité <br> Le pays où se trouve la propriété <br>
									La ville <br> Les options <br> La description
									détaillé <strong>(plus de détails égales plus
										d'interet)</strong> <br> Importer vos photos
								</p>
							</div>
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div class=" col-md-12">
								<h2>
									<strong class="white">Déposez une Annonce </strong>
								</h2>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
								<!-- FORMULAIRE DE CREATION D'ANNONCE -->
								<form class="main_form" method="post"
									action="<%=request.getContextPath()%>/CreerAnnonce">
									<div class="row">
											<!-- CHAMPS TITRE -->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="titre"><strong class="white">Titre</strong></label>
											<input class="form-control" placeholder="Titre" type="text"
												name="titre" required />
										</div>
											<!-- CHAMPS SURFACE -->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="surface"><strong class="white">Surface
													en m²</strong></label> <input class="form-control" placeholder="Surface"
												type="number" name="surface" min="100" max="112100" required />
										</div>
										<!-- CHAMPS DATE DEBUT -->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="surface"><strong class="white">Début</strong></label>
											<input class="form-control"
												placeholder="Début de disponibilité" type="date"
												name="creneau_debut" required
												pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
										</div>
											<!-- CHAMPS DATE FIN -->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="surface"><strong class="white">Fin</strong></label>
											<input class="form-control"
												placeholder="Fin de disponibilité" type="date"
												name="creneau_fin" required
												pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
										</div>
												<!-- CHAMPS PAYS -->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="surface"><strong class="white">Pays</strong></label>
											<input class="form-control" placeholder="Pays"
												list="liste_pays" name="pays" required />
											<datalist id="liste_pays">
												<option value="France">France</option>
												<option value="Angleterre">Angleterre</option>
												<option value="Italie">Italie</option>
											</datalist>
										</div>
										<!-- CHAMPS VILLE -->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="surface"><strong class="white">Ville</strong></label>
											<input class="form-control" placeholder="Ville"
												list="liste_ville" name="ville" required />
											<datalist id="liste_ville">
												<option value="Marseille">Marseille</option>
												<option value="Paris">Paris</option>
												<option value="Bordeaux">Bordeaux</option>
											</datalist>
										</div>
<!-- 										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="surface"><strong class="white">Ville</strong></label>
											<input class="form-control" placeholder="Ville"
												list="liste_ville" name="ville" required />
											<datalist id="liste_ville">
												<option value="Londres">Londres</option>
												<option value="Manchester">Manchester</option>
												<option value="Liverpool">Liverpool</option>
											</datalist>
										</div>
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="surface"><strong class="white">Ville</strong></label>
											<input class="form-control" placeholder="Ville"
												list="liste_ville" name="ville" required />
											<datalist id="liste_ville">
												<option value="Rome">Rome</option>
												<option value="Florence">Florence</option>
												<option value="Venise">Venise</option>
											</datalist>
										</div> -->
										<!-- CHAMPS OPTION -->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">

											<label for="surface"><strong class="white">Option</strong></label>
											<div class="checkbox">
												<label for="spa"><strong class="white">SPA</strong></label>
												<input class="form-control" placeholder="Option"
													type="checkbox" name="spa" id="spa" multiple /> <label
													for="golf"><strong class="white">Terrain
														de golf</strong></label> <input class="form-control" placeholder="Option"
													type="checkbox" name="golf" id="golf" multiple /> <label
													for="piscine"><strong class="white">Piscine</strong></label>
												<input class="form-control" placeholder="Option"
													type="checkbox" name="piscine" id="piscine" multiple /> <label
													for="tennis"><strong class="white">Court
														de tennis</strong></label> <input class="form-control" placeholder="Option"
													type="checkbox" name="tennis" id="tennis" multiple />

											</div>
										</div>
										<!-- CHAMPS DESCRIPTION-->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<label for="description"><strong class="white">Description</strong></label>
											<textarea class="textarea" placeholder="Description"
												name="description"></textarea>
										</div>
										<!-- CHAMPS PHOTO-->
										<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
											<div class="img-box">
												<figure>
													<img
														src="<%=request.getContextPath()%>/assets/images/plus_1.jpg"
														alt="Ajout d'une photo" width="3000" height="auto" />
													<input type="file"
														accept="image/png, image/jpeg, image/jpg" value="img_1"
														name="fileName">
												</figure>
											</div>
										</div>
										<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
											<div class="img-box">
												<figure>
													<img
														src="<%=request.getContextPath()%>/assets/images/plus_1.jpg"
														alt="Ajout d'une photo" width="3000" height="auto" />
													<input type="file"
														accept="image/png, image/jpeg, image/jpg" value="img_2"
														name="fileName">
												</figure>
											</div>
										</div>
										<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
											<div class="img-box">
												<figure>
													<img
														src="<%=request.getContextPath()%>/assets/images/plus_1.jpg"
														alt="Ajout d'une photo" width="3000" height="auto" />
													<input type="file"
														accept="image/png, image/jpeg, image/jpg" value="img_3"
														name="fileName">
												</figure>
											</div>
										</div>
										<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
											<div class="img-box">
												<figure>
													<img
														src="<%=request.getContextPath()%>/assets/images/plus_1.jpg"
														alt="Ajout d'une photo" width="3000" height="auto" />
													<input type="file"
														accept="image/png, image/jpeg, image/jpg" value="img_4"
														name="fileName">
												</figure>
											</div>
										</div>
										<!-- VALIDATION-->
										<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
											<input type="submit" class="form-control"
												placeholder="Valider" /> <input type="reset"
												class="form-control" placeholder="Reset">
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-md-12">
							<div class="title"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
							<div class="about_box">
								<h3>
									Visitez votre <br> espace abonné
								</h3>
								<p>Vous pouvez accéder à votre espace abonné pour consulter
									la mise en ligne de votre annonces, ainsi que vos annonces déja
									en ligne. Vous pouvez modifier, supprimer les annonces.</p>
								<a href="<%=request.getContextPath()%>/vue/ListerAnnonce.jsp">Consulter
									mes annonces <i class="fa fa-long-arrow-right"
									aria-hidden="true"></i>
								</a>
							</div>
						</div>
						<div
							class="col-xl-5 col-lg-5 col-md-10 col-sm-12 about_img_boxpdnt">
							<div class="about_img">
								<figure class="white">
									<img src="<%=request.getContextPath()%>/assets/images/nav.jpg"
										alt="fond noir">
								</figure>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end about -->

	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
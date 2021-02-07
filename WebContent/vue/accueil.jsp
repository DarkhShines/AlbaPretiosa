<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/WEB-INF/header.jsp" />

<meta charset="ISO-8859-1">
<title>Accueil Alba & Pretiosa</title>
</head>
<body class="main-layout about_page">
	<jsp:include page="/WEB-INF/navbar.jsp" />



	<!--   CAROUSEL CAROUSEL CAROUSEL  -->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<div class="carousel1">
					<img class="d-block w-100" src="../assets/images/poudlard.jpg"
						alt="First slide">
				</div>

			</div>
			<div class="carousel-item">
				<div class="carousel2">
					<img class="d-block w-100" src="../assets/images/simpsons-live.jpg"
						alt="Second slide">
				</div>
			</div>
			<div class="carousel-item">
				<div class="carousel3">
					<img class="d-block w-100" src="../assets/images/poudlard.jpg"
						alt="Third slide">
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>


	<h2 class="h2accueil">Vous prendriez bien un peu de bon temps ?</h2>

	<jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
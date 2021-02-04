<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="/WEB-INF/header.jsp" />

<meta charset="ISO-8859-1">
<title>Accueil Alba & Pretiosa</title>
</head>
<body class="main-layout about_page">
<jsp:include page="/WEB-INF/navbar.jsp" />
<div class="yellow_bg">
		<div class="container">
			<div class="row1">
				<div class="col-md-12">
					<div class="title">
						<h2>Accueil d'Alba & Pretiosa ( Alain ) </h2>

					</div>
				</div>
			</div>
		</div>
	</div>
<h1>ICI UN CARROUSSEL</h1>  
<div class="grid-container2">
<div class="grid-item2"></div>
<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
  </ol>

  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="test">
      	<img src="../assets/images/poudlard.jpg" class="d-block w-100 carousel" alt="...">
      </div>
      <div class="carousel-caption d-none d-md-block">
        <h5>First slide label</h5>
        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Second slide label</h5>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Third slide label</h5>
        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div class="grid-item2"></div>
</div>

<h2 class="h2accueil">Vous prendriez bien un peu de bon temps ?</h2>

<jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
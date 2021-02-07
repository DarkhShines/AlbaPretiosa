<jsp:include page="/WEB-INF/header.jsp" />
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
	<!-- about -->
	<div class="about">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title">
						<div class="bg-warning rounded col-8 mt-3 mb-3">
							<h2 class="title-span">About Our Food & Restaurant</h2>
							<span class="span-middle">It is a long established fact
								that a reader will be distracted by the readable content of a <br>
								page when looking at its layout. The point of using Lorem
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
					<div class="about_box">
						<h3>Best Food</h3>
						<p>Contrary to popular belief, Lorem Ipsum is not simply
							random text. It has roots in a piece of classical Latin
							literature from 45 BC, making it over 2000 years old. Richard
							McClintock, a Latin professor at Hampden-Sydney College in
							Virginia, looked up one of the more obscureContrary to popular
							belief, Lorem Ipsum is not simply random text. It has roots in a
							piece of classical Latin literature from 45 BC, making it over
							2000 years old. Richard</p>
					</div>
				</div>
				<div class="col-xl-5 col-lg-5 col-md-10 col-sm-12 about_img_boxpdnt">
					<div class="about_img">
						<figure>
							<img src="../assets/images/simpsons-live.jpg" alt="#/">
						</figure>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end about -->
	<!-- Our Client -->
<div class="Client">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="title">
          <h2 class="text-align-center">Our Client</h2>
        </div>
      </div>
    </div>
    <div class="row mb-4 mt-4">
      <div class="col-md-6 offset-md-3">
         <div class="Client_box">
           <img src="../assets/images/client.jpg" alt="#"/>
           <h3>Roock Due</h3>
           <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which dont look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isnt anything embarrassing hidden in the middle of text.</p>
           <i><img src="../assets/images/client_icon.png" alt="#"/></i>
         </div>
      </div>
    </div>
  </div>
</div>  
<!-- end Our Client -->
	<jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
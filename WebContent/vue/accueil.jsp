<jsp:include page="/WEB-INF/header.jsp" />
<title>Accueil Alba & Pretiosa</title>
<%@page import="fr.albapretiosa.dao.Dao"%>
<%@page import="fr.albapretiosa.metier.zak.*"%>
</head>
<body class="main-layout about_page">
	<jsp:include page="/WEB-INF/navbar.jsp" />

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
		<!--   CAROUSEL CAROUSEL CAROUSEL  -->
	
			<%= Dao.CreateCar() %>
	<!-- end about -->
	<!-- Our Client -->
	<div class="Client">
		<div class="container">
			<div class="row mb-4 mt-4">
				<div class="col-md-6 offset-md-3">
					<div class="Client_box">
						<img src="../assets/images/client.jpg" alt="#" />
						<h3>Roock Due</h3>
						<p>There are many variations of passages of Lorem Ipsum
							available, but the majority have suffered alteration in some
							form, by injected humour, or randomised words which dont look
							even slightly believable. If you are going to use a passage of
							Lorem Ipsum, you need to be sure there isnt anything embarrassing
							hidden in the middle of text.</p>
						<i><img src="../assets/images/client_icon.png" alt="#" /></i>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end Our Client -->
	<jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
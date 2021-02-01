<jsp:include page="/WEB-INF/header.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/navbar.jsp" />


	<!-- FORMULAIRE D'INSCRIPTION -->
	<div class="content-inscription container">
		<div class="shadow-sm p-3 mb-5 bg-warning rounded">
			<h1 class="titre-inscription mb-4">Inscription</h1>

			<form class="form-inscription" action="#" method="post">

				<div class="form-row pl-2 justify-content-center">
					<div class="form-group col-md-4">
						<label for="nom">Nom</label> <input type="text"
							class="form-control" id="nom" name="nom" placeholder="Nom"
							required>
					</div>
					<div class="form-group col-md-4">
						<label for="prenom">Prenom</label> <input type="text"
							class="form-control" id="prenom" name="Prenom"
							placeholder="prenom" required>
					</div>
				</div>

				<div class="form-row pl-2 justify-content-center">
					<div class="form-group col-md-4 ">
						<label for="alias">Alias</label> <input type="text"
							class="form-control" id="alias" name="alias" placeholder="Alias"
							required>
					</div>
					<div class="form-group col-md-4">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email" placeholder="Email"
							required>
					</div>
				</div>
				<div class="form-row pl-2 justify-content-center">
					<div class="form-group col-md-4 ">
						<label for="password">Mot de passe</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Mot de passe" required>
					</div>
					<div class="form-group col-md-4 ">
						<label for="passwordConfirm">Confirmer le mot de passe</label> <input
							type="password" class="form-control" id="passwordConfirm"
							name="passwordConfirm" placeholder="Confirmer" required>
					</div>
				</div>
				<div class="form-row pl-2 justify-content-center">
					<div class="form-group col-md-4 ">
						<label for="parrainage">Parrainage</label> <input type="text"
							class="form-control" id="parrainage" name="parrainage"
							placeholder="Parrainage">
					</div>
					<div class="form-group col-md-4 ">
						<label for="phone">Tel</label> <input type="number"
							class="form-control" id="phone" name="phone"
							placeholder="Numéro de téléphone" required>
					</div>
				</div>
				<div class="form-row pl-2 justify-content-center">
					<div class="form-check mt-3">
						<input type="checkbox" class="form-check-input" id="checkNews"
							name="checkNews"> <label class="form-check-label"
							for="checkNews">J'accepte les termes et conditions
							d'utilisations</label>

					</div>
					<div class="form-check ml-3 mt-3">
						<input type="checkbox" class="form-check-input" id="checkNews"
							name="checkNews"> <label class="form-check-label"
							for="checkNews">Je m'abonne a la newsletter</label>
					</div>
				</div>
				<div class="form-row pl-2 mt-2 justify-content-center">
					<p>Vous avez déjà un compte ?</p>
					<a href="#">  Connectez-Vous</a>
				</div>
		<div class="form-row pl-2 justify-content-end">
			<button type="submit" class="btn btn-white ml-2 align-self-end">Confirmer</button>
		</div>
		</form>
	</div>
	</div>
	<jsp:include page="/WEB-INF/footer.jsp" />
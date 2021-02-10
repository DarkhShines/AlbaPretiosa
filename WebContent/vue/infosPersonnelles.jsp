<jsp:include page="/WEB-INF/header.jsp" />
<%@ page import="fr.albapretiosa.metier.nico.Abonne"%>
<script src="https://kit.fontawesome.com/56455f0e6e.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/navbar.jsp" />

	<!-- FORMULAIRE DE MODIFICATION/SUPPRESSION DE DONNEES PERSONNELLES -->
	<% 
		HttpSession session1 = request.getSession(true); 
 		Abonne abonne = (Abonne) session.getAttribute("Abonne");
 		String telFixe = abonne.getTelFixe();
 		boolean telFok = false;
 		if(telFixe == null){
 			telFok = true;
 		}
 	%>
	<div class="content-inscription container">
		<h1 class="titre-inscription mb-4">Espace Personnel</h1>

		<!-- 							                      INFOS PERSO                                                            -->
		<form class="form-inscription" action="#" method="post">
			<div class="shadow-sm p-3 mb-5 bg-warning rounded">
				<h2>Informations Personnelles</h2>
				<div class="form-row pl-2 pb-2 justify-content-start">
					<p>Modification du nom et du prénom</p>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4">
						<label for="nom">Nom</label> <input type="text"
							class="form-control" id="nom" name="nom" placeholder="Nom"
							required value="<%= abonne.getNom() %>">
					</div>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4">
						<label for="prenom">Prenom</label> <input type="text"
							class="form-control" id="prenom" name="Prenom"
							placeholder="prenom" required value="<%= abonne.getPrenom() %>">
					</div>
				</div>
			</div>
			<!-- 							ALIAS EST LE PSEUDO POUR SE CONNECTER -->
			<div class="shadow-sm p-3 mb-5 bg-warning rounded">
				<h2>Alias</h2>
				<div class="form-row pl-2 pb-2 justify-content-start"></div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4 ">
						<label for="alias">Alias</label> <input type="text"
							class="form-control" id="alias" name="alias" placeholder="Alias"
							readonly value="<%= abonne.getAlias() %>">
					</div>
				</div>
			</div>
			<!-- 							                     EMAIL                                                         -->
			<div class="shadow-sm p-3 mb-5 bg-warning rounded">
				<h2>Email</h2>
				<div class="form-row pl-2 pb-2 justify-content-start">
					<p>Modification de l'email</p>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email" placeholder="Email"
							required value="<%= abonne.getEmail() %>">
					</div>
				</div>
			</div>
			<!-- 							                    MOT DE PASSE                                                            -->
			<div class="shadow-sm p-3 mb-5 bg-warning rounded">
				<h2>Mot de passe</h2>
				<div class="form-row pl-2 pb-2 justify-content-start">
					<p>Modification du mot de passe</p>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4 ">
						<label for="password">Mot de passe</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Mot de passe" required value="<%= abonne.getMdp() %>">
					</div>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4 ">
						<label for="passwordConfirm">Nouveau mot de passe</label> <input
							type="password" class="form-control" id="newPassword"
							name="newPassword" placeholder="Nouveau mot de passe" required>
					</div>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4 ">
						<label for="passwordConfirm">Confirmer le nouveau mot de passe</label> <input
							type="password" class="form-control" id="passwordConfirm"
							name="passwordConfirm" placeholder="Confirmer" required>
					</div>
				</div>
			</div>
			<!-- 							                      PARRAINAGE                                                          -->
			<div class="shadow-sm p-3 mb-5 bg-warning rounded">
				<h2>Parrainage</h2>
				<div class="form-row pl-2 pb-2 justify-content-start">
					<p>Modification des informations de parrainage (Work In
						Progress)</p>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4 ">
						<label for="parrainage">Parrainage</label> <input type="text"
							class="form-control" id="parrainage" name="parrainage"
							placeholder="Parrainage" value="<%= abonne.getParrainage() %>">
					</div>
				</div>
			</div>
			<!-- 							                      TEL                                                            -->
			<div class="shadow-sm p-3 mb-5 bg-warning rounded">
				<h2>Téléphone</h2>
				<div class="form-row pl-2 pb-2 justify-content-start">
					<p>Modification des différents numéros de téléphones</p>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4 ">
						<label for="phone">Téléphone</label> <input type="number"
							class="form-control" id="phone" name="phone"
							placeholder="Numéro de téléphone" required value="<%= abonne.getTelPortable() %>">
					</div>
				</div>
				<div class="form-row pl-2 justify-content-start">
					<div class="form-group col-md-4 ">
						<label for="phone-fixe">Téléphone fixe </label> <input
							type="number" class="form-control" id="phone-fixe"
							name="phone-fixe" placeholder="Numéro de téléphone fixe" 
							value="<% if(telFok){ abonne.getTelPortable(); } %>">
					</div>
					<span class="trash-bin"><i class="fas fa-trash-alt"></i></span>
				</div>
			</div>
			<div class="form-row pl-2 justify-content-start">
				<button type="submit"
					class="btn btn-warning ml-2 mt-2 align-self-end">Confirmer</button>
			</div>
		</form>
	</div>
	<jsp:include page="/WEB-INF/footer.jsp" />
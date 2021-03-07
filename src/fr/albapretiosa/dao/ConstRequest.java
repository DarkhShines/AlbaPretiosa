package fr.albapretiosa.dao;


public class ConstRequest{

	protected static final String GETANNONCE 		= "select a.idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille, o.lib_option from annonce a"
															+ " inner join ajouter_option ao on a.idAnnonce = ao.idAnnonce"
															+ " inner join options o on ao.idOption = o.idOption "
															+ " where idAbo = ?";
	
	protected static final String GETANNONCEBYID	=  "select a.idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, ab.alias, idVille, o.lib_option from Annonce a"
															+ " inner join abonne ab on a.idAbo = ab.idAbo"
															+ " inner join options o on ao.idOption = o.idOption "
															+ " where idAbo = ?";
<<<<<<< HEAD

	protected static final String GETALLANNONCE 	= "select idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille from Annonce";
	
	protected static final String GETALLANNONCEBYID = "select idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille from Annonce where idAbo = ?";
=======
>>>>>>> refs/remotes/origin/Zakarya_1

	protected static final String GETALLANNONCE 	= "select idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille from Annonce";
	
	protected static final String GETALLANNONCEBYID = "select idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille from Annonce where idAbo = ?";

<<<<<<< HEAD
	protected static final String GET_ABO 			= "select idAbo, alias, nomAbo, prenomAbo, telFixe, telMobile, code_parrainage, email from abonne where alias = ? and mdp = ?";
	protected static final String GET_ADMIN 		= "select idAdmin, alias, nomAdmin, prenomAdmin, telFixe, telMobile, parrainage, email from admin where alias = ? and mdp = ?";
	protected static final String GET_ADMIN_MDP 	= "select alias, mdp from admin where alias = ?";
	protected static final String GET_ABO_MDP 		= "select alias, mdp from abonne where alias = ?";


=======
>>>>>>> refs/remotes/origin/Zakarya_1
	protected static final String CREATEANNONCE		= "insert into Annonce (idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille)"
															+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	protected static final String DELETEANNONCE		= "delete from annonce where idAnnonce = ?";
	
	protected static final String UPDATEANNONCE		= "update annonce set titreAnnonce = ? , surfaceAnnonce = ? , creneau_debut = ? , creneau_fin = ? , description = ? where idAnnonce = ?  ";

<<<<<<< HEAD
	protected static final String GET_ALL_ABONNES = "select nomAbo, idAbo, prenomAbo, alias, email, telMobile, telFixe, platinium from Abonne";
	protected static final String BAN_ABO = "delete from abonne where idAbo = ?";
	protected static final String DELETE_COM = "delete from commentaire where idCom = ?";

	protected static final String ADD_COMMENTAIRE = "insert into commentaire (com, idAbo, idAnnonce, idCom, dateCom) values(?, ?, ?, ?, ?)";
	protected static final String GET_ALL_COMM = "select idCom, com, dateCom, idAbo, idAnnonce from commentaire";
	protected static final String PUBLIER_NOTIF = "insert into notification (idNotif, objetNotif, textNotif, dateNotif, idAdmin) values(?, ?, ?, ?, ?)";
	protected static final String GET_ALL_NOTIF = "select idNotif, objetNotif, textNotif, dateNotif, idAdmin from Notification";

	
	protected static final String GET_ALL_ADMIN 	= "select nomAdmin, idAdmin, prenomAdmin, alias, email, telMobile, telFixe, platinium from Admin";
	
	
	protected static final String CREATE_ABO		= "insert into abonne (idAbo, nomAbo, prenomAbo, alias, email, telMobile, telFixe, platinium, mdp, code_parrainage, isBan) values(?,?,?,?,?,?,?,?,?,?,?)";
	protected static final String MODIF_ABO			= "update abonne set nomAbo = ?, prenomAbo = ? , email = ?, telMobile = ?, telFixe = ?, mdp = ?, code_parrainage = ? where alias = ?";
	protected static final String MODIF_ADMIN		= "update admin set nomAdmin = ?, prenomAdmin = ?, email = ?, telMobile = ?, telFixe = ?, mdp = ?, parrainage = ? where alias = ?";

	

=======
	protected static final String GET_ABO 			= "select idAbo, alias, nomAbo, prenomAbo from abonne where alias = ? and mdp = ?";
	protected static final String GET_ADMIN 		= "select idAdmin, alias, nomAdmin, prenomAdmin from admin where alias = ? and mdp = ?";

	protected static final String GET_ALL_ABONNES	= "select nomAbo, idAbo, prenomAbo, alias, email, telMobile, telFixe, platinium from Abonne";
	protected static final String BAN_ABO			= "delete from abonne where idAbo = ?";
	protected static final String ADD_COMMENTAIRE 	= "insert into commentaire (com, idAbo, idAnnonce) values(?, ?, ?)";
>>>>>>> refs/remotes/origin/Zakarya_1

}


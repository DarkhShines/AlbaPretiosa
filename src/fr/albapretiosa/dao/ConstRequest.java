package fr.albapretiosa.dao;


public class ConstRequest{
	
	protected static final String GETANNONCE = "select idAnnonce, titreAnnonce, surfaceAnnonce, pays, ville, creneau_debut, creneau_fin, description, piscine, golf, spa, tennis, idAbo where idAbo = ?";


	protected static final String GET_ABO 		= "select idAbo, alias, nomAbo, prenomAbo from abonne where alias = ? and mdp = ?";
	protected static final String GET_ADMIN 	= "select idAdmin, alias, nomAdmin, prenomAdmin from admin where alias = ? and mdp = ?";

	protected static final String GET_ALL_ABONNES = "select nomAbo, idAbo, prenomAbo, alias, email, telMobile, telFixe, platinium from Abonne";
	protected static final String BAN_ABO = "delete from abonne where idAbo = ?";
<<<<<<< HEAD
	protected static final String ADD_COMMENTAIRE = "insert into commentaire (com, idAbo, idAnnonce, idCom, dateCom) values(?, ?, ?, ?, ?)";
=======
	protected static final String ADD_COMMENTAIRE = "insert into commentaire (com, idAbo, idAnnonce) values(?, ?, ?)";

>>>>>>> refs/remotes/origin/nico_3
}

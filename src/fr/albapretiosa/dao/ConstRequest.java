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

	protected static final String GETALLANNONCE 	= "select idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille from Annonce";
	
	protected static final String GETALLANNONCEBYID = "select idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille from Annonce where idAbo = ?";

	protected static final String CREATEANNONCE		= "insert into Annonce (idAnnonce, titreAnnonce, surfaceAnnonce, creneau_debut, creneau_fin, description, idAbo, idVille)"
															+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	protected static final String DELETEANNONCE		= "delete from annonce where idAnnonce = ?";
	
	protected static final String UPDATEANNONCE		= "update annonce set titreAnnonce = ? , surfaceAnnonce = ? , creneau_debut = ? , creneau_fin = ? , description = ? where idAnnonce = ?  ";

	protected static final String GET_ABO 			= "select idAbo, alias, nomAbo, prenomAbo from abonne where alias = ? and mdp = ?";
	protected static final String GET_ADMIN 		= "select idAdmin, alias, nomAdmin, prenomAdmin from admin where alias = ? and mdp = ?";

	protected static final String GET_ALL_ABONNES	= "select nomAbo, idAbo, prenomAbo, alias, email, telMobile, telFixe, platinium from Abonne";
	protected static final String BAN_ABO			= "delete from abonne where idAbo = ?";
	protected static final String ADD_COMMENTAIRE 	= "insert into commentaire (com, idAbo, idAnnonce) values(?, ?, ?)";

}


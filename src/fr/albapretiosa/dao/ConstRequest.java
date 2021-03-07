package fr.albapretiosa.dao;


public class ConstRequest{
	
	protected static final String GETANNONCE = "select idAnnonce, titreAnnonce, surfaceAnnonce, pays, ville, creneau_debut, creneau_fin, description, piscine, golf, spa, tennis, idAbo where idAbo = ?";


	protected static final String GET_ABO 			= "select idAbo, alias, nomAbo, prenomAbo, telFixe, telMobile, code_parrainage, email from abonne where alias = ? and mdp = ?";
	protected static final String GET_ADMIN 		= "select idAdmin, alias, nomAdmin, prenomAdmin, telFixe, telMobile, parrainage, email from admin where alias = ? and mdp = ?";
	protected static final String GET_ADMIN_MDP 	= "select alias, mdp from admin where alias = ?";
	protected static final String GET_ABO_MDP 		= "select alias, mdp from abonne where alias = ?";


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

}

<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/connexion.css">
<body>
    <div class="login-box">
        <h2>Connexion</h2>
        <form method="POST" action="<%=request.getContextPath()%>/ConnexionServlet">
            <div class="user-box">
                <input type="text" name="pseudo" id="pseudo" required>
                <label for="pseudo">Pseudo</label>
            </div>
            <div class="user-box">
                <input type="password" name="password" id="password" required>
                <label for="pseudo">Mot de passe</label>
            </div>
            <!-- Le lien qui suit ne sera pas présent sur la version finale, mais il vous permet aujourd'hui d'accéder à la partie connecté du site. -->
            <a href="vue/consulter.jsp">Lien vers le site</a><br>
            
            
            <a href="vue/inscription.jsp">Pas encore de compte ? Cliquez ici !</a>
            <button type="submit" class="btn-connexion" action="#">Connexion
            </button>
        </form>
    </div>
</body>

</html>
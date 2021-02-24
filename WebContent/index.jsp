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
                <input type="text" name="alias" id="alias" required>
                <label for="alias">Alias</label>
            </div>
            <div class="user-box">
                <input type="password" name="mdp" id="mdp" required>
                <label for="mdp">Mot de passe</label>
            </div>
           
            
            
            <a href="vue/inscription.jsp">Pas encore de compte ? Cliquez ici !</a>
            <button type="submit" class="btn-connexion">Connexion
            </button>
        </form>
    </div>
</body>

</html>
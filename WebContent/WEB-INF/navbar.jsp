<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="fr.albapretiosa.dao.*"%>
<%@ page import="fr.albapretiosa.metier.nico.*"%>
<%


 Abonne abonne = (Abonne) session.getAttribute("Abonne");

%>
<!--/ Nav Star /-->
 <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
        
        <div class="navbar-collapse collapse justify-content-end" id="navbarDefault">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="accueil.jsp">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="consulter.jsp">Consulter</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Formulaire_Annonce.jsp">Déposer une annonce</a>
                </li>
                <% if(abonne != null) { %>
                <li class="nav-item">
                    <a class="nav-link" href="infosPersonnelles.jsp"><%= abonne.getAlias() %></a>
                </li>
                <% } 
                    else {%>
                    <li class="nav-item">
                    <a class="nav-link" href="infosPersonnelles.jsp">Mon espace</a>
                </li>
                 <% } %>
                <li class="nav-item">
                    <a class="nav-link" href="notification.jsp">Notification</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="apropos.jsp">A propos</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!--/ Nav End /-->

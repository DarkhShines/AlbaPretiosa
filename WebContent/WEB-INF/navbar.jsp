<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!--/ Nav Star /-->
 <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
        
        <div class="navbar-collapse collapse justify-content-end" id="navbarDefault">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="../index.html">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="consulter.jsp">Consulter</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Déposer une annonce</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="infosPersonnelles.jsp">Mon Espace</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="apropos.jsp">A propos</a>
                </li>
                <li class="nav-item">
                <!-- Nous avons deux exemples de page d'annonce que nous proposerons au client
                	Une partie du site est différente pour les éléments de Zak, nous souhaitons également 
                	connaître la préférence du client à ce propos.  -->
                    <a class="nav-link" href="consultAnnonce.jsp">Version Zak</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!--/ Nav End /-->

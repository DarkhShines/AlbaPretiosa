<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
        <!-- footer -->

            <div class="footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="lik">
                                <li> <a href="#">Accueil</a></li>
                                <li> <a href="consulter.jsp">Consulter les annonces</a></li>
                                <li> <a href="DepotAnnonce.jsp">Déposer une annonce</a></li>
                                <li> <a href="espaceabonne.jsp">Mon espace</a></li>
                                <li> <a href="apropos.jsp">A propos</a></li>
                            </ul>
                        </div>
                        <div class="col-md-12">
                            <div class="new">
                                <h3>Newsletter</h3>
                                <form class="newtetter">
                                    <input class="tetter" placeholder="Votre email" type="text" name="Votre email">
                                    <button class="submit">Souscrire</button>
                                </form>
                                <p>Alba & Pretiosa tout droits réservés.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <!-- end footer -->


    <div class="overlay"></div>
    <!-- Javascript files-->
    <script src="<%= request.getContextPath() %>/assets/js/jquery.min.js"></script>
    <script src="<%= request.getContextPath() %>/assets/js/popper.min.js"></script>
    <script src="<%= request.getContextPath() %>/assets/js/bootstrap.bundle.min.js"></script>
    <script src="<%= request.getContextPath() %>/assets/js/owl.carousel.min.js"></script>
    <script src="<%= request.getContextPath() %>/assets/js/custom.js"></script>
    <script src="<%= request.getContextPath() %>/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>

    <script src="<%= request.getContextPath() %>/assets/js/jquery-3.0.0.min.js"></script>
   

</body>

</html>
<%@page
	import="org.eclipse.jdt.internal.compiler.ast.Annotation.AnnotationTargetAllowed"%>
<jsp:include page="/WEB-INF/header.jsp" />
<title>Espace Abonne</title>
<%@page import="fr.albapretiosa.dao.Dao"%>
<%@page import="fr.albapretiosa.metier.zak.*"%>
</head>
<body class="main-layout about_page">
	<jsp:include page="/WEB-INF/navbar.jsp" />
	
	
	
	<%= Dao.galerieAnnonce() %>
	
	
	
	
<jsp:include page="/WEB-INF/footer.jsp" />
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="accueil.css" />
    </head>
    
<body>

	<header>

	<div id="topBar">
		<div id="headerLinks"
			style="position: absolute; top: 0; right: 10px; float: right;">
			<%String s = ( (String) session.getAttribute("Admin"));%>
			<%if( (s==null)?true:s.equals("Deco") ){%>
			<form method="get" action="/plateformeGroupe/Connexion">
				<input type="submit" value="Se Connecter">
			</form>
			<form method="get" action="/plateformeGroupe/Inscription">
				<input type="submit" value="S'inscrire">
			</form>
			<%
				} else {
			%>
			<form method="get" action="/plateformeGroupe/Deconnexion">
				<input type="submit" value="Se deconnecter"/>
			</form>
			<%
				}
			%>

		</div>
	</div>



	<li><form method="get" action="/plateformeGroupe/Accueil">
			<input type="submit" value="Accueil">
		</form></li>
	<br />


	<%s = ( (String) session.getAttribute("Admin"));%>
	<%if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/GestionGroupe">
			<input type="submit" value="Gestion des groupes">
		</form></li>
	<br />

	<% }  
	
	s = ( (String) session.getAttribute("Admin"));	
	if( (s==null)?false:s.equals("Oui") ){%>
	<li><form method="get" action="/plateformeGroupe/SaisieEtudiant">
			<input type="submit" value="Saisie Etudiant">
		</form></li>
	<br />
	<% } %>

	<%s = ( (String) session.getAttribute("Admin"));
	String lie = (String) session.getAttribute("Lie");
	if( (s==null)?false:s.equals("Non") && ((lie==null)?true:lie.equals("Non"))){%>
	<li><form method="get" action="/plateformeGroupe/LierCompte">
			<input type="submit" value="Lier le compte">
		</form></li>
	<br />
	<% } %> 

	<li><form method="get" action="/plateformeGroupe/Listeretu">
			<input type="submit" value="Lister Etudiant">
		</form></li>
	<br />
	
	<li><form method="get" action="/plateformeGroupe/Listergrp">
			<input type="submit" value="Lister Groupe">
		</form></li>
	<br />

	<% s = ( (String) session.getAttribute("Admin"));
	if( (s==null)?false:s.equals("Non") ){%>
	<li><form method="get" action="/plateformeGroupe/Newprojet">
			<input type="submit" value="Nouveau Projet">
		</form></li>
	<br />
	<% } %> 
	
	<% s = ( (String) session.getAttribute("Admin"));
	if( (s==null)?false:s.equals("Non") ){%>
	<li><form method="get" action="/plateformeGroupe/JoinProjet">
			<input type="submit" value="Rejoindre un groupe">
		</form></li>
	<br />
	<% } %> 
	
	</header>

        <form method="post" action="Inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>

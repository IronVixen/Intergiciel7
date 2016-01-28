<%@ page pageEncoding="UTF-8" %>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>

<html>

    <head>

        <meta charset="utf-8" />

        <title>Connexion</title>

        <link type="text/css" rel="stylesheet" href="form1.css" />

    </head>

    <body>
	<li><form method="get" action="/plateformeGroupe/Accueil">
			<input type="submit" value="Accueil">
		</form></li>

        <form method="post" action="Connexion">

            <fieldset>

                <legend>Connexion</legend>

                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Adresse email <span class="requis">*</span></label>

                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />

                <span class="erreur">${form.erreurs['email']}</span>

                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>

                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />

                <span class="erreur">${form.erreurs['motdepasse']}</span>

                <br />

                <input type="submit" value="Connexion" class="sansLabel" />

                <br />

                

                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

            </fieldset>

        </form>

    </body>
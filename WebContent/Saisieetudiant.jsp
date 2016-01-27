<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisie Etudiant</title>
</head>
<body>
<form action= "accueil" method="post">
Nom+Prenom+GTD</br>
<textarea rows="5" cols="50" name="letudiant"></textarea></br>
<input type="submit" value="OK">
<input type="hidden" name="op" value="se">
<input type="submit" name="op" value="Retour"> 
<p>
</br>${letudiantbis[0]}
</br>${letudiantbis[1]}
</br>${letudiantbis[2]}
</br>${paramletudiant}
</p>
</form>
</body>
</html>
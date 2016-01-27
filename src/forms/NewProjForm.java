package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import entities.Etudiant;
import entities.Projet;

public final class NewProjForm {
    private static final String CHAMP_NOM    = "nom";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

public String getResultat() {
    return resultat;
}

public Map<String, String> getErreurs() {
    return erreurs;
}

public Projet inscrireProjet( HttpServletRequest request ) {

    String nom = (String) request.getAttribute(CHAMP_NOM );
    Projet proj = new Projet();

    try {

        validationNom( nom );

    } catch ( Exception e ) {

    	e.printStackTrace();
        setErreur( CHAMP_NOM, e.getMessage() );

    }
    proj.setName( nom );

    if ( erreurs.isEmpty() ) {

        resultat = "Succès de l'inscription.";

    } else {

        resultat = "Échec de l'inscription.";

    }

    return proj;

}

private void validationNom( String nom ) throws Exception {

    if ( nom != null && nom.length() < 2 ) {

        throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );

    }

}

/*

 * Ajoute un message correspondant au champ spécifié à la map des erreurs.

 */

private void setErreur( String champ, String message ) {

    erreurs.put( champ, message );

}
}

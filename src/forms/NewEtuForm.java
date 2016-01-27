package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import entities.Etudiant;

public final class NewEtuForm {
    private static final String CHAMP_PRENOM  = "prenom";
    private static final String CHAMP_GTD   = "gtd";
    private static final String CHAMP_NOM    = "nom";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

public String getResultat() {
    return resultat;
}

public Map<String, String> getErreurs() {
    return erreurs;
}

public Etudiant inscrireEtudiant( HttpServletRequest request ) {

    String nom = getValeurChamp( request, CHAMP_NOM );
    
    String prenom = getValeurChamp( request, CHAMP_PRENOM );
    
    String gtd = getValeurChamp( request, CHAMP_GTD );

    System.out.println(nom);
    System.out.println(prenom);

    Etudiant etu = new Etudiant();


    try {

        validationNom( nom );

    } catch ( Exception e ) {

    	e.printStackTrace();
        setErreur( CHAMP_NOM, e.getMessage() );

    }
    etu.setNom( nom );

    try {

        validationPrenom( prenom );

    } catch ( Exception e ) {

    	e.printStackTrace();
        setErreur( CHAMP_PRENOM, e.getMessage() );

    }
    
    etu.setPrenom( prenom );
    
    try {

        validationGtd( gtd );

    } catch ( Exception e ) {

    	e.printStackTrace();
        setErreur( CHAMP_GTD, e.getMessage() );

    }
    
    etu.setGtd( gtd );
    
    
    
    if ( erreurs.isEmpty() ) {

        resultat = "Succès de l'inscription.";

    } else {

        resultat = "Échec de l'inscription.";

    }

    return etu;

}

private void validationNom( String nom ) throws Exception {

    if ( nom != null && nom.length() < 2 ) {

        throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );

    }

}

private void validationPrenom( String prenom ) throws Exception {

    if ( prenom != null && prenom.length() < 2 ) {

        throw new Exception( "Le pr�nom d'utilisateur doit contenir au moins 2 caractères." );

    }

}

private void validationGtd( String gtd ) throws Exception {

    if ( gtd != null && gtd.length() > 1 ) {

        throw new Exception( "Le groupe de TD doit �tre un seul caract�re" );

    }

}
/*

 * Ajoute un message correspondant au champ spécifié à la map des erreurs.

 */

private void setErreur( String champ, String message ) {

    erreurs.put( champ, message );

}

/*

 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu

 * sinon.

 */

private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {

    String valeur = request.getParameter( nomChamp );

    if ( valeur == null || valeur.trim().length() == 0 ) {

        return null;

    } else {

        return valeur.trim();

    }

}
}

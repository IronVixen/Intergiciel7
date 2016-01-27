package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ejb.UtilisateurImpl;
import entities.Utilisateur;

public final class ConnexionForm {

	private static final String CHAMP_EMAIL  = "email";
	private static final String CHAMP_PASS   = "motdepasse";
	private String              resultat;
	private Map<String, String> erreurs      = new HashMap<String, String>();
	private UtilisateurImpl utilisateurImpl;


	public ConnexionForm(UtilisateurImpl utilisateurImpl) {
		super();
		this.utilisateurImpl = utilisateurImpl;
	}

	public String getResultat() {

		return resultat;

	}

	public Map<String, String> getErreurs() {

		return erreurs;

	}

	public Utilisateur connecterUtilisateur( HttpServletRequest request ) {

		/* Récupération des champs du formulaire */

		String email = getValeurChamp( request, CHAMP_EMAIL );

		String motDePasse = getValeurChamp( request, CHAMP_PASS );

		Utilisateur utilisateur = new Utilisateur();

		/* Validation du champ email. */

		try {

			validationEmail( email );

		} catch ( Exception e ) {

	    	e.printStackTrace();
			setErreur( CHAMP_EMAIL, e.getMessage() );

		}

		utilisateur.setEmail( email );

		/* Validation du champ mot de passe. */

		try {

			validationMotDePasse(email, motDePasse );

		} catch ( Exception e ) {

			setErreur( CHAMP_PASS, e.getMessage() );

		}

		utilisateur.setMotDePasse( motDePasse );
		utilisateur.setNom(utilisateurImpl.trouver(email).getNom());
		utilisateur.setAdmin(utilisateurImpl.trouver(email).getAdmin());
		/* Initialisation du résultat global de la validation. */

		if ( erreurs.isEmpty() ) {

			resultat = "Succ�s de la connexion.";

		} else {

			resultat = "�chec de la connexion.";

		}

		return utilisateur;

	}

	/**

	 * Valide l'adresse email saisie.

	 */

	private void validationEmail( String email ) throws Exception {


		Utilisateur user;
		try
		{
			user = utilisateurImpl.trouver(email);
		}
		catch(Exception e)
		{
			user = null;
		}


		if ( (email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) || (user == null)) {

			throw new Exception("Merci de saisir une adresse mail valide.");
		}

	}

	/**

	 * Valide le mot de passe saisi.

	 */

	private void validationMotDePasse(String email, String motDePasse ) throws Exception {

		Utilisateur user;
		try {
			user = utilisateurImpl.trouver(email);
		}
		catch(Exception e)
		{
			user = null;
		}

		if (user != null) 
		{

			if ( motDePasse != null ) {



				if ( motDePasse.length() < 3  ) {

					throw new Exception( "Le mot de passe doit contenir au moins 3 caract�res." );

				}

				if ( user.getMotDePasse() == motDePasse ) {

					throw new Exception("Votre mot de passe est incorrect");

				}

			} else {

				throw new Exception( "Merci de saisir votre mot de passe." );

			}
		}
		else
		{
			throw new Exception("Veuillez entrer une adresse email correcte");
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

			return valeur;

		}

	}

}
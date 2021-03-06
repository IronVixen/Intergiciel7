package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Etudiant;
import entities.Utilisateur;

@Stateless

public class UtilisateurImpl {

    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";

    private static final String PARAM_EMAIL = "email";

    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext( unitName = "pu" )

    private EntityManager em;

    // Enregistrement d'un nouvel utilisateur

    public void creer( Utilisateur utilisateur ) {
    		Utilisateur u = new Utilisateur();
    		u.setEmail(utilisateur.getEmail());
    		u.setMotDePasse(utilisateur.getMotDePasse());
    		u.setNom(utilisateur.getNom());
    		u.setLie("Non");
    		if (utilisateur.getNom().equals("Hagimont"))
    		{
    			u.setAdmin("Oui");
    		}
    		else
    		{
    			u.setAdmin("Non");
    		}
            em.persist(u);
    }

    // Recherche d'un utilisateur à partir de son adresse email

    public Utilisateur trouver( String email ){

        Utilisateur utilisateur = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );
        utilisateur = (Utilisateur) requete.getSingleResult();
        return utilisateur;

    }
    
    public void lierUtilisateur(int id, Utilisateur utilisateur){
    	Etudiant e = em.find(Etudiant.class, id);
    	System.out.println(id);
    	System.out.println(e);
    	utilisateur.setEtudiant(e);
    	utilisateur.setLie("Oui");
    }

}
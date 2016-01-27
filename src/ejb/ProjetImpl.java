package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Groupe;
import entities.Utilisateur;


@Stateless


public class ProjetImpl {

	private static final String PARAM_NAME = "name";

	private static final String JPQL_SELECT_PAR_NAME = "SELECT p FROM Projet p WHERE p.name=:name";
	// Injection du manager, qui s'occupe de la connexion avec la BDD

	@PersistenceContext( unitName = "pu" )

	private EntityManager em;


	public void creer( Groupe projet ) {
		Groupe p = new Groupe();
		p.setName(projet.getName());
		em.persist(p);
	}

	// Recherche d'un utilisateur à partir de son adresse email

	public Groupe trouver( String name ){

		Groupe projet = null;
		Query requete = em.createQuery( JPQL_SELECT_PAR_NAME );
		requete.setParameter( PARAM_NAME, name );
		projet = (Groupe) requete.getSingleResult();
		return projet;

	}

}

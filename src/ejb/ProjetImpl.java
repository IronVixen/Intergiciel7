package ejb;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Etudiant;
import entities.Projet;
import entities.Utilisateur;


@Stateless


public class ProjetImpl {

	private static final String PARAM_NAME = "nom";

	private static final String JPQL_SELECT_PAR_NAME = "SELECT p FROM Projet p WHERE p.name=:name";
	// Injection du manager, qui s'occupe de la connexion avec la BDD

	@PersistenceContext( unitName = "pu" )

	private EntityManager em;


	public void creer( Projet projet ) {
		Projet p = new Projet();
		p.setNom(projet.getNom());
		em.persist(p);
	}

	// Recherche d'un utilisateur à partir de son adresse email

	public Projet trouver( String name ){

		Projet projet = null;
		Query requete = em.createQuery( JPQL_SELECT_PAR_NAME );
		requete.setParameter( PARAM_NAME, name );
		projet = (Projet) requete.getSingleResult();
		return projet;

	}
	
	public Collection<Projet> listeProjets() {
		return em.createQuery("from Projet", Projet.class).getResultList();
	}

}

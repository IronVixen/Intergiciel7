package ejb;

import java.util.Collection;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Etudiant;
import entities.Utilisateur;

@Stateless
public class EtudiantImpl {
   
	@PersistenceContext( unitName = "pu" )
    private EntityManager em;
	
    public void ajoutEtudiant(String nom,String prenom, String gtd) {
    	Etudiant e = new Etudiant();
    	e.setNom(nom);
    	e.setPrenom(prenom);
        em.persist(e);
    }
    
    public void creer( Etudiant etu ) {
		Etudiant e = new Etudiant();
		e.setPrenom(etu.getPrenom());
		e.setGtd(etu.getGtd());
		e.setNom(etu.getNom());
        em.persist(e);
}
    
	public Collection<Etudiant> listeEtudiants() {
		return em.createQuery("from Etudiant", Etudiant.class).getResultList();
	}
}
		
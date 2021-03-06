package entities;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eid;
	
	private String nom;
	private String prenom;
	private String gtd;
	private String aUnGroupe;

	@ManyToOne(targetEntity=Projet.class)
	Projet projet;
	
	@OneToOne(targetEntity=Utilisateur.class)
	Utilisateur utilisateur;
	
	
	
	public String getaUnGroupe() {
		return aUnGroupe;
	}
	public void setaUnGroupe(String aUnGroupe) {
		this.aUnGroupe = aUnGroupe;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Integer getId() {
		return eid;
	}
	public void setId(Integer id) {
		this.eid = id;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getGtd() {
		return gtd;
	}
	public void setGtd(String gtd) {
		this.gtd = gtd;
	}


}

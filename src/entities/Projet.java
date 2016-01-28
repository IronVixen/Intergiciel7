package entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Projet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;
	
	private String nom;
	@OneToMany(targetEntity=Etudiant.class,mappedBy="projet",fetch=FetchType.EAGER)
	Collection<Etudiant> etudiants = new ArrayList<Etudiant>();
	
	
	public Integer getId() {
		return pid;
	}
	public void setId(Integer id) {
		this.pid = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String name) {
		this.nom = name;
	}
    public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public void addEtudiant(Etudiant etudiant)
	{
		etudiants.add(etudiant);
	}
}

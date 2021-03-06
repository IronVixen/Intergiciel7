package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column( name = "nom" )
	private String nom;
    @Column( name = "motDePasse" )
    private String motDePasse;
    @Column( name = "email" )
	private String email;
    @Column( name = "admin")
    private String admin;
    @Column ( name = "lie")
    private String lie;
    
    
    
    public String getLie() {
		return lie;
	}

	public void setLie(String lie) {
		this.lie = lie;
	}

	@OneToOne(targetEntity = Etudiant.class)
    Etudiant etudiant;

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String mdp) {
		this.motDePasse = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	

}

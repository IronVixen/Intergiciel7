package servlets;

//Premi�re de la liste non fini


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.EtudiantImpl;
import ejb.UtilisateurImpl;
import entities.Etudiant;
import entities.Utilisateur;
import forms.InscriptionForm;
import forms.NewEtuForm;

/**
 * Servlet implementation class Listeretu
 */
@WebServlet("/Listeretu")
public class Listeretu  extends HttpServlet{
private static final long serialVersionUID = 1L;      
	
	@EJB
	 private UtilisateurImpl   utilisateurImpl;
	@EJB
	 private EtudiantImpl   etudiantImpl;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Listeretu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		if(session!=null){
			String admin = (String) session.getAttribute("Admin");
			if (admin == null ){
				// Quand on arrive sur le site pour la premi�re fois
				session.setAttribute("Admin", "Deco");
			}
			else
			{
				session.setAttribute("Admin", admin);
			}
		}
		
        // Préparation de l'objet formulaire
        NewEtuForm form = new NewEtuForm();
		request.setAttribute("nom", "Li Britannia");
		request.setAttribute("prenom", "Derp");
		request.setAttribute("gtd", "Z");
		
        // Appel au traitement et à la validation de la requête, et récupération du bean en résultant 
        Etudiant etu = form.inscrireEtudiant( request );
        
        if ( form.getErreurs().isEmpty() ) {
        	etudiantImpl.creer(etu);
        } else {
        	System.out.println("Param�tre d'inscription incorrect");
        }
        
		request.setAttribute("listetu", etudiantImpl.listeEtudiants());
		System.out.println(etudiantImpl.listeEtudiants());
        this.getServletContext().getRequestDispatcher("/WEB-INF/Listeretu.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération du paramètre permettant d'indiquer d'où on vient
		String op = request.getParameter("op");
		
		
		
		//Redirection
		/*
		if(op.equals("Lister")){		
			request.setAttribute("etudiants", etudiantImpl.listeEtudiants());
			request.getRequestDispatcher( "/plateformeGroupe/Lister" ).forward( request, response );	
		}
		
		if(op.equals("Nouveau Projet")){		
			request.getRequestDispatcher( "/plateformeGroupe/Newprojet" ).forward( request, response );	
		}
		
		if(op.equals("Projet")){		
			request.getRequestDispatcher( "/plateformeGroupe/Projet" ).forward( request, response );	
		}
		
		if(op.equals("Saisie Etudiant")){  
			request.getRequestDispatcher( "/plateformeGroupe/SaisieEtudiant" ).forward( request, response ); 
		}
		
		if(op.equals("Accueil")){
			request.getRequestDispatcher( "/plateformeGroupe/Accueil").forward(request, response);
		}
		*/
	}

}

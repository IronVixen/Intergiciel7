package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.EtudiantImpl;
import ejb.ProjetImpl;
import ejb.UtilisateurImpl;
import entities.Etudiant;
import forms.NewEtuForm;
import parseur.Parseur;

@WebServlet("/SaisieEtudiant")
public class SaisieEtudiant extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	 private UtilisateurImpl   utilisateurImpl;
	@EJB
	 private EtudiantImpl   etudiantImpl;
	@EJB
	 private ProjetImpl   projetImpl;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public SaisieEtudiant() {
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
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/SaisieEtudiant.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération du paramètre permettant d'indiquer d'où on vient
		String op = request.getParameter("op");
		
		String listetu = request.getParameter("letudiant");
		System.out.println("COUCOU" + listetu);
		Parseur p = new Parseur(listetu);
		ArrayList<ArrayList<String>> listes = p.parse();
		for(int i = 0 ; i < listes.size(); i++) {
			ArrayList<String> listemp = listes.get(i);

	        // Préparation de l'objet formulaire
	        NewEtuForm form = new NewEtuForm();
			request.setAttribute("nom", listemp.get(0));
			request.setAttribute("prenom", listemp.get(1));
			request.setAttribute("gtd", listemp.get(2));
			
	        // Appel au traitement et à la validation de la requête, et récupération du bean en résultant 
	        Etudiant etu = form.inscrireEtudiant( request );
	        
	        if ( form.getErreurs().isEmpty() ) {
	        	etudiantImpl.creer(etu);
	        } else {
	        	System.out.println("Param�tre d'inscription incorrect");
	        }
		}
        this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward( request, response );
		
	}

}

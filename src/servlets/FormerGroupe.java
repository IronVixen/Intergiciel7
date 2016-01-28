package servlets;

import java.io.IOException;

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
import entities.Utilisateur;
import forms.ConnexionForm;

@WebServlet("/FormerGroupe")
public class FormerGroupe extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
	public static final String ATT_FORM         = "form";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE              = "/WEB-INF/FormerGroupe.jsp";

	// Injection de notre EJB (Session Bean Stateless)
	@EJB
	private UtilisateurImpl   utilisateurImpl;
	@EJB
	private EtudiantImpl   etudiantImpl;
	@EJB
	private ProjetImpl   projetImpl;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		HttpSession session= request.getSession(false);
		if(session!=null){
			String admin = (String) session.getAttribute("Admin");
			if (admin == null ){
				// Quand on arrive sur le site pour la première fois
				session.setAttribute("Admin", "Deco");
			}
			else
			{
				session.setAttribute("Admin", admin);
			}
		}
		request.setAttribute("listproj", projetImpl.listeProjets());
		request.setAttribute("listetu", etudiantImpl.listeEtudiants());

		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		long ide = (Long) request.getAttribute("ide");
		long idp = (Long) request.getAttribute("idp");

		etudiantImpl.lierEtudiantProjet(ide, idp);
				
	}

}

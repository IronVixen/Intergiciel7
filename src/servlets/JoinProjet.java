package servlets;

//Première de la liste non fini


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
import entities.Etudiant;
import entities.Utilisateur;
import forms.InscriptionForm;
import forms.NewEtuForm;

/**
 * Servlet implementation class Listeretu
 */
@WebServlet("/JoinProjet")
public class JoinProjet  extends HttpServlet{
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
    public JoinProjet() {
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
				// Quand on arrive sur le site pour la première fois
				session.setAttribute("Admin", "Deco");
			}
			else
			{
				session.setAttribute("Admin", admin);
			}
		}
		request.setAttribute("session", session);
	

		request.setAttribute("listproj", etudiantImpl.listeEtudiants());
        this.getServletContext().getRequestDispatcher("/WEB-INF/JoinProjet.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String sidp = request.getParameter("idp");
		int idp = Integer.parseInt(sidp);
		HttpSession session = (HttpSession) request.getAttribute("session");
		Utilisateur u = (Utilisateur) session.getAttribute("Utilisateur");
		Etudiant e = u.getEtudiant();
		if (e!=null) {
			etudiantImpl.lierEtudiantProjet((long) e.getId(),(long) idp);
		}
        this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward( request, response );
	}

}

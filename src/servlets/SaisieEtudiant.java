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
			System.out.println(listemp.get(0));
			System.out.println(listemp.get(1));
			System.out.println(listemp.get(2));
		}
		request.getRequestDispatcher( "/SaisieEtudiant.jsp" ).forward( request, response );	
		
	}

}

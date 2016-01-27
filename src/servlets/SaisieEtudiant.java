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
import ejb.UtilisateurImpl;

@WebServlet("/SaisieEtudiant")
public class SaisieEtudiant extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	 private UtilisateurImpl   utilisateurImpl;
	 private EtudiantImpl   etudiantImpl;
    
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
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/Saisieetudiant.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération du paramètre permettant d'indiquer d'où on vient
		String op = request.getParameter("op");
		
		
		/*
		//Redirection
		if(op.equals("se")){		
			String paramletudiant = request.getParameter("letudiant");
			String letudiant_bis[] = new String[6];
			
			// Problème letudiant_bis envoyé marche mais vide du coup voir probleme avec le tableau
			
			//letudiant_bis = paramletudiant.split("\n");		
			etudiantImpl.ajoutEtudiant("Bekrar","Sami");
			System.out.println("Sami qui �crit des trucs");
			request.setAttribute("paramletudiant", paramletudiant);
			request.setAttribute("letudiant_bis", letudiant_bis);
			request.getRequestDispatcher( "/Saisieetudiant.jsp" ).forward( request, response );	
		}
		*/
		/*
		//Redirection
		if(op.equals("Lister")){		
			request.setAttribute("etudiants", etudiantImpl.listeEtudiants());
			request.getRequestDispatcher( "/Lister" ).forward( request, response );	
		}
		
		if(op.equals("Nouveau Projet")){		
			request.getRequestDispatcher( "/Newprojet" ).forward( request, response );	
		}
		
		if(op.equals("Projet")){		
			request.getRequestDispatcher( "/Projet" ).forward( request, response );	
		}
		
		if(op.equals("Accueil")){
			request.getRequestDispatcher( "/Accueil").forward(request, response);
		}
		*/
	}

}

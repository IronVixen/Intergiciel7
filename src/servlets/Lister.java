package servlets;

//Premi�re de la liste non fini


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.EtudiantImpl;
import ejb.UtilisateurImpl;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Lister")
public class Lister  extends HttpServlet{
private static final long serialVersionUID = 1L;      
	
	@EJB
	 private UtilisateurImpl   utilisateurImpl;
	 private EtudiantImpl   etudiantImpl;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Lister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/Lister.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération du paramètre permettant d'indiquer d'où on vient
		String op = request.getParameter("op");
		
		//Redirection
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
	}

}

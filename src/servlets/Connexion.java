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

@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/Connexion.jsp";
    
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

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
    	
    	/* PrÃ©paration de l'objet formulaire */
        ConnexionForm form = new ConnexionForm(utilisateurImpl);

        /* Traitement de la requÃªte et rÃ©cupÃ©ration du bean en rÃ©sultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );
        /* RÃ©cupÃ©ration de la session depuis la requÃªte */
        HttpSession session = request.getSession();
        
        
		String op = request.getParameter("op");
		//Redirection{
		System.out.println(op);
		if(op!= null && op.equals("deco")){	
				System.out.println("Tu as essayé de te déco. Bien tenté.");
				session.setAttribute("Admin","Deco");
				session.setAttribute(ATT_SESSION_USER,null);
				request.removeAttribute(ATT_USER);
				request.getRequestDispatcher( "/Accueil" ).forward( request, response );	
	        }
		else {
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur Ã  la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
        	System.out.println("La connexion est un succès");
            session.setAttribute( ATT_SESSION_USER, utilisateur );
            session.setAttribute("Admin", utilisateur.getAdmin());
            System.out.println(utilisateur.getAdmin());
            this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward( request, response );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }

        
        
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
        
		}
    }
}
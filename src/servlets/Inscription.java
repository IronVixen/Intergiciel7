package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.UtilisateurImpl;
import entities.Utilisateur;
import forms.InscriptionForm;

@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/Inscription.jsp";
    
    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private UtilisateurImpl   utilisateurImpl;
		
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
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
        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Utilisateur utilisateur = form.inscrireUtilisateur( request );
        
        
        if ( form.getErreurs().isEmpty() ) {
        	utilisateurImpl.creer(utilisateur);
        } else {
        	System.out.println("Param�tre d'inscription incorrect");
        }
        
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward( request, response );
        
    }
}

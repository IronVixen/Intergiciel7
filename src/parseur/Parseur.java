package parseur;

import java.util.ArrayList ;	
import java.io.* ;
import java.lang.String;
public class Parseur{
	String texte ;  
	
	public Parseur(String s ){
			this.texte = s ; 
	}
	
	public ArrayList<ArrayList<String>> parse() {
		ArrayList<ArrayList<String>> liste_etus = new ArrayList<ArrayList<String>>();
		BufferedReader br = new BufferedReader(new StringReader(this.texte)) ;  
		String ligne = null ; 
		String champs[];
		try {
			while( (ligne = br.readLine())!=null ){
			
			 champs = ligne.split("\\s+");
				 ArrayList<String> couple = new ArrayList<String>();
				 if(champs.length == 3 ) {
						 // Deux Champs , on suppose que c'est bon (ie que le premier c'est le nom et le second c'est le prénom )
						 couple.add(0,champs[0]);
						 couple.add(1,champs[1]);
						 couple.add(2,champs[2]);
						 liste_etus.add(couple);
				 }
				 else{
					  // plus de deux champs --> nom composé . On part du principe que le nom de famille est écrit en majuscules 
					  String nom = champs[0] ; 
					  String prenom = null ; 
					  int size = champs.length ; 
					  int i = 1 ; 
					  
					   while(i < size && champs[i].equals(champs[i].toUpperCase())) {
						   nom = nom + " " + champs[i] ; 
						   i++ ; 
					   }
					   prenom = champs[i];
					   i++;
					   while(i < size - 1) {
						   prenom = prenom + " " + champs[i] ; 
						   i++ ; 
					   }
					   couple.add(0,nom);
					   couple.add(1,prenom);
					   couple.add(2,champs[size-1]);
					   
					
					   liste_etus.add(couple); 	
					  
				}	
			
}
		} catch (IOException e) {
			e.printStackTrace();
		}  
	return liste_etus ; 
	
}

}


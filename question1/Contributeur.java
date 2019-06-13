package question1;


public class Contributeur extends Cotisant{
  private int solde;
  
  public Contributeur(String nom, int somme)throws RuntimeException{
    super(nom);
      
    if(somme<0){
      throw new RuntimeException
      ("la somme allou�e lors de la cr�ation ne peut �tre n�gative ???");
    }
    
    this.solde = somme;
  }
  
  public int solde(){
    return this.solde;
  }
  
  public int nombreDeCotisants(){

    return 1;
  }
	public void debit(int somme) throws SoldeDebiteurException,RuntimeException{
    if(somme<0)throw new RuntimeException
      ("la somme d�bit�e ne peut �tre n�gative ???");
	  if(somme>this.solde){
      throw new SoldeDebiteurException("solde insuffisante !!!");
    }
    else
	  this.solde-=somme;
	}
  	
	/**
	 * throws RuntimeException new RuntimeException("nombre négatif !!!");
	 */
  public  void credit(int somme)throws RuntimeException{
    if(somme<0)throw new RuntimeException
      ("la somme cr�dit�e ne peut �tre n�gative ???");
	  this.solde+=somme;
	}
	
	/**
	 * throws RuntimeException new RuntimeException("nombre négatif !!!");
	 */
  public void affecterSolde(int somme)throws RuntimeException{
     if(somme <0) throw new RuntimeException
      ("nombre négatif !!!");
    try{
      debit(solde());
       credit(somme); 
    }catch(SoldeDebiteurException sde){ 
      
      this.solde = somme; 
    }
  }
  
  public <T> T accepter(Visiteur<T> visiteur){
    return visiteur.visite(this);
  }
  
  public String toString(){
    return "<Contributeur : " + nom + "," + solde + ">";
  }

}

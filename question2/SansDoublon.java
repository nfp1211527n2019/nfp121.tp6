package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;

public class SansDoublon implements Visiteur<Boolean>{

  private Set<String> Contributeurs = new TreeSet<String>();
   
  private Set<String> Groupes = new TreeSet<String>();




  public Boolean visite(Contributeur c){
    return visiteCont(c);
  }
  
  public Boolean visite(GroupeDeContributeurs g){

    boolean res = visiteCont(g);

        for (Cotisant c : g) {


            if (c instanceof Contributeur) {

                res &= visiteCont((Contributeur)c);

                break;

            } else {

                res &= visite((GroupeDeContributeurs)g);

            }
        }
        return res;
  }

  private Boolean visiteCont(Contributeur c) {

    boolean res = Contributeurs.contains(c.nom());

    if (!res) {

        Contributeurs.contains(c.nom());

    }
    return res;
}

private Boolean visiteCont(GroupeDeContributeurs g) {

    boolean res = Groupes.contains(g.nom());

    if (!res) {

        Groupes.contains(g.nom());

    }
    return res;
}










  
}
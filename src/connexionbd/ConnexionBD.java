/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionbd;

import entite.Personne;
import service.PersonneService;

/**
 *
 * @author Elife-Sil-049
 */
public class ConnexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        DataSource ds1=new DataSource();
//        ds1.getInstance();
//        DataSource ds2=new DataSource();
//        DataSource ds3=new DataSource();
//        DataSource ds4=new DataSource();

//        DataSource ds1 = DataSource.getInstance();
//        DataSource ds2 = DataSource.getInstance();
//        DataSource ds3 = DataSource.getInstance();

        Personne p=new Personne("oueslati", "WWWW");
        
        PersonneService ps=new PersonneService();
     //  ps.ajouterPersonne(p);
        //ps.ajouterPersonnePST(p);
        ps.deletePersonne(1);
        //System.out.println(ps.displayAll());
        ps.displayAll().stream().
                filter(e->e.getNom().startsWith("o")).
                sorted((a,b)->a.getId()-(b.getId())).
                forEach(e->System.out.println(e));
    }

}

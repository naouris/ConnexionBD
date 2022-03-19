/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexionbd.DataSource;
import entite.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elife-Sil-049
 */
public class PersonneService implements IService<Personne>{
    
    private Statement ste;
    private Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;

    public PersonneService() {
        cnx=DataSource.getInstance().getConnection();
    }
    
    public void ajouterPersonne(Personne p){
        String requete="insert into personne (nom,prenom) values ('"+p.getNom()+"','"+p.getPrenom()+"')";
        
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ajouterPersonnePST(Personne p){
        String requete="insert into personne (nom,prenom) values(?,?)";
        
        try {
            pst=cnx.prepareStatement(requete);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public List<Personne> displayAll(){
        String requete="select * from personne";
        List<Personne> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                Personne p=new Personne(rs.getInt(1), rs.getString("nom"), rs.getString(3));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void deletePersonne(int id){
        String requete="delete from personne where id="+id;
        
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void ajouter(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}

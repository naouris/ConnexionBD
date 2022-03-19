/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.PersonneService;

/**
 * FXML Controller class
 *
 * @author Elife-Sil-049
 */
public class AjoutPersonneController implements Initializable {

    @FXML
    private TextField txtn;
    @FXML
    private TextField txtp;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Personne p=new Personne(txtn.getText(), txtp.getText());
        
        PersonneService ps=new PersonneService();
        
        ps.ajouterPersonne(p);
        
    }
    
}

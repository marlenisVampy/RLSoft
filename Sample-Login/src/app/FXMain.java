/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.view.LoginController;
import java.io.InputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class FXMain extends Application {
   /*  @Override
    public void start(Stage stage) throws Exception {

       Parent root = FXMLLoader.load(getClass().getResource("view/LoginView.fxml")); 
        // Parent root = FXMLLoader.load(getClass().getResource("view/DetailsView.fxml"));        
        Scene scene = new Scene(root);        
        stage.setTitle("RLSoft Login");
        stage.setScene(scene);
        stage.show();
    }
    
  */
    
    private Stage stage;    
    
    @Override
    public void start(Stage stage) throws Exception {
         try {
            this.stage = stage;
            stage.setTitle("RLSoft Login");                     
            LoginController login = (LoginController) replaceSceneContent("login/LoginView.fxml");
            login.setStage(stage);            
            stage.show();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }     
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = FXMain.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(FXMain.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, 480,320);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

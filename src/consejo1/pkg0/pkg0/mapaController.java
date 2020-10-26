/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consejo1.pkg0.pkg0;

import MethodConnection.ConnectionUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author yair
 */
public class mapaController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    
    @FXML
    private JFXButton closeLBtn;
    
    @FXML
    private WebView webViewMapa;
    
     @FXML
    private Pane PaneW;
    

    java.sql.ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    java.sql.ResultSet resultSetC = null;
    PreparedStatement preparedStatementC = null;

    public mapaController() {

        //ConnectionUtil connectionUtil = new ConnectionUtil();
        //connection = (Connection) connectionUtil.getConnection();
      
    }
    
     public void loadWebview(WebView webView, Pane pane) throws IOException{
//             Parent root = FXMLLoader.load(getClass().getResource("mapa.fxml"));
       webView = new  WebView();
       WebEngine webEngine = webView.getEngine();
       webEngine.load(getClass().getResource("/mapa/MapaPeru.html").toString());
       
      
          //pane = new Pane(webView);
         Scene scene = new Scene(webView,1000,500);
      Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.show();
        //
     }
    
    Connection connection;

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ventana.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //set mouse pressed
        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        //set mouse drag
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        stage.setScene(scene);
        stage.show();

    }

   @FXML
    private void regresar(ActionEvent event) {

        try {
            changeScreenButtonPushed(event);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    private void colocarImagenBotones() {

        URL linkClose = getClass().getResource("/img/window-close.png");
        URL linkLogout = getClass().getResource("/img/sign-out-alt.png");

        Image imagenClose = new Image(linkClose.toString(), 20, 20, false, true);
        Image imagenLoutOut = new Image(linkLogout.toString(), 20, 20, false, true);
                


        closeLBtn.setGraphic((new ImageView(imagenLoutOut)));
    }
    
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

   

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colocarImagenBotones();
        try {
            loadWebview(webViewMapa, PaneW);
        } catch (IOException ex) {
            Logger.getLogger(mapaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

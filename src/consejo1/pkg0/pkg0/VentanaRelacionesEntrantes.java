/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consejo1.pkg0.pkg0;

import MethodConnection.ConnectionUtil;
import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modeloRanking.RelacionesEntrantes;


/**
 *
 * @author yair
 */
public class VentanaRelacionesEntrantes implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private JFXButton closeVsBtn;

    private ObservableList<RelacionesEntrantes> listRanking;

    private ObservableList<RelacionesEntrantes> listFiltro;

    @FXML
    private TableView<RelacionesEntrantes> consejoData;

    @FXML
    private TableColumn<RelacionesEntrantes, String> cEntidad1;

    @FXML
    private TableColumn<RelacionesEntrantes, Integer> cNFrecuenciaEntidad1;
    
    
    @FXML
    private TableColumn<RelacionesEntrantes, String> cRelaciones;
        
    @FXML
    private TableColumn<RelacionesEntrantes, Integer> cnFrecuenciaRelacion1;
    
   @FXML
    private TableColumn<RelacionesEntrantes, String>   cEntidad2;
    PreparedStatement preparedStatement;
    java.sql.ResultSet resultSet = null;

    String macroRcomboSQL = null;
    String grupoEtarioSQL = null;
    String perfilParticipantesSQL = null;
    String departamentosSQL = null;
    String grupoEtarioDnSQL = null;
    String fuenteSQL = null;
    String discapacidadSQL = null;
    String paternidadSQL = null;
    String gEtnicoSQL = null;
    Connection connection;

   public VentanaRelacionesEntrantes() {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();

    }

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
    private void loutOutMethod(ActionEvent event) {
        try {
            changeScreenButtonPushed(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void colocarImagenBotones() {
        try {
            URL linkLogoutI = getClass().getResource("/img/sign-out-alt.png");
            Image imagenLoutOutI = new Image(linkLogoutI.toString(), 20, 20, false, true);
            closeVsBtn.setGraphic((new ImageView(imagenLoutOutI)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    String SQL = "SELECT `Entidad1`, `nFrecuenciaEntidad1`, `Relaciones`, `nFrecuenciaRelacion1`, `Entidad2` FROM `relaciones_Entrantes`";
  //VentanaController ventanaController= new VentanaController();
    private String SQLF=SQL;
/*public TablaSeparadaController(String SQLF){
    this.SQLF=SQLF;
     SQLF=ventanaController.getSQLF();
    popullateTable(SQLF);

} 
  */  
    public void popullateTable() {
        listRanking = FXCollections.observableArrayList();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();
        try {
            resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(SQLF);
            while (resultSet.next()) {
               
                    RelacionesEntrantes relacionesEntrantes= new RelacionesEntrantes();
                    relacionesEntrantes.setEntidad1(resultSet.getString("Entidad1"));
                        relacionesEntrantes.setNfrecuenciaE1(resultSet.getInt("nFrecuenciaEntidad1"));
                    relacionesEntrantes.setRelaciones(resultSet.getString("Relaciones"));
                    relacionesEntrantes.setNfrecuenciaR1(resultSet.getInt("nFrecuenciaRelacion1"));
                    relacionesEntrantes.setEntidad2(resultSet.getString("Entidad2"));
                    //ranking.setId(resultSet.getInt("id"));
                listRanking.add(relacionesEntrantes);
                cEntidad1.setCellValueFactory(new PropertyValueFactory<>("entidad1"));
               
                cNFrecuenciaEntidad1.setCellValueFactory(new PropertyValueFactory<>("nfrecuenciaE1"));
                cRelaciones.setCellValueFactory(new PropertyValueFactory<>("relaciones"));
                cnFrecuenciaRelacion1.setCellValueFactory(new PropertyValueFactory<>("nfrecuenciaE1"));
                cEntidad2.setCellValueFactory(new PropertyValueFactory<>("entidad2"));
                //  cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                consejoData.setItems(listRanking);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //EtiquetaN.prefWidthProperty().bind(contenedorN.widthProperty());
        //EtiquetaR.prefWidthProperty().bind(contenedorR.widthProperty());
        //contenedorN.prefWidthProperty().bind(vBoxPanelLateral.widthProperty());
        //contenedorR.prefWidthProperty().bind(vBoxPanelLateral.widthProperty());
        colocarImagenBotones();
        popullateTable();
    }
}

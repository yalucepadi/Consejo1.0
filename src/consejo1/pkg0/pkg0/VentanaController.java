package consejo1.pkg0.pkg0;

import MethodConnection.ConnectionUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modeloRanking.Ranking;

public class VentanaController extends TablaSeparadaController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    private double xOffsetIft = 0;
    private double yOffsetIft = 0;

    @FXML
    private ImageView pen;

    @FXML
    private ImageView todosEdu;

    @FXML
    private ImageView abuela;

    @FXML
    private Label panelHeader;

    @FXML
    private HBox contenedorR;

    @FXML
    private VBox vBoxPanelLateral;

    @FXML
    private JFXButton rankingBtn;

    //@FXML
    private JFXButton SepararBtn;

    @FXML
    private JFXButton btnRelacionesEntrantes;

    @FXML
    private JFXButton btnRelacionesSalientes;

    @FXML
    private JFXButton closeBtn;

    @FXML
    private Pane rankingPanel;

    @FXML
    private Pane necesidadesPanel;

    @FXML
    private TableView<Ranking> consejoData;

    // @FXML
    // private TableColumn<Ranking, Integer> cId;
    @FXML
    private TableColumn<Ranking, String> cEntidades;

    @FXML
    private TableColumn<Ranking, Integer> cNMenciones;

    @FXML
    private TableColumn<Ranking, Void> cButtonInfo;

    @FXML
    JFXComboBox<String> macroRcombo;

    ObservableList<String> optionsMc
            = FXCollections.observableArrayList(
                    "todos",
                    "centro 1",
                    "centro 2",
                    "centro 3",
                    "sur 1",
                    "sur 2",
                    "norte 1",
                    "norte 2"
            );

    @FXML
    JFXComboBox<String> grupoEtarioDn;
    ObservableList<String> optionsGeDn
            = FXCollections.observableArrayList(
                    "todos",
                    "adolecencia",
                    "niñez",
                    "primera infacia",
                    "juventud",
                    "adultez",
                    "adultez mayor"
            );

    @FXML
    JFXComboBox<String> fuente;
    ObservableList<String> optionsF
            = FXCollections.observableArrayList(
                    "todos",
                    "encuesta virtual",
                    "jornadas por la educación"
            );
    @FXML
    JFXComboBox<String> grupoEtario;
    ObservableList<String> optionsGe
            = FXCollections.observableArrayList(
                    "todos",
                    "adolecencia",
                    "niñez",
                    "juventud",
                    "adultez",
                    "adultez mayor"
            );
    @FXML
    JFXComboBox<String> perfilParticipantes;
    ObservableList<String> optionsPp
            = FXCollections.observableArrayList(
                    "todos",
                    "Estudiante",
                    "Docente",
                    "Ni estudiante, ni docente",
                    "Docente y estudiante"
            );
    @FXML
    JFXComboBox<String> departamentos;
    ObservableList<String> optionsD
            = FXCollections.observableArrayList(
                    "todos",
                    "Amazonas",
                    "Áncash",
                    "Apurímac",
                    "Arequipa",
                    "Ayacucho",
                    "Cajamarca",
                    "Callao",
                    "Cusco",
                    "Huancavelica",
                    "Huánuco",
                    "Ica",
                    "Junín",
                    "La Libertad",
                    "Lambayeque",
                    "Lima metropolitana",
                    "Lima provincia",
                    "Loreto",
                    "Madre de Dios",
                    "Moquegua",
                    "Pasco",
                    "Piura",
                    "Puno",
                    "San Martín",
                    "Tacna",
                    "Tumbes",
                    "Ucayali"
            );
    @FXML
    JFXComboBox<String> discapacidad;
    ObservableList<String> optionsDisca
            = FXCollections.observableArrayList(
                    "todos",
                    "Si",
                    "No"
            );

    @FXML
    JFXComboBox<String> paternidad;
    ObservableList<String> optionsPat
            = FXCollections.observableArrayList(
                    "todos",
                    "Si",
                    "No"
            );

    @FXML
    JFXComboBox<String> gEtnico;
    ObservableList<String> optionsGeT
            = FXCollections.observableArrayList(
                    "todos",
                    "Castellano",
                    "Lengua Originaria",
                    "Idioma extranjero"
            );

    private ObservableList<Ranking> listRanking;
    private ObservableList<Ranking> listFiltro;

    private ObservableList<Ranking> listInfoFiltro;

    PreparedStatement preparedStatement;
    java.sql.ResultSet resultSet = null;

    String macroRcomboSQL = "";
    String grupoEtarioSQL = "";
    String perfilParticipantesSQL = "";
    String departamentosSQL = "";
    String grupoEtarioDnSQL = "";
    String fuenteSQL = "";
    String discapacidadSQL = "";
    String paternidadSQL = "";
    String gEtnicoSQL = "";

    public void changeScreenButtonPushedVrE(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ventanaRelacionesEntrantes.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //set mouse pressed
        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                xOffsetIft = event.getSceneX();
                yOffsetIft = event.getSceneY();
            }
        });
        //set mouse drag
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffsetIft);
                stage.setY(event.getScreenY() - yOffsetIft);
            }
        });
        stage.setScene(scene);
        stage.show();

    }

    public void changeScreenButtonPushedVrS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ventanaRelacionesSalientes.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //set mouse pressed
        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                xOffsetIft = event.getSceneX();
                yOffsetIft = event.getSceneY();
            }
        });
        //set mouse drag
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffsetIft);
                stage.setY(event.getScreenY() - yOffsetIft);
            }
        });
        stage.setScene(scene);
        stage.show();

    }

    public void changeScreenButtonPushedVi(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("infoTabla.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //set mouse pressed
        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                xOffsetIft = event.getSceneX();
                yOffsetIft = event.getSceneY();
            }
        });
        //set mouse drag
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffsetIft);
                stage.setY(event.getScreenY() - yOffsetIft);
            }
        });
        stage.setScene(scene);
        stage.show();

    }

    public void changeScreenButtonPushedVs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tablaSeparada.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //set mouse pressed
        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                xOffsetIft = event.getSceneX();
                yOffsetIft = event.getSceneY();
            }
        });
        //set mouse drag
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffsetIft);
                stage.setY(event.getScreenY() - yOffsetIft);
            }
        });
        stage.setScene(scene);
        stage.show();

    }

    public VentanaController() {

        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (event.getSource() == rankingBtn) {

            rankingPanel.toFront();
            rankingPanel.setBackground(new Background(new BackgroundFill(Color.rgb(93, 153, 198), CornerRadii.EMPTY, Insets.EMPTY)));
        }

    }

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

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
    Connection connection;

    @FXML
    private void separar(ActionEvent event) {

        try {
            changeScreenButtonPushedVs(event);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void mostrarEntrantes(ActionEvent event) {

        try {
            changeScreenButtonPushedVrE(event);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void mostrarSalientes(ActionEvent event) {

        try {
            changeScreenButtonPushedVrS(event);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String sentenciaSelectFiltro(String tabla) {

        return "SELECT Entidades , NMenciones FROM `" + tabla + "` GROUP by Entidades";
    }
    String SQL = "SELECT Entidades , NMenciones FROM `ranking` GROUP by Entidades";
    String SQLNinez = "SELECT Entidades , NMenciones FROM `ranking_GEtario_ninez` GROUP by Entidades";
    String SQLAdolecencia = "SELECT Entidades , NMenciones FROM `ranking_GEtario_adolecencia` GROUP by Entidades";
    String SQLprimeraInfancia = "SELECT Entidades , NMenciones FROM `ranking_GEtario_primera_infancia` GROUP by Entidades";
    String SQLjuventud = "SELECT Entidades , NMenciones FROM `ranking_GEtario_juventud` GROUP by Entidades";
    String SQLadultez = "SELECT Entidades , NMenciones FROM `ranking_GEtario_adultez` GROUP by Entidades";
    String SQLadultezMayor = "SELECT Entidades , NMenciones FROM `ranking_GEtario_adultez_mayor` GROUP by Entidades";

    public void popullateTable() {
        listRanking = FXCollections.observableArrayList();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();
        try {
            resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(SQL);
            while (resultSet.next()) {
                Ranking ranking = new Ranking();
                ranking.setEntidades(resultSet.getString("Entidades"));
                ranking.setNroMenciones(resultSet.getInt("NMenciones"));
                //ranking.setId(resultSet.getInt("id"));
                listRanking.add(ranking);
                cEntidades.setCellValueFactory(new PropertyValueFactory<>("entidades"));
                cNMenciones.setCellValueFactory(new PropertyValueFactory<>("nroMenciones"));
                //  cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                consejoData.setItems(listRanking);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private String SQLF;

    public String getSQLF() {
        return SQLF;
    }

    public void setSQLF(String SQLF) {
        this.SQLF = SQLF;
    }

    public void filtrarAndPopulateTabla() {
        macroRcomboSQL = filtro(macroRcombo);
        grupoEtarioSQL = filtro(grupoEtario);
        perfilParticipantesSQL = filtro(perfilParticipantes);
        departamentosSQL = filtro(departamentos);
        grupoEtarioDnSQL = filtro(grupoEtarioDn);
        fuenteSQL = filtro(fuente);
        discapacidadSQL = filtro(discapacidad);
        paternidadSQL = filtro(paternidad);
        gEtnicoSQL = filtro(gEtnico);

        SQLF = ("SELECT r.Entidades, count(f.departamento & f.fuente & f.grupoEtario & f.macroregion & f.grupo_etareo_de_participante & f.perfil_de_participante & f.discapacidad  & f.paternidad & f.grupo_étnico) as NMenciones, r.id from ranking  r inner join filtros f WHERE"
                + " f.departamento= " + "'" + departamentosSQL + "'"
                + " or f.fuente=" + "'" + fuenteSQL + "'"
                + " or f.grupoEtario=" + "'" + grupoEtarioSQL + "'"
                + " or f.macroregion=" + "'" + macroRcomboSQL + "'"
                + " or f.grupo_etareo_de_participante=" + "'" + grupoEtarioDnSQL + "'"
                + " or f.perfil_de_participante=" + "'" + perfilParticipantesSQL + "'"
                + " or f.discapacidad=" + "'" + discapacidadSQL + "'"
                + " or f.paternidad=" + "'" + paternidadSQL + "'"
                + " or f.grupo_étnico=" + "'" + gEtnicoSQL + "'" + " GROUP by r.Entidades").toLowerCase();

        String sqlp = "SELECT r.Entidades, count(f.departamento & f.fuente & f.grupoEtario & f.macroregion & f.grupo_etareo_de_participante & f.perfil_de_participante & f.discapacidad  & f.paternidad & f.grupo_étnico) as NMenciones, r.id from ranking  r inner join filtros f WHERE f.departamento= 'Cajamarca' or f.fuente='encuesta virtual' or f.grupoEtario='adolecencia' or f.macroregion='norte 1' or f.grupo_etareo_de_participante='niñez' or f.perfil_de_participante='Estudiante' or f.discapacidad='No' or f.paternidad='Si' or f.grupo_étnico='Castellano'";

        //&& fuenteSQL.equals("encuesta virtual")
        /*  if(grupoEtarioSQL.equals("niñez") ){
             
        setSQLF(SQLNinez);
        System.out.println(SQLNinez);
        listFiltro = FXCollections.observableArrayList();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = (Connection) connectionUtil.getConnection();
        try {
            resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(SQLNinez);
            while (resultSet.next()) {
                Ranking ranking = new Ranking();
                ranking.setEntidades(resultSet.getString("Entidades"));
                ranking.setNroMenciones(resultSet.getInt("NMenciones"));
                // ranking.setId(resultSet.getInt("id"));
                listFiltro.add(ranking);
                cEntidades.setCellValueFactory(new PropertyValueFactory<>("entidades"));
                cNMenciones.setCellValueFactory(new PropertyValueFactory<>("nroMenciones"));
                // cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                consejoData.setItems(listFiltro);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
       
        }
         */
        //1departamento
        if (departamentosSQL != null && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL.equals("todos")
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {
            
           
            
            filtroParaCombo(departamentosSQL, "Amazonas", sentenciaSelectFiltro("ranking_departamento_amazonas"));
            filtroParaCombo(departamentosSQL, "Áncash", sentenciaSelectFiltro("ranking_departamento_áncash"));
            filtroParaCombo(departamentosSQL, "Apurímac", sentenciaSelectFiltro("ranking_departamento_apurímac"));
            filtroParaCombo(departamentosSQL, "Arequipa", sentenciaSelectFiltro("ranking_departamento_arequipa"));
            filtroParaCombo(departamentosSQL, "Ayacucho", sentenciaSelectFiltro("ranking_departamento_ayacucho"));
            filtroParaCombo(departamentosSQL, "Cajamarca", sentenciaSelectFiltro("ranking_departamento_cajamarca"));
            filtroParaCombo(departamentosSQL, "Callao", sentenciaSelectFiltro("ranking_departamento_callao"));
            filtroParaCombo(departamentosSQL, "Cusco", sentenciaSelectFiltro("ranking_departamento_cusco"));
            filtroParaCombo(departamentosSQL, "Huancavelica", sentenciaSelectFiltro("ranking_departamento_huancavelica"));
            filtroParaCombo(departamentosSQL, "Huánuco", sentenciaSelectFiltro("ranking_departamento_huánuco"));
            filtroParaCombo(departamentosSQL, "Ica", sentenciaSelectFiltro("ranking_departamento_ica"));
            filtroParaCombo(departamentosSQL, "Junín", sentenciaSelectFiltro("ranking_departamento_junín"));
            filtroParaCombo(departamentosSQL, "La Libertad", sentenciaSelectFiltro("ranking_departamento_la_libertad"));
            filtroParaCombo(departamentosSQL, "Lambayeque", sentenciaSelectFiltro("ranking_departamento_lambayeque"));
            filtroParaCombo(departamentosSQL, "Lima metropolitana", sentenciaSelectFiltro("ranking_departamento_lima_metropolitana"));
            filtroParaCombo(departamentosSQL, "Lima provincia", sentenciaSelectFiltro("ranking_departamento_lima_provincia"));
            filtroParaCombo(departamentosSQL, "Loreto", sentenciaSelectFiltro("ranking_departamento_loreto"));
            filtroParaCombo(departamentosSQL, "Madre de Dios", sentenciaSelectFiltro("ranking_departamento_madre_de_dios"));
            filtroParaCombo(departamentosSQL, "Moquegua", sentenciaSelectFiltro("ranking_departamento_moquegua"));
            filtroParaCombo(departamentosSQL, "Pasco", sentenciaSelectFiltro("ranking_departamento_pasco"));
            filtroParaCombo(departamentosSQL, "Piura", sentenciaSelectFiltro("ranking_departamento_piura"));
            filtroParaCombo(departamentosSQL, "Puno", sentenciaSelectFiltro("ranking_departamento_puno"));
            filtroParaCombo(departamentosSQL, "San Martín", sentenciaSelectFiltro("ranking_departamento_san_martin"));
            filtroParaCombo(departamentosSQL, "Tacna", sentenciaSelectFiltro("ranking_departamento_tacna"));
            filtroParaCombo(departamentosSQL, "Tumbes", sentenciaSelectFiltro("ranking_departamento_tumbes"));
            filtroParaCombo(departamentosSQL, "Ucayali", sentenciaSelectFiltro("ranking_departamento_ucayali"));
        // inicializarComboItemSelected(departamentos,departamentosSQL);
              //      System.out.println("Departamento selected:"+departamentosSQL);
        }
        //2grupo etario
        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL != null && fuenteSQL.equals("todos")
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {

            filtroParaCombo(grupoEtarioDnSQL, "adolecencia", sentenciaSelectFiltro("ranking_GEtario_adolecencia"));

            filtroParaCombo(grupoEtarioDnSQL, "niñez", SQLNinez);
            filtroParaCombo(grupoEtarioDnSQL, "primera infancia", SQLprimeraInfancia);
            filtroParaCombo(grupoEtarioDnSQL, "juventud", SQLjuventud);
            filtroParaCombo(grupoEtarioDnSQL, "adultez", SQLadultez);
            filtroParaCombo(grupoEtarioDnSQL, "adultez mayor", SQLadultezMayor);
        }

        //3grupo etario de participante
        if (departamentosSQL.equals("todos") && grupoEtarioSQL != null && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL.equals("todos")
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {

            filtroParaCombo(grupoEtarioSQL, "adolecencia", sentenciaSelectFiltro("ranking_GEtario_adolecenciaP"));

            filtroParaCombo(grupoEtarioSQL, "niñez", sentenciaSelectFiltro("ranking_GEtario_ninezP"));
            filtroParaCombo(grupoEtarioSQL, "juventud", sentenciaSelectFiltro("ranking_GEtario_juventudP"));
            filtroParaCombo(grupoEtarioSQL, "adultez", sentenciaSelectFiltro("ranking_GEtario_adultezP"));
            filtroParaCombo(grupoEtarioSQL, "adultez mayor", sentenciaSelectFiltro("ranking_GEtario_adultez_mayorP"));
        }

        //4filtro
        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL != null
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {

            filtroParaCombo(fuenteSQL, "encuesta virtual", sentenciaSelectFiltro("ranking_fuente_encuesta_virtual"));
            filtroParaCombo(fuenteSQL, "jornadas por la educación", sentenciaSelectFiltro("ranking_fuente_jornadas_por_la_educación"));

        }

        //5discapacidad
        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL.equals("todos")
                && discapacidadSQL != null && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {

            filtroParaCombo(discapacidadSQL, "No", sentenciaSelectFiltro("ranking_discapacidad_no"));
            filtroParaCombo(discapacidadSQL, "Si", sentenciaSelectFiltro("ranking_discapacidad_si"));

        }

        //6grupo etnico
        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL.equals("todos")
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL != null) {

            filtroParaCombo(gEtnicoSQL, "Castellano", sentenciaSelectFiltro("ranking_GEtnico_castellano"));
            filtroParaCombo(gEtnicoSQL, "Lengua Originaria", sentenciaSelectFiltro("ranking_GEtnico_lengua_originaria"));
            filtroParaCombo(gEtnicoSQL, "Idioma extranjero", sentenciaSelectFiltro("ranking_GEtnico_idioma_extranjero"));

        }

        //7macro region 
        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL != null && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL.equals("todos")
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {

            filtroParaCombo(macroRcomboSQL, "centro 1", sentenciaSelectFiltro("ranking_Mregion_centro_1"));
            filtroParaCombo(macroRcomboSQL, "centro 2", sentenciaSelectFiltro("ranking_Mregion_centro_2"));
            filtroParaCombo(macroRcomboSQL, "centro 3", sentenciaSelectFiltro("ranking_Mregion_centro_3"));
            filtroParaCombo(macroRcomboSQL, "norte 1", sentenciaSelectFiltro("ranking_Mregion_norte_1"));
            filtroParaCombo(macroRcomboSQL, "norte 2", sentenciaSelectFiltro("ranking_Mregion_norte_2"));
            filtroParaCombo(macroRcomboSQL, "sur 1", sentenciaSelectFiltro("ranking_Mregion_sur_1"));
            filtroParaCombo(macroRcomboSQL, "sur 2", sentenciaSelectFiltro("ranking_Mregion_sur_2"));

        }
        //8Perfil de participante

        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL != null
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL.equals("todos")
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {

            filtroParaCombo(perfilParticipantesSQL, "Estudiante", sentenciaSelectFiltro("ranking_PdeParticipante_estudiante"));
            filtroParaCombo(perfilParticipantesSQL, "Docente", sentenciaSelectFiltro("ranking_PdeParticipante_docente"));
            filtroParaCombo(perfilParticipantesSQL, "Ni estudiante, ni docente", sentenciaSelectFiltro("ranking_PdeParticipante_ni_estudiante_ni_docente"));
            filtroParaCombo(perfilParticipantesSQL, "Docente y estudiante", sentenciaSelectFiltro("ranking_PdeParticipante_docente_y_estudiante"));

        }

        //9Paternidad
        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL.equals("todos") && fuenteSQL.equals("todos")
                && discapacidadSQL.equals("todos") && paternidadSQL != null && gEtnicoSQL.equals("todos")) {

            filtroParaCombo(paternidadSQL, "Si", sentenciaSelectFiltro("ranking_paternidad_si"));
            filtroParaCombo(paternidadSQL, "No", sentenciaSelectFiltro("ranking_paternidad_no"));

        }

        //Fuente GE
        if (departamentosSQL.equals("todos") && grupoEtarioSQL.equals("todos") && macroRcomboSQL.equals("todos") && perfilParticipantesSQL.equals("todos")
                && grupoEtarioDnSQL != null && fuenteSQL != null
                && discapacidadSQL.equals("todos") && paternidadSQL.equals("todos") && gEtnicoSQL.equals("todos")) {
            filtroParaComboPara2(grupoEtarioDnSQL, "adolecencia", fuenteSQL, "encuesta virtual", sentenciaSelectFiltro("ranking_fGE_adolecencia_encuestaVirtual"));
            filtroParaComboPara2(grupoEtarioDnSQL, "niñez", fuenteSQL, "encuesta virtual", sentenciaSelectFiltro("ranking_fGE_ninez_encuestaVirtual"));
            filtroParaComboPara2(grupoEtarioDnSQL, "primera infacia", fuenteSQL, "encuesta virtual", sentenciaSelectFiltro("ranking_fGE_primeraInfancia_encuestaVirtual"));
            filtroParaComboPara2(grupoEtarioDnSQL, "juventud", fuenteSQL, "encuesta virtual", sentenciaSelectFiltro("ranking_fGE_juventud_encuestaVirtual"));
            filtroParaComboPara2(grupoEtarioDnSQL, "adultez", fuenteSQL, "encuesta virtual", sentenciaSelectFiltro("ranking_fGE_adultez_encuestaVirtual"));
            filtroParaComboPara2(grupoEtarioDnSQL, "adultez mayor", fuenteSQL, "encuesta virtual", sentenciaSelectFiltro("ranking_fGE_adultezMayor_encuestaVirtual"));

            filtroParaComboPara2(grupoEtarioDnSQL, "adolecencia", fuenteSQL, "jornadas por la educación", sentenciaSelectFiltro("ranking_fGE_adolecencia_jornadasPorLaEducacion"));
            filtroParaComboPara2(grupoEtarioDnSQL, "niñez", fuenteSQL, "jornadas por la educación", sentenciaSelectFiltro("ranking_fGE_primeraInfancia_jornadasPorLaEducacion"));
            filtroParaComboPara2(grupoEtarioDnSQL, "primera infacia", fuenteSQL, "jornadas por la educación", sentenciaSelectFiltro("ranking_fGE_primeraInfancia_encuestaVirtual"));
            filtroParaComboPara2(grupoEtarioDnSQL, "juventud", fuenteSQL, "jornadas por la educación", sentenciaSelectFiltro("ranking_fGE_juventud_jornadasPorLaEducacion"));
            filtroParaComboPara2(grupoEtarioDnSQL, "adultez", fuenteSQL, "jornadas por la educación", sentenciaSelectFiltro("ranking_fGE_adultez_jornadasPorLaEducacion"));
            filtroParaComboPara2(grupoEtarioDnSQL, "adultez mayor", fuenteSQL, "jornadas por la educación", sentenciaSelectFiltro("ranking_fGE_adultezMayor_jornadasPorLaEducacion"));

        }

    }

    public void filtroParaComboPara2(String comBox, String valorCombo, String comBox1, String valorCombo1, String sql) {

        if (comBox.equals(valorCombo) && comBox1.equals(valorCombo1)) {

            setSQLF(sql);
            System.out.println(sql);
            listFiltro = FXCollections.observableArrayList();
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();
            try {
                resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Ranking ranking = new Ranking();
                    ranking.setEntidades(resultSet.getString("Entidades"));
                    ranking.setNroMenciones(resultSet.getInt("NMenciones"));
                    // ranking.setId(resultSet.getInt("id"));
                    listFiltro.add(ranking);
                    cEntidades.setCellValueFactory(new PropertyValueFactory<>("entidades"));
                    cNMenciones.setCellValueFactory(new PropertyValueFactory<>("nroMenciones"));
                    // cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                    consejoData.setItems(listFiltro);

                }
            } catch (Exception e) {
                e.getMessage();

            }

        } else {

            if (comBox.equals("todos") && comBox1.equals("todos")) {

                setSQLF(SQL);
                System.out.println(SQL);
                listFiltro = FXCollections.observableArrayList();
                ConnectionUtil connectionUtil = new ConnectionUtil();
                connection = (Connection) connectionUtil.getConnection();
                try {
                    resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(SQL);
                    while (resultSet.next()) {
                        Ranking ranking = new Ranking();
                        ranking.setEntidades(resultSet.getString("Entidades"));
                        ranking.setNroMenciones(resultSet.getInt("NMenciones"));
                        // ranking.setId(resultSet.getInt("id"));
                        listFiltro.add(ranking);
                        cEntidades.setCellValueFactory(new PropertyValueFactory<>("entidades"));
                        cNMenciones.setCellValueFactory(new PropertyValueFactory<>("nroMenciones"));
                        // cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                        consejoData.setItems(listFiltro);

                    }
                } catch (Exception e) {
                    e.getMessage();
                }

            }

        }

    }

    public void filtroParaCombo(String comBox, String valorCombo, String sql) {

        if (comBox.equals(valorCombo)) {

            setSQLF(sql);
            System.out.println(sql);
            listFiltro = FXCollections.observableArrayList();
            ConnectionUtil connectionUtil = new ConnectionUtil();
            connection = (Connection) connectionUtil.getConnection();
            try {
                resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Ranking ranking = new Ranking();
                    ranking.setEntidades(resultSet.getString("Entidades"));
                    ranking.setNroMenciones(resultSet.getInt("NMenciones"));
                    // ranking.setId(resultSet.getInt("id"));
                    listFiltro.add(ranking);
                    cEntidades.setCellValueFactory(new PropertyValueFactory<>("entidades"));
                    cNMenciones.setCellValueFactory(new PropertyValueFactory<>("nroMenciones"));
                    // cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                    consejoData.setItems(listFiltro);

                }
            } catch (Exception e) {
                e.getMessage();

            }

        } else {

            if (comBox.equals("todos")) {

                setSQLF(SQL);
                System.out.println(SQL);
                listFiltro = FXCollections.observableArrayList();
                ConnectionUtil connectionUtil = new ConnectionUtil();
                connection = (Connection) connectionUtil.getConnection();
                try {
                    resultSet = (java.sql.ResultSet) connection.createStatement().executeQuery(SQL);
                    while (resultSet.next()) {
                        Ranking ranking = new Ranking();
                        ranking.setEntidades(resultSet.getString("Entidades"));
                        ranking.setNroMenciones(resultSet.getInt("NMenciones"));
                        // ranking.setId(resultSet.getInt("id"));
                        listFiltro.add(ranking);
                        cEntidades.setCellValueFactory(new PropertyValueFactory<>("entidades"));
                        cNMenciones.setCellValueFactory(new PropertyValueFactory<>("nroMenciones"));
                        // cId.setCellValueFactory(new PropertyValueFactory<>("id"));

                        consejoData.setItems(listFiltro);

                    }
                } catch (Exception e) {
                    e.getMessage();
                }

            }

        }

    }

    public String filtro(JFXComboBox<String> comboBoxString) {

        String resultado = comboBoxString.getSelectionModel().getSelectedItem();

        return resultado;
    }

    //1
    @FXML
    public void selecionarMregion() {

        filtrarAndPopulateTabla();
    }

    //2
    @FXML
    public void selecionarFuente() {

        filtrarAndPopulateTabla();

    }

    //3
    @FXML
    public void selecionarGrupoEtario() {
        filtrarAndPopulateTabla();

    }

    //4
    @FXML
    public void selecionarDepartamentos() {
        filtrarAndPopulateTabla();

    }

    //5
    @FXML
    public void selecionarDiscapacidad() {

        filtrarAndPopulateTabla();

    }

    //6
    @FXML
    public void selecionarGetcnico() {
        filtrarAndPopulateTabla();

    }

    //7
    @FXML
    public void selecionarGrupoEterarioDn() {

        filtrarAndPopulateTabla();

    }

    //8
    @FXML
    public void selecionarPaternidad() {
        filtrarAndPopulateTabla();

    }

    //9
    @FXML
    public void selecionarperfilParticipantes() {

        filtrarAndPopulateTabla();

    }

    private void colocarImagenBotones() {

        URL linkRanking = getClass().getResource("/img/chart-bar.png");
        URL linkLogout = getClass().getResource("/img/sign-out-alt.png");
        URL linkPen = getClass().getResource("/img/logo-pen2036.png");
        URL linkTodosEdu = getClass().getResource("/img/letras.png");
        URL linkAbuela = getClass().getResource("/img/madreCsuHijo.png");
        Image imagePen = new Image(linkPen.toString(), 200, 96, false, true);
        Image imageTodosEdu = new Image(linkTodosEdu.toString(), 200, 96, false, true);
        Image imageAbuela = new Image(linkAbuela.toString(), 181, 341, false, true);
        Image imagenRanking = new Image(linkRanking.toString(), 24, 24, false, true);
        Image imagenLoutOut = new Image(linkLogout.toString(), 20, 20, false, true);
        pen.setImage(imagePen);
        todosEdu.setImage(imageTodosEdu);
        abuela.setImage(imageAbuela);
        rankingBtn.setGraphic((new ImageView(imagenRanking)));
        closeBtn.setGraphic((new ImageView(imagenLoutOut)));
    }

    public void iteracionRapidaDcomboBoxes(ObservableList<String> observableList, JFXComboBox<String> comboBoxString) {
        for (int i = 0; i < observableList.size(); i++) {
            comboBoxString.getItems().add(observableList.get(i));
        }

    }
    public void inicializarCombo(JFXComboBox<String> comboBoxString){
          comboBoxString.setValue("todos");
    }
    
    public void inicializarComboItemSelected(JFXComboBox<String> comboBoxString,String itemSelected){
    comboBoxString.setValue(itemSelected);
    
    }
    
    

    public void botonesInfo() {
        TableColumn<Ranking, Void> colBtn = new TableColumn("INFO");
        cButtonInfo = colBtn;

        Callback<TableColumn<Ranking, Void>, TableCell<Ranking, Void>> cellFactory = new Callback<TableColumn<Ranking, Void>, TableCell<Ranking, Void>>() {
            @Override
            public TableCell<Ranking, Void> call(final TableColumn<Ranking, Void> param) {
                final TableCell<Ranking, Void> cell = new TableCell<Ranking, Void>() {

                    private final Button btn = new Button("Info");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            /*    try {
                               // changeScreenButtonPushedVi(event);
                            } catch (IOException ex) {
                                Logger.getLogger(VentanaController.class.getName()).log(Level.SEVERE, null, ex);
                            }*/
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        cButtonInfo.setCellFactory(cellFactory);

        consejoData.getColumns().add(colBtn);

    }
      public void cargaDcomboBoxesValorInicial() {
        inicializarCombo(macroRcombo);
        inicializarCombo(grupoEtario);
        inicializarCombo(perfilParticipantes);
        inicializarCombo(departamentos);
        inicializarCombo(grupoEtarioDn);
        inicializarCombo(fuente);
        inicializarCombo(discapacidad);
        inicializarCombo(paternidad);
        inicializarCombo(gEtnico);

    }
    
   
    public void cargaDcomboBoxes() {
        iteracionRapidaDcomboBoxes(optionsMc, macroRcombo);
        iteracionRapidaDcomboBoxes(optionsGe, grupoEtario);
        iteracionRapidaDcomboBoxes(optionsPp, perfilParticipantes);
        iteracionRapidaDcomboBoxes(optionsD, departamentos);
        iteracionRapidaDcomboBoxes(optionsGeDn, grupoEtarioDn);
        iteracionRapidaDcomboBoxes(optionsF, fuente);
        iteracionRapidaDcomboBoxes(optionsDisca, discapacidad);
        iteracionRapidaDcomboBoxes(optionsPat, paternidad);
        iteracionRapidaDcomboBoxes(optionsGeT, gEtnico);

    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //EtiquetaN.prefWidthProperty().bind(contenedorN.widthProperty());
        //EtiquetaR.prefWidthProperty().bind(contenedorR.widthProperty());
        //contenedorN.prefWidthProperty().bind(vBoxPanelLateral.widthProperty());
        //contenedorR.prefWidthProperty().bind(vBoxPanelLateral.widthProperty());
        colocarImagenBotones();
        cargaDcomboBoxes();
        cargaDcomboBoxesValorInicial();
        botonesInfo();
        popullateTable();
        
        //filtrarAndPopulateTabla();

    }

}

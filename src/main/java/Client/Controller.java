package Client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Controller {

    //Set the GUI variable
    @FXML
    SplitPane splitPane;
    //List variable
    ObservableList<FileRecord> fileNames = FXCollections.observableArrayList();
    @FXML
    private TableView<FileRecord> tableView1;
    @FXML
    private TableView<FileRecord> tableView2;
    @FXML
    private TableColumn<FileRecord, String> localDirectory;
    @FXML
    private TableColumn<FileRecord, String> serverDirectory;

    //Client Server Variables
    public static String serverAddress = "localhost";
    public static int serverPort = 8080;

    //Client Variables
    private Socket socket;
    private BufferedReader in;
    private BufferedReader networkIn;
    private PrintWriter networkOut;

    //Directory Chooser
    //The function below will open and list the file contents of a chosen directory
    @FXML
    public void openDir(ActionEvent event) throws Exception {
        DirectoryChooser open = new DirectoryChooser();
        open.setTitle("Open");


        File files = open.showDialog(null);
        File[] directory = files.listFiles();
        fileNames.clear();
        for (File file : directory) {
            FileRecord data = new FileRecord(file);
            fileNames.add(data);

        }

    }

    //Functions

    //Connect
    //The function below will initialize a socket to connect to the server
    @FXML
    public void connect(ActionEvent event){
       ServerClient client = new ServerClient();
    }

    //This function will upload the selected file to the server
    //
    @FXML
    public void upload(ActionEvent event){


    }

    @FXML
    public void download(){

    }

    @FXML
    public void upload(){

    }

    @FXML
    public void initialize() {

        localDirectory.setCellValueFactory(new PropertyValueFactory<FileRecord, String>("file"));

        tableView1.setItems(fileNames);
    }
}
